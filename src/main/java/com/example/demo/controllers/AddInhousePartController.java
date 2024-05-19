package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.service.InhousePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddInhousePartController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("inhousepart", part);

        // Check for validation errors
        if(theBindingResult.hasErrors()){
            return "InhousePartForm";
        }

        // Validate inventory levels
        if(part.getInv() < part.getMinInventory() || part.getInv() > part.getMaxInventory()) {
            theBindingResult.addError(new FieldError("inhousepart", "inv", "Inventory must be between Minimum and Maximum"));
            return "InhousePartForm";
        }

        // Save part if validation passes
        InhousePartService repo=context.getBean(InhousePartService.class);
        InhousePart ip=repo.findById((int)part.getId());
        if(ip != null) {
            part.setProducts(ip.getProducts());
        }
        repo.save(part);

        return "confirmationaddpart";
    }
}