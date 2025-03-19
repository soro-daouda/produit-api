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

    @GetMapping("all")
    public List<Produit> getallProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public  Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }

    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable long id){
        return produitService.getProduitById(id);
    }

    @DeleteMapping("{id}")
    public String deleteProduitById(@PathVariable("id") long idProduit){
        return produitService.deleteProduitById(idProduit);
    }

    @PutMapping("{id}")
    public Produit editProduit(@PathVariable long id, @RequestBody Produit produit){
        return produitService.editProduit(id, produit);
    }
}
