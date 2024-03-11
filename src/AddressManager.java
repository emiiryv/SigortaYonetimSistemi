import java.util.ArrayList;
public class AddressManager {
    private ArrayList<Address> addressArrayList;
    private ArrayList<HomeAddress> homeAddressArrayList;
    private ArrayList<BusinessAddress> businessAddressArrayList;

    public AddressManager(ArrayList<Address> addressArrayList, ArrayList<HomeAddress> homeAddressArrayList, ArrayList<BusinessAddress> businessAddressArrayList) {
        this.addressArrayList = addressArrayList;
        this.homeAddressArrayList = homeAddressArrayList;
        this.businessAddressArrayList = businessAddressArrayList;
    }

    public static void addAddress(User user, Address address){
        user.getAddressArrayList().add(address);
    }
    public static void removeAddress(User user, Address address){
        user.getAddressArrayList().remove(address);
    }
    public static void addHomeAddress(User user,HomeAddress homeAddress){
        user.getHomeAddressArrayList().add(homeAddress);
    }
    public static void removeHomeAddress(User user,HomeAddress homeAddress){
        user.getAddressArrayList().remove(homeAddress);
    }
    public static void addBusinessAddress(User user,BusinessAddress businessAddress){
        user.getBusinessAddressArrayList().add(businessAddress);
    }
    public static void removeBusinessAddress(User user,BusinessAddress businessAddress){
        user.getBusinessAddressArrayList().remove(businessAddress);
    }
}
