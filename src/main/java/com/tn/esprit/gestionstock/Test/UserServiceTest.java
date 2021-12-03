package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Entities.CategorieUser;
import com.tn.esprit.gestionstock.Service.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Ignore
    @Test
    public void testAddUser() {
//        List<User> users = userService.findAll();
//        int expected = users.size();
//        User user = new User("bassem", "jadoui", "bassem.jadoui1@esprit.tn", "123456", CategorieUser.Fidele);
//        User savedUser = userService.add(user);
//        assertEquals(expected + 1, userService.findAll().size());
//        assertNotNull(savedUser.getNom());
//        userService.delete(savedUser.getIdUser());
    }

    @Ignore
    @Test
    public void testListUser() {
        userService.findAll()
                .forEach(user -> log.info("User :" + user));
    }

    @Test
    public void testGetChiffreAffaireParCategorieUser() {
        log.info(" chiifre = " + userService.getChiffreAffaireParCategorieUser(CategorieUser.Fidele, new Date(121, Calendar.NOVEMBER, 10), new Date(121, Calendar.NOVEMBER, 18)));
    }
}
