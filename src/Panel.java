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
            System.out.print("Seçiminiz:");
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
            Account account = accountManager.login(email, sifre);
            if (account instanceof Individual) {
                System.out.println("Bireysel hesaba giriş yapıldı.");
                System.out.println("#######################################");

                // Bireysel hesap işlemleri
            } else if (account instanceof Enterprise) {
                System.out.println("Kurumsal hesaba giriş yapıldı.");
                System.out.println("#######################################");

                // Kurumsal hesap işlemleri
            } else {
                System.out.println("Geçersiz hesap türü.");
                System.out.println("#######################################");

            }
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
        System.out.print("Seçiminiz:");
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
                System.out.println("#######################################");
                break;
            case 2:
                System.out.print("Isim: ");
                String isim2 = input.next();
                System.out.print("Soyisim: ");
                String soyisim2 = input.next();
                System.out.print("Eposta: ");
                String email2 = input.next();
                System.out.print("Şifre: ");
                String sifre2 = input.next();
                System.out.print("Meslek: ");
                String meslek2 = input.next();
                System.out.print("Yaş: ");
                int yas2 = 0;
                if (input.hasNextInt()) {
                    yas2 = input.nextInt();
                } else {
                    System.out.println("Yaş için geçerli bir sayı giriniz.");
                    return;
                }
                // Diğer gerekli bilgileri alabilirsiniz
                // Örnek: Adres bilgileri gibi
                // Son olarak bir kullanıcı nesnesi oluşturun ve AccountManager'a ekleyin
                User user2 = new User(isim2, soyisim2, email2, sifre2, meslek2, yas2, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new Date());
                accountManager.addUser(new Enterprise(AuthenticationStatus.FAIL, user2, new ArrayList<>(), new ArrayList<>()));
                System.out.println("Kurumsal hesap oluşturuldu.");
                System.out.println("#######################################");
                break;
            default:
                System.out.println("Hatalı bir seçim yaptınız.");
                System.out.println("#######################################");
                break;
        }
    }


}
