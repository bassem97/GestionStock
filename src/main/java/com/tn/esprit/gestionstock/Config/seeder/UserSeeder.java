package com.tn.esprit.gestionstock.Config.seeder;

import com.tn.esprit.gestionstock.Entities.CategorieUser;
import com.tn.esprit.gestionstock.Entities.Role;
import com.tn.esprit.gestionstock.Entities.User;
import com.tn.esprit.gestionstock.Entities.Profession;
import com.tn.esprit.gestionstock.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Component
public class UserSeeder {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleSeeder roleSeeder;

    public User user1;
    public User user2 ;
    public User user3 ;


    public void seed(){
        user1  = new User("tarek","bellalouna", new Date(97, Calendar.OCTOBER,10),"tarek.bellalouna@esprit.tn","55067708","07428163","123456", CategorieUser.Premium, Profession.Etudiant);
        user2  = new User("Amr","bellalouna", new Date(94, Calendar.OCTOBER,18),"amr.bellalouna@esprit.tn","9032145","023456789","123456", CategorieUser.Fidele, Profession.Docteur);
        user3  = new User("mounir","hmidi", new Date(97, Calendar.NOVEMBER,3),"mounir.hmidi@esprit.tn","90325478","057142148","123456", CategorieUser.Fidele, Profession.Commercial);

        ArrayList<Role> rolesAdmin = new ArrayList<>();
        rolesAdmin.add(roleSeeder.admin);

        ArrayList<Role> rolesUser = new ArrayList<>();
        rolesUser.add(roleSeeder.user);

        user1.setRoles(rolesAdmin);
        user2.setRoles(rolesUser);
        user3.setRoles(rolesUser);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
    }
}
