<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <span>欢迎：{{ name }}</span>
      <i style="float: right; padding: 3px 0" class="el-icon-user-solid"></i>
    </el-card>

    <el-card class="box-card" style="width: 42%; margin-top: 30px">
      <div slot="header" class="clearfix">
        <span>公告</span>
        <el-button style="float: right; padding: 3px 0" type="text">更新公告</el-button>
      </div>
      <div>
        <a href="https://github.com/besscroft/aurora-drive" target="_blank">aurora-mall</a> 是一个微服务商城项目，我做这个项目的目的就是为了以项目驱动学习，其中也参考了不少大佬的项目，同时查阅了大量文档和资料，也在看不少的书 。我一直有写作的习惯（不仅限于博客），如果在练习这个项目的同时，还能够整理出相关的学习笔记那是再好不过了😀目前还在开发中！
        <br />
        <br />
        <a href="https://github.com/besscroft/aurora-mall/blob/main/fork-and-push.md" target="_blank">--> 贡献项目 <--</a>
        <a href="https://mall.doc.besscroft.com/" target="_blank">--> 阅读文档 <--</a>
      </div>
    </el-card>

    <el-card class="box-card" style="width: 42%; margin-top: 30px;">
      <div slot="header" class="clearfix">
        <span>交流：<a target="_blank" href="https://qm.qq.com/cgi-bin/qm/qr?k=QGRHYDL2XE46mQMgl54WtIUl5pSuHVKP&jump_from=webapi"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="GitGitGo" title="GitGitGo"></a></span>
        <br />
        <span>关注：扫描下方二维码！</span>
      </div>
      <div>
        <span></span>
        <img src="https://imgcdn.52bess.com/images/9ae613da046d8.png" style="width: 150px" />
      </div>
    </el-card>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
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
