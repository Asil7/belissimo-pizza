package uzpdp.belissimopizza.Servise;

//Asilbek Fayzullayev 10.04.2022 1:17   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzpdp.belissimopizza.dto.UserDto;
import uzpdp.belissimopizza.model.User;
import uzpdp.belissimopizza.payload.ApiResponse;
import uzpdp.belissimopizza.repository.RoleRepository;
import uzpdp.belissimopizza.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public ApiResponse getUser() {
        List<User> userList = userRepository.findAll();
        if (userList.size() == 0) {
            return new ApiResponse("List Empty", false);
        }
        return new ApiResponse("Success", true, userList);
    }

//    public ApiResponse addUser(UserDto userDto) {
//        try {
//            User user = new User();
//            user.setFullName(userDto.getFullName());
//            user.setUserName(userDto.getUserName());
//            user.setUserName(userDto.getPassword());
//            user.setGender(userDto.getGender());
//            User save = userRepository.save(user);
//            return new ApiResponse("Successfully added", true, save);
//        } catch (Exception e) {
//            return new ApiResponse("Error", false);
//        }
//    }


    public ApiResponse addUser(User user) {
        try {
            User save = userRepository.save(user);
            return new ApiResponse("Successfully added", true, save);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse editUser(User user, Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ApiResponse("User not found", false);
        }
        User editUser = optionalUser.get();
        editUser.setFullName(user.getFullName());
        editUser.setUserName(user.getUserName());
        editUser.setPassword(user.getPassword());
        editUser.setGender(user.getGender());
        return new ApiResponse("Successfully edited", true, editUser);
    }


    public ApiResponse deleteUser(Integer id) {
        userRepository.deleteAllById(Collections.singleton(id));
        return new ApiResponse("Deleted", true);
    }
}
