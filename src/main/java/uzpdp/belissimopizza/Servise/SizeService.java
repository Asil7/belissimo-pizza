package uzpdp.belissimopizza.Servise;

//Asilbek Fayzullayev 09.04.2022 15:40   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzpdp.belissimopizza.model.Size;
import uzpdp.belissimopizza.payload.ApiResponse;
import uzpdp.belissimopizza.repository.SizeRepository;
import uzpdp.belissimopizza.repository.SizeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {
    @Autowired
    SizeRepository sizeRepository;

    public ApiResponse getAllSize() {
        List<Size> sizeList = sizeRepository.findAll();
        if (sizeList.size() == 0) {
            return new ApiResponse("List Empty", false);
        }
        return new ApiResponse("Success", true, sizeList);
    }


    public ApiResponse getSizeById(Integer id) {
        Optional<Size> optionalSize = sizeRepository.findById(id);
        if (optionalSize.isPresent()) {
            return new ApiResponse("Success", true, optionalSize);
        }
        return new ApiResponse("Size not found", false);
    }


    public ApiResponse addSize(Size size) {
        try {
            Size save = sizeRepository.save(size);
            return new ApiResponse("Successfully added", true, save);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse editSize(Integer id, Size size) {
        Optional<Size> optionalSize = sizeRepository.findById(id);
        if (optionalSize.isPresent()) {
            Size editSize = optionalSize.get();
            editSize.setName(size.getName());
            editSize.setPrice(size.getPrice());
            return new ApiResponse("Successfully edited", true, editSize);
        }
        return new ApiResponse("Error", false);
    }

    public ApiResponse deleteSize(Integer id) {
        try {
            sizeRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Size not found", false);
        }
    }

}
