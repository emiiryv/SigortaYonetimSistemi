public class BusinessAddress implements Address {
    private String street;
    private String city;
    private String zipCode;
    private String country;

    public BusinessAddress(String street, String city, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    // Adres bilgisini döndüren metot
    @Override
    public String getAddressInfo() {
        return street + ", " + city + ", " + zipCode + ", " + country;
    }
}
