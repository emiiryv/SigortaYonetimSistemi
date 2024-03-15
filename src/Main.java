import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Address> addressArrayList = new ArrayList<>();
        ArrayList<HomeAddress> homeAddressArrayList = new ArrayList<>();
        ArrayList<BusinessAddress> businessAddressArrayList = new ArrayList<>();

        AddressManager addressManager = new AddressManager(addressArrayList, homeAddressArrayList, businessAddressArrayList);
        AccountManager accountManager = new AccountManager();
        createPredefinedUsers(accountManager);
        Panel panel = new Panel(addressManager, accountManager);
        panel.start();
    }

    private static void createPredefinedUsers(AccountManager accountManager) {
        ArrayList<Address> addressArrayList = new ArrayList<>();
        ArrayList<HomeAddress> homeAddressArrayList = new ArrayList<>();
        ArrayList<BusinessAddress> businessAddressArrayList = new ArrayList<>();

        // Kullanıcı 1
        User user1 = new User("Ahmet", "Avcı", "ahmet@mail.com", "ahmet123", "Serbest", 23, addressArrayList, homeAddressArrayList, businessAddressArrayList, new Date());
        Individual individual1 = new Individual(AuthenticationStatus.SUCCESS, user1, new ArrayList<>(), new ArrayList<>());
        accountManager.addUser(individual1);

        // Kullanıcı 2
        User user2 = new User("Ayşe", "Yılmaz", "ayse@mail.com", "ayse123", "Mühendis", 28, addressArrayList, homeAddressArrayList, businessAddressArrayList, new Date());
        Individual individual2 = new Individual(AuthenticationStatus.SUCCESS, user2, new ArrayList<>(), new ArrayList<>());
        accountManager.addUser(individual2);

        // Diğer önceden tanımlı kullanıcılar
        // ...
    }

}



