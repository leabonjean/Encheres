/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Paiement;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface PaiementService extends CrudRepository<Paiement, Long>{
    
}
