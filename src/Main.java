import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Address> addressArrayList = new ArrayList<>();
        ArrayList<HomeAddress> homeAddressArrayList = new ArrayList<>();
        ArrayList<BusinessAddress> businessAddressArrayList = new ArrayList<>();

        User user = new User("Ahmet", "Avcı", "ahmeta@mail.com", "ahmet123", "Serbest", 23, addressArrayList, homeAddressArrayList, businessAddressArrayList, new Date());
        AddressManager addressManager = new AddressManager();
        AccountManager accountManager = new AccountManager();
        accountManager.addUser(user.getEmail(), user.getSifre()); // Kullanıcıyı ekleyin
        Panel panel = new Panel(addressManager, accountManager, user);
        panel.start();
    }
}
