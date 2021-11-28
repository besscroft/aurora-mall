<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
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
        <el-table-column label="订单编号" width="100" align="center">
          <template slot-scope="scope">{{scope.row.orderSn}}</template>
        </el-table-column>
        <el-table-column label="订单总金额" width="120" align="center">
          <template slot-scope="scope">{{scope.row.totalAmount}}</template>
        </el-table-column>物流单号
        <el-table-column label="应付金额（实际支付金额）" width="120" align="center">
          <template slot-scope="scope">{{scope.row.payAmount}}</template>
        </el-table-column>
        <el-table-column label="物流单号" width="120" align="center">
          <template slot-scope="scope">{{scope.row.deliverySn}}</template>
        </el-table-column>
        <el-table-column label="订单收货地区" width="120" align="center">
          <template slot-scope="scope">{{scope.row.receiverProvince + scope.row.receiverCity + scope.row.receiverRegion}}</template>
        </el-table-column>
        <el-table-column label="订单状态" width="120" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.status == 0">待付款</span>
            <span v-if="scope.row.status == 1">待发货</span>
            <span v-if="scope.row.status == 2">已发货</span>
            <span v-if="scope.row.status == 3">已完成</span>
            <span v-if="scope.row.status == 4">已关闭</span>
            <span v-if="scope.row.status == 5">无效订单</span>
          </template>
        </el-table-column>
        <el-table-column label="订单类型" width="140" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.orderType == 0">正常订单</span>
            <span v-if="scope.row.orderType == 1">秒杀订单</span>
          </template>
        </el-table-column>
        <el-table-column label="发票类型" width="100" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.billType == 0">不开发票</span>
            <span v-if="scope.row.billType == 1">电子发票</span>
            <span v-if="scope.row.billType == 2">纸质发票</span>
          </template>
        </el-table-column>
        <el-table-column label="确认收货状态" width="120" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.confirmStatus == 0">未确认</span>
            <span v-if="scope.row.confirmStatus == 1">已确认</span>
          </template>
        </el-table-column>
        <el-table-column label="订单备注" align="center">
          <template slot-scope="scope">{{scope.row.note}}</template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right" width="100">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-share"
              @click="handleDetail(scope.row)"
            >详情</el-button>
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
import { getOrderList, getOrderDetail, deleteOrder, exportOrder } from "@/api/order/order";

const defaultAdminOrderList = {
  // 查询参数
  id: '',
  orderSn: '',
  userId: '',
  couponId: '',
  createTime: '',
  memberUsername: '',
  totalAmount: '',
  payAmount: '',
  freightAmount: '',
  auroraBitAmount: '',
  couponAmount: '',
  discountAmount: '',
  payType: '',
  sourceType: '',
  status: '',
  orderType: '',
  deliveryCompany: '',
  deliverySn: '',
  autoConfirmDay: '',
  getAuroraPoint: '',
  getAuroraBit: '',
  promotionInfo: '',
  billType: '',
  billHeader: '',
  billContent: '',
  billReceiverPhone: '',
  billReceiverEmail: '',
  receiverName: '',
  receiverPhone: '',
  receiverPostCode: '',
  receiverProvince: '',
  receiverCity: '',
  receiverRegion: '',
  receiverDetailAddress: '',
  note: '',
  confirmStatus: '',
  deleteStatus: '',
  paymentTime: '',
  deliveryTime: '',
  receiveTime: '',
  commentTime: '',
  modifyTime: ''
};

export default {
  name: 'orderList',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      adminOrderList: Object.assign({}, defaultAdminOrderList),
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
  methods:{
    /** 查询商品管理模块商品列表 */
    getList() {
      this.loading = true;
      getOrderList(this.listQuery).then(response => {
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
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除商品资源编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deleteOrder(ids);
      }).then(response => {
        this.getList();
        Message.success(response.message);
      })
    },
    /** 订单详情 */
    handleDetail(row) {
      getOrderDetail(row.id).then(response => {
        this.form = response.data;
      });
    },
    /** 导出按钮操作 */
    handleExport(row) {
      const ids = row.id || this.ids;
      exportOrder(ids).then(response => {
        const blob = new Blob([response], { type: 'application/vnd.ms-excel' }) // 构造一个blob对象来处理数据
        let date = new Date();
        const fileName = '订单信息-' + date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate() + '.xlsx' // 导出文件名
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
