package br.com.gnb.loginapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HelloWorldController {

    @GetMapping
    fun getHello(): String {
       return "Hello login-api"
    }
}