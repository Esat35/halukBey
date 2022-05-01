package proje_benim_calısmam.ogrcOgrtYonetimi01;

public class Ogretmen extends  Kisi {

String bolum;
String sicilNo;

    public Ogretmen() {
    }

    public Ogretmen(String adSoyad, String kimlikNo, int yaş) {
        super(adSoyad, kimlikNo, yaş);
    }

    public Ogretmen(String bolum, String sicilNo) {
        this.bolum = bolum;
        this.sicilNo = sicilNo;
    }

    public Ogretmen(String adSoyad, String kimlikNo, int yaş, String bolum, String sicilNo) {
        super(adSoyad, kimlikNo, yaş);
        this.bolum = bolum;
        this.sicilNo = sicilNo;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    @Override
    public String toString() {
        return "Ogretmen : " +
                "adSoyad='" + adSoyad + '\'' +
                ", kimlikNo='" + kimlikNo + '\'' +
                ", yaş=" + yaş +
                ", bolum='" + bolum + '\'' +
                ", sicilNo='" + sicilNo + '\''
                +"\n";
    }
}


































