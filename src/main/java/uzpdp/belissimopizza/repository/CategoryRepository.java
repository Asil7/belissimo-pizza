package uzpdp.belissimopizza.repository;

//Asilbek Fayzullayev 09.04.2022 15:47   

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
