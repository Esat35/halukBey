package proje_benim_calısmam.kitapYonetimi01;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Islemler {
    static int kitapNo = 1000;
    static Scanner scan = new Scanner(System.in);
    static Map<Integer, Kitaplar> kitaplarMap = new HashMap<>();

    public static void menu() throws InterruptedException {

        System.out.println("\n==========   KİTAP YÖNETİMİ   ==========");
        System.out.print("\t\t1-kitap ekle\n" +
                "\t\t2-numara ile kitap goruntule\n" +
                "\t\t3-bilgi ile kitap goruntule\n" +
                "\t\t4-numara ile kitap sil\n" +
                "\t\t5-tum kitaplari listele\n" +
                "\t\t6-cikis\n\n" +
                "\t\tIşleminizi seçiniz : ");

        String secim = scan.next();

        switch (secim) {
            case "1":
                kitapEkle();
                menu();
                break;
            case "2":
                numaraIleKitapGor();
                menu();
                break;
            case "3":
                bilgiIleKitapGor();
                menu();
                break;
            case "4":
                numaraIleKitapSil();
                menu();
                break;
            case "5":
                tumKitaplarıListele();
                menu();
                break;
            case "6":
                cıkıs();
                break;
            default:
                System.out.println("hatalı işlem secimi yaptınız. Tekrar deneyiniz...");
                Thread.sleep(2000);
                menu();
                break;
        }
    }

    private static void tumKitaplarıListele() {
        System.out.println("=============    TÜM KİTAPLAR LİSTESİ     =============");
        System.out.println(" K.NO   KİTAP ADI         YAZAR ADI    B.YILI    FİYAT  ");
        System.out.println("--------------------------------------------------------");
        for (Kitaplar each:kitaplarMap.values()) {
            System.out.printf("%-5d  %-15S  %-12S   %-7s  %4s\n",each.getKitapNo(),each.getKitapAdi(),each.getYazarAdi(),each.getBaskıYili(),each.getKitapFiyati()+" TL.");
        }
        System.out.println("--------------------------------------------------------");
    }

    private static void numaraIleKitapSil() throws InterruptedException {
        System.out.println("==========  NUMARA ile KİTAP SİLME SAYFASI   ==========");
        System.out.print("Silmek istediğiniz kitabın numarsını gırınız : ");
        int silinecekKitapNo=scan.nextInt();
        if (kitaplarMap.containsKey(silinecekKitapNo)){
            kitaplarMap.remove(silinecekKitapNo);
            System.out.println("Silme işlemi başarı ıle yapıldı...");
        }else {
            System.out.println("Silmek istediğiniz kitap listemizde yok...");
        }
        Thread.sleep(2000);
    }

    private static void bilgiIleKitapGor() throws InterruptedException {
        System.out.println("==========  BİLGİ ile KİTAP GÖRÜNTÜLEME SAYFASI   ==========");
        System.out.print("1-Kitap adı ile\n2-Yazar adi ile\n3-Baskı yılı ile\n");
        System.out.print("Görüntülemek istediğiniz kitabın bilgi turunu secınız : ");
        String secim = scan.next();
        switch (secim) {
            case "1":
                kitapAdiIleKitapGor();
                break;
            case "2":
                yazarAdiIleKitapGor();
                break;
            case "3":
                baskıYiliIleKitapGor();
                break;
            default:
                System.out.println("hatalı secım...");
        }

    }

    private static void baskıYiliIleKitapGor() throws InterruptedException {
        scan.nextLine();
        System.out.println("==========  BASKI YILI ile KİTAP GÖRÜNTÜLEME SAYFASI   ==========");
        System.out.print("Görüntülemek istediğiniz kitabın  baskı yılını gırınız : ");
        String baskıYili = scan.nextLine();
        boolean kitapVarmı = true;
        for (Kitaplar each : kitaplarMap.values()
        ) {
            if (each.getBaskıYili().equalsIgnoreCase(baskıYili)) {
                System.out.println(each);
                kitapVarmı = false;
            }
        }
        if (kitapVarmı) {
            System.out.println("aradıgınız kıtap listemizde yok ...");
        }
        Thread.sleep(2000);
    }

    private static void kitapAdiIleKitapGor() throws InterruptedException {
        scan.nextLine();
        System.out.println("==========  KİTAP ADI ile KİTAP GÖRÜNTÜLEME SAYFASI   ==========");
        System.out.print("Görüntülemek istediğiniz kitabın  adını gırınız : ");
        String goruntulenecekKitap = scan.nextLine();
        boolean kitapVarmı = true;
        for (Kitaplar each : kitaplarMap.values()
        ) {
            if (each.getKitapAdi().equalsIgnoreCase(goruntulenecekKitap)) {
                System.out.println(each);
                kitapVarmı = false;
            }
        }
        if (kitapVarmı) {
            System.out.println("aradıgınız kıtap listemizde yok ...");
        }
        Thread.sleep(2000);
    }

    private static void yazarAdiIleKitapGor() throws InterruptedException {
        scan.nextLine();
        System.out.println("==========  YAZAR ADI ile KİTAP GÖRÜNTÜLEME SAYFASI   ==========");
        System.out.print("Görüntülemek istediğiniz kitabın yazar adını gırınız : ");
        String goruntulenecekYazar = scan.nextLine();
        boolean yazarVarmı = true;
        for (Kitaplar each : kitaplarMap.values()
        ) {
            if (each.getYazarAdi().equalsIgnoreCase(goruntulenecekYazar)) {
                System.out.println(each);
                yazarVarmı = false;
            }
        }
        if (yazarVarmı) {
            System.out.println("aradıgınız kıtap listemizde yok ...");
        }
        Thread.sleep(2000);
    }

    private static void numaraIleKitapGor() throws InterruptedException {
        System.out.println("==========  NUMARA ile KİTAP GÖRÜNTÜLEME SAYFASI   ==========");
        System.out.print("Görüntülemek istediğiniz kitabın numarasını gırınız : ");
        int goruntulenecekKitapNo = 0;

        try {
            goruntulenecekKitapNo = scan.nextInt();

            if (kitaplarMap.containsKey(goruntulenecekKitapNo)) {
                System.out.println(kitaplarMap.get(goruntulenecekKitapNo));
            } else System.out.println("aradıgınız kıtap lıstemızde yok...");
            Thread.sleep(2000);
        } catch (InputMismatchException e) {
            System.out.println("Kitap numarası rakamlardan olusmalı...");
            Thread.sleep(2000);
        }

    }

    private static void kitapEkle() throws InterruptedException {
        System.out.println("==========   KİTAP EKLEME SAYFASI   ==========");
        scan.nextLine();
        System.out.print("Eklenecek kitabın adı : ");
        String eklenecekKitapAdi = scan.nextLine();

        System.out.print("Eklenecek kitabın Yazar adı : ");
        String eklenecekKitapYazari = scan.nextLine();

        System.out.print("Eklenecek kitabın Baskı Yılı : ");
        String eklenecekKitapBaskiYili = scan.next();
        scan.nextLine();
        System.out.print("Eklenecek kitabın Fiyatı : ");
        double eklenecekKitapFiyati = 0;
        try {
            eklenecekKitapFiyati = scan.nextDouble();
            Kitaplar kitap = new Kitaplar(kitapNo, eklenecekKitapAdi, eklenecekKitapYazari, eklenecekKitapFiyati, eklenecekKitapBaskiYili);
            kitaplarMap.put(kitapNo, kitap);
            System.out.println(" Kitap ekleme işlemi basarı ıle gerceklesti...");
            kitapNo++;
            Thread.sleep(2000);
        } catch (InputMismatchException e) {
            System.out.println("Fiyati yanlış gırdınız. Lutfen rakam kullanın...");
            Thread.sleep(2000);

        }


    }

    private static void cıkıs() {
        System.out.println("İYİ GÜNLER...");
    }
}
