<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <span>访问日志</span>
      <i style="float: right; padding: 3px 0" class="el-icon-s-promotion"></i>
    </el-card>

    <el-card class="box-card" style="margin-top: 30px" shadow="never">
      <el-table border v-loading="loading" :data="dataList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="id" align="center" prop="id" width="150"/>
        <el-table-column label="用户名" align="center" prop="username"/>
        <el-table-column label="日志描述信息" align="center" prop="description" />
        <el-table-column label="请求入参" align="center" prop="requestArgs" />
        <el-table-column label="请求时间" align="center" prop="startTime" />
        <el-table-column label="消耗时间(毫秒)" align="center" prop="spendTime" />
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
import { getLogList } from "@/api/system/weblog";

const defaultWebLog = {
  // 查询参数
  id: null,
  username: null,
  description: null,
  url: null,
  httpMethod: null,
  classMethod: null,
  ip: null,
  requestArgs: null,
  responseArgs: null,
  startTime: null,
  spendTime: null
};

export default {
  name: 'weblog',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      WebLog: Object.assign({}, defaultWebLog),
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
        keyword: ""
      }
    }
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询权限管理模块资源列表 */
    getList() {
      this.loading = true;
      getLogList(this.listQuery).then(response => {
        const data = response.data.list;
        this.dataList = data;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
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
