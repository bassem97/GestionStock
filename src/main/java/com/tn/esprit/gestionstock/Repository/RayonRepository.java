package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RayonRepository extends JpaRepository<Rayon,Long> {
    @Modifying
    @Transactional
    @Query(value = "ALTER table rayon AUTO_INCREMENT=1"
            , nativeQuery = true)
    void reset_auto_increment();
    @Modifying
    @Transactional
    @Query(value = "ALTER table rayon AUTO_INCREMENT=?1"
            , nativeQuery = true)
    void fix_auto_increment(int value);

}
