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
        <el-table-column label="编号" width="100" align="center">
          <template slot-scope="scope">{{scope.row.id}}</template>
        </el-table-column>
        <el-table-column label="商品图片" width="120" align="center">
          <template slot-scope="scope"><img style="height: 80px" :src="scope.row.pic"></template>
        </el-table-column>
        <el-table-column label="商品名称" align="center">
          <template slot-scope="scope">
            <p>{{scope.row.name}}</p>
            <p>品牌：{{scope.row.brandName}}</p>
          </template>
        </el-table-column>
        <el-table-column label="价格/货号" width="120" align="center">
          <template slot-scope="scope">
            <p>价格：￥{{scope.row.price}}</p>
            <p>货号：{{scope.row.productSn}}</p>
          </template>
        </el-table-column>
        <el-table-column label="标签" width="140" align="center">
          <template slot-scope="scope">
            <p>上架：
              <el-switch
                @change="handlePushStatusChange(scope.$index, scope.row)"
                :active-value="1"
                :inactive-value="0"
                v-model="scope.row.pushStatus">
              </el-switch>
            </p>
            <p>新品：
              <el-switch
                @change="handleNewStatusChange(scope.$index, scope.row)"
                :active-value="1"
                :inactive-value="0"
                v-model="scope.row.newStatus">
              </el-switch>
            </p>
            <p>推荐：
              <el-switch
                @change="handleRecommendStatusChange(scope.$index, scope.row)"
                :active-value="1"
                :inactive-value="0"
                v-model="scope.row.recommandStatus">
              </el-switch>
            </p>
          </template>
        </el-table-column>
        <el-table-column label="排序" width="100" align="center">
          <template slot-scope="scope">{{scope.row.sort}}</template>
        </el-table-column>
        <el-table-column label="SKU库存" width="120" align="center">
          <template slot-scope="scope">
            <p>{{scope.row.stock}}</p>
            <el-button type="primary" round size="mini" @click="handleShowSkuEditDialog(scope.$index, scope.row)">编辑套餐</el-button>
          </template>
        </el-table-column>
        <el-table-column label="销量" width="100" align="center">
          <template slot-scope="scope">{{scope.row.sale}}</template>
        </el-table-column>
        <el-table-column label="审核状态" width="100" align="center">
          <template slot-scope="scope">
            <p v-if="scope.row.verifyStatus == 0">未审核</p>
            <p v-else>审核通过</p>
            <p>
              <el-button
                type="text"
                @click="handleShowVerifyDetail(scope.$index, scope.row)">审核详情
              </el-button>
            </p>
          </template>
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
import { mapGetters } from 'vuex'
import { Message } from "element-ui"
import { listProductList, delProduct, exportProduct, changeSwitchPush, changeSwitchNew, changeSwitchRecommend } from "@/api/product/product";

const defaultAdminProductList = {
  // 查询参数
  id: null,
  name: null,
  logo: null,
  pushStatus: null,
  newStatus: null,
  recommandStatus: null,
  productCount: null,
  bigPic: null,
  sort: null
};

export default {
  name: 'productList',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminProductList: Object.assign({}, defaultAdminProductList),
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
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商品管理模块商品列表 */
    getList() {
      this.loading = true;
      listProductList(this.listQuery).then(response => {
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
    /** 导出按钮操作 */
    handleExport(row) {
      const ids = row.id || this.ids;
      exportProduct(ids).then(response => {
        const blob = new Blob([response], { type: 'application/vnd.ms-excel' }) // 构造一个blob对象来处理数据
        let date = new Date();
        const fileName = '商品信息-' + date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate() + '.xlsx' // 导出文件名
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
    /** 新增按钮操作 */
    handleAdd() {
      this.$router.push({ path: '/product/productAdd' })
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      const id = row.id || this.ids[0];
      this.$router.push({ path: '/product/productUpdate', query : { "id" : id } })
    },
    /** 编辑套餐 */
    handleShowSkuEditDialog(index, row) {
      const id = row.id || this.ids[0];
      this.$router.push({ path: '/product/productSku', query : { "id" : id } })
    },
    /** 是否启用按钮监听 */
    handlePushStatusChange(index, row) {
      console.log(row)
      changeSwitchPush(row).then(response => {
        Message.success(response.message);
      })
    },
    handleNewStatusChange(index, row) {
      console.log(row)
      changeSwitchNew(row).then(response => {
        Message.success(response.message);
      })
    },
    handleRecommendStatusChange(index, row) {
      console.log(row)
      changeSwitchRecommend(row).then(response => {
        Message.success(response.message);
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除商品资源编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delProduct(ids);
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
