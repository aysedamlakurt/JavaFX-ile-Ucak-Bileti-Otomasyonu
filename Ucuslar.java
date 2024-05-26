package application;

import java.time.LocalDate;


public class Ucuslar {
    private String ucusNumarasi;
    private String departure;
    private String destination;
    private LocalDate seferTarihi;
    private String kalkisSaati;
    private String inisSaati;
    private String fiyat;

    // Constructor
    public Ucuslar(String ucusNumarasi, String departure, String destination, LocalDate seferTarihi, String kalkisSaati, String inisSaati, String fiyat) {
        this.ucusNumarasi = ucusNumarasi;
        this.departure = departure;
        this.destination = destination;
        this.seferTarihi = seferTarihi;
        this.kalkisSaati = kalkisSaati;
        this.inisSaati = inisSaati;
        this.fiyat = fiyat;
    }

    
    public String getUcusNumarasi() {
        return ucusNumarasi;
    }

    public void setUcusNumarasi(String ucusNumarasi) {
        this.ucusNumarasi = ucusNumarasi;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getSeferTarihi() {
        return seferTarihi;
    }

    public void setSeferTarihi(LocalDate seferTarihi) {
        this.seferTarihi = seferTarihi;
    }

    public String getKalkisSaati() {
        return kalkisSaati;
    }

    public void setKalkisSaati(String kalkisSaati) {
        this.kalkisSaati = kalkisSaati;
    }

    public String getInisSaati() {
        return inisSaati;
    }

    public void setInisSaati(String inisSaati) {
        this.inisSaati = inisSaati;
    }
    public  String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }


}
