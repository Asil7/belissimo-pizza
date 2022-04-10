package uzpdp.belissimopizza.repository;

//Asilbek Fayzullayev 10.04.2022 12:40   

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
}
