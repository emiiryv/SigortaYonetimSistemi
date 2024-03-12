import java.util.ArrayList;

public class Individual extends Account {
    public Individual(AuthenticationStatus authenticationStatus, User user, ArrayList<String> insuranceList, ArrayList<Address> addressArrayList) {
        super(authenticationStatus, user, insuranceList, addressArrayList);
    }

    @Override
    public void SigortaPolicesiEkleme() {
        // İlgili işlemleri yapınız
    }
}