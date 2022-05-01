package proje_benim_calısmam.ogrcOgrtYonetimi01;

public class Ogrenci  extends Kisi{

    String ogrencıNo;
    String sınıf;

    public Ogrenci() {
    }

    public Ogrenci(String ogrencıNo, String sınıf) {
        this.ogrencıNo = ogrencıNo;
        this.sınıf = sınıf;
    }

    public Ogrenci(String adSoyad, String kimlikNo, int yaş, String ogrencıNo, String sınıf) {
        super(adSoyad, kimlikNo, yaş);
        this.ogrencıNo = ogrencıNo;
        this.sınıf = sınıf;
    }

    public String getOgrencıNo() {
        return ogrencıNo;
    }

    public void setOgrencıNo(String ogrencıNo) {
        this.ogrencıNo = ogrencıNo;
    }

    public String getSınıf() {
        return sınıf;
    }

    public void setSınıf(String sınıf) {
        this.sınıf = sınıf;
    }

    @Override
    public String toString() {
        return "Ogrenci : " +
                "adSoyad='" + adSoyad + '\'' +
                ", kimlikNo='" + kimlikNo + '\'' +
                ", yaş=" + yaş +
                ", ogrencıNo='" + ogrencıNo + '\'' +
                ", sınıf='" + sınıf + '\'' +
                "\n";
    }
}
