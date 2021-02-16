import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class Data {
    String allData;
    String url;

    Data(String url) throws Exception{
        this.url=url;
        try (InputStream in = URI.create(url).toURL().openStream()){
            allData=new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

}
