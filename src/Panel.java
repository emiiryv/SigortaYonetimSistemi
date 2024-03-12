import java.util.Scanner;

public class Panel {
    private AddressManager addressManager;

    private AccountManager accountManager;
    private User user;
    private Address address;
    private HomeAddress homeAddress;
    private BusinessAddress businessAddress;
    private Scanner input;

    public Panel(AddressManager addressManager, AccountManager accountManager, User user, Address address, HomeAddress homeAddress, BusinessAddress businessAddress, Scanner input) {
        this.addressManager = addressManager;
        this.accountManager = accountManager;
        this.user = user;
        this.address = address;
        this.homeAddress = homeAddress;
        this.businessAddress = businessAddress;
        this.input = input;
    }

    public void start(){
        System.out.println("Sigorta Yönetim Sistemi'ne Hoşgeldiniz!");
        System.out.println("#######################################");
        System.out.println("-Kurumsal Giriş(K)");
        System.out.println("-Bireysel Giriş(B)");
        String girisSecim=input.nextLine();
        int Ksecim;
        int Bsecim;
        if (girisSecim.equalsIgnoreCase("K")){

            do {
                System.out.println("#######################################");
                System.out.print("Lütfen eposta adresinizi giriniz:");
                String email = input.nextLine();
                System.out.print("Lütfen şifrenizi giriniz:");
                String sifre = input.nextLine();

                try {
                    accountManager.login(email, sifre);
                    // Burada eğer giriş başarılı ise devam edecek işlemleri yapabilirsiniz
                    // Örneğin menü gösterme veya ilgili işlemleri gerçekleştirme gibi
                    System.out.println("Giriş Başarılı!");
                } catch (InvalidAuthenticationException e) {
                    System.out.println("Hata: " + e.getMessage());
                }

                System.out.println("SEÇENEKLER");
                Ksecim = input.nextInt();
                switch (Ksecim){
                    case 1:



                }






            } while (Ksecim != 0);
        } else if (girisSecim.equalsIgnoreCase("B")) {

            do {
            System.out.println("#######################################");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz");
            System.out.println("SEÇENEKLER");
            Bsecim = input.nextInt();
            switch (Bsecim){
                case 1:



            }






        } while (Bsecim != 0);

        }else {
            System.out.println("Hatalı bir seçim yaptınız.");
        }

    }
}
