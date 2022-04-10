package uzpdp.belissimopizza.Servise;

//Asilbek Fayzullayev 09.04.2022 23:52   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzpdp.belissimopizza.dto.AddressDto;
import uzpdp.belissimopizza.model.Address;
import uzpdp.belissimopizza.model.City;
import uzpdp.belissimopizza.payload.ApiResponse;
import uzpdp.belissimopizza.repository.AddressRepository;
import uzpdp.belissimopizza.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CityRepository cityRepository;

    public ApiResponse getAllAddress() {
        List<Address> addressList = addressRepository.findAll();
        if (addressList.size() == 0) {
            return new ApiResponse("List Empty", false);
        }
        return new ApiResponse("Success", true, addressList);
    }

    public ApiResponse getAllAddressByCityId(Integer id) {
        List<Address> byCityId = addressRepository.findByCityId(id);
        if (byCityId.size() == 0) {
            return new ApiResponse("Error", false);
        }
        return new ApiResponse("Success", true, byCityId);
    }

    public ApiResponse addAddress(AddressDto addressDto) {
        try {
            Address address = new Address();
            address.setLatitude(addressDto.getLatitude());
            address.setLongitude(addressDto.getLongitude());
            Optional<City> optionalCity = cityRepository.findById(addressDto.getCityId());
            if (!optionalCity.isPresent())
                return new ApiResponse("City not found", false);
            address.setCity(optionalCity.get());
            Address save = addressRepository.save(address);
            return new ApiResponse("Successfully added", true, save);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse deleteAddress(Integer id) {
        try {
            addressRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }
}
