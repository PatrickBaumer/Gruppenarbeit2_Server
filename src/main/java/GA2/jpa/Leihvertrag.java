/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Patrick Baumer
 */
@Entity
public class Leihvertrag implements Serializable{
    @Id
    @GeneratedValue(generator ="leihvertrag_ids")
    @TableGenerator(name = "leihvertrag_ids", initialValue = 0, allocationSize = 50)
    private long id = 0L;
    
    
    @ManyToOne
    @NotNull
    private Fahrzeug fahrzeugId = null;
    
    
    @ManyToOne
    @NotNull
    private Kunde kundenId = null;

    @Temporal(TemporalType.DATE)
    private Date beginnDatum = new Date();
    
    
    @Temporal(TemporalType.DATE)
    private Date endeDatum = new Date();

    
//<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Leihvertrag() {}
    
    public Leihvertrag(Date beginnDatum, Date endeDatum, Fahrzeug fahrzeugId, Kunde kundenId) {
        this.beginnDatum=beginnDatum;
        this.endeDatum= endeDatum;
        this.fahrzeugId = fahrzeugId;
        this.kundenId = kundenId;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getter/setter">
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Fahrzeug getFahrzeugId() {
        return fahrzeugId;
    }
    
    public void setFahrzeugId(Fahrzeug fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
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
