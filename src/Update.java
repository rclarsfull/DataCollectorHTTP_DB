import java.time.LocalDateTime;

public class Update {
    String text;
    LocalDateTime datum;
    public static int anzahl=0;

    Update(String datum,String text){
        String teilDatum=datum.split("T")[0];
        String uhrzeit=datum.split("T")[1];
        //System.out.println(teilDatum+"    "+uhrzeit);

        //System.out.println(teilDatum.split("-")[0]);
        int jahr=Integer.parseInt("2021");
        int monat=Integer.parseInt(teilDatum.split("-")[1]);
        int tag=Integer.parseInt(teilDatum.split("-")[2]);
        int stunde=Integer.parseInt(uhrzeit.split(":")[0]);
        int minute=Integer.parseInt(uhrzeit.split(":")[1]);
        this.datum=LocalDateTime.of(jahr,monat,tag,stunde,minute);
        this.text=text;
        anzahl++;
    }

    public boolean equals(Update update){
        if (update.datum.equals(datum) && update.text.equals(this.text)) return true;
        return false;
    }
}
