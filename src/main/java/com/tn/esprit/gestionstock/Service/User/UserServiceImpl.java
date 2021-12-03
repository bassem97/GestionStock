package com.tn.esprit.gestionstock.Service.User;

import antlr.BaseAST;
import com.tn.esprit.gestionstock.Entities.CategorieUser;
import com.tn.esprit.gestionstock.Entities.User;
import com.tn.esprit.gestionstock.Entities.Facture;
import com.tn.esprit.gestionstock.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public User add(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user, Long id) {
//        if(userRepository.findById(id).isPresent()){
//            User cl = userRepository.findById(id).get();
//            cl.setNom(user.getNom());
//            cl.setPrenom(user.getPrenom());
//            cl.setEmail(user.getEmail());
//            cl.setPassword(user.getPassword());
//            cl.setDateNaissance(user.getDateNaissance());
//            cl.setProffesion(user.getProffesion());
//            cl.setCategorieUser(user.getCategorieUser());
//            cl.setFactures(user.getFactures());
//            return userRepository.save(cl);
//        }
//        return null;
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public float getChiffreAffaireParCategorieUser(CategorieUser categorieUser, Date startDate, Date endDate) {
        return (float) userRepository.findAllByCategorieUser(categorieUser)
                .stream()
                .mapToDouble(user -> user.getFactures()
                        .stream()
                        .filter(facture -> facture.getDateFacture().after(startDate) && facture.getDateFacture().before(endDate))
                        .mapToDouble(Facture::getMontantFacture)
                        .sum())
                .sum();

    }
}
