package com.ahmet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {

    USER_ALREADY_EXISTS(4003, "An account with this email address already exists.", BAD_REQUEST),
    INCORRECT_CREDENTIALS(1001, "Email or password is incorrect.", UNAUTHORIZED),
    INVALID_TOKEN(1002, "Token is invalid.", UNAUTHORIZED),
    PASSWORD_MISMATCH_ERROR(4001, "Password and repassword doesn't match.", BAD_REQUEST),

    MUSTERI_BULUNAMADI(1003, "Aradığınız müşteri sistemde kayıtlı değildir.", INTERNAL_SERVER_ERROR),
    URUN_EKLEME(2001, "Ürün ekleme başarısız oldu", INTERNAL_SERVER_ERROR),
    METHOD_MISMATCH_ERROR(2002, "Giriş yaptığınız değer, istenilen değerle uyuşmamaktadır.", BAD_REQUEST),
    METHOD_NOT_VALID_ARGUMENT_ERROR(2003, "URL içinde eksik parametre gönderimi", BAD_REQUEST),
    INVALID_PARAMETER(3001, "Geçersiz parametre girişi yaptınız", BAD_REQUEST),

            ;

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
