import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Run {
    public static void main(String[]args){
        File eingang=new File("Sammelstelle.txt");
        System.out.println(eingang.length());
        String zeile="";
        String alles="";


        System.out.println("## Datei wird eingelesen...");
        try {
            BufferedReader br = new BufferedReader(new FileReader(eingang));
            while ((zeile=br.readLine())!= null){
                alles+=zeile+"\n";
            }
            br.close();
        } catch (Exception e){

        }


        System.out.println("## Datei wird Verarbeitet...");
        String[] alleUpdateStrings=alles.split("<EndeUpdate>");
        //System.out.println(alleUpdateStrings.length);
        LinkedList<Update> alleUpdates=new LinkedList();
        for (String s:alleUpdateStrings) {
            String [] temp=s.split("<AnfangUpdate>");
            try {
            alleUpdates.add(new Update(temp[0],temp[1]));
            } catch (Exception e){
            }
        }

        //System.out.println(alleUpdates.size());
        int counter=0;
        for (int i = 0; i <alleUpdates.size() ; i++) {
            try{
                Update temp=alleUpdates.get(i);
                for (int j = 0; j < alleUpdates.size(); j++) {
                    if (temp.equals(alleUpdates.get(j))){
                       counter++;
                       if (counter>1){
                           alleUpdates.remove(temp);
                       }
                        counter=0;
                    }
                }
            }catch (Exception e){

            }
        }

        //System.out.println(alleUpdates.size());
        //System.out.println(alleUpdates.getFirst().text);
        System.out.println("## Die Meldungen werden gruppiert...");
        LinkedList<Meldung> alleMeldungen=new LinkedList<>();
        String was,beschreibung, warum;
        LocalDate von,bis;
        for (Update u:alleUpdates) {
            for (String s:u.text.split("<article class=\"incident compact long-text \" tabindex=\"0\">")) {
                //was=s.split("<h2 class=\"margin-top-0\">")[1];
                //was=was.split("</h2>")[0];
               // beschreibung=s.split("<h3 class=\"bullet-list-headline\">")[1];
               // beschreibung=beschreibung.split("</h3>")[0];

                alleMeldungen.add(new Meldung(s));
            }
        }

        System.out.println(alleMeldungen.size());

        counter=0;
        for (int i = 0; i <alleMeldungen.size() ; i++) {
            try{
                Meldung temp1=alleMeldungen.get(i);
                for (int j = 0; j < alleMeldungen.size(); j++) {
                    if (temp1.equals(alleMeldungen.get(j))){
                        counter++;
                        if (counter>1){
                            alleMeldungen.remove(temp1);
                        }
                        counter=0;
                    }
                }
            }catch (Exception e){

            }
        }

        System.out.println(alleMeldungen.size());

    }
}
