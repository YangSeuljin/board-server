package com.sideproject.boardserver.controller;

import com.sideproject.boardserver.aop.LoginCheck;
import com.sideproject.boardserver.dto.CategoryDTO;
import com.sideproject.boardserver.service.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@Log4j2
@Slf4j
public class CategoryController {
    private CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryService = categoryServiceImpl;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void registerCategory(String accountId, @RequestBody CategoryDTO categoryDTO) {
        categoryService.register(accountId, categoryDTO);
    }

    @PatchMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void updateCategory(String accountId,
                               @PathVariable(name = "categoryId") int categoryId,
                               @RequestBody CategoryRequest categoryRequest) {
        CategoryDTO categoryDTO = new CategoryDTO(categoryId, categoryRequest.getName(), CategoryDTO.SortStatus.NEWEST, 10, 1);
        categoryService.update(categoryDTO);
    }

    @DeleteMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void deleteCategories(String accountId, @PathVariable("categoryId") int categoryId) {
        categoryService.delete(categoryId);

    }

    // request 객체
    @Getter
    @Setter
    @AllArgsConstructor
    private static class CategoryRequest {
        private int id;
        private String name;
    }
}
