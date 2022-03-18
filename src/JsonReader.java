import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

public class JsonReader {
    static HashSet<LabWork> fromDataFile(String filename){
        try
        {
            String content = Files.lines(Paths.get(filename)).reduce("", String::concat);
            Gson gson = new Gson();
            return gson.fromJson(content, new TypeToken<HashSet<LabWork>>(){}.getType());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
