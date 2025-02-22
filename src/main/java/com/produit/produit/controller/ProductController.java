package com.produit.produit.controller;

import com.produit.produit.model.Produit;
import com.produit.produit.service.ProduitService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("all")
    public List<Produit> getallProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public  Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }
}
