package com.produit.produit.service;

import com.produit.produit.model.Produit;
import com.produit.produit.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Desolé produit inexistant");
        }

        return optionalProduit.get();
    }

    public String deleteProduitById(long idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);

        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Suppression impossible: produit inexistant");
        }

        produitRepository.delete(optionalProduit.get());

        return "Produit supprimé avec succès !";
    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Modification impossible");
        }

        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setName(produit.getName());
        produitAModifier.setPrice(produit.getPrice());

        return produitRepository.save(produitAModifier);
    }
}
