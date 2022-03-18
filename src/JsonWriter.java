import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class JsonWriter {
   static void toDataFile(HashSet<LabWork> hashSet, String filename){
       TreeSet treeSet = Interactive_App.sort_collection(hashSet);
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
       String s = gson.toJson(treeSet);

       File file = new File(filename);

       try {
           file.createNewFile();
       } catch (IOException e) {
           e.printStackTrace();
       }

       try {
           FileWriter writer = new FileWriter(file);
           writer.write(s);
           writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }

      /* Gson gson = new GsonBuilder().setPrettyPrinting().create();
       try {
           FileWriter writer = new FileWriter("C:\\Users\\Yaroslav\\IdeaProjects\\Lab5\\" + filename + ".json");
           gson.toJson(hashSet, writer);
       } catch (IOException e) {
            e.printStackTrace();
       }*/

    }
}