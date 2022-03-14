package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.AuthUserMapper;
import com.besscroft.aurora.mall.admin.mapper.ProductMapper;
import com.besscroft.aurora.mall.admin.service.ProductService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.domain.ProductExcelDto;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.entity.Product;
import com.besscroft.aurora.mall.admin.converter.ProductConverterMapper;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/5/15 19:26
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final AuthUserMapper authUserMapper;
    private final UserService userService;

    @Override
    public List<Product> getProductPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectProductListByPage(keyword);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean productAdd(Product product) {
        // 获取当前用户
        AuthUser currentAdmin = userService.getCurrentAdmin();
        // 设置商品唯一id
        product.setId("P" + IdUtil.simpleUUID());
        // 设置新增商品的用户
        product.setCreateUserId(currentAdmin.getId());
        return this.baseMapper.insert(product) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean productDel(String id) {
        return this.baseMapper.deleteByProductId(id) > 0;
    }

    @Override
    public void export(List<String> ids, HttpServletResponse response) {
        List<Product> productList = this.baseMapper.selectBatchIds(ids);
        if (CollUtil.isNotEmpty(productList)) {
            List<ProductExcelDto> productExcelDtos = ProductConverterMapper.INSTANCE.productToProductExcelListDto(productList);
            productExcelDtos.forEach(productExcelDto -> {
                String pushStatus = productExcelDto.getPushStatus();
                switch (pushStatus) {
                    case "0":
                        productExcelDto.setPushStatus("下架");
                        break;
                    case "1":
                        productExcelDto.setPushStatus("上架");
                        break;
                }
                String newStatus = productExcelDto.getNewStatus();
                switch (newStatus) {
                    case "0":
                        productExcelDto.setNewStatus("不是新品");
                        break;
                    case "1":
                        productExcelDto.setNewStatus("新品");
                        break;
                }
                String recommandStatus = productExcelDto.getRecommandStatus();
                switch (recommandStatus) {
                    case "0":
                        productExcelDto.setRecommandStatus("不推荐");
                        break;
                    case "1":
                        productExcelDto.setRecommandStatus("推荐");
                        break;
                }
                String verifyStatus = productExcelDto.getVerifyStatus();
                switch (verifyStatus) {
                    case "0":
                        productExcelDto.setVerifyStatus("未审核");
                        break;
                    case "1":
                        productExcelDto.setVerifyStatus("审核通过");
                        break;
                }
                String deleteStatus = productExcelDto.getDeleteStatus();
                switch (deleteStatus) {
                    case "0":
                        productExcelDto.setDeleteStatus("未删除");
                        break;
                    case "1":
                        productExcelDto.setDeleteStatus("已删除");
                        break;
                }
                AuthUser user = authUserMapper.selectById(productExcelDto.getCreateUser());
                productExcelDto.setCreateUser(user.getUsername());
            });
            try {
                // 这里注意 有同学反应使用 swagger 会导致各种问题，请直接用浏览器或者用 postman
                response.setContentType("application/vnd.ms-excel");
                // 设置返回的数据编码
                response.setCharacterEncoding("utf-8");
                // 这里 URLEncoder.encode 可以防止中文乱码 当然和 easyexcel 没有关系
                String fileName = URLEncoder.encode("商品信息", "UTF-8").replaceAll("\\+", "%20");
                response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
                EasyExcel.write(response.getOutputStream(), ProductExcelDto.class).autoCloseStream(true).sheet("商品信息").doWrite(productExcelDtos);
            } catch (IOException e) {
                log.error("excel 导出失败.", e);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitchPush(Integer hidden, String id) {
        return this.baseMapper.changeSwitch(hidden, null, null, id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitchNew(Integer hidden, String id) {
        return this.baseMapper.changeSwitch(null, hidden, null, id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitchRecommend(Integer hidden, String id) {
        return this.baseMapper.changeSwitch(null, null, hidden, id) > 0;
    }

}
