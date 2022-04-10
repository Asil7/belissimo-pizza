package uzpdp.belissimopizza.controller;

//Asilbek Fayzullayev 09.04.2022 16:10   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzpdp.belissimopizza.Servise.CityService;
import uzpdp.belissimopizza.Servise.CityService;
import uzpdp.belissimopizza.model.City;
import uzpdp.belissimopizza.payload.ApiResponse;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping
    public HttpEntity<?> getAllCity(){
        ApiResponse allCity = cityService.getAllCity();
        return ResponseEntity.status(allCity.isSuccess()?200:400).body(allCity);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCityById(@PathVariable Integer id){
        ApiResponse cityById = cityService.getCityById(id);
        return ResponseEntity.status(cityById.isSuccess()?200:400).body(cityById);
    }

    @PostMapping
    public HttpEntity<?> addCity(@RequestBody City city){
        ApiResponse apiResponse = cityService.addCity(city);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editCity(@RequestBody City city,@PathVariable Integer id){
        ApiResponse apiResponse = cityService.editCity(id, city);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete (@PathVariable Integer id){
        ApiResponse apiResponse = cityService.deleteCity(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }
}
