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
 * @author Manuel
 */
@Stateless
public class LeihvertragBean extends EntityBean<Leihvertrag, Long> {

    public LeihvertragBean() {
        super(Leihvertrag.class);
    }

    public Leihvertrag loanACar(Date loanStart, Date loanEnde, Fahrzeug fahrzeug, Kunde kunde) throws Exception {
        
        boolean hilf = false;
        
        List<Leihvertrag> fittingLeihvertrag1 = em.createQuery("SELECT l FROM Leihvertrag l "
                + "WHERE l.endeDatum >= :loanStart AND l.endeDatum <= :loanEnde AND l.fahzeugId = :fahrzeug")
                .setParameter("loanStart", loanStart)
                .setParameter("loanEnde", loanEnde)
                .setParameter("fahrzeug", fahrzeug)
                .getResultList();
        if (fittingLeihvertrag1.isEmpty()) {
            List<Leihvertrag> fittingLeihvertrag2 = em.createQuery("SELECT l FROM Leihvertrag l "
                    + "WHERE l.beginnDatum >= :loanStart AND l.beginnDatum <= :loanEnde AND l.fahzeugId = :fahrzeug")
                    .setParameter("loanStart", loanStart)
                    .setParameter("loanEnde", loanEnde)
                    .setParameter("fahrzeug", fahrzeug)
                    .getResultList();
            if (fittingLeihvertrag2.isEmpty()) {
                List<Leihvertrag> fittingLeihvertrag3 = em.createQuery("SELECT l FROM Leihvertrag l "
                        + "WHERE l.beginnDatum >= :loanStart AND l.endeDatum <= :loanEnde AND l.fahzeugId = :fahrzeug")
                        .setParameter("loanStart", loanStart)
                        .setParameter("loanEnde", loanEnde)
                        .setParameter("fahrzeug", fahrzeug)
                        .getResultList();

                if (fittingLeihvertrag3.isEmpty()) {
                    List<Leihvertrag> fittingLeihvertrag4 = em.createQuery("SELECT l FROM Leihvertrag l "
                            + "WHERE l.beginnDatum <= :loanStart AND l.endeDatum >= :loanEnde AND l.fahzeugId = :fahrzeug")
                            .setParameter("loanStart", loanStart)
                            .setParameter("loanEnde", loanEnde)
                            .setParameter("fahrzeug", fahrzeug)
                            .getResultList();

                    if (fittingLeihvertrag4.isEmpty()) {
                        hilf = true;
                    } 
                }
            }

        }
            if (hilf) {
               return this.saveNew(new Leihvertrag(loanStart, loanEnde, fahrzeug, kunde)); 
            }
            else {
                throw new Exception();
            }
        
    }

    public List<Leihvertrag> findAllByKunde(Kunde kunde) {
        return em.createQuery("SELECT l FROM Leihvertrag l "
                + "WHERE l.kundenId = :kunde "
                + "ORDER BY l.beginnDatum")
                .setParameter("kunde", kunde)
                .getResultList();
    }
}
