<template>
  <div>
    <iframe src="http://localhost:8000/swagger-ui/index.html" frameborder="0"></iframe>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'systemDoc',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  mounted(){
    let that = this
    window.onresize = () => {
      let ifdoc = that.$refs.main_page_iframe.contentDocument
      let cHeight = Math.max(ifdoc.body.clientHeight, ifdoc.documentElement.clientHeight)
      let sHeight = Math.max(ifdoc.body.scrollHeight, ifdoc.documentElement.scrollHeight)
      that.$refs.main_page_iframe.style.height = Math.max(cHeight, sHeight) + 'px'
    }
  }
}
</script>

<style lang="scss" scoped>
html,body {
  margin: 0;
  padding: 0;
  border: 0;
  overflow: hidden;
  height: 100%;
}
iframe { width: 100%; height: calc(100vh - 75px); }
</style>
