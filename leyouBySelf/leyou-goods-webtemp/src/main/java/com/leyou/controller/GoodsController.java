package com.leyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class GoodsController {
    @GetMapping("{id}.html")
    public String toItemPage(@PathVariable("id") Long id){
        return "item";
    }
}
