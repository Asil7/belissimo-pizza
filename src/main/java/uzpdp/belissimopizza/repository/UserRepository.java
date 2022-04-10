package uzpdp.belissimopizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
