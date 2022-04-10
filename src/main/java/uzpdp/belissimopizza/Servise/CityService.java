package uzpdp.belissimopizza.Servise;

//Asilbek Fayzullayev 09.04.2022 15:40   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzpdp.belissimopizza.model.City;
import uzpdp.belissimopizza.model.City;
import uzpdp.belissimopizza.payload.ApiResponse;
import uzpdp.belissimopizza.repository.CityRepository;
import uzpdp.belissimopizza.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public ApiResponse getAllCity() {
        List<City> cityList = cityRepository.findAll();
        if (cityList.size() == 0) {
            return new ApiResponse("List Empty", false);
        }
        return new ApiResponse("Success", true, cityList);
    }


    public ApiResponse getCityById(Integer id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            return new ApiResponse("Success", true, optionalCity);
        }
        return new ApiResponse("City not found", false);
    }


    public ApiResponse addCity(City city) {
        try {

            City save = cityRepository.save(city);
            return new ApiResponse("Successfully added", true, save);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse editCity(Integer id, City city) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            City editCity = optionalCity.get();
            editCity.setName(city.getName());
            return new ApiResponse("Successfully edited", true, editCity);
        }
        return new ApiResponse("Error", false);
    }

    public ApiResponse deleteCity(Integer id) {
        try {
            cityRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("City not found", false);
        }
    }

}
