package com.besscroft.aurora.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.besscroft.aurora.mall.common.entity.Product;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 后台管理商品服务
 *
 * @Author Bess Croft
 * @Date 2021/5/15 19:25
 */
public interface ProductService extends IService<Product> {

    /**
     * 分页查询所有商品
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页商品列表
     */
    List<Product> getProductPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 新增商品
     * @param product 商品参数(新增）
     * @return
     */
    boolean productAdd(Product product);

    /**
     * 删除商品
     * @param id
     * @return
     */
    boolean productDel(String id);

    /**
     * 导出商品信息
     * @param ids
     * @param response
     */
    void export(List<String> ids, HttpServletResponse response);

    /**
     * 修改上架状态
     * @param hidden 状态值
     * @param id 商品id
     * @return
     */
    boolean changeSwitchPush(Integer hidden, String id);

    /**
     * 修改新品状态
     * @param hidden 状态值
     * @param id 商品id
     * @return
     */
    boolean changeSwitchNew(Integer hidden, String id);

    /**
     * 修改推荐状态
     * @param hidden 状态值
     * @param id 商品id
     * @return
     */
    boolean changeSwitchRecommend(Integer hidden, String id);

}
