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

    private final void showUserInfo() {
        System.out.println("Kullanıcı Bilgileri:");
        System.out.println("Isim: " + user.getIsim());
        System.out.println("Soyisim: " + user.getSoyisim());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Meslek: " + user.getMeslek());
        System.out.println("Yaş: " + user.getYas());
        System.out.println("Son Giriş: " + user.getLastLogin());
        System.out.println("Giriş Durumu: " + authenticationStatus);
        System.out.println("Adresler: ");

        // Ev Adresleri
        ArrayList<HomeAddress> homeAddresses = user.getHomeAddressArrayList();
        for (HomeAddress homeAddress : homeAddresses) {
            System.out.println("Ev Adresi:");
            System.out.println(homeAddress.getAddressInfo());
        }

        // İş Adresleri
        ArrayList<BusinessAddress> businessAddresses = user.getBusinessAddressArrayList();
        for (BusinessAddress businessAddress : businessAddresses) {
            System.out.println("İş Adresi:");
            System.out.println(businessAddress.getAddressInfo());
        }
    }












}
class User {
    private String isim;
    private String soyisim;

    private String email;
    private String sifre;
    private String meslek;
    private int yas;
    private ArrayList<Address> addressArrayList;
    private ArrayList<HomeAddress> homeAddressArrayList;
    private ArrayList<BusinessAddress> businessAddressArrayList;
    private Date lastLogin;

    public User(String isim, String soyisim, String email, String sifre, String meslek, int yas, ArrayList<Address> addressArrayList,ArrayList<HomeAddress> homeAddressArrayList,ArrayList<BusinessAddress> businessAddressArrayList, Date lastLogin) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
        this.sifre = sifre;
        this.meslek = meslek;
        this.yas = yas;
        this.addressArrayList = addressArrayList;
        this.homeAddressArrayList = homeAddressArrayList;
        this.businessAddressArrayList = businessAddressArrayList;
        this.lastLogin = lastLogin;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public ArrayList<Address> getAddressArrayList() {
        return addressArrayList;
    }

    public void setAddressArrayList(ArrayList<Address> addressArrayList) {
        this.addressArrayList = addressArrayList;
    }

    public ArrayList<HomeAddress> getHomeAddressArrayList() {
        return homeAddressArrayList;
    }

    public void setHomeAddressArrayList(ArrayList<HomeAddress> homeAddressArrayList) {
        this.homeAddressArrayList = homeAddressArrayList;
    }

    public ArrayList<BusinessAddress> getBusinessAddressArrayList() {
        return businessAddressArrayList;
    }

    public void setBusinessAddressArrayList(ArrayList<BusinessAddress> businessAddressArrayList) {
        this.businessAddressArrayList = businessAddressArrayList;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}