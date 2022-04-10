package uzpdp.belissimopizza.repository;

//Asilbek Fayzullayev 10.04.2022 12:39   

import org.springframework.data.jpa.repository.JpaRepository;
import uzpdp.belissimopizza.model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}
