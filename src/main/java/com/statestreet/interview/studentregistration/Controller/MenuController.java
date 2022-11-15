package com.statestreet.interview.studentregistration.Controller;

import com.statestreet.interview.studentregistration.entity.Menu;
import com.statestreet.interview.studentregistration.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepo menuRepo;

    @PostMapping
    public Menu save(@RequestBody Menu menuDetails){
        return menuRepo.save(menuDetails);
    }

    @GetMapping
    public List<Menu> getMenus() {
        return menuRepo.findAll();
    }
}
