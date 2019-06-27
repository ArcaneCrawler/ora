package com.math.epidemic.Services;

import com.math.epidemic.Entities.Login;
import com.math.epidemic.Repositories.LoginRepository;
import com.math.epidemic.Repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void add(Login login) {
        loginRepository.save(login);
    }

    public void delete(Login login) {
        loginRepository.delete(login);
    }

    public List<Login> findAll() {
        return loginRepository.findAll();
    }
}
