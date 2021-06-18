package controllers;

import lombok.RequiredArgsConstructor;
import models.Category;
import org.springframework.stereotype.Controller;
import repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@Transactional
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find category with id " + id));
    }
}
