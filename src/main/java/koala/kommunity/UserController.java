package koala.kommunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import koala.kommunity.DTOs.User.CreateUserRequest;
import koala.kommunity.DTOs.User.EnumCreateUserResult;
import koala.kommunity.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/")
    public String test(){
        return "test users";
    }

    @PostMapping("/create")
    public EnumCreateUserResult createUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }
}
