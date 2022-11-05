package pl.coderslab.charity.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Classes.Category;
import pl.coderslab.charity.Repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}