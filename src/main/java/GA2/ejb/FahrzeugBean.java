/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author jsche
 */
@Stateless
public class FahrzeugBean extends EntityBean<Fahrzeug, Long>{
    public FahrzeugBean() {
        super(Fahrzeug.class);
    }
    
    
}
