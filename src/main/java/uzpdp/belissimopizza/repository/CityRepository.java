package uzpdp.belissimopizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.City;

public interface CityRepository extends JpaRepository<City,Integer> {
}
