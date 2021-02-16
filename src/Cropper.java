public class Cropper {

    public static String getAlleAusfaelleString(String input){
        String output=input;
        output=output.split("<div class=\"js-list list\">")[1];
        output=output.split("\t</article>\n" + "\n" +"  </div>")[0];
        output+="\t</article>\n";

     return output;
    }
}
