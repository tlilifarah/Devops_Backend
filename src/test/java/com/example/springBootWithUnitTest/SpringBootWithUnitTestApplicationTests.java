package com.example.springBootWithUnitTest;

import com.example.springBootWithUnitTest.entites.Magasin;
import com.example.springBootWithUnitTest.repositories.MagasinRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
class SpringBootWithUnitTestApplicationTests {

    @Autowired
    MagasinRepository magasinRepository;

    Magasin m =Magasin.builder().nom("GO").adresse("Centre ville, Tunis").telephone(123456789).email("go@gmail.com").build();


    @Test
    @Order(0)
    public void ajouterMagasinTest() {
        m = magasinRepository.save(m);
        log.info(m.toString());
        Assertions.assertNotNull(m.getId());
    }

    @Test
    @Order(1)
    public void modifierMagasinTest() {
        m.setAdresse("Ariana");
        m = magasinRepository.save(m);
        log.info(m.toString());
        Assertions.assertNotEquals(m.getAdresse(), "Tunis");
    }

    @Test
    @Order(2)
    public void listerMagasins() {
        List<Magasin> list = magasinRepository.findAll();
        log.info(list.size()+"");
        Assertions.assertTrue(list.size() > 0);
    }

    @Test
    @Order(3)
    public void chercherMagasinAvecId() {
        log.info(m.getId()+"");
        Magasin m1 = magasinRepository.findById(m.getId()).get();
        Assertions.assertEquals(m1.getAdresse(),m.getAdresse());
    }

    @Test
    @Order(4)
    public void supprimerMagasin() {
        magasinRepository.delete(m);
    }

    @Test
    @Order(5)
    public void compter() {
        long taille = magasinRepository.count();
        Assertions.assertEquals(taille,magasinRepository.findAll().size());
    }
}
