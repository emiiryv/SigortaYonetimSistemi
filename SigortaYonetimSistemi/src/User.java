import java.util.ArrayList;
import java.util.Date;

public class User {
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

    public User(String isim, String soyisim, String email, String sifre, String meslek, int yas, ArrayList<Address> addressArrayList, ArrayList<HomeAddress> homeAddressArrayList, ArrayList<BusinessAddress> businessAddressArrayList, Date lastLogin) {
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
