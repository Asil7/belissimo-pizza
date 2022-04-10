package uzpdp.belissimopizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.City;
import uzpdp.belissimopizza.model.Role;
import uzpdp.belissimopizza.model.User;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
