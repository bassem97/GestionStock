package com.tn.esprit.gestionstock.Service.Reclamation;

import com.tn.esprit.gestionstock.Entities.Reclamation;
import com.tn.esprit.gestionstock.Entities.User;
import com.tn.esprit.gestionstock.Repository.ReclamationRepository;
import com.tn.esprit.gestionstock.Service.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReclamationServiceImpl implements ReclamationService  {

    @Autowired
    ReclamationRepository reclamationRepository;

    @Autowired
    UserService userService;

    @Override
    public Reclamation add(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation update(Reclamation reclamation, Long id) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public void delete(long id) {
         reclamationRepository.deleteById(id);
    }

    @Override
    public List<Reclamation> findAll() {

        User userConnected = userService.findByUserByToken(SecurityContextHolder.getContext().getAuthentication().getName());
//        log.info(""+);
        if(userConnected.getRoles().stream().findFirst().get().getRoleName().equals("ADMIN"))
            return reclamationRepository.findAll();
        else
            return reclamationRepository.findAll().stream().
                    filter(reclamation -> reclamation.getUser().getIdUser().equals(userConnected.getIdUser()))
                    .collect(Collectors.toList());
    }

    @Override
    public Reclamation findById(Long id) {
        return reclamationRepository.findById(id).get();
    }
}
