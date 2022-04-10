package uzpdp.belissimopizza.controller;

//Asilbek Fayzullayev 10.04.2022 0:17   

import com.fasterxml.classmate.members.ResolvedParameterizedMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzpdp.belissimopizza.Servise.AddressService;
import uzpdp.belissimopizza.dto.AddressDto;
import uzpdp.belissimopizza.payload.ApiResponse;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public HttpEntity<?> getAllAddress() {
        ApiResponse allAddress = addressService.getAllAddress();
        return ResponseEntity.status(allAddress.isSuccess() ? 200 : 400).body(allAddress);
    }


    @GetMapping("/{id}")
    public HttpEntity<?> getAddressByCityId(@PathVariable Integer id) {
        ApiResponse allAddressByCityId = addressService.getAllAddressByCityId(id);
        return ResponseEntity.status(allAddressByCityId.isSuccess() ? 200 : 400).body(allAddressByCityId);
    }

    @PostMapping
    public HttpEntity<?> addAddress(@RequestBody AddressDto addressDto) {
        ApiResponse apiResponse = addressService.addAddress(addressDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAddress(@PathVariable Integer id) {
        ApiResponse apiResponse = addressService.deleteAddress(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

}
