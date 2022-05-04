package proje_benim_calısmam.ogrcOgrtYonetimi01;

public class Kisi {
    String adSoyad;
    String kimlikNo;
    int yaş;

    public Kisi() {
    }

    public Kisi(String adSoyad, String kimlikNo, int yaş) {
        this.adSoyad = adSoyad;
        this.kimlikNo = kimlikNo;
        this.yaş = yaş;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad.toUpperCase();
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
       if (kimlikNo.length()!=11){
           System.out.println("Kimlik numarası 11 haneli olmalıdır");
       }else  {
           this.kimlikNo = kimlikNo;
       }

    }

    public int getYaş() {
        return yaş;
    }

    public void setYaş(int yaş) {
       if (yaş<0){
           yaş=-yaş;
       }
        this.yaş = yaş;
    }
}





