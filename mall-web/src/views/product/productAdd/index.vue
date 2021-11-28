<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <span>添加商品</span>
      <i style="float: right; padding: 3px 0" class="el-icon-user-solid"></i>
    </el-card>

    <el-card class="box-card" style="margin-top: 30px" shadow="never">
      <el-form :model="form" :rules="rules" ref="form" label-width="120px" style="width: 1000px; margin: auto" size="small">
        <el-form-item label="商品名称：" prop="name">
          <el-input v-model="form.name" placeholder="请输入商品名称"></el-input>
        </el-form-item>
        <el-form-item label="副标题：" prop="subTitle">
          <el-input v-model="form.subTitle" placeholder="请输入副标题"></el-input>
        </el-form-item>
        <el-form-item label="商品描述：" prop="description">
          <el-input
            type="textarea"
            autosize
            placeholder="请输入商品描述"
            v-model="form.description"
            maxlength="300"
            show-word-limit
          >
          </el-input>
        </el-form-item>
        <el-form-item label="库存：" prop="stock">
          <el-input v-model="form.stock" placeholder="请输入库存"></el-input>
        </el-form-item>
        <el-form-item label="库存预警值：" prop="lowStock">
          <el-input v-model="form.lowStock" placeholder="请输入库存预警值"></el-input>
        </el-form-item>
        <el-form-item label="单位：" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位"></el-input>
        </el-form-item>
        <el-form-item label="商品重量：" prop="weight">
          <el-input v-model="form.weight" placeholder="商品重量，默认为克"></el-input>
        </el-form-item>
        <el-form-item label="商品图片：" prop="pic">
          <el-upload
            class="upload-demo"
            action="https://img.besscroft.com/api/upload"
            :headers="token"
            name="image"
            :file-list="picList"
            :on-success="handleSuccess"
            :on-error="handleError"
            list-type="picture">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="商品品牌：" prop="brandId">
          <el-select v-model="form.brandId" placeholder="请选择商品品牌">
            <el-option
              v-for="item in brandDataList"
              :key="item.brandId"
              :label="item.brandName"
              :value="{ value: item.brandId, label: item.brandName }">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品类型：" prop="brandId">
          <el-select v-model="form.productTypeId" placeholder="请选择商品类型">
            <el-option
              v-for="item in productTypeDataList"
              :key="item.productTypeId"
              :label="item.productTypeName"
              :value="{ value: item.productTypeId, label: item.productTypeName }">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品分类：" prop="brandId">
          <el-select v-model="form.productCategoryId" placeholder="请选择商品分类">
            <el-option
              v-for="item in productCategoryDataList"
              :key="item.productCategoryId"
              :label="item.productCategoryName"
              :value="{ value: item.productCategoryId, label: item.productCategoryName }">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品货号/编号：" prop="productSn">
          <el-input v-model="form.productSn" placeholder="请输入商品货号/编号"></el-input>
        </el-form-item>
        <el-form-item label="是否为新品：" prop="newStatus">
          <el-select v-model="form.newStatus" placeholder="请选择新品状态">
            <el-option label="新品" :value="1"></el-option>
            <el-option label="不是新品" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否推荐：" prop="recommandStatus">
          <el-select v-model="form.recommandStatus" placeholder="请选择推荐状态">
            <el-option label="推荐" :value="1"></el-option>
            <el-option label="不推荐" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="排序：" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序值，默认升序"></el-input>
        </el-form-item>
        <el-form-item label="标价：" prop="sale">
          <el-input v-model="form.sale" placeholder="请输入标价"></el-input>
        </el-form-item>
        <el-form-item label="赠送的极光值：" prop="auroraPoint">
          <el-input v-model="form.auroraPoint" placeholder="请输入赠送的极光值"></el-input>
        </el-form-item>
        <el-form-item label="赠送的极光币：" prop="auroraBit">
          <el-input v-model="form.auroraBit" placeholder="请输入赠送的极光币"></el-input>
        </el-form-item>
        <el-form-item label="是否为秒杀商品：" prop="previewStatus">
          <el-select v-model="form.previewStatus" placeholder="请选择是否为秒杀商品">
            <el-option label="是" :value="1"></el-option>
            <el-option label="不是" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品服务：" prop="serviceIds">
          <el-select v-model="form.serviceIds" multiple placeholder="请选择">
            <el-option
              v-for="item in serviceOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品详情标题：" prop="detailTitle">
          <el-input v-model="form.detailTitle" placeholder="请输入产品详情标题"></el-input>
        </el-form-item>
        <el-form-item label="产品详情网页内容：" prop="detailHtml">
          <el-input
            type="textarea"
            autosize
            placeholder="请输入商品描述"
            v-model="form.detailHtml"
            maxlength="1000"
            show-word-limit
          >
          </el-input>
        </el-form-item>
        <el-form-item label="移动/小程序端网页详情：" prop="detailHtml">
          <el-input
            type="textarea"
            autosize
            placeholder="请输入移动/小程序端网页详情"
            v-model="form.detailMobileHtml"
            maxlength="1000"
            show-word-limit
          >
          </el-input>
        </el-form-item>
        <el-form-item label="促销开始时间：" prop="promotionStartTime">
          <el-date-picker
            v-model="form.promotionStartTime"
            type="datetime"
            placeholder="选择日期时间"
            align="right"
            value-format="yyyy-MM-dd HH:mm:ss"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="促销结束时间：" prop="promotionStartTime">
          <el-date-picker
            v-model="form.promotionEndTime"
            type="datetime"
            placeholder="选择日期时间"
            align="right"
            value-format="yyyy-MM-dd HH:mm:ss"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动限购数量：" prop="promotionPerLimit">
          <el-input v-model="form.promotionPerLimit" placeholder="请输入活动限购数量，0为不限购"></el-input>
        </el-form-item>

        <el-form-item style="text-align: center">
          <el-button type="primary" size="medium" @click="handleCommit">提交商品</el-button>
        </el-form-item>
      </el-form>
    </el-card>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { getToken } from "@/api/imgUtils";
import { Message } from "element-ui";
import { productAdd } from '@/api/product/productAdd'
import { getProductBrandDict } from '@/api/product/productBrand'
import { getProductSortDict } from '@/api/product/productSort'
import { getProductTypeDict } from '@/api/product/productType'

const defaultProductParam = {
  // 商品货号/编号
  productSn: '',
  // 商品名称
  name: '',
  // 副标题
  subTitle: '',
  // 商品描述
  description: '',
  // 库存
  stock: 0,
  // 库存预警值
  lowStock: 0,
  // 单位
  unit: '',
  // 商品重量，默认为克
  weight: 0,
  // 商品图片
  pic: '',
  // 商品品牌id
  brandId: '',
  // 品牌名称
  brandName: '',
  // 商品类型id
  productTypeId: '',
  // 商品类型名称
  productTypeName: '',
  // 商品分类id
  productCategoryId: '',
  // 商品分类名称
  productCategoryName: '',
  // 上架状态：0->下架；1->上架
  pushStatus: 0,
  // 新品状态:0->不是新品；1->新品
  newStatus: 0,
  // 推荐状态；0->不推荐；1->推荐
  recommandStatus: 0,
  // 审核状态：0->未审核；1->审核通过
  verifyStatus: 0,
  // 删除状态：0->未删除；1->已删除
  deleteStatus: 0,
  // 排序，默认升序
  sort: 0,
  // 商品总销量
  sale: 0,
  // 标价
  price: 0,
  // 赠送的极光值
  auroraPoint: 0,
  // 赠送的极光币
  auroraBit: 0,
  // 是否为秒杀商品：0->不是；1->是
  previewStatus: 0,
  // 以逗号分割的产品服务：1->包邮；2->急速退款；3->7天无理由；4->此商品不可用极光券
  serviceIds: '',
  // 产品详情标题
  detailTitle: '',
  // 产品详情网页内容
  detailHtml: '',
  // 移动/小程序端网页详情
  detailMobileHtml: '',
  // 促销开始时间
  promotionStartTime: '',
  // 促销结束时间
  promotionEndTime: '',
  // 活动限购数量
  promotionPerLimit: 1
};

export default {
  name: 'productAdd',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data() {
    return {
      productParam: Object.assign({}, defaultProductParam),
      picList: [],
      // 表单参数
      form: Object.assign({}, defaultProductParam),
      // 图片上传接口token
      token: {
        token: ''
      },
      brandDataList: [{brandId: 1, brandName: '测试'}],
      productTypeDataList: [],
      productCategoryDataList: [],
      serviceOptions: [{
        value: '1',
        label: '包邮'
      }, {
        value: '2',
        label: '急速退款'
      }, {
        value: '3',
        label: '7天无理由'
      }, {
        value: '4',
        label: '此商品不可用极光券'
      }],
      pickerOptions: {
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      rules: {},
      dialogFormVisible: false
    }
  },
  created() {
    getToken({ email: 'admin@qq.com', password: 'img123456' }).then(response => {
      const data = response.data
      this.token.token = data.token
      console.log(this.token)
    });
    // 获取商品品牌字典
    getProductBrandDict().then(response => {
      const data = response.data
      this.brandDataList = data
    });
    // 获取商品分类字典
    getProductSortDict().then(response => {
      const data = response.data
      this.productCategoryDataList = data
    });
    // 商品类型字典
    getProductTypeDict().then(response => {
      const data = response.data
      this.productTypeDataList = data
    });
  },
  watch: {
    dialogFormVisible(val) {
      if (!val) {
        this.resetForm()
      }
    },
  },
  methods: {
    /** 文件上传成功 */
    handleSuccess(response, file, picList) {
      console.log(response)
      if (response.code == 200) {
        Message.success(response.msg)
      } else {
        Message.error(response.msg)
      }
      this.form.pic = response.data.url
    },
    /** 文件上传失败 */
    handleError(file, picList) {
      console.log(file, picList)
    },
    /** 提交商品 */
    handleCommit() {
      this.form.brandName = this.form.brandId.label
      this.form.brandId = this.form.brandId.value
      this.form.productTypeName = this.form.productTypeId.label
      this.form.productTypeId = this.form.productTypeId.value
      this.form.productCategoryName = this.form.productCategoryId.label
      this.form.productCategoryId = this.form.productCategoryId.value
      this.form.serviceIds = JSON.stringify(this.form.serviceIds)
      productAdd(this.form).then(response => {
        console.log(response)
        if (response.code == 200) {
          Message.success(response.message)
        } else {
          Message.error(response.message)
        }
        this.dialogFormVisible = false
      });
    },
    // 重置表单为初始值并移除校验结果
    resetForm() {
      this.$refs["form"].resetFields()
      this.form = Object.assign({}, defaultProductParam)
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
