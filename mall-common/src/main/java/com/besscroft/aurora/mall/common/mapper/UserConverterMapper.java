package com.besscroft.aurora.mall.common.mapper;

import com.besscroft.aurora.mall.common.domain.AuthUserExcelDto;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/10/14 10:29
 */
@Mapper(componentModel = "spring")
public interface UserConverterMapper {

    UserConverterMapper INSTANCE = Mappers.getMapper(UserConverterMapper.class);

    @Mappings({
            @Mapping(target = "status", expression = "java(IntegerToString(user.getStatus()))"),
            @Mapping(target = "del", expression = "java(IntegerToString(user.getDel()))")
    })
    AuthUserExcelDto authUserToAuthUserExcelDto(AuthUser user);

    List<AuthUserExcelDto> authUserToAuthUserExcelListDto(List<AuthUser> user);

    default String IntegerToString(Integer source) {
        return String.valueOf(source);
    }

}
