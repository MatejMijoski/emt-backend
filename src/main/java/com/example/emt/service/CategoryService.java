package com.example.emt.service;

import com.example.emt.model.enumerations.Category;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    public List<Category> listCategories() {
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}
