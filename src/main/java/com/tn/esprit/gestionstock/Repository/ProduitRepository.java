package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

    @Query(value =
            "SELECT (" +
                    "SELECT sum(df.qte)FROM DetailFacture df  WHERE df.produit.idProduit = ?1" +
                    ") AS  qte " +
                    "FROM DetailProduit dp  " +
                    "WHERE dp.dateCreation BETWEEN ?2 AND ?3 "
    )
    int getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);

    @Query(value = "SELECT p FROM Produit p JOIN p.stock s WHERE s.qte<s.qteMin ")
    List<Produit> retrieveStatusStock();


}
