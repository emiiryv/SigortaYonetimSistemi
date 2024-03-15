public class BusinessAddress implements Address {
    private String isMahalle;
    private String isSokak;
    private String isApartman;
    private String isKapiNo;
    private String isililce;

    public BusinessAddress(String isMahalle, String isSokak, String isApartman, String isKapiNo, String isililce) {
        this.isMahalle = isMahalle;
        this.isSokak = isSokak;
        this.isApartman = isApartman;
        this.isKapiNo = isKapiNo;
        this.isililce = isililce;
    }

    // Adres bilgisini döndüren metot
    @Override
    public String getAddressInfo() {
        return isMahalle + " Mahallesi, " + isSokak + " Sokak, " + isApartman + " Apartmanı, Kapı No: " + isKapiNo + " , " + isililce;
    }
}
