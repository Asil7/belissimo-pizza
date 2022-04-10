package uzpdp.belissimopizza.controller;

//Asilbek Fayzullayev 09.04.2022 16:10   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzpdp.belissimopizza.Servise.SizeService;
import uzpdp.belissimopizza.Servise.SizeService;
import uzpdp.belissimopizza.model.Size;
import uzpdp.belissimopizza.payload.ApiResponse;

@RestController
@RequestMapping("/api/size")
public class SizeController {
    @Autowired
    SizeService sizeService;

    @GetMapping
    public HttpEntity<?> getAllSize(){
        ApiResponse allSize = sizeService.getAllSize();
        return ResponseEntity.status(allSize.isSuccess()?200:400).body(allSize);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getSizeById(@PathVariable Integer id){
        ApiResponse cityById = sizeService.getSizeById(id);
        return ResponseEntity.status(cityById.isSuccess()?200:400).body(cityById);
    }

    @PostMapping
    public HttpEntity<?> addSize(@RequestBody Size city){
        ApiResponse apiResponse = sizeService.addSize(city);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editSize(@RequestBody Size city,@PathVariable Integer id){
        ApiResponse apiResponse = sizeService.editSize(id, city);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete (@PathVariable Integer id){
        ApiResponse apiResponse = sizeService.deleteSize(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }
}
