package application;

import java.time.LocalDate;


public class Uyeler {
    private String ad;
    private String soyad;
    private String username;
    private LocalDate dogum_tarihi;
    private String cinsiyet;
    private String tlfno;
    private String email;

    // Constructor
    public Uyeler(String ad, String soyad, String username, LocalDate dogum_tarihi, String cinsiyet, String tlfno, String email) {
        this.ad = ad;
        this.soyad = soyad;
        this.username = username;
        this.dogum_tarihi = dogum_tarihi;
        this.cinsiyet = cinsiyet;
        this.tlfno = tlfno;
        this.email = email;
    }

    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(LocalDate dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getTlfno() {
        return tlfno;
    }

    public void setTlfno(String tlfno) {
        this.tlfno = tlfno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}