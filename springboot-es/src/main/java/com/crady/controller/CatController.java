package com.crady.controller;

import com.crady.entity.Cat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Crady
 * date :2019/9/12 11:58
 * desc :
 **/
@RestController("cat")
public class CatController {


    @GetMapping("getCatById/{id}")
    public Cat getCatById(@RequestParam Long id){
        return null;
    }

    @GetMapping("putCat")
    public String putCat(Cat cat){
        return "put success";
    }
}
