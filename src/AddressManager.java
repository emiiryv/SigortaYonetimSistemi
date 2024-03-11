import java.util.ArrayList;
public class AddressManager {
    public static void addAddress(User user, Address address){
        user.getAddressArrayList().add(address);
    }
    public static void removeAddress(User user, Address address){
        user.getAddressArrayList().remove(address);
    }
}
