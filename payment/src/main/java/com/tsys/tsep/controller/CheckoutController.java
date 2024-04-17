package com.tsys.tsep.controller;

import com.tsys.tsep.manifest.ManifestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {

    @Autowired
    private ManifestProcessor manifestProcessor;

    @RequestMapping("/payment-form")
    @ResponseBody
    public String getCheckoutPage() {
        return "view"; // Assuming you have a Thymeleaf or other template engine configured
    }

    @RequestMapping("/view")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/viewResponse")
    public ModelAndView view () throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        String manifest = manifestProcessor.generateFinalManifest();
        System.out.println("Manifest: " + manifest);
        modelAndView.addObject("dynamicValue1", manifest);
        return modelAndView;
    }

    @RequestMapping("/saleResponse")
    public ModelAndView sale () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sale");
        return modelAndView;
    }

//    @RequestMapping("/saleResponse")
//    @ResponseBody
//    public String getSalePage() {
//        return "sale"; // Assuming you have a Thymeleaf or other template engine configured
//    }

    @GetMapping("/display-data")
    public ModelAndView displayData() {
        // Create a ModelAndView instance and set the view name
        ModelAndView modelAndView = new ModelAndView("display-data");

        // Add data to the model
        modelAndView.addObject("message", "Hello, World!");
        modelAndView.addObject("number", 42);

        // Return the ModelAndView instance
        return modelAndView;
    }
}
