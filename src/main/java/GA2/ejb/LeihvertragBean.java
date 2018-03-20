/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.ejb;

import GA2.jpa.Fahrzeug;
import GA2.jpa.Kunde;
import GA2.jpa.Leihvertrag;
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
    
    public Leihvertrag loanACar(Date loanStart, Date loanEnde, Fahrzeug fahrzeug, Kunde kunde) {
        List<Leihvertrag> fittingLeihvertrag =
                em.createQuery("SELECT l FROM Leihvertrag l"
                            + "WHERE ((l.beginnDatum > :loanStart AND l.beginnDatum < :loanEnde)"
                            + "OR (l.endeDatum > :loanStart AND l.endeDatum < :loanEnde))"
                            + "OR (l.beginnDatum < :loanStart AND l.endeDatum > :loanEnde))"
                            + "OR (l.beginnDatum > :loanStart AND l.endeDatum < :loanEnde))"
                            + "AND l.fahzeugId.id == fahrzeug.id")
                            .setParameter("loanStart", loanStart)
                            .setParameter("loanEnde", loanEnde)
                            .setParameter("fahrzeug", fahrzeug)
                            .getResultList();
        if (fittingLeihvertrag != null) {
            throw new LeihException ("Das Auto ist in diesem Zeitraum bereits ausgeliehen.");
        }
        else {
            return new Leihvertrag(loanStart, loanEnde, fahrzeug, kunde);
        }
    }
    
    public List<Leihvertrag> findAllByKunde (Kunde kunde) {
        return em.createQuery("SELECT l FROM Leihvertrag l"
                            + "WHERE l.kundenId.id == kunde.id"
                            + "ORDER BY l.startDatum")
                            .setParameter("kunde", kunde)
                            .getResultList();
    }
    
    public class LeihException extends RuntimeException {
        public LeihException() {
            
        }
        public LeihException (String s) {
            super(s);
        }
    }
}
