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
        System.out.print("Lütfen eposta adresinizi giriniz:");
        String email = input.next();
        System.out.print("Lütfen şifrenizi giriniz:");
        String sifre = input.next();

        try {
            accountManager.login(email, sifre);
            System.out.println("Giriş Başarılı!");
            // Giriş başarılıysa gerekli işlemler buraya yazılabilir
        } catch (InvalidAuthenticationException e) {
            System.out.println("Hata: " + e.getMessage());
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
