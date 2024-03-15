public class HomeAddress implements Address {
    private String mahalle;
    private String sokak;
    private String apartman;
    private String daire;
    private String ililce;

    public HomeAddress(String mahalle, String sokak, String apartman, String daire,String ililce) {
        this.mahalle = mahalle;
        this.sokak = sokak;
        this.apartman = apartman;
        this.daire = daire;
        this.ililce = ililce;
    }

    // Adres bilgisini döndüren metot
    @Override
    public String getAddressInfo() {
        return mahalle + " Mahallesi, " + sokak + " Sokak, " + apartman + " Apartmanı, Daire: " + daire + " , " + ililce;
    }
}
