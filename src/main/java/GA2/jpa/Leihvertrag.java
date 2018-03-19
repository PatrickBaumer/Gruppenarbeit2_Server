/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Patrick Baumer
 */
public class Leihvertrag implements Serializable{
    @Id
    @GeneratedValue(generator ="leihvertrag_ids")
    private long id;
    
    
    @ManyToOne
    private Fahrzeug fahrzeugID;
    @ManyToOne
    private Kunde kundenId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date beginnDatum = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date endeDatum = new Date();

    
//<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Leihvertrag() {}
    
    public Leihvertrag(Date beginnDatum, Date endeDatum) {
        this.beginnDatum=beginnDatum;
        this.endeDatum= endeDatum;
        this.fahrzeugID = this.fahrzeugID;
        this.kundenId = this.kundenId;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getter/setter">
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Fahrzeug getFahrzeugID() {
        return fahrzeugID;
    }
    
    public void setFahrzeugID(Fahrzeug fahrzeugID) {
        this.fahrzeugID = fahrzeugID;
    }
    
    public Kunde getKundenId() {
        return kundenId;
    }
    
    public void setKundenId(Kunde kundenId) {
        this.kundenId = kundenId;
    }
    
    public Date getBeginnDatum() {
        return beginnDatum;
    }
    
    public void setBeginnDatum(Date beginnDatum) {
        this.beginnDatum = beginnDatum;
    }
    
    public Date getEndeDatum() {
        return endeDatum;
    }
    
    public void setEndeDatum(Date endeDatum) {
        this.endeDatum = endeDatum;
    }
    
//</editor-fold>
    
}
