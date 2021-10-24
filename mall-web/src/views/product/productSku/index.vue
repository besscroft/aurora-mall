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
        <el-table-column label="套餐编码" width="100" align="center">
          <template slot-scope="scope">{{scope.row.skuCode}}</template>
        </el-table-column>
        <el-table-column label="套餐价格(单位：元)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.price}}</template>
        </el-table-column>
        <el-table-column label="库存" width="100" align="center">
          <template slot-scope="scope">{{scope.row.stock}}</template>
        </el-table-column>
        <el-table-column label="预警库存" width="100" align="center">
          <template slot-scope="scope">{{scope.row.lowStock}}</template>
        </el-table-column>
        <el-table-column label="展示图片" width="100" align="center">
          <template slot-scope="scope">{{scope.row.pic}}</template>
        </el-table-column>
        <el-table-column label="销量" width="100" align="center">
          <template slot-scope="scope">{{scope.row.sale}}</template>
        </el-table-column>
        <el-table-column label="锁定库存" width="100" align="center">
          <template slot-scope="scope">{{scope.row.lowStock}}</template>
        </el-table-column>
        <el-table-column label="商品销售属性" width="120" align="center">
          <template slot-scope="scope">{{scope.row.spData}}></template>
        </el-table-column>
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

  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { listProductSkuList } from "@/api/product/productSku";

const defaultAdminProductSkuList = {
  // 查询参数
  id: null,
  productId: null,
  skuCode: null,
  price: null,
  stock: null,
  lowStock: null,
  pic: null,
  sale: null,
  lockStock: null,
  spData: null
};

export default {
  name: "productSku",
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminProductSkuList: Object.assign({}, defaultAdminProductSkuList),
      productId: null,
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
        productId: '',
        pageNum: 0,
        // 分页参数（条）
        pageSize: 10,
        keyword: null
      }
    }
  },
  beforeCreate() {
    if ((this.$route.query.id == undefined) || (this.$route.query.id == null)) {
      this.$store.dispatch("tagsView/delView", this.$route)
      this.$router.push({ path: '/product/productList' })
    }
    this.productId = this.$route.query.id
  },
  mounted() {
    console.log("当前商品id为:" + this.$route.query.id)
    this.listQuery.productId = this.$route.query.id
    this.getList()
  },
  methods: {
    /** 查询商品套餐列表 */
    getList() {
      this.loading = true;
      listProductSkuList(this.listQuery).then(response => {
        const data = response.data.list;
        this.dataList = data;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.parentFlag = false;
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
