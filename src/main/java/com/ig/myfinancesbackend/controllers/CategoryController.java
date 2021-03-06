package com.ig.myfinancesbackend.controllers;

import com.ig.myfinancesbackend.models.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @RequestMapping(method= RequestMethod.GET)
    public List<Category> listar() {
        Category cat1 = new Category("1", "Entrada");

        List<Category> list = new ArrayList<>();
        list.add(cat1);

        return list;

    }
}
