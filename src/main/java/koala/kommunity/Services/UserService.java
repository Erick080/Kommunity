package koala.kommunity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import koala.kommunity.DTOs.User.CreateUserRequest;
import koala.kommunity.DTOs.User.EnumCreateUserResult;
import koala.kommunity.DTOs.User.UserMapper;
import koala.kommunity.Persistence.UserJPA;
import koala.kommunity.Persistence.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public EnumCreateUserResult createUser(CreateUserRequest request){
        if (userRepository.existsByEmail(request.getEmail())) {
            return EnumCreateUserResult.EMAIL_ALREADY_IN_USE;
        }
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        UserJPA userJPA = UserMapper.toJPA(request);
        userRepository.save(userJPA);
        return EnumCreateUserResult.SUCCESS;
    }
}
