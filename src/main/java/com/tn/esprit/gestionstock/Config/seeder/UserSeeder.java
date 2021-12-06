package com.tn.esprit.gestionstock.Config.seeder;

import com.tn.esprit.gestionstock.Entities.CategorieUser;
import com.tn.esprit.gestionstock.Entities.Profession;
import com.tn.esprit.gestionstock.Entities.Role;
import com.tn.esprit.gestionstock.Entities.User;
import com.tn.esprit.gestionstock.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
        user1  = new User("jadoui","bassem", new Date(97, Calendar.MAY,20),"bassem.jadoui@esprit.tn","55135774","07496483","123456", CategorieUser.Premium, Profession.Etudiant);
        user2  = new User("mannai","karim", new Date(98, Calendar.JANUARY,18),"karim.mannai@esprit.tn","24125478","023456789","123456", CategorieUser.Fidele, Profession.Docteur);
        user3  = new User("battiche","khaled", new Date(97, Calendar.NOVEMBER,3),"khaled.battiche@esprit.tn","90325478","057142148","123456", CategorieUser.Fidele, Profession.Commercial);

        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(roleSeeder.admin);

        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(roleSeeder.client);

        user1.setRoles(rolesAdmin);
        user2.setRoles(rolesUser);
        user3.setRoles(rolesUser);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
    }
}
