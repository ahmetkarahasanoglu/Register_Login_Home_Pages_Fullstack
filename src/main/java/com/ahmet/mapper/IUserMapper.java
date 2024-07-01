package com.ahmet.mapper;

import com.ahmet.dto.request.UserSaveRequestDto;
import com.ahmet.dto.response.LoginResponseDto;
import com.ahmet.dto.response.UserSaveResponseDto;
import com.ahmet.repository.entity.Userr;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    Userr toUser(UserSaveRequestDto dto);
    UserSaveResponseDto toUserSaveResponseDto(Userr user);

    LoginResponseDto toLoginResponseDto(Userr user);

}
