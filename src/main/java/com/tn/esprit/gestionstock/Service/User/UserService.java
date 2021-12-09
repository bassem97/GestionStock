package com.tn.esprit.gestionstock.Service.User;

import com.tn.esprit.gestionstock.Entities.CategorieUser;
import com.tn.esprit.gestionstock.Entities.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    User add(User user);
    User update(User user, Long id);
    void delete(long id);
    List<User> findAll();
    User findById(Long id);
    User findByUserByToken(String email);
    boolean switchDarkMode(User user);
    float getChiffreAffaireParCategorieUser(CategorieUser categorieUser, Date startDate, Date endDate);

}
