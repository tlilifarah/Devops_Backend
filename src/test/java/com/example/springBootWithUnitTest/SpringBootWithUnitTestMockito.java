package com.example.springBootWithUnitTest;


import com.example.springBootWithUnitTest.entites.Magasin;
import com.example.springBootWithUnitTest.repositories.MagasinRepository;
import com.example.springBootWithUnitTest.services.MagasinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SpringBootWithUnitTestMockito {

    @Mock
    MagasinRepository magasinRepo;
    //ou MagasinRepository magasinRepo = Mockito.mock(MagasinRepository.class);

    @InjectMocks
    MagasinServiceImpl magasinService;

    Magasin m  = Magasin.builder().nom("Le Bonus").email("bonus@gmail.com").adresse("Ghazella, Ariana").telephone(123456789).build();

    List<Magasin> list= new ArrayList<Magasin>() {
        {
            add(Magasin.builder().nom("MG").email("mg@gmail.com").adresse("Ariana Soghra, Ariana").telephone(123456789).build());
            add(Magasin.builder().nom("Carrefour").email("carrefour@gmail.com").adresse("Nkhilet, Tunis").telephone(123456789).build());
        }
    };

    @Test
    public void addMagasinTest() {
        Mockito.when(magasinRepo.save(Mockito.any(Magasin.class))).then(invocation -> {
            Magasin model = invocation.getArgument(0, Magasin.class);
            model.setId(1);
            return model;
        });
        log.info("Avant ==> " + m.toString());
        Magasin magasin = magasinService.ajouterEtModifierMagasin(m);
        assertSame(magasin, m);
        log.info("Après ==> " + m.toString());
    }

    @Test
    public void retreiveMagasinTest() {
        Mockito.when(magasinRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(m));
        Magasin magasin = magasinService.chercherMagasinAvecId((long) 2);
        assertNotNull(magasin);
        log.info("get ==> " + magasin.toString());

        verify(magasinRepo).findById(Mockito.anyLong());

    }

    @Test
    public void retreiveAllMagasinTest() {
        Mockito.when(magasinRepo.findAll()).thenReturn(list);
        List<Magasin> magasins = magasinService.listerMagasins();
        assertNotNull(magasins);
        for (Magasin magasin : magasins) {
            log.info(magasin.toString());
        }
    }
}
