package uzpdp.belissimopizza.controller;

//Asilbek Fayzullayev 10.04.2022 1:19   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzpdp.belissimopizza.Servise.UserService;
import uzpdp.belissimopizza.dto.UserDto;
import uzpdp.belissimopizza.model.User;
import uzpdp.belissimopizza.payload.ApiResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public HttpEntity<?> getUser() {
        ApiResponse user = userService.getUser();
        return ResponseEntity.status(user.isSuccess() ? 200 : 400).body(user);
    }

    @PostMapping
    public HttpEntity<?> addUser(@RequestBody User user) {
        ApiResponse apiResponse = userService.addUser(user);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editUser(@RequestBody User user, Integer id) {
        ApiResponse apiResponse = userService.editUser(user, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.deleteUser(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

}
