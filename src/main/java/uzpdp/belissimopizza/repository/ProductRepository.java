package uzpdp.belissimopizza.repository;

//Asilbek Fayzullayev 09.04.2022 15:39   

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
