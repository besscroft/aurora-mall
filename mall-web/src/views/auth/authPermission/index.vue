<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <span>权限管理(暂不开发)</span>
      <i style="float: right; padding: 3px 0" class="el-icon-user-solid"></i>
    </el-card>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'authPermission',
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
