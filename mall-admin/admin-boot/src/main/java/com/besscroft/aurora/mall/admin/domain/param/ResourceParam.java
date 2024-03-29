package com.besscroft.aurora.mall.admin.domain.param;

import com.besscroft.aurora.mall.common.entity.AuthResource;
import lombok.Data;

import java.util.List;

/**
 * 资源树封装
 *
 * @Author Bess Croft
 * @Date 2021/4/16 15:40
 */
@Data
public class ResourceParam {

    /** 资源类别id */
    private Long id;

    /** 资源类别名称 */
    private String name;

    /** 可选状态 */
    private boolean disabled;

    private List<AuthResource> children;

}
