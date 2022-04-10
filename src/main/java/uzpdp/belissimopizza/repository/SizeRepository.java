package uzpdp.belissimopizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.City;
import uzpdp.belissimopizza.model.Size;

public interface SizeRepository extends JpaRepository<Size,Integer> {
}
