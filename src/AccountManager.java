import java.util.HashMap;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Individual> individualTreeSet;
    private TreeSet<Enterprise> enterpriseTreeSet;
    private HashMap<String,String> userCredentials;//Anahtar: email, Değer: şifre
    private String email;
    private String sifre;
    public AccountManager(){
        userCredentials = new HashMap<>();
    }

    public void login(String email, String sifre) throws InvalidAuthenticationException {
        String storedPassword = userCredentials.get(email);
        if (storedPassword != null && storedPassword.equals(sifre)) {
            // Giriş başarılı ise bir şey yapmaya gerek yok, sadece işlemi tamamlayabiliriz
        } else {
            throw new InvalidAuthenticationException("Geçersiz kullanıcı bilgileri");
        }



        /*
     Bu fonksiyon dışarıdan verilen email ve şifre bilgisini alıp
     Account listesi üzerinde dolaşıp uygun bir giriş işlemi bulursa
     Account nesnesini çağrıldığı yere dönecektir
     Bu fonksiyon Account nesnesi üzerindeki
     "login" olma fonksiyonunu çağıracaktır.
     Unutmayın bu fonksiyon "InvalidAuthenticationException"
     tipinde hata fırlatabiliyordu.
     Bu nedenle burada try-catch mekanizması kurmayı unutmayınız.

         */
    }





}
