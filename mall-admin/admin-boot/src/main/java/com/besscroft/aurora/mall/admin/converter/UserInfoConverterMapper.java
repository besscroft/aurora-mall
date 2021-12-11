package com.besscroft.aurora.mall.admin.converter;

import com.besscroft.aurora.mall.admin.domain.dto.UserInfoDetailDto;
import com.besscroft.aurora.mall.common.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description 商城用户对象转换器
 * @Author Bess Croft
 * @Time 2021/12/11 17:10
 */
@Mapper(componentModel = "spring")
public interface UserInfoConverterMapper {

    UserInfoConverterMapper INSTANCE = Mappers.getMapper(UserInfoConverterMapper.class);

    UserInfoDetailDto userInfoToUserInfoDetailDto(UserInfo userInfo);

}
