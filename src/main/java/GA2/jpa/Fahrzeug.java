/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Patrick Baumer
 */
@Entity
public class Fahrzeug implements Serializable{
    @Id
    @GeneratedValue(generator ="fahrzeug_ids")
    @TableGenerator (name = "fahrzeug_ids" , initialValue = 0, allocationSize = 50)
    private long id = 0L;
    
    @NotNull
    @Size (min = 1)
    private String hersteller ="";
    
    @NotNull
    @Size (min = 1)
    private String modell="";
    
    @NotNull
    @Size (min = 1)
    private String baujahr ="";

    
    
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Fahrzeug(){
    }
    
    public Fahrzeug(String hersteller, String modell, String baujahr) {
        this.baujahr = baujahr;
        this.modell = modell;
        this.hersteller = hersteller;
    }
    
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">
 
//</editor-fold>

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }
    
    
     
    
    
}
