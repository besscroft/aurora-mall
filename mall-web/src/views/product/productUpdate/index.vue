<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <span>更新商品</span>
      <i style="float: right; padding: 3px 0" class="el-icon-user-solid"></i>
    </el-card>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import {getToken} from "@/api/imgUtils";

export default {
  name: 'productUpdate',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      productId: null
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
