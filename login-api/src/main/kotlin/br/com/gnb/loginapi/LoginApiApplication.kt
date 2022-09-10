package br.com.gnb.loginapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoginApiApplication

fun main(args: Array<String>) {
	runApplication<LoginApiApplication>(*args)
}
