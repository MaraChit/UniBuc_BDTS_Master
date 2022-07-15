package com.example.proiectfinal.repositories;

import com.example.proiectfinal.model.Category;
import com.example.proiectfinal.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void TestAddCategorys()
    {
        Category category = new Category();
        category.setCategoryName("Comedy");

        Category savedCategory = categoryRepository.save(category);

        Category existingCategory = testEntityManager.find(Category.class, savedCategory.getId());

        assertThat(existingCategory.getCategoryName()).isEqualTo(category.getCategoryName());
    }
}
