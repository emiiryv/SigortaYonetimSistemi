import java.util.HashMap;

public class AccountManager {
    private HashMap<String, Account> accounts; // Anahtar: email, Değer: Account

    public AccountManager() {
        accounts = new HashMap<>();
    }

    public void addUser(Account account) {
        // HashMap'e kullanıcıyı ekle
        accounts.put(account.getUser().getEmail(), account);
    }

    public Account login(String email, String password) throws InvalidAuthenticationException {
        Account account = accounts.get(email); // HashMap'ten hesabı al

        if (account != null && account.getUser().getSifre().equals(password)) {
            // Eğer hesap bulunursa ve şifre doğruysa, giriş başarılı olur
            System.out.println("Giriş Başarılı!");
            return account;
        } else {
            // Eğer hesap bulunamazsa veya şifre yanlışsa hata fırlat
            throw new InvalidAuthenticationException("Geçersiz kullanıcı bilgileri");
        }
    }
}
