package com.ahmet.controller;

import com.ahmet.dto.request.LoginRequestDto;
import com.ahmet.dto.request.UserSaveRequestDto;
import com.ahmet.dto.response.LoginResponseDto;
import com.ahmet.dto.response.UserSaveResponseDto;
import lombok.RequiredArgsConstructor;
import com.ahmet.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.ahmet.constants.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(REGISTER)
    public ResponseEntity<UserSaveResponseDto> save(@RequestBody UserSaveRequestDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }

    @PostMapping(DOLOGIN)
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

}
