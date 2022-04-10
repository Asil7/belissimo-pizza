package uzpdp.belissimopizza.controller;

//Asilbek Fayzullayev 09.04.2022 16:10   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzpdp.belissimopizza.Servise.RoleService;
import uzpdp.belissimopizza.Servise.RoleService;
import uzpdp.belissimopizza.model.Role;
import uzpdp.belissimopizza.payload.ApiResponse;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public HttpEntity<?> getAllRole(){
        ApiResponse allRole = roleService.getAllRole();
        return ResponseEntity.status(allRole.isSuccess()?200:400).body(allRole);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getRoleById(@PathVariable Integer id){
        ApiResponse roleById = roleService.getRoleById(id);
        return ResponseEntity.status(roleById.isSuccess()?200:400).body(roleById);
    }

    @PostMapping
    public HttpEntity<?> addRole(@RequestBody Role role){
        ApiResponse apiResponse = roleService.addRole(role);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editRole(@RequestBody Role role,@PathVariable Integer id){
        ApiResponse apiResponse = roleService.editRole(id, role);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete (@PathVariable Integer id){
        ApiResponse apiResponse = roleService.deleteRole(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }
}
