package uzpdp.belissimopizza.repository;

//Asilbek Fayzullayev 09.04.2022 15:35   

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.Card;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
