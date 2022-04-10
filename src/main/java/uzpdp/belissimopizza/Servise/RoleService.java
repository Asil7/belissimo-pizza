package uzpdp.belissimopizza.Servise;

//Asilbek Fayzullayev 09.04.2022 15:40   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzpdp.belissimopizza.model.Role;
import uzpdp.belissimopizza.payload.ApiResponse;
import uzpdp.belissimopizza.repository.RoleRepository;
import uzpdp.belissimopizza.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public ApiResponse getAllRole() {
        List<Role> roleList = roleRepository.findAll();
        if (roleList.size() == 0) {
            return new ApiResponse("List Empty", false);
        }
        return new ApiResponse("Success", true, roleList);
    }


    public ApiResponse getRoleById(Integer id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            return new ApiResponse("Success", true, optionalRole);
        }
        return new ApiResponse("Role not found", false);
    }


    public ApiResponse addRole(Role role) {
        try {

            Role save = roleRepository.save(role);
            return new ApiResponse("Successfully added", true, save);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse editRole(Integer id, Role role) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role editRole = optionalRole.get();
            editRole.setRole(role.getRole());
            return new ApiResponse("Successfully edited", true, editRole);
        }
        return new ApiResponse("Error", false);
    }

    public ApiResponse deleteRole(Integer id) {
        try {
            roleRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Role not found", false);
        }
    }

}
