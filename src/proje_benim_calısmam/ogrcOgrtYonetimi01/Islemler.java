package proje_benim_calısmam.ogrcOgrtYonetimi01;

import java.util.*;

public class Islemler {

    static Scanner scan = new Scanner(System.in);
    static String kisiTuru;
    static Map<String, Ogrenci> ogrenciMap = new HashMap<>();
    static Map<String, Ogretmen> ogretmenMap = new HashMap<>();

    public static void anaMenu() throws InterruptedException {
        System.out.print("\n" +
                "\t====================================\n" +
                "\t ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ\n" +
                "\t====================================\n" +
                "\t 1- ÖĞRENCİ İŞLEMLERİ\n" +
                "\t 2- ÖĞRETMEN İŞLEMLERİ\n" +
                "\t Q- ÇIKIŞ\n\nSeçiminiz : ");

        String secim = scan.next().toLowerCase(Locale.ROOT);
        switch (secim) {
            case "1":
                kisiTuru = "ogrenci";
                ogrenciIsleri();
                break;
            case "2":
                kisiTuru = "ogretmen";
                       ogretmenIsleri();
                break;
            case "q":
                cıkıs();
                break;
            default:
                System.out.println("Hatalı işlem secımı yaptınız tekrar deneyınız ");
                anaMenu();
                break;

        }

    }

    private static void ogretmenIsleri() throws InterruptedException {

        System.out.print("\n" +
                "\t============= İŞLEMLER =============\n" +
                "\t\t 1-EKLEME\t\t\t \n" +
                "\t\t 2-ARAMA\n" +
                "\t\t 3-LİSTELEME\n" +
                "\t\t 4-SİLME\n" +
                "\t\t 5-ANA MENÜ\n" +
                "\t\t Q-ÇIKIŞ\n" +
                "\t\t\n" +
                "\tSEÇİMİNİZ:\n");
        String secim = scan.next();

        switch (secim) {
            case "1":
                ekle();
                ogrenciIsleri();
                break;

            case "2":
                arama();
                ogrenciIsleri();
                break;

            case "3":
                listele();
                ogrenciIsleri();
                break;
            case "4":
                sil();
                ogrenciIsleri();
                break;
            case "5":
                anaMenu();
                break;
            case "q":
            case "Q":
                cıkıs();
                break;
            default:
                System.out.println("Hatalı gırıs!");
                Thread.sleep(3000);
                ogrenciIsleri();

        }


    }

    private static void ogrenciIsleri() throws InterruptedException {

        System.out.print("\n" +
                "\t============= İŞLEMLER =============\n" +
                "\t\t 1-EKLEME\t\t\t \n" +
                "\t\t 2-ARAMA\n" +
                "\t\t 3-LİSTELEME\n" +
                "\t\t 4-SİLME\n" +
                "\t\t 5-ANA MENÜ\n" +
                "\t\t Q-ÇIKIŞ\n" +
                "\t\t\n" +
                "\tSEÇİMİNİZ:\n");
        String secim = scan.next();

        switch (secim) {
            case "1":
                ekle();
                ogrenciIsleri();
                break;

            case "2":
                arama();
                ogrenciIsleri();
                break;

            case "3":
                  listele();
                ogrenciIsleri();
                break;
            case "4":
                  sil();
                ogrenciIsleri();
                break;
            case "5":
                anaMenu();
                break;
            case "q":
            case "Q":
                cıkıs();
                break;
            default:
                System.out.println("Hatalı gırıs!");
                Thread.sleep(3000);
                ogrenciIsleri();

        }


    }

    private static void sil() {
        System.out.print("Silmek istediğiniz "+kisiTuru+" nin TC numarasını gırınız : ");
        String silinecekTc=scan.next();

        if (kisiTuru.equalsIgnoreCase("ogrenci")&&ogrenciMap.containsKey(silinecekTc)){
            ogrenciMap.remove(silinecekTc);
            System.out.println("silme işlemi basarı ıle gerceklesti");
        }else if (kisiTuru.equalsIgnoreCase("ogrtmen")&&ogretmenMap.containsKey(silinecekTc)){
            ogretmenMap.remove(silinecekTc);
            System.out.println("silme işlemi basarı ıle gerceklesti");
        }else System.out.println("Silmek istediğiniz kişi listemizde yok.");


    }

    private static void listele() {
        mapYazdır(kisiTuru);
    }

   public static void mapYazdır(String kisiTuru){
       Set<String> ogrencıKeyset= ogrenciMap.keySet();
       Set<String> ogretmenKeyset=ogretmenMap.keySet();


        if (kisiTuru.equalsIgnoreCase("ogrenci")){

            System.out.println("TC            AD SOYAD     SINIF  OGRENCİ NO    YAŞ\n" +
                              "-------------------------------------------------------");
            for (String each:ogrencıKeyset
            ) {
                System.out.printf("%-11s %-15s %-8s%-10s  %2s",each,ogrenciMap.get(each).adSoyad,ogrenciMap.get(each).sınıf,
                        ogrenciMap.get(each).ogrencıNo,ogrenciMap.get(each).yaş+"\n");

            }



        }else{
            System.out.println("TC           AD SOYAD      SİCİL NO    BRANŞ    YAŞ\n" +
                    "-------------------------------------------------------");
            for (String each:ogretmenKeyset
            ) {
                System.out.printf("%-11s %-15s %-8s%-10s  %2s",each,ogretmenMap.get(each).adSoyad,ogretmenMap.get(each).bolum,
                        ogretmenMap.get(each).sicilNo,ogretmenMap.get(each).yaş+"\n");

            }
        }

    }


    private static void arama() {
        System.out.print("Aranacak " + kisiTuru + " nin TC sini tuşlayınız : ");
        String aranacakTc = scan.next();
        if (kisiTuru.equalsIgnoreCase("ogrenci")&&ogrenciMap.containsKey(aranacakTc)) {
            System.out.println(ogrenciMap.get(aranacakTc));
        } else if (kisiTuru.equalsIgnoreCase("ogretmen")&&ogretmenMap.containsKey(aranacakTc)) {
            System.out.println(ogretmenMap.get(aranacakTc));

        } else {
            System.out.println("Aradıgınız " + kisiTuru + " kayıtlarda yok.");
        }
    }

    private static void ekle() {
        System.out.print("Eklenecek " + kisiTuru + " nin Ad Soyad : ");
        scan.nextLine();//Dummy
        String eklenecekAdSoyad = scan.nextLine();

        System.out.print("Eklenecek " + kisiTuru + " nin yaşı : ");
        int yas = 0;
        try {
            yas = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("yas için rakam gırmelısınız.");;
        }

        System.out.print("Eklenecek " + kisiTuru + " nin Kimlik Numarası : ");
        String eklencekKimlikNo = scan.next();
        scan.nextLine();

        if (kisiTuru.equalsIgnoreCase("ogrenci")) {
            scan.nextLine();
            System.out.print("Eklenecek " + kisiTuru + " nin Ögrenci Numarası : ");
            String eklenecekOgrenciNo = scan.next();
            System.out.print("Eklenecek " + kisiTuru + " nin Sınıfı : ");
            String eklenecekSınıf = scan.next();
            Ogrenci ogrenci = new Ogrenci(eklenecekAdSoyad, eklencekKimlikNo, yas, eklenecekOgrenciNo, eklenecekSınıf);

            ogrenciMap.put(eklencekKimlikNo, ogrenci);
        } else {
            scan.nextLine();
            System.out.print("Eklenecek " + kisiTuru + " nin Sicil Numarası : ");
            String eklenecekSicilNo = scan.next();
            System.out.print("Eklenecek " + kisiTuru + " nin Branşı : ");
            String eklenecekBrans = scan.next();
            Ogretmen ogretmen = new Ogretmen(eklenecekAdSoyad, eklencekKimlikNo, yas, eklenecekSicilNo, eklenecekBrans);

            ogretmenMap.put(eklencekKimlikNo, ogretmen);
        }

    }

    private static void cıkıs() {
        System.out.println("İyi gunler dileriz ....");
    }
}
