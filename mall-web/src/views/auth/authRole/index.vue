<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
          <el-button
            type="primary"
            plain
            icon="el-icon-plus"
            size="mini"
            @click="handleAdd"
          >新增</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="success"
            plain
            icon="el-icon-edit"
            size="mini"
            :disabled="single"
            @click="handleUpdate"
          >修改</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="danger"
            plain
            icon="el-icon-delete"
            size="mini"
            :disabled="multiple"
            @click="handleDelete"
          >删除</el-button>
        </el-col>
        <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
      </el-row>
    </el-card>

    <el-card class="box-card" style="margin-top: 30px" shadow="never">
      <el-table border v-loading="loading" :data="dataList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="角色名称" align="center" prop="name" width="150"/>
        <el-table-column label="描述" align="center" prop="description" />
        <el-table-column label="用户数量" align="center" prop="adminCount" />
        <el-table-column label="创建时间" align="center" prop="createTime" />
        <el-table-column label="排序" align="center" prop="sort" />
        <el-table-column label="帐号启用状态" align="center" prop="hidden" width="160">
          <template slot-scope="scope">
            <el-switch
              v-model="scope.row.status"
              active-text="启用"
              inactive-text="不启用"
              @change="changeSwitch(scope.row)">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right" width="150">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleBindMenu(scope.row)"
            >菜单绑定</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleBindResource(scope.row)"
            >资源绑定</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
            >修改</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
            >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :page-sizes="[10, 20, 30, 40, 50, 100]"
      :page-size="listQuery.pageSize"
      layout="sizes, prev, pager, next"
      :total="total">
    </el-pagination>

    <!-- 添加或修改权限管理模块角色对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="角色名" prop="icon">
          <el-input v-model="form.name" type="textarea" placeholder="请输入角色名" />
        </el-form-item>
        <el-form-item label="角色描述" prop="email">
          <el-input v-model="form.description" placeholder="请输入角色描述" />
        </el-form-item>
        <el-form-item label="排序值" prop="nickName">
          <el-input v-model="form.sort" placeholder="请输入排序值" />
        </el-form-item>
        <el-form-item label="角色是否可用">
          <el-select v-model="form.status" placeholder="请选择激活状态">
            <el-option label="禁用" :value="0"></el-option>
            <el-option label="启用" :value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 绑定菜单对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="menuDialogVisible"
      width="30%"
      center>
      <el-tree
        :data="menuTree"
        show-checkbox
        :default-expanded-keys="defaultMenuTree"
        :default-checked-keys="defaultMenuTree"
        node-key="id"
        ref="tree"
        highlight-current
        :props="menuProps">
      </el-tree>
      <div slot="footer" class="dialog-footer">
        <el-button @click="menuDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitMenu">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 绑定资源对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="resourceDialogVisible"
      width="30%"
      center>
      <el-tree
        :data="resourceTree"
        show-checkbox
        :default-expanded-keys="defaultResourceTree"
        :default-checked-keys="defaultResourceTree"
        node-key="id"
        ref="tree"
        highlight-current
        :props="resourceProps">
      </el-tree>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resourceDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitResource">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { Message } from 'element-ui'
import { listRole, getRole, addRole, updateRole, delRole, exportRole, changeSwitch } from '@/api/auth/role'
import { getMenuTreeById, getAllMenuTree, updateMenuTree } from '@/api/auth/menu'
import { getAllResourceTree, getResourceTreeById, updateResourceTree } from '@/api/auth/resource'

const defaultAdminRole = {
  // 查询参数
  id: null,
  name: null,
  description: null,
  adminCount: null,
  createTime: null,
  status: null,
  sort: null
};

export default {
  name: 'authRole',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminRole: Object.assign({}, defaultAdminRole),
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 表格数据
      dataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 表单参数
      form: {},
      listQuery: {
        // 分页参数（页）
        pageNum: 0,
        // 分页参数（条）
        pageSize: 10,
        keyword: null
      },
      // 绑定菜单对话框控制
      menuDialogVisible: false,
      // 绑定资源对话框控制
      resourceDialogVisible: false,
      // 菜单树数据
      menuTree: [],
      // 资源树数据
      resourceTree: [],
      // 默认勾选菜单树数据
      defaultMenuTree: [],
      // 默认勾选资源树数据
      defaultResourceTree: [],
      // 指定菜单树默认值
      menuProps: {
        children: 'children',
        label: 'title'
      },
      // 指定资源默认值
      resourceProps: {
        children: 'children',
        label: 'name'
      },
      // 被操作的角色id
      roleId: 0,
      dialogFormVisible: false
    };
  },
  created() {
    this.getList();
  },
  watch: {
    dialogFormVisible(val) {
      if (!val) {
        this.resetForm()
      }
    },
  },
  methods: {
    /** 查询权限管理模块角色列表 */
    getList() {
      this.loading = true;
      listRole(this.listQuery).then(response => {
        const data = response.data.list;
        data.forEach(role => {
          if (role.status == 1) {
            role.status = true
          } else {
            role.status = false
          }
        });
        this.dataList = data;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.dialogFormVisible = false
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.dialogFormVisible = true
      this.open = true
      this.title = "添加权限管理模块角色"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      const id = row.id || this.ids
      getRole(id).then(response => {
        this.$nextTick(() => {
          this.dialogFormVisible = true
          this.form = response.data;
          this.open = true;
          this.title = "修改权限管理模块角色";
        })
      });
    },
    /** 是否启用按钮监听 */
    changeSwitch(row) {
      changeSwitch(row).then(response => {
        Message.success(response.message);
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRole(this.form).then(response => {
              Message.success(response.message);
              this.dialogFormVisible = false
              this.open = false;
              this.getList();
            });
          } else {
            addRole(this.form).then(response => {
              Message.success(response.message);
              this.dialogFormVisible = false
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除权限管理模块角色编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delRole(ids);
      }).then(response => {
        this.getList();
        Message.success(response.message);
      })
    },
    // 分页
    // 每页显示条目个数处理
    handleSizeChange(event) {
      this.listQuery.pageSize = event
      this.getList()
    },
    // 当前页数处理
    handleCurrentChange(event) {
      this.listQuery.pageNum = event
      this.getList()
    },
    /** 菜单绑定 */
    handleBindMenu(row) {
      getAllMenuTree().then(response => {
        this.defaultMenuTree = [];
        this.menuDialogVisible = true;
        this.menuTree = response.data;
        this.title = "菜单绑定";
        getMenuTreeById(row.id).then(response => {
          this.roleId = row.id;
          this.defaultMenuTree = response.data;
        });
      });
    },
    /** 资源绑定 */
    handleBindResource(row) {
      getAllResourceTree().then(response => {
        this.defaultResourceTree = [];
        this.resourceDialogVisible = true;
        this.resourceTree = response.data;
        this.title = "资源绑定";
        getResourceTreeById(row.id).then(response => {
          this.roleId = row.id;
          this.defaultResourceTree = response.data;
        });
      });
    },
    /** 菜单绑定提交 */
    submitMenu() {
      let parentTree = this.$refs.tree.getHalfCheckedKeys();
      let childTree = this.$refs.tree.getCheckedKeys().filter(Boolean);
      const menuTreeData = [...parentTree, ...childTree];
      updateMenuTree({ id: this.roleId, data: menuTreeData }).then(response => {
        Message.success(response.message);
        this.dialogFormVisible = false
        this.menuDialogVisible = false;
      });
    },
    /** 资源绑定提交 */
    submitResource() {
      const resourceTreeData = this.$refs.tree.getCheckedKeys().filter(Boolean);
      updateResourceTree({ id: this.roleId, data: resourceTreeData }).then(response => {
        Message.success(response.message);
        this.dialogFormVisible = false
        this.resourceDialogVisible = false;
      });
    },
    // 重置表单为初始值并移除校验结果
    resetForm() {
      this.$refs["form"].resetFields()
      this.form = Object.assign({}, defaultAdminRole)
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
