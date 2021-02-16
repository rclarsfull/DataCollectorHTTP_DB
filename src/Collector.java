import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Collector {

    public static void save(String in,File file){
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write(in);
            bufferedWriter.close();
        } catch (Exception e){
        }
    }

  public static void main(String[]args) {

      String url = "https://www.bahn.de/p/view/service/aktuell/index.shtml";
      String aktuellsteDaten="";
      String alteDaten="";
      int frequenz=60*1000*5;


      File sammelstelle=new File("Sammelstelle.txt");



      while (true) {
          try {
              Data data = new Data(url);
              aktuellsteDaten = Cropper.getAlleAusfaelleString(data.allData);
          } catch (Exception e) {
              e.printStackTrace();
          }

          if (!aktuellsteDaten.equals(alteDaten)) {
              System.out.println("Update in Datei geschrieben am "+ LocalDateTime.now().toString());
              save(LocalDateTime.now().toString() + "<AnfangUpdate>{\n" + aktuellsteDaten + "\n}<EndeUpdate>\n\n\n", sammelstelle);
              alteDaten = aktuellsteDaten;
          }
          try {
              Thread.sleep(frequenz);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
}



