package uzpdp.belissimopizza.Servise;

//Asilbek Fayzullayev 09.04.2022 15:48   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzpdp.belissimopizza.model.Category;
import uzpdp.belissimopizza.payload.ApiResponse;
import uzpdp.belissimopizza.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.size() == 0) {
            return new ApiResponse("List Empty", false);
        }
        return new ApiResponse("Success", true, categoryList);
    }


    public ApiResponse getCategoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return new ApiResponse("Success", true, optionalCategory);
        }
        return new ApiResponse("Category not found", false);
    }


    public ApiResponse addCategory(Category category) {
        try {

            Category save = categoryRepository.save(category);
            return new ApiResponse("Successfully added", true, save);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse editCategory(Integer id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category editCategory = optionalCategory.get();
            editCategory.setName(category.getName());
            return new ApiResponse("Successfully edited", true, editCategory);
        }
        return new ApiResponse("Error", false);
    }

    public ApiResponse deleteCategory(Integer id) {
        try {
            categoryRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Category not found", false);
        }
    }
}
