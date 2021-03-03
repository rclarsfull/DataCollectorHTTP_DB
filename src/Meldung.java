import java.time.LocalDate;
import java.time.LocalDateTime;

public class Meldung {

    private String text;
    String was;
    String beschreibung;
    LocalDate von,bis;
    String warum;

    public Meldung(String text) {

        this.text = text;

    }
}
