import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Address> addressArrayList = new ArrayList<>();
        ArrayList<HomeAddress> homeAddressArrayList = new ArrayList<>();
        ArrayList<BusinessAddress> businessAddressArrayList = new ArrayList<>();

        AddressManager addressManager = new AddressManager(addressArrayList, homeAddressArrayList, businessAddressArrayList);
        AccountManager accountManager = new AccountManager();

        Panel panel = new Panel(addressManager, accountManager);
        panel.start();
    }
}
