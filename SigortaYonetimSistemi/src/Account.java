import java.util.ArrayList;
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

    // Kullanıcının login olma durumunu döndüren fonksiyon
    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
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

    public ArrayList<Address> getAddressArrayList() {
        return addressArrayList;
    }

    public void setAddressArrayList(ArrayList<Address> addressArrayList) {
        this.addressArrayList = addressArrayList;
    }

    //public abstract void loginFunction();

    public void addressEkleme(Address address) {
        addressArrayList.add(address);
    }

    public void addressCikarma(Address address) {
        addressArrayList.remove(address);
    }

    public abstract void SigortaPolicesiEkleme();

    public final void showUserInfo(AddressManager addressManager) {
        System.out.println("#######################################");
        System.out.println("Kullanıcı Bilgileri:");
        System.out.println("Isim: " + user.getIsim());
        System.out.println("Soyisim: " + user.getSoyisim());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Meslek: " + user.getMeslek());
        System.out.println("Yaş: " + user.getYas());
        System.out.println("Son Giriş: " + user.getLastLogin());
        System.out.println("Giriş Durumu: " + authenticationStatus);
        System.out.println("Adresler: ");

        // Adresler
        addressManager.getAddressArrayList();
        //ArrayList<Address> userAddresses = addressManager.getAddressArrayList();
        //for (Address address : userAddresses) {
        //    System.out.println(address.getAddressInfo());
        //}

        System.out.println("#######################################");
    }


}
