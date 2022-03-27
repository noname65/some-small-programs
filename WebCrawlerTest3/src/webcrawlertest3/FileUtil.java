package webcrawlertest3;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
public class FileUtil {
    public static List<String> getListFromFile(String path){
        List<String> list = new ArrayList<>();
        String data = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            while((data = br.readLine())!=null){
                System.out.println(data); 
                list.add(data);
            }
        } catch (IOException e) {
        }
        return list;
    }
}