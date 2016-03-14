/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PaypalServiceMock implements PaypalService{
    
    
    
    public boolean validation(){
        return true;
    }
    
}
