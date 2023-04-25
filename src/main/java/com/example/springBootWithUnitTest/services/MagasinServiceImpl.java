package com.example.springBootWithUnitTest.services;

import com.example.springBootWithUnitTest.entites.Magasin;
import com.example.springBootWithUnitTest.repositories.MagasinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagasinServiceImpl implements IMagasinService{

    @Autowired
    MagasinRepository mr;

    @Override
    public Magasin ajouterEtModifierMagasin(Magasin m) {
        return mr.save(m);
    }

    @Override
    public List<Magasin> listerMagasins() {
        return mr.findAll();
    }

    @Override
    public Magasin chercherMagasinAvecId(long id) { return mr.findById(id).get(); }

    @Override
    public void supprimerMagasin(long id) { mr.deleteById(id); }

    @Override
    public long compter() { return  mr.count(); }

}
