/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2.jpa;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Patrick Baumer
 */
public class Kunde implements Serializable{
    
    @Id
    @GeneratedValue(generator ="kunden_ids")
    @TableGenerator(name="kunden_ids", initialValue = 0, allocationSize = 50)
    private long id = 0L;
    
   
    @NotNull
    @Size(min = 1)
    private String vorname ="";
    
    @NotNull
    @Size(min = 1)
    private String nachname ="";
    
    @NotNull
    @Size(min = 1)
    private String straße ="";
    
    @NotNull
    @Size(min = 1)
    private String hausnummer ="";
    
    @NotNull
    @Size(min = 1)
    private String plz ="";
    
    @NotNull
    @Size(min = 1)
    private String ort ="";
    
    @NotNull
    @Size(min = 1)
    private String land ="";

    
    public Kunde(){
    }
    
    public Kunde(String vorname, String nachname, String straße, String hausnummer,String plz, String ort ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort=ort;

    }

    
    
    
    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    

    
    public String getVorname() {
        return vorname;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public String getNachname() {
        return nachname;
    }
    
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public String getStraße() {
        return straße;
    }
    
    public void setStraße(String straße) {
        this.straße = straße;
    }
    
    public String getHausnummer() {
        return hausnummer;
    }
    
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }
    
    public String getPlz() {
        return plz;
    }
    
    public void setPlz(String plz) {
        this.plz = plz;
    }
    
    public String getOrt() {
        return ort;
    }
    
    public void setOrt(String ort) {
        this.ort = ort;
    }
    
    public String getLand() {
        return land;
    }
    
    public void setLand(String land) {
        this.land = land;
    }
    
//</editor-fold>
    
    
    
    
    
}
