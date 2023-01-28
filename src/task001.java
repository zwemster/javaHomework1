import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class task001 {
   public static void main(String[] args){
       String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
   }

   public static String download(String fileUrl){
       try {
           URL url = new URL(fileUrl);
           URLConnection urlConnection = url.openConnection();
           InputStream inputStream = urlConnection.getInputStream();
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
           StringBuilder stringBuilder = new StringBuilder();
           String fileRow;

           while ((fileRow = bufferedReader.readLine()) != null){
               stringBuilder.append(fileRow);
               stringBuilder.append(System.lineSeparator());
           }

           return stringBuilder.toString();
       } catch (IOException e){
           System.out.println("File downloading error: " + e.getMessage());
           return null;
       }
   }


}
