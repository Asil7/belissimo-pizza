package uzpdp.belissimopizza.repository;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uzpdp.belissimopizza.model.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer>{

    List<Address> findByCityId(Integer cityId);

}
