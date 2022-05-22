package com.swietlicki.library.controller;

import com.swietlicki.library.config.securityConfig.LoginCredentials;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "", tags = "A. Login endpoint used to obtain authorization in SWAGGER")
public class LoginController {

    @ApiOperation(value = "Log in by typing both login and password 'test'")
    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {
    }
}
