package com.example.springBootWithUnitTest.services;

import com.example.springBootWithUnitTest.entites.Magasin;

import java.util.List;

public interface IMagasinService {
    Magasin ajouterEtModifierMagasin(Magasin m);
    List<Magasin> listerMagasins();
    Magasin chercherMagasinAvecId(long id);
    void supprimerMagasin(long id);
    long compter();
}
