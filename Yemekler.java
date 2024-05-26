package application;

public class Yemekler {
	
	    private String yemekturu;
	    private String yemek;
	    private String fiyat;

	   
	    public Yemekler(String yemekturu, String yemek, String fiyat) {
	        this.yemekturu = yemekturu;
	        this.yemek = yemek;
	        this.fiyat = fiyat;
	    }

	   
	    public String getYemekturu() {
	        return yemekturu;
	    }

	    public void setYemekturu(String yemekturu) {
	        this.yemekturu = yemekturu;
	    }

	    public String getYemek() {
	        return yemek;
	    }

	    public void setYemek(String yemek) {
	        this.yemek = yemek;
	    }

	    public String getFiyat() {
	        return fiyat;
	    }

	    public void setFiyat(String fiyat) {
	        this.fiyat = fiyat;
	    }
	}

