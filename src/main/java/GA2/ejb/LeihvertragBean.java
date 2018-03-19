/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jsche
 */
@Stateless
public class LeihvertragBean extends EntityBean<Leihvertrag, Long> {
    
    public LeihvertragBean() {
        super(Leihvertrag.class);
    }
    
    public List<Leihvertrag> findByRentBetween(Date rentStart, Date rentEnde) {
        return em.createQuery("SELECT l FROM Leihvertrag l"
                            + "WHERE (l.beginnDatum > :rentStart AND l.beginnDatum > :rentEnde)"
                            + "OR (l.endeDatum < :rentStart AND l.endeDatum < :rentEnde"
                            + "ORDER BY l.beginnDatum, l.fahrzeugID.modell")
                            .setParameter("rentStart", rentStart)
                            .setParameter("rentEnde", rentEnde)
                            .getResultList();
    }
}
