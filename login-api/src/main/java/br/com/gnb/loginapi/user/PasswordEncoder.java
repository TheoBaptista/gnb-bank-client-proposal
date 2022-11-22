package br.com.gnb.loginapi.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    private final BCryptPasswordEncoder encoder;

    public PasswordEncoder() {
        this.encoder = new BCryptPasswordEncoder();
    }

    public static PasswordEncoder build() {
        return new PasswordEncoder();
    }

    public String encode(String password){
        return encoder.encode(password);
    }

}
