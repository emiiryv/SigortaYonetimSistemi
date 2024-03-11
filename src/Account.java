import java.util.ArrayList;
import java.util.Date;
enum AuthenticationStatus {
    SUCCESS, // Başarılı giriş
    FAIL     // Başarısız giriş
}


public abstract class Account {
    private AuthenticationStatus authenticationStatus;
    private User user;
    private ArrayList<String> insuranceList;
    private ArrayList<Address> addressArrayList;

    public Account(AuthenticationStatus authenticationStatus, User user, ArrayList<String> insuranceList, ArrayList<Address> addressArrayList) {
        this.authenticationStatus = authenticationStatus;
        this.user = user;
        this.insuranceList = insuranceList;
        this.addressArrayList = addressArrayList;
    }

    public Account(AuthenticationStatus authenticationStatus, User user, ArrayList<String> insuranceList) {
        this.authenticationStatus = authenticationStatus;
        this.user = user;
        this.insuranceList = insuranceList;
    }

    //Kullanıcının login olma durumunu döndüren fonksiyon
    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }
    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus){
        this.authenticationStatus = authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<String> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(ArrayList<String> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public void loginFunction(String email,String sifre){
      /*
       Bu fonksiyon email ve şifre bilgisi alacak
       ve gelen email şifre bilgisini
       User sınıfındaki email ve şifre ile kıyaslayacaktır.
       Eğer girilen bilgiler doğruysa giriş işlemi başarılı olacaktır.
       Ve kullanıcının login olma durumu SUCCESS'e çekilecektir.
       Giriş işlemi başarısız ise
       "InvalidAuthenticationException" tipinde bir hata fırlatacaktır.
       Bu hata sınıfını Exception isimli Java sınıfından kalıtım alarak
       sizin yazmanız gerekecektir.
       */
    }

    public void AddressEkleme(){

    }




    public void AddressCikarma(){

    }


    public abstract void SigortaPolicesiEkleme();//Individual ve Enterprise isimli alt sınıflarda override edilecek












}
class User {
    private String isim;
    private String soyisim;

    private String email;
    private String sifre;
    private String meslek;
    private int yas;
    private ArrayList<Address> addressArrayList;
    private Date lastLogin;

    public User(String isim, String soyisim, String email, String sifre, String meslek, int yas, ArrayList<Address> addressArrayList, Date lastLogin) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
        this.sifre = sifre;
        this.meslek = meslek;
        this.yas = yas;
        this.addressArrayList = addressArrayList;
        this.lastLogin = lastLogin;
    }
}