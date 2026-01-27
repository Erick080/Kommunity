package koala.kommunity.DTOs.User;

import koala.kommunity.Persistence.UserJPA;

public class UserMapper {
    public static UserJPA toJPA(CreateUserRequest request) {
        return new UserJPA(
            request.getName(),
            request.getEmail(),
            request.getPassword(),
            request.getRole()
        );
    }

}
