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
 * @author Patrick Baumer
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
        return kundeBean.saveNew(kunde);
    }
    
    @WebMethod
    @WebResult (name="fahrzeug")
    public Fahrzeug createNewFahrzeug(@WebParam(name = "fahrzeug") Fahrzeug fahrzeug) {
        return fahrzeugBean.saveNew(fahrzeug);
    }
    
    @WebMethod
    @WebResult(name = "leihvertrag")
    public Leihvertrag createNewLeihvertrag (
            @WebParam(name = "rentStart")Date rentStart
            @WebParam(name = "rentEnde")Date rentEnde
            @WebParam(name = "fahrzeugId")Fahrzeug fahrzeug) {
        return leihvertragBean.saveNew(leihvertrag);
    }
    
    @WebMethod
    @WebResult (name = "fahrzeug")
    public List<Fahrzeug> findAllFahrzeug(){
        return fahrzeugBean.findAll();
    }
    
    @WebMethod
    @WebResult (name = "leihvertrag")
    public List<Leihvertrag> findLeihvertragByKunde (
            @WebParam(name = "kunde") Kunde kunde) {
        return leihvertragBean.findAllByKunde(kunde);
    }
    
            
    
    
}
