/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.soap;

import GA2.ejb.FahrzeugBean;
import GA2.ejb.KundeBean;
import GA2.ejb.LeihvertragBean;
import javax.ejb.EJB;
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
    public Station createNewkunde
    
}
