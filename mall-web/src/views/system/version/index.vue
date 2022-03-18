<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <span>版本更新/发布日志</span>
      <i style="float: right; padding: 3px 0" class="el-icon-s-promotion"></i>
    </el-card>

    <el-card class="box-card" shadow="hover" style="margin-top: 1.25em">
      <el-collapse v-model="activeNames" v-for="item in items" :key="item.name">
        <el-collapse-item :name="item.name">
          <template slot="title">
            <i :class="item.titleIcon" style="margin-left: 5px;"></i>&nbsp;{{item.title}}
            <el-tag :type="item.titleType" style="margin-left: 5px;">{{item.titleTagInfo}}</el-tag>
            <el-tag style="margin-left: 5px;">{{item.titleTag}}</el-tag>
            <el-tag style="margin-left: 5px;" effect="dark">{{item.titleTime}}</el-tag>
          </template>
          <ul v-for="itail in item.detail" :key="itail.id">
            <li>{{itail.body}}</li>
          </ul>
        </el-collapse-item>
      </el-collapse>
    </el-card>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { listUpdateLog } from '@/api/system/version'

export default {
  name: 'version',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      // 默认展开的面板的name值
      activeNames: ['3'],
      // 这里放数据
      items: [
        // 这里是模板，可复制一份填写（数据必须是json格式，否则将解析错误）
        // {
        //     name: "3",           // 这个是name，对应上面的activeNames，如果有相应的值，会默认展开
        //     title: "v.0.0.3",    // 这个将显示版本号
        //     titleIcon: "el-icon-s-promotion",    // 这个将显示图标https://element.eleme.cn/#/zh-CN/component/icon
        //     titleType: "warning",                // 这个是第一个tag的样式，可选值：success，info，warning，danger
        //     titleTagInfo: "样式更新",             // 这个是第一个tag的内容
        //     titleTag: "稳定版",                   // 这个是第二个tag的内容
        //     titleTime: "这里放时间",                       // 这里是第三个tag的内容
        //     detail: [                // 这里是列表项要显示的内容，为一个数组
        //         {
        //             id: 1,           // 列表项子项的id
        //             body: "内容"      // 列表项子项的内容
        //         }
        //     ]
        // }
        {
          name: "3",
          title: "v.0.0.3",
          titleIcon: "el-icon-s-promotion",
          titleType: "warning",
          titleTagInfo: "样式更新",
          titleTag: "稳定版",
          titleTime: "2020-01-08",
          detail: [
            {
              id: 1,
              body: "[fix] 修改部分模块的Excel导出功能"
            },
            {
              id: 2,
              body: "[feat] 新增发行说明模块页面"
            },
            {
              id: 3,
              body: "[Dev] 常规升级"
            },
            {
              id: 4,
              body: "[fix] 修复了样式处理效果，提升了性能"
            }
          ]
        }
      ]
    }
  },
  created() {
    this.getList();
  },
  methods: {
    /** 获取版本日志列表 */
    getList() {
      this.loading = true;
      listUpdateLog().then(response => {
        console.log(response.data)
        const data = response.data;
        this.items = data;
        this.activeNames = data.length;
        this.loading = false;
      });
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
