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

/**
 *
 * @author Patrick Baumer
 */
public class Kunde implements Serializable{
    
    @Id
    @GeneratedValue(generator ="kunden_ids")
    @TableGenerator(name="kunden_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
   
    
    private String vorname ="";
    private String nachname ="";
    private String straße ="";
    private String hausnummer ="";
    private String plz ="";
    private String ort ="";
    private String land ="";

    
    public Kunde(){}
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
