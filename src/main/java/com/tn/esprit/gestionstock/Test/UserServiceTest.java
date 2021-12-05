package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Service.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;

//    @Ignore
//    @Test
//    public void testAddClient() {
//        List<User> clients = clientService.findAll();
//        int expected = clients.size();
//        User client = new User("bassem", "jadoui", "bassem.jadoui1@esprit.tn", "123456", CategorieUser.Fidele);
//        User savedClient = clientService.add(client);
//        assertEquals(expected + 1, clientService.findAll().size());
//        assertNotNull(savedClient.getNom());
//        clientService.delete(savedClient.getIdClient());
//    }

//    @Ignore
//    @Test
//    public void testListClient() {
//        clientService.findAll()
//                .forEach(client -> log.info("User :" + client));
//    }
//
//    @Test
//    public void testGetChiffreAffaireParCategorieClient() {
//        log.info(" chiifre = " + clientService.getChiffreAffaireParCategorieClient(CategorieUser.Premium, new Date(121, Calendar.NOVEMBER, 10), new Date(121, Calendar.NOVEMBER, 18)));
//    }
}
