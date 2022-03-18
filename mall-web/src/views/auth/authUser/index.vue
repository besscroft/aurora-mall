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
          <el-button
            type="success"
            plain
            icon="el-icon-plus"
            size="mini"
            :disabled="multiple"
            @click="handleExport"
          >导出</el-button>
        </el-col>
        <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
      </el-row>
    </el-card>

    <el-card class="box-card" style="margin-top: 30px" shadow="never">
      <el-table border v-loading="loading" :data="dataList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="编号" width="100" align="center">
          <template slot-scope="scope">{{scope.row.id}}</template>
        </el-table-column>
        <el-table-column label="用户名" align="center" prop="username" width="150"/>
        <el-table-column label="头像" align="center" prop="icon">
          <template slot-scope="scope">
            <img :src="scope.row.icon" class="image" style="width: 3.125rem;height: 3.125rem;" />
          </template>
        </el-table-column>
        <el-table-column label="邮箱" align="center" prop="email" />
        <el-table-column label="手机" align="center" prop="phone" />
        <el-table-column label="昵称" align="center" prop="nickName" />
        <el-table-column label="备注信息" align="center" prop="note" />
        <el-table-column label="创建时间" align="center" prop="createTime" />
        <el-table-column label="最后登录时间" align="center" prop="loginTime" />
        <el-table-column label="帐号启用状态" align="center" prop="status" width="160">
          <template slot-scope="scope">
            <el-switch
              v-model="scope.row.status"
              active-text="启用"
              inactive-text="禁用"
              @change="changeSwitch(scope.row)">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right" width="100">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleBind(scope.row)"
            >角色绑定</el-button>
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

    <!-- 添加或修改权限管理模块用户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item v-if="pwdFlag" label="密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="头像" prop="icon">
          <el-input v-model="form.icon" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="手机" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机" />
        </el-form-item>
        <el-form-item label="昵称" prop="nickName">
          <el-input v-model="form.nickName" placeholder="请输入昵称" />
        </el-form-item>
        <el-form-item label="备注信息" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="帐号启用状态">
          <el-select v-model="form.status" placeholder="请选择启用状态">
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

    <!-- 绑定角色对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="centerDialogVisible"
      width="30%"
      center>
      <el-tag v-if="roleData">当前绑定角色为：{{ roleData.name }}</el-tag>
      <el-tag v-if="!roleData">当前无绑定角色</el-tag>
      <el-form :model="form">
        <el-form-item label="角色" label-width="100px">
          <el-select v-model="form.id" placeholder="请选择角色">
            <el-option
              v-for="item in roleDataList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitRole">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { listUser, getUser, updateUser, addUser, delUser, exportUser, changeSwitch } from '@/api/auth/user'
import { getRoleAll, updateRoleById, getRoleById } from '@/api/auth/role'
import { Message } from 'element-ui'

const defaultAdminUser = {
  // 查询参数
  id: null,
  username: null,
  password: null,
  icon: null,
  email: null,
  phone: null,
  nickName: null,
  note: null,
  createTime: null,
  loginTime: null,
  status: 0
};

export default {
  name: 'authUser',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminUser: Object.assign({}, defaultAdminUser),
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
      // 权限管理模块用户表格数据
      dataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 表单参数
      form: {},
      // 密码框显示标识
      pwdFlag: false,
      listQuery: {
        // 分页参数（页）
        pageNum: 0,
        // 分页参数（条）
        pageSize: 10,
        keyword: null
      },
      centerDialogVisible: false,
      // 可选择的角色数据
      roleDataList: [],
      // 编辑的用户id
      userId: 0,
      // 用户的角色数据
      roleData: [],
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
    /** 查询权限管理模块用户列表 */
    getList() {
      this.loading = true;
      listUser(this.listQuery).then(response => {
        const data = response.data.list;
        data.forEach(user => {
          if (user.status == 1) {
            user.status = true
          } else {
            user.status = false
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
      this.pwdFlag = true
      this.dialogFormVisible = true
      this.open = true
      this.title = "添加权限管理模块用户"
    },
    /** 导出按钮操作 */
    handleExport(row) {
      const ids = row.id || this.ids;
      exportUser(ids).then(response => {
        const blob = new Blob([response], { type: 'application/vnd.ms-excel' }) // 构造一个blob对象来处理数据
        let date = new Date();
        const fileName = '用户信息-' + date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate() + '.xlsx' // 导出文件名
        const elink = document.createElement('a') // 创建a标签
        elink.download = fileName // a标签添加属性
        elink.style.display = 'none'
        elink.href = URL.createObjectURL(blob)
        document.body.appendChild(elink)
        elink.click() // 执行下载
        URL.revokeObjectURL(elink.href) // 释放URL 对象
        document.body.removeChild(elink) // 释放标签
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.pwdFlag = false
      const id = row.id || this.ids
      getUser(id).then(response => {
        this.$nextTick(() => {
          this.dialogFormVisible = true
          this.form = response.data;
          this.open = true;
          this.title = "修改权限管理模块用户";
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
            updateUser(this.form).then(response => {
              Message.success(response.message);
              this.dialogFormVisible = false
              this.open = false;
              this.getList();
            });
          } else {
            addUser(this.form).then(response => {
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
      this.$confirm('是否确认删除权限管理模块用户编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delUser(ids);
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
    /** 角色绑定 */
    handleBind(row) {
      getRoleAll().then(response => {
        this.roleData = null;
        this.userId = row.id;
        this.roleDataList = response.data;
        this.centerDialogVisible = true;
        this.title = "一个用户只能绑定一个角色！！！";
        getRoleById(row.id).then(response => {
          if (response.data != null) {
            this.roleData = response.data;
          }
        });
      });
    },
    /** 用户角色提交更新 */
    submitRole() {
      if (this.form.id != null) {
        updateRoleById({userId: this.userId, roleId: this.form.id}).then(response => {
          Message.success(response.message);
          this.dialogFormVisible = false
          this.centerDialogVisible = false;
          // this.getList();
        });
      }
    },
    // 重置表单为初始值并移除校验结果
    resetForm() {
      this.$refs["form"].resetFields()
      this.form = Object.assign({}, defaultAdminUser)
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
