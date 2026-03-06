package com.jose.ia.spring.palindrome.EjercicioPalindromo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/WordController")
public class WordController {
    
    @GetMapping("/isPalindrome/{word}")
    public String isPalindrome(@PathVariable String word) {
        if(word.equals(new StringBuilder(word).reverse().toString())){
            return "Es palíndroma";
        }
        return "No es palíndroma";
    }
    
}
