package com.denizcakmak.carsearch.controller;

import com.denizcakmak.carsearch.model.Car;
import com.denizcakmak.carsearch.service.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //Creating controller class
@RequestMapping("/cars") //Mapping the bean's method, work for coming request
public class MainController {

    @Autowired  //Inject bean to another bean
    ReadFile readFile;

    @GetMapping(value = "/{criteria}/{key}", produces = "application/json")
    public List<Car> getBook(@PathVariable String criteria,@PathVariable String key) {
        return readFile.search(criteria,key);
    }


}
