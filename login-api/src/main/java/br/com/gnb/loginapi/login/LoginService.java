package br.com.gnb.loginapi.login;

import br.com.gnb.loginapi.security.TokenService;
import br.com.gnb.loginapi.user.User;
import br.com.gnb.loginapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Override //make tests here
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(email) ;
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }
        return user.get();
    }

    public String getTokenLogin(LoginRequest request){
        UsernamePasswordAuthenticationToken loginData = request.converterTo();

        Authentication auth = authManager.authenticate(loginData);
        String token = tokenService.generateToken(auth);

        return token;
    }

}
