package uce.edu.ec.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.repositories.UserRepository;
import uce.edu.ec.services.interfaces.UserService;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
