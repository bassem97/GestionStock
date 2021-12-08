package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
