import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Названия файла не содержится в командной строке, пожалуйста, запустите программу с именем файла");
        return;
        }

        String filename = args[0];
        try {
            FileReader fileReader = new FileReader(filename);
            fileReader.read();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Файл " + filename + " не удаётся открыть");
            return;
        }

        HashSet<LabWork> labWorks = JsonReader.fromDataFile(filename);
        Date ini_date = new Date();
        if (labWorks == null){
            System.out.println("В файле отсутствуют элементы");
            return;
        }

        for (LabWork lab : labWorks){
           boolean isCorrect = false;
           if(lab.getName() == null || lab.getName() == "") {
               System.out.println("Вы ввели некоректное имя, повторите попытку");
               while (!isCorrect) {
                   System.out.println("Введите имя: ");
                   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                   String s = null;
                   String name = null;

                   try {
                       s = reader.readLine();
                       if(s.matches("\\w+")){
                           name = s;
                       }
                   } catch (IOException e) {
                       e.printStackTrace();
                   }

                   if (name == null) {
                       System.out.println("Вы ввели некоректные данные, повторите попытку");
                   } else {
                       lab.setName(name);
                       isCorrect = true;
                   }
               }
               isCorrect = false;
           }

            if (lab.getCoordinates().getX() == null || lab.getCoordinates().getX() <= -28) {
                while (!isCorrect){
                    System.out.println("Введите координату х: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    Double x = null;
                    try {
                        s = reader.readLine();
                        if (s.matches("-?[0-9]+\\.?[0-9]*")) {
                            x = Double.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (x == null || x <= -28) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getCoordinates().setX(x);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getCoordinates().getY() <= -886){
                while (!isCorrect){
                    System.out.println("Введите координату y: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    float y = -886;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            y = Float.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (y <= -886) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getCoordinates().setY(y);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getMinimalPoint() <= 0){
                while (!isCorrect){
                    System.out.println("Введите минимальную оценку: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    int min = 0;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            min = Integer.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (min <= 0) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.setMinimalPoint(min);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getMaximumPoint() <= 0){
                while (!isCorrect){
                    System.out.println("Введите максимальную оценку: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    double max = 0;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            max = Double.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (max <= 0) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.setMaximumPoint(max);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getAveragePoint() == null || lab.getAveragePoint() <= 0){
                while (!isCorrect){
                    System.out.println("Введите среднюю оценку: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    Double average = null;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            average = Double.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (average == null || average <= 0 ) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.setAveragePoint(average);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if(lab.getDifficulty() == null){
                while (!isCorrect){
                    System.out.println("Введите сложность:\n EASY,\n VERY_HARD,\n HOPELESS");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    String diff = null;
                    try {
                        s = reader.readLine();
                        if (s.matches("[A-Z,a-z]+_?[A-Z,a-z]*")){
                            diff = s;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (diff == null){
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else if (diff.toUpperCase().equals("HOPELESS")) {
                        lab.setDifficulty(Difficulty.HOPELESS);
                        isCorrect = true;
                    }
                    else if(diff.toUpperCase().equals("EASY")){
                        lab.setDifficulty(Difficulty.EASY);
                        isCorrect = true;
                    }
                    else if(diff.toUpperCase().equals("VERY_HARD")){
                        lab.setDifficulty(Difficulty.VERY_HARD);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getAuthor().getName() == null){
                while (!isCorrect){
                    System.out.println("Введите имя автора: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    String name = null;

                    try {
                        s = reader.readLine();
                        if (s.matches("[A-Z,a-z]+")){
                            name = s;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (name == null) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getAuthor().setName(name);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getAuthor().getBirthday() == null){
                while (!isCorrect){
                    System.out.println("Введите дату в формате dd.MM.yyyy: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    Date date = null;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

                    try {
                        s = reader.readLine();
                        if (s.matches("[1-3]?[0-9]{1}\\.1?[1-2]\\.[1-9]{1}[0-9]{3}")){
                            date = dateFormat.parse(s);
                        }
                    } catch (IOException | ParseException e) {
                        e.printStackTrace();
                    }

                    if (date == null) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getAuthor().setBirthday(date);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if(lab.getAuthor().getHeight() <= 0){
                while (!isCorrect){
                    System.out.println("Введите высоту: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    float height = 0;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            height = Float.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (height <= 0) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getAuthor().setHeight(height);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getAuthor().getWeight() == null || lab.getAuthor().getWeight() <= 0){
                while (!isCorrect){
                    System.out.println("Введите вес: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    Long weight = null;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            weight = Long.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (weight == null || weight <= 0 ) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getAuthor().setWeight(weight);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getAuthor().getLocation().getX() == null){
                while (!isCorrect){
                    System.out.println("Введите координату локации х: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    Double x = null;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            x = Double.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (x == null) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getAuthor().getLocation().setX(x);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getAuthor().getLocation().getY() == 0){
                while (!isCorrect){
                    System.out.println("Введите координату локации у: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    long y = 0;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            y = Long.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (y == 0) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getAuthor().getLocation().setY(y);
                        isCorrect = true;
                    }
                }
                isCorrect = false;
            }

            if (lab.getAuthor().getLocation().getZ() == null){
                while (!isCorrect){
                    System.out.println("Введите координату локации z: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String s = null;
                    Integer z = null;
                    try {
                        s = reader.readLine();
                        if (s.matches("[0-9]+\\.?[0-9]*")) {
                            z = Integer.valueOf(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (z == null) {
                        System.out.println("Вы ввели некоректные данные, повторите попытку");
                    }
                    else{
                        lab.getAuthor().getLocation().setZ(z);
                        isCorrect = true;
                    }
                }
            }
       }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*System.out.println("Введите название файла: ");
        filename = null;
        try {
            filename = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        while (true){
            System.out.println("Введите команду: ");

            String command = null;
            while (true){
                try {
                    String s = reader.readLine();
                    command = s;


                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (command == null || command == "" ){
                    System.out.println("Ошибка, поле не может быть пустым");
                }
                else break;
            }

            if (command.equals("add")){
                Interactive_App.add(labWorks);
            }
            else if(command.matches("update +[0-9]{6}")){
                String[] composite_command = command.split(" +");
                long id = Long.valueOf(composite_command[1]);
                Interactive_App.update_id(labWorks, id);
            }
            else if (command.equals("exit")){
                break;
            }
            else if (command.equals("add_if_max")){
                Interactive_App.add_if_max(labWorks);
            }
            else if (command.equals("add_if_min")){
                Interactive_App.add_if_min(labWorks);
            }
            else if (command.equals("remove_lower")){
                Interactive_App.remove_lower(labWorks);
            }
            else if(command.matches("remove_by_id +[0-9]{6}")){
                String[] composite_command = command.split(" +");
                long id = Long.valueOf(composite_command[1]);
                Interactive_App.remove_by_id(labWorks, id);
            }
            else if (command.equals("save")){
                Interactive_App.save(labWorks, filename);
            }
            else if (command.equals("clear")){
                Interactive_App.clear(labWorks);
            }
            else if (command.equals("min_by_creation_date")){
                Interactive_App.min_by_creation_date(labWorks);
            }
            else if (command.equals("print_field_descending_average_point")){
                Interactive_App.print_field_descending_average_point(labWorks);
            }
            else if(command.matches("filter_starts_with_name +[a-z,A-Z]+")){
                String[] composite_command = command.split(" +");
                String name = composite_command[1];
                Interactive_App.filter_starts_with_name(labWorks, name);
            }
            else if(command.equals("show")){
                Interactive_App.show(labWorks);
            }
            else if (command.equals("info")){
                Interactive_App.info(labWorks, ini_date);
            }
            else if(command.matches("execute_script +\\w+.txt")){
                String[] composite_command = command.split(" +");
                String scriptname = composite_command[1];
                try {
                    FileReader fileReader = new FileReader(scriptname);
                    fileReader.read();
                    fileReader.close();
                    Interactive_App.execute_script(labWorks, scriptname, ini_date, filename);
                } catch (IOException e) {
                    System.out.println("Файл " + scriptname + " не удаётся открыть");
                }
            }
            else if(command.equals("help")){
                Interactive_App.help();
            }
            else {
                System.out.println("Вы ввели неправильную команду");
            }
        }

    }

}
