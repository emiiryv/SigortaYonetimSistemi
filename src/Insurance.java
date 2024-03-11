import java.util.Date;

public abstract class Insurance {
    private String sigortaIsmi;
    private Double sigortaUcreti;
    private Date sigortaGirisCikis;
    public abstract void Calculate();
}
