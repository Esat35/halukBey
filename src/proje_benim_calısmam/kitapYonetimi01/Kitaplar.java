package proje_benim_calısmam.kitapYonetimi01;

public class Kitaplar {
private int kitapNo;
   private String kitapAdi;
   private String yazarAdi;
   private double kitapFiyati;
   private String baskıYili;

    public Kitaplar() {
    }

    public Kitaplar(int kitapNo, String kitapAdi, String yazarAdi, double kitapFiyati, String baskıYili) {
        this.kitapNo = kitapNo;
        this.kitapAdi = kitapAdi.toUpperCase();
        this.yazarAdi = yazarAdi.toUpperCase();
        this.kitapFiyati = kitapFiyati;
        this.baskıYili = baskıYili;
    }

    public void setKitapNo(int kitapNo) {
        this.kitapNo = kitapNo;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi.toUpperCase();
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi.toUpperCase();
    }

    public void setKitapFiyati(double kitapFiyati) {
        if (kitapFiyati<0){
            this.kitapFiyati = -kitapFiyati;
        }else {
            this.kitapFiyati = kitapFiyati;
        }
    }

    public void setBaskıYili(String baskıYili) {
        this.baskıYili = baskıYili;
    }

    public int getKitapNo() {
        return kitapNo;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public double getKitapFiyati() {
        return kitapFiyati;
    }

    public String getBaskıYili() {
        return baskıYili;
    }

    @Override
    public String toString() {
        return"\nAradıgınız Kitab...\n"+
                "Kitap No=" + kitapNo +
                "\nKitap Adi= " + kitapAdi  +
                "\nYazar Adi= " + yazarAdi +
                "\nKitap Fiyati= " + kitapFiyati +" TL."+
                "\nBaskı Yili= " + baskıYili
                ;
    }
}
