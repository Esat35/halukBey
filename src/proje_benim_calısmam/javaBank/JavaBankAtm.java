package proje_benim_calısmam.javaBank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

class JavaBankAtm {
   /*      ATM
        Kullaniciya giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
        Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
        Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,

        Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis.

        Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
        Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina geri donsun.
        Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,       */

    static double bakiye = 1000;
    static String kartNo = "1234123412341234";
    static String sifrem = "1234";
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        girisMenu();

    }

    private static void girisMenu() throws InterruptedException {
        System.out.print("Kart numaranızı gırınız : ");
        String kartNumber = scan.nextLine();

        System.out.print("Sifrenizi giriniz : ");
        String girilenSifre = scan.next();
        bilgiKontrol(kartNumber, girilenSifre);

    }

    private static void bilgiKontrol(String kartNumber, String girilenSifre) throws InterruptedException {
        kartNumber = kartNumber.replace(" ", "");
        if (!(kartNo.equalsIgnoreCase(kartNumber) && girilenSifre.equalsIgnoreCase(sifrem))) {

            if (!kartNumber.equalsIgnoreCase(kartNo)) {
                System.out.println("Hatalı kart numarası!");
            }

            if (!girilenSifre.equalsIgnoreCase(sifrem)) {
                System.out.println("Hatalı sifre !");
            }
            scan.nextLine();
            girisMenu();
        } else {
            islemMenusu();
        }


    }

    private static void islemMenusu() throws InterruptedException {// Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis.
        System.out.print("1- BAKİYE SORGULAMA\n2- PARA YATIRMA\n3- PARA ÇEKME\n4- PARA GÖNDERME\n5- ŞİFRE DEĞİŞTİRME\n6- ÇIKIŞ\n  işleminizi seçiniz : ");
        String secim = scan.next();

        switch (secim) {
            case "1":
                bakiyeSorgula();
                islemMenusu();
                break;
            case "2":
                paraYatir();
                islemMenusu();
                break;
            case "3":
                paraCek();
                islemMenusu();
                break;
            case "4":
                paraGonder();
                islemMenusu();
                break;
            case "5":
                sifreDegistir();
                islemMenusu();
                break;
            case "6":
                cıkıs();
                break;
            default:

                System.out.println("Hatali işlem secimi yaptınız. Tekrar deneyınız :");
                islemMenusu();
                break;
        }
    }

    private static void sifreDegistir() {//Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
        System.out.println("=======  ŞİFRE DEĞİŞTİRME EKRANI  ======");
        System.out.print("Mevcut sıfrenızı gırınız : ");
        String mevcutSıfre = scan.next();
        if (mevcutSıfre.equalsIgnoreCase(sifrem)) {
            System.out.print("Yeni sifrenızı gırınız : ");
            String yeniSifre = scan.next();
            sifrem = yeniSifre;
            System.out.println("sifreniz " + yeniSifre + " olarak guncellendi.");
        } else {
            System.out.println("Sıfrenız uyusmuyor.");
            sifreDegistir();
        }
    }

    private static void paraGonder() throws InterruptedException {//Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali,
        // eger değilse menü ekranina geri donsun.
        System.out.println("=======  PARA GÖNDERME EKRANI  ======");
        System.out.print("Para gonderilecek IBAN numarasını gırınız :");
        String iban = scan.nextLine().replace(" ", "");
        if (iban.startsWith("TR") && iban.length() == 26) {
            System.out.print("Gönderilecek miktarı gırınız : ");
            double gönderilecekMiktar = 0;
            try {
                gönderilecekMiktar = scan.nextDouble();
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
            if (gönderilecekMiktar > bakiye) {
                System.out.println("Yeterli bakıyenız olmadıgı ıcın para gonderme yapılamaz!");

            } else {
                bakiye -= gönderilecekMiktar;
                System.out.println("Para gonderme işlemi basarı ıle tamamlandı.\nguncel bakıyenız : " + bakiye + " TL.");
                Thread.sleep(4000);
            }

        } else {
            if (!iban.startsWith("TR")) System.out.println("Iban numarası TR ile baslamalı");
            if (iban.length() != 26) System.out.println("Iban numarası 26 karakterden olusmalı");
        }
    }

    private static void paraCek() throws InterruptedException {
        System.out.println("=======  PARA ÇEKME EKRANI  ======");
        System.out.print("Cekmek istediğiniz miktarı gırınız : ");
        double cekilecekMiktar = 0;
        try {
            cekilecekMiktar = scan.nextDouble();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        if (bakiye < cekilecekMiktar) {
            System.out.println("bakıyenız yetersız! ");
        } else {
            bakiye -= cekilecekMiktar;
            System.out.println("para cekme işlemi basarı ıle yapıldı");
            System.out.println("Kalan bakıyenız : " + bakiye + " TL");
            Thread.sleep(4000);

        }
    }

    private static void paraYatir() throws InterruptedException {
        System.out.println("=======  PARA YATIRMA EKRANI  ======");
        System.out.print("Yatırmak istediğiniz miktari giriniz :");

        int yatırılanMiktar = 0;
        try {
            yatırılanMiktar = scan.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("hatalı veri girişi yaptınız tekrar deneyınız ");
        }
        bakiye += yatırılanMiktar;
        System.out.println(yatırılanMiktar + " TL hesabınıza eklendi");
        System.out.println("guncel bakıyenız : " + bakiye + " TL.");
        Thread.sleep(4000);


    }




    private static void cıkıs() {
        System.out.println("Güle güle...");
    }

    private static void bakiyeSorgula() throws InterruptedException {
        System.out.println("=======  BAKİYE SORGULAMA EKRANI  ======");
        System.out.println("Guncel bakiyeniz : " + bakiye + " TL.");
        Thread.sleep(4000);
    }


}