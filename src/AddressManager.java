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

    public ArrayList<Address> getAddressArrayList() {
        return addressArrayList;
    }

    public void addAddress(Address address) {
        addressArrayList.add(address);
    }

    public void removeAddress(Address address) {
        addressArrayList.remove(address);
    }

    public void addHomeAddress(HomeAddress homeAddress) {
        homeAddressArrayList.add(homeAddress);
    }

    public void removeHomeAddress(HomeAddress homeAddress) {
        homeAddressArrayList.remove(homeAddress);
    }

    public void addBusinessAddress(BusinessAddress businessAddress) {
        businessAddressArrayList.add(businessAddress);
    }

    public void removeBusinessAddress(BusinessAddress businessAddress) {
        businessAddressArrayList.remove(businessAddress);
    }
}
