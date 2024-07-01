package com.ahmet.service;

import com.ahmet.dto.request.LoginRequestDto;
import com.ahmet.dto.request.UserSaveRequestDto;
import com.ahmet.dto.response.UserSaveResponseDto;
import com.ahmet.exception.EErrorType;
import com.ahmet.exception.ProjectManagerException;
import com.ahmet.mapper.IUserMapper;
import com.ahmet.repository.IUserRepository;
import com.ahmet.repository.entity.Userr;
import com.ahmet.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;
    private final JwtTokenManager tokenManager;
    private final PasswordEncoder passwordEncoder;

    public UserSaveResponseDto save(UserSaveRequestDto dto) {
        if(!dto.getPassword().equals(dto.getRepassword())) {
            throw new ProjectManagerException(EErrorType.PASSWORD_MISMATCH_ERROR);
        }
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        boolean isAlreadyExist = repository.existsByEmail(dto.getEmail());
        if(isAlreadyExist) {
            throw new ProjectManagerException(EErrorType.USER_ALREADY_EXISTS);
        }
        Userr user = IUserMapper.INSTANCE.toUser(dto);
        repository.save(user);
        return IUserMapper.INSTANCE.toUserSaveResponseDto(user);
    }

    public String login(LoginRequestDto dto) {
        Optional<Userr> userOptional = repository.findOptionalByEmail(dto.getEmail());
        if(userOptional.isEmpty() || !passwordEncoder.matches(dto.getPassword(), userOptional.get().getPassword())) {
            throw new ProjectManagerException(EErrorType.INCORRECT_CREDENTIALS);
        } else {
            return tokenManager.createToken(userOptional.get().getId()).get();
        }
    }

    public Optional<Userr> findById(Long id) {
        return repository.findById(id);
    }
}
