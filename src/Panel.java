import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Panel {
    private AddressManager addressManager;
    private AccountManager accountManager;

    public Panel(AddressManager addressManager, AccountManager accountManager) {
        this.addressManager = addressManager;
        this.accountManager = accountManager;
    }
    //account type ayarla
    public void start() {

        while (true) {
            System.out.println("Sigorta Yönetim Sistemi'ne Hoşgeldiniz!");
            System.out.println("#######################################");
            System.out.println("1-Giriş Yap");
            System.out.println("2-Hesap Oluştur");
            System.out.println("0-Çıkış Yap");
            Scanner input = new Scanner(System.in);
            int secim = input.nextInt();

            switch (secim) {
                case 1:
                    girisYap();
                    break;
                case 2:
                    hesapOlustur();
                    break;
                case 0:
                    System.out.println("Çıkış Yapılıyor...");
                    return;
                default:
                    System.out.println("Hatalı bir seçim yaptınız.");
                    break;
            }
        }
    }
    private void girisYap() {
        Scanner input = new Scanner(System.in);
        System.out.println("#######################################");
        System.out.print("Hangi türde hesaba giriş yapmak istersiniz? (1-Bireysel, 2-Kurumsal): ");
        int hesapTuruSecim = input.nextInt();
        input.nextLine(); // Buffer temizleme

        switch (hesapTuruSecim) {
            case 1:
                System.out.print("Bireysel hesap için eposta adresinizi giriniz: ");
                String bireyselEmail = input.nextLine();
                System.out.print("Şifrenizi giriniz: ");
                String bireyselSifre = input.nextLine();
                try {
                    accountManager.login(bireyselEmail, bireyselSifre);
                    System.out.println("Bireysel hesaba giriş başarılı!");
                } catch (InvalidAuthenticationException e) {
                    System.out.println("Bireysel hesaba giriş yapılamadı: " + e.getMessage());
                }
                break;
            case 2:
                System.out.print("Kurumsal hesap için eposta adresinizi giriniz: ");
                String kurumsalEmail = input.nextLine();
                System.out.print("Şifrenizi giriniz: ");
                String kurumsalSifre = input.nextLine();
                try {
                    accountManager.login(kurumsalEmail, kurumsalSifre);
                    System.out.println("Kurumsal hesaba giriş başarılı!");
                } catch (InvalidAuthenticationException e) {
                    System.out.println("Kurumsal hesaba giriş yapılamadı: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Hatalı bir seçim yaptınız.");
                break;
        }
    }


    private void hesapOlustur() {
        Scanner input = new Scanner(System.in);
        System.out.println("#######################################");
        System.out.println("Hangi türde hesap oluşturmak istersiniz?");
        System.out.println("1-Bireysel Hesap");
        System.out.println("2-Kurumsal Hesap");
        int secim = input.nextInt();

        switch (secim) {
            case 1:
                System.out.print("Isim: ");
                String isim = input.next();
                System.out.print("Soyisim: ");
                String soyisim = input.next();
                System.out.print("Eposta: ");
                String email = input.next();
                System.out.print("Şifre: ");
                String sifre = input.next();
                System.out.print("Meslek: ");
                String meslek = input.next();
                System.out.print("Yaş: ");
                int yas = 0;
                if (input.hasNextInt()) {
                    yas = input.nextInt();
                } else {
                    System.out.println("Yaş için geçerli bir sayı giriniz.");
                    return;
                }
                // Diğer gerekli bilgileri alabilirsiniz
                // Örnek: Adres bilgileri gibi
                // Son olarak bir kullanıcı nesnesi oluşturun ve AccountManager'a ekleyin
                User user = new User(isim, soyisim, email, sifre, meslek, yas, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new Date());
                accountManager.addUser(new Individual(AuthenticationStatus.FAIL, user, new ArrayList<>(), new ArrayList<>()));
                System.out.println("Bireysel hesap oluşturuldu.");
                break;
            case 2:
                // Kurumsal hesap oluşturma işlemleri
                break;
            default:
                System.out.println("Hatalı bir seçim yaptınız.");
                break;
        }
    }

}
