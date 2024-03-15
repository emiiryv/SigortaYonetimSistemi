import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Panel {
    private AddressManager addressManager;
    private AccountManager accountManager;

    public Panel(AddressManager addressManager, AccountManager accountManager) {
        this.addressManager = addressManager;
        this.accountManager = accountManager;
    }

    // Hesaplama türünü ayarla
    public void start() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Sigorta Yönetim Sistemi'ne Hoşgeldiniz!");
            System.out.println("#######################################");
            System.out.println("1-Giriş Yap");
            System.out.println("2-Hesap Oluştur");
            System.out.println("0-Çıkış Yap");
            try {
                System.out.print("Seçiminiz:");
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
            } catch (InputMismatchException e) {
                System.out.println("Hatalı bir giriş yaptınız. Lütfen geçerli bir sayı giriniz.");
                input.nextLine();
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
            while (true) {
                if (account instanceof Individual) {
                    System.out.println("Bireysel hesaba giriş yapıldı.");
                    System.out.println("#######################################");

                    System.out.println("1-Kullanıcı Hesap Bilgisi Görüntüle");
                    System.out.println("2-Sigorta Bilgilerini Görüntüle");
                    System.out.println("3-Adres Ekle");
                    System.out.println("4-Sigorta Poliçesi Ekleme");
                    System.out.println("0-Çıkış Yap");
                    try {
                        System.out.print("Seçiminiz:");
                        int islemSecim = input.nextInt();

                        switch (islemSecim) {
                            case 1:
                                account.showUserInfo(addressManager);
                                break;
                            case 2:
                                sigortaBilgiGoruntule();
                                break;
                            case 3:
                                adresEkleme();
                                break;
                            case 4:
                                sigortaPolicesiEkleme();
                                break;
                            case 0:
                                System.out.println("Çıkış Yapılıyor...");
                                return;
                            default:
                                System.out.println("Hatalı bir seçim yaptınız.");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Hatalı bir giriş yaptınız. Lütfen geçerli bir sayı giriniz.");
                        input.nextLine();
                    }
                } else if (account instanceof Enterprise) {
                    System.out.println("Kurumsal hesaba giriş yapıldı.");
                    System.out.println("#######################################");

                    System.out.println("1-Kullanıcı Hesap Bilgisi Görüntüle");
                    System.out.println("2-Sigorta Bilgilerini Görüntüle");
                    System.out.println("3-Adres Ekle");
                    System.out.println("4-Sigorta Poliçesi Ekleme");
                    System.out.println("0-Çıkış Yap");
                    try {
                        System.out.print("Seçiminiz:");
                        int islemSecim = input.nextInt();

                        switch (islemSecim) {
                            case 1:
                                account.showUserInfo(addressManager);
                                break;
                            case 2:
                                sigortaBilgiGoruntule();
                                break;
                            case 3:
                                adresEkleme();
                                break;
                            case 4:
                                sigortaPolicesiEkleme();
                                break;
                            case 0:
                                System.out.println("Çıkış Yapılıyor...");
                                return;
                            default:
                                System.out.println("Hatalı bir seçim yaptınız.");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Hatalı bir giriş yaptınız. Lütfen geçerli bir sayı giriniz.");
                        input.nextLine();
                    }

                } else {
                    System.out.println("Geçersiz hesap türü.");
                    System.out.println("#######################################");
                }
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

    private void sigortaBilgiGoruntule(){
        while (true) {
            System.out.println("#######################################");
            System.out.println("1-Sağlık Sigortası");
            System.out.println("2-Araba Sigortası");
            System.out.println("3-Ev Sigortası");
            System.out.println("4-Seyahat Sigortası");
            System.out.println("0-Geri Dön");
            System.out.print("Görmek İstediğiniz Sigorta Bilgisini Seçiniz:");
            Scanner input = new Scanner(System.in);
            int sigortaSecim = input.nextInt();
            switch (sigortaSecim) {
                case 1:
                    HealthInsurance healthInsurance = new HealthInsurance();
                    healthInsurance.Calculate();
                    break;
                case 2:
                    CarInsurance carInsurance = new CarInsurance();
                    carInsurance.Calculate();
                    break;
                case 3:
                    ResidenceInsurance residenceInsurance = new ResidenceInsurance();
                    residenceInsurance.Calculate();
                    break;
                case 4:
                    TravelInsurance travelInsurance = new TravelInsurance();
                    travelInsurance.Calculate();
                    break;
                case 0:
                    System.out.println("Bir önceki sayafaya dönülüyor...");
                    System.out.println("#######################################");
                    break;
                default:
                    System.out.println("Hatalı bir seçim yaptınız.");
                    break;
            }
            if (sigortaSecim == 0) {
                break;
            }
        }
    }

    private void adresEkleme() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("#######################################");
            System.out.println("1-Ev Adresi");
            System.out.println("2-İş Adresi");
            System.out.println("0-Geri Dön");
            System.out.print("Eklemek istediğiniz adres tipini seçiniz:");
            int adresSecim = input.nextInt();

            switch (adresSecim) {
                case 1:
                    System.out.println("#######################################");
                    System.out.println("Ev Adresinizi Giriniz ");
                    System.out.print("-Mahalle:");
                    String mahalle = input.next();
                    System.out.print("-Sokak:");
                    String sokak = input.next();
                    System.out.print("-Apartman:");
                    String apartman = input.next();
                    System.out.print("-Daire:");
                    String daire = input.next();
                    System.out.print("-Il/Ilçe:");
                    String ililce = input.next();
                    HomeAddress homeAddress = new HomeAddress(mahalle, sokak, apartman, daire, ililce);
                    addressManager.addHomeAddress(homeAddress);
                    System.out.println("Ev adresi eklendi.");
                    break;
                case 2:
                    System.out.println("#######################################");
                    System.out.println("İş Adresinizi Giriniz ");
                    System.out.print("-Mahalle:");
                    String isMahalle = input.next();
                    System.out.print("-Sokak:");
                    String isSokak = input.next();
                    System.out.print("-Apartman:");
                    String isApartman = input.next();
                    System.out.print("-Daire:");
                    String isKapiNo = input.next();
                    System.out.print("-Il/Ilçe:");
                    String isililce = input.next();
                    BusinessAddress businessAddress = new BusinessAddress(isMahalle, isSokak, isApartman, isKapiNo, isililce);
                    addressManager.addBusinessAddress(businessAddress);
                    System.out.println("İş adresi eklendi.");
                    break;
                case 0:
                    System.out.println("Bir önceki sayfaya dönülüyor...");
                    System.out.println("#######################################");
                    return;
                default:
                    System.out.println("Hatalı bir seçim yaptınız.");
                    break;
            }
        }
    }




    private void sigortaPolicesiEkleme(){
        // Burada ilgili işlemler yapılacak
        System.out.println("Bu Kısımdan Sigorta Poliçesi Ekleyebilirsiniz...");
        System.out.println("Bu Kısımdan Sigorta Poliçesi Ekleyebilirsiniz...");
        System.out.println("Bu Kısımdan Sigorta Poliçesi Ekleyebilirsiniz...");
    }
}
