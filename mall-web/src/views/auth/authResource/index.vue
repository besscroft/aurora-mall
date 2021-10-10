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
        <el-table-column label="资源名称" align="center" prop="name" width="150"/>
        <el-table-column label="资源路径" align="center" prop="url" />
        <el-table-column label="资源描述" align="center" prop="description" />
        <el-table-column label="创建时间" align="center" prop="createTime" />
        <el-table-column label="资源类别ID" align="center" prop="categoryId" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right" width="100">
          <template slot-scope="scope">
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

    <!-- 添加或修改权限管理模块资源对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="资源类别" prop="categoryId">
          <el-select v-model="form.categoryId" placeholder="请选择资源类别">
            <el-option
              v-for="item in resourceSortList"
              :key="item.id"
              :label="item.categoryName"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="资源名" prop="name">
          <el-input v-model="form.name" type="textarea" placeholder="请输入资源名" />
        </el-form-item>
        <el-form-item label="资源路径" prop="url">
          <el-input v-model="form.url" placeholder="请输入资源路径" />
        </el-form-item>
        <el-form-item label="资源描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入资源描述" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { Message } from 'element-ui'
import { listResource, getResource, addResource, updateResource, delResource, exportResource } from '@/api/auth/resource'
import { listResourceSort } from '@/api/auth/resourceSort'

const defaultAdminResource = {
  // 查询参数
  id: null,
  name: null,
  url: null,
  description: null,
  createTime: null,
  categoryId: null
};

export default {
  name: 'authResource',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminResource: Object.assign({}, defaultAdminResource),
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
      // 资源类别
      resourceSortList: [],
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
    /** 查询权限管理模块资源列表 */
    getList() {
      this.loading = true;
      listResource(this.listQuery).then(response => {
        const data = response.data.list;
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
      this.title = "添加权限管理模块资源"
      listResourceSort({ pageNum: 0, pageSize: 100, keyword: null }).then(response => {
        this.resourceSortList = response.data.list
      })
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      const id = row.id || this.ids
      listResourceSort({ pageNum: 0, pageSize: 100, keyword: null }).then(response => {
        this.resourceSortList = response.data.list
      })
      getResource(id).then(response => {
        this.$nextTick(() => {
          this.dialogFormVisible = true
          this.form = response.data;
          this.open = true;
          this.title = "修改权限管理模块资源";
        })
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if ((this.form.id != null) && (this.form.id != '')) {
            updateResource(this.form).then(response => {
              Message.success(response.message);
              this.dialogFormVisible = false
              this.open = false;
              this.getList();
            });
          } else {
            addResource(this.form).then(response => {
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
      this.$confirm('是否确认删除权限管理模块资源编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delResource(ids);
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
    // 重置表单为初始值并移除校验结果
    resetForm() {
      this.$refs["form"].resetFields()
      this.form = Object.assign({}, defaultAdminResource)
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
