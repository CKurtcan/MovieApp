package com.CK.mapper;

import com.CK.dto.request.RegisterRequestDto;
import com.CK.dto.response.LoginResponseDto;
import com.CK.dto.response.RegisterResponseDto;
import com.CK.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    LoginResponseDto fromUserToLoginResponseDto(User user);

    User fromRegisterRequestDtoToUser(RegisterRequestDto dto);

    RegisterResponseDto fromUserToRegisterResponseDto(User user);
}
