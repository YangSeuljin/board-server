package com.sideproject.boardserver.service;

import com.sideproject.boardserver.dto.CategoryDTO;

public interface CategoryService {
    void register(String accountId, CategoryDTO categoryDTO);
    void update(CategoryDTO categoryDTO);
    void delete(int categoryId);
}
