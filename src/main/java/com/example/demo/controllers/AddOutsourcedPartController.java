package com.example.demo.controllers;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.service.OutsourcedPartService;
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
public class AddOutsourcedPartController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        OutsourcedPart part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("outsourcedpart", part);

        // Check for validation errors
        if(bindingResult.hasErrors()){
            return "OutsourcedPartForm";
        }

        // Validate inventory levels
        if(part.getInv() < part.getMinInventory() || part.getInv() > part.getMaxInventory()) {
            bindingResult.addError(new FieldError("outsourcedpart", "inv", "Inventory must be between Minimum and Maximum"));
            return "OutsourcedPartForm";
        }

        // Save part if validation passes
        OutsourcedPartService repo=context.getBean(OutsourcedPartService.class);
        OutsourcedPart op=repo.findById((int)part.getId());
        if(op != null) {
            part.setProducts(op.getProducts());
        }
        repo.save(part);

        return "confirmationaddpart";
    }
}
