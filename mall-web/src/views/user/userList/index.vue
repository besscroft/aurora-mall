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
        <el-table-column label="用户名" width="150" align="center">
          <template slot-scope="scope">{{scope.row.username}}</template>
        </el-table-column>
        <el-table-column label="昵称" width="180" align="center">
          <template slot-scope="scope">{{scope.row.nickname}}</template>
        </el-table-column>
        <el-table-column label="账号启用状态" width="120" align="center">
          <template slot-scope="scope">
            <p v-if="scope.row.status == 0">禁用</p>
            <p v-if="scope.row.status == 1">启用</p>
          </template>
        </el-table-column>
        <el-table-column label="注册时间" width="200" align="center">
          <template slot-scope="scope">{{scope.row.createTime}}</template>
        </el-table-column>
        <el-table-column label="头像" width="150" align="center">
          <template slot-scope="scope"><img style="height: 80px" :src="scope.row.avatar"></template>
        </el-table-column>
        <el-table-column label="所在城市" width="100" align="center">
          <template slot-scope="scope">{{scope.row.city}}</template>
        </el-table-column>
        <el-table-column label="职业" width="200" align="center">
          <template slot-scope="scope">{{scope.row.job}}</template>
        </el-table-column>
        <el-table-column label="注册来源" width="100" align="center">
          <template slot-scope="scope">
            <p v-if="scope.row.sourceType == 0">内部注册</p>
            <p v-if="scope.row.sourceType == 1">微信小程序</p>
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

    <el-dialog
      title="用户详情"
      :visible.sync="detailDialogVisible"
      width="30%"
      center>
      <div :data="detailData" class="text">
        <span>用户名：{{detailData.username}}</span><br />
        <span>昵称：{{detailData.nickname}}</span><br />
        <span>手机号码：{{detailData.phone}}</span><br />
        <span>创建时间：{{detailData.createTime}}</span><br />
        <span>个性签名：{{detailData.personalizedSignature}}</span><br />
        <span>极光值：{{detailData.auroraPoint}}</span><br />
        <span>极光币：{{detailData.auroraBit}}</span><br />
      </div>
      <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="detailDialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { Message } from "element-ui"
import {delUser, getUserDetail, getUserList} from "@/api/user/user";

const defaultUserInfoList = {
  // 查询参数
  id: '',
  username: '',
  password: '',
  nickname: '',
  phone: '',
  status: '',
  createTime: '',
  avatar: '',
  gender: '',
  birthday: '',
  city: '',
  job: '',
  personalizedSignature: '',
  sourceType: '',
  auroraPoint: '',
  auroraBit: ''
}

export default {
  name: 'userList',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      defaultUserInfoList: Object.assign({}, defaultUserInfoList),
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
      // 详情数据
      detailData: {},
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
        pageSize: 10
      },
      // 用户详情弹窗判断标识
      detailDialogVisible: false
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商城用户列表 */
    getList() {
      this.loading = true;
      getUserList(this.listQuery).then(response => {
        const data = response.data.list;
        this.dataList = data;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 用户详情 */
    handleDetail(row) {
      this.loading = true;
      getUserDetail(row.id).then(response => {
        const data = response.data;
        this.detailData = data;
        this.loading = false;
        this.detailDialogVisible = true;
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
      this.$confirm('是否确认删除用户资源编号为"' + ids + '"的数据项?', "警告", {
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
