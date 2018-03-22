/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.soap;

import GA2.ejb.FahrzeugBean;
import GA2.ejb.KundeBean;
import GA2.ejb.LeihvertragBean;
import GA2.jpa.Fahrzeug;
import GA2.jpa.Kunde;
import GA2.jpa.Leihvertrag;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Manuel
 */
@WebService (serviceName = "Fahrzeugverleih")
public class FahrzeugverleihSoapWebservice {
    
    @EJB
    KundeBean kundeBean;
    
    @EJB
    LeihvertragBean leihvertragBean;
    
    @EJB
    FahrzeugBean fahrzeugBean;
    
    @WebMethod
    @WebResult (name="kunde")
    public Kunde createNewKunde(@WebParam(name = "kunde") Kunde kunde) {
        return this.kundeBean.saveNew(kunde);
    }
    
    @WebMethod
    @WebResult (name="fahrzeug")
    public Fahrzeug createNewFahrzeug(@WebParam(name = "fahrzeug") Fahrzeug fahrzeug) {
        return this.fahrzeugBean.saveNew(fahrzeug);
    }
    
    @WebMethod
    @WebResult (name = "leihvertrag")
    public Leihvertrag createNewLeihvertrag (
            @WebParam(name = "loanStart")Date loanStart,
            @WebParam(name = "loanEnde")Date loanEnde,
            @WebParam(name = "fahrzeug")Fahrzeug fahrzeug, 
            @WebParam(name = "kunde") Kunde kunde) throws Exception{
        return this.leihvertragBean.loanACar(loanStart, loanEnde, fahrzeug, kunde);
    }
    
    @WebMethod
    @WebResult (name = "fahrzeug")
    public List<Fahrzeug> findAllFahrzeuge(){
        return this.fahrzeugBean.findAllFahrzeuge();
    }
    
    @WebMethod
    @WebResult (name = "fahrzeug")
    public Fahrzeug findFahrzeugById(
            @WebParam(name = "fahrzeugId") Long fahrzeugId) {
        return this.fahrzeugBean.findById(fahrzeugId);
    }
    
    @WebMethod
    @WebResult (name = "kunde")
    public Kunde findKundeById(
            @WebParam(name = "kundeId") Long kundeId) {
        return this.kundeBean.findById(kundeId);
    }
    
    @WebMethod
    @WebResult (name = "leihvertrag")
    public List<Leihvertrag> findLeihvertragByKunde (
            @WebParam(name = "kunde") Kunde kunde) {
        return this.leihvertragBean.findAllByKunde(kunde);
    }
    
            
    
    
}
