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
        <el-table-column label="品牌名称" align="center" prop="name" width="150"/>
        <el-table-column label="品牌logo" align="center" prop="logo" />
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
        <el-table-column label="产品数量" align="center" prop="productCount" />
        <el-table-column label="品牌专区大海报" align="center" prop="bigPic" />
        <el-table-column label="排序" align="center" prop="sort" />
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

    <!-- 添加或修改商品管理模块商品品牌对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="品牌名称" prop="icon">
          <el-input v-model="form.name" type="textarea" placeholder="请输入品牌名称" />
        </el-form-item>
        <el-form-item label="品牌logo" prop="icon">
          <el-input v-model="form.logo" type="textarea" placeholder="请输入品牌logo图片地址" />
        </el-form-item>
        <el-form-item label="显示状态">
          <el-select v-model="form.showStatus" placeholder="请选择显示状态">
            <el-option label="显示" :value="1"></el-option>
            <el-option label="不显示" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品数量" prop="icon">
          <el-input v-model="form.productCount" type="textarea" placeholder="请输入产品数量" />
        </el-form-item>
        <el-form-item label="品牌专区大海报" prop="icon">
          <el-input v-model="form.bigPic" type="textarea" placeholder="请输入品牌专区大海报地址" />
        </el-form-item>
        <el-form-item label="排序" prop="icon">
          <el-input v-model="form.sort" type="textarea" placeholder="请输入排序" />
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
import { addProductBrand, delProductBrand, getProductBrand, listProductBrand, updateProductBrand, changeSwitch } from "@/api/product/productBrand";

const defaultAdminProductBrand = {
  // 查询参数
  id: null,
  name: null,
  logo: null,
  showStatus: null,
  productCount: null,
  bigPic: null,
  sort: null
};

export default {
  name: 'productBrand',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminProductBrand: Object.assign({}, defaultAdminProductBrand),
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
    /** 查询商品管理模块商品品牌列表 */
    getList() {
      this.loading = true;
      listProductBrand(this.listQuery).then(response => {
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
      this.title = "添加商品管理模块商品品牌"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.pwdFlag = false
      const id = row.id || this.ids
      getProductBrand(id).then(response => {
        this.$nextTick(() => {
          this.dialogFormVisible = true
          this.form = response.data;
          this.open = true;
          this.title = "修改商品管理模块商品品牌";
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
            updateProductBrand(this.form).then(response => {
              Message.success(response.message);
              this.dialogFormVisible = false
              this.open = false;
              this.getList();
            });
          } else {
            addProductBrand(this.form).then(response => {
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
      this.$confirm('是否确认删除商品管理商品品牌资源编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delProductBrand(ids);
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
      this.form = Object.assign({}, defaultAdminProductBrand)
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
