import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class task001 {
    public static void main(String[] args) {
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String fileContent = download(fileUrl);
        String name = "John";
        String updatedFile = change(fileContent, name);
        saveOnLocal(updatedFile);
    }

    public static String download(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String fileRow;

            while ((fileRow = bufferedReader.readLine()) != null) {
                stringBuilder.append(fileRow);
                stringBuilder.append(System.lineSeparator());
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            System.out.println("File downloading error: " + e.getMessage());
            return null;
        }
    }

    public static String change(String name, String fileContent) {
        return fileContent.replaceAll("%s", name);
    }

    public static void saveOnLocal(String fileContent){
        try {
            File file = new File("localFile.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File saving error: " + e.getMessage());
        }
    }


}
