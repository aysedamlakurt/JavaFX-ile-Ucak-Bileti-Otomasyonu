package application;
import java.time.LocalDate;

public class Biletler {
    private String musteriUsername;
    private String departure;
    private String destination;
    private LocalDate seferTarihi;
    private String kalkisSaati;
    private String inisSaati;
    private String paket;
    private String koltuk;
    private String yemek;
    private String bagaj;
    private String hizmet;
    private String fiyat;

    public Biletler(String musteriUsername, String departure, String destination, LocalDate seferTarihi, 
            String kalkisSaati, String inisSaati, String paket, String koltuk, 
            String yemek, String bagaj, String hizmet, String fiyat) {
			this.musteriUsername = musteriUsername;
			this.departure = departure;
			this.destination = destination;
			this.seferTarihi = seferTarihi;
			this.kalkisSaati = kalkisSaati;
			this.inisSaati = inisSaati;
			this.paket = paket;
			this.koltuk = koltuk;
			this.yemek = yemek;
			this.bagaj = bagaj;
			this.hizmet = hizmet;
			this.fiyat = fiyat;
			}
    public String getMusteriUsername() {
        return musteriUsername;
    }

    public void setMusteriUsername(String musteriUsername) {
        this.musteriUsername = musteriUsername;
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

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getKoltuk() {
        return koltuk;
    }

    public void setKoltuk(String koltuk) {
        this.koltuk = koltuk;
    }

    public String getYemek() {
        return yemek;
    }

    public void setYemek(String yemek) {
        this.yemek = yemek;
    }

    public String getBagaj() {
        return bagaj;
    }

    public void setBagaj(String bagaj) {
        this.bagaj = bagaj;
    }

    public String getHizmet() {
        return hizmet;
    }

    public void setHizmet(String hizmet) {
        this.hizmet = hizmet;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }
}