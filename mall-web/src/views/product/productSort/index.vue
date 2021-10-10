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
        <el-table-column label="分类名称" align="center" prop="name" width="150"/>
        <el-table-column label="分类级别" align="center" prop="level" />
        <el-table-column label="显示状态" align="center" prop="showStatus" width="160">
          <template slot-scope="scope">
            <el-switch
              v-model="scope.row.showStatus"
              active-text="显示"
              inactive-text="不显示"
              @change="changeSwitch(scope.row)">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="排序" align="center" prop="sort" />
        <el-table-column label="图标" align="center" prop="icon">
          <template slot-scope="scope">
            <i :class="scope.row.icon"></i>
          </template>
        </el-table-column>
        <el-table-column label="描述" align="center" prop="description" />
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

    <!-- 添加或修改商品管理模块商品分类对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="分类级别" prop="nickName">
          <el-select @change="levelChange" v-model="form.level" placeholder="请选择分类级别">
            <el-option
              v-for="item in levelDataList"
              :key="item.levelId"
              :label="item.title"
              :value="item.levelId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item v-if="parentFlag" label="父类名称" prop="nickName">
          <el-select v-model="form.parentId" placeholder="请选择父类名称">
            <el-option
              v-for="item in parentIdDataList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="分类名称" prop="icon">
          <el-input v-model="form.name" type="textarea" placeholder="请输入分类名称" />
        </el-form-item>
        <el-form-item label="排序" prop="email">
          <el-input v-model="form.sort" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="图标" prop="email">
          <el-input v-model="form.icon" placeholder="请输入图标" />
        </el-form-item>
        <el-form-item label="显示状态">
          <el-select v-model="form.showStatus" placeholder="请选择显示状态">
            <el-option label="显示" :value="1"></el-option>
            <el-option label="不显示" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="描述" prop="email">
          <el-input v-model="form.description" placeholder="请输入描述" />
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
import { Message } from "element-ui"
import { listProductSort, getProductSort, addProductSort, updateProductSort, delProductSort, getProductSortByParent, changeSwitch } from "@/api/product/productSort";

const defaultAdminProductSort = {
  // 查询参数
  id: null,
  parentId: null,
  name: null,
  level: null,
  showStatus: null,
  sort: null,
  icon: null,
  description: null
};

export default {
  name: 'productSort',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminProductSort: Object.assign({}, defaultAdminProductSort),
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
      // 分类级别
      levelDataList: [
        {
          levelId: 0,
          title: "一级"
        },
        {
          levelId: 1,
          title: "二级"
        }
      ],
      // 父级是否显示
      parentFlag: false,
      // 父类数据
      parentIdDataList: [
        // 默认值
        {
          id: 0,
          name: "默认分类"
        }
      ],
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
    /** 查询商品管理模块商品分类列表 */
    getList() {
      this.loading = true;
      listProductSort(this.listQuery).then(response => {
        const data = response.data.list;
        data.forEach(productSort => {
          if (productSort.showStatus == 1) {
            productSort.showStatus = true
          } else {
            productSort.showStatus = false
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
      this.parentFlag = false;
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
      this.title = "添加商品管理模块商品分类"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      const id = row.id || this.ids
      if (row.level == 0) {
        this.parentFlag = false;
      } else {
        this.parentFlag = true;
      }
      getProductSort(id).then(response => {
        this.$nextTick(() => {
          this.dialogFormVisible = true
          this.form = response.data;
          this.open = true;
          this.title = "修改商品管理模块商品分类";
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
            updateProductSort(this.form).then(response => {
              Message.success(response.message);
              this.dialogFormVisible = false
              this.open = false;
              this.getList();
            });
          } else {
            addProductSort(this.form).then(response => {
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
      this.$confirm('是否确认删除商品管理商品分类资源编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delProductSort(ids);
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
    // 下拉框值变化
    levelChange(value) {
      if (value == 1) {
        this.parentFlag = true;
        getProductSortByParent().then(response => {
          console.log(response.data)
          this.parentIdDataList = response.data;
        });
      } else {
        this.parentFlag = false;
      }
    },
    // 重置表单为初始值并移除校验结果
    resetForm() {
      this.$refs["form"].resetFields()
      this.form = Object.assign({}, defaultAdminProductSort)
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
