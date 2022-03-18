import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;;
import java.util.*;

public class Interactive_App {

    public static void Add_Foundation(LabWork lab){
        boolean isCorrect = false;

            while (!isCorrect){
                System.out.println("Введите имя проекта: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String s = null;
                String name = null;

                try {
                    s = reader.readLine();
                    if (s.matches("\\w+")){
                        name = s;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (name == null) {
                    System.out.println("Вы ввели некоректные данные, повторите попытку");
                }
                else{
                    lab.setName(name);
                    isCorrect = true;
                }
            }
            isCorrect = false;



        //Coordinates
        Coordinates coordinates = new Coordinates();
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
                    coordinates.setX(x);
                    isCorrect = true;
                }
            }
            isCorrect = false;




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
                coordinates.setY(y);
                lab.setCoordinates(coordinates);
                isCorrect = true;
            }
        }
        isCorrect = false;

        //Minimal point

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

        // Maximum point

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


        // Average point

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



        // Difficulty

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

        // Author

        Person person = new Person();

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
                person.setName(name);
                isCorrect = true;
            }
        }
        isCorrect = false;


        while (!isCorrect){
            System.out.println("Введите дату в формате dd.MM.yyyy: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            Date date = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            try {
                s = reader.readLine();
                if (s.matches("[0-3]?[0-9]{1}\\.[0-1]?[0-2]\\.[1-9]{1}[0-9]{3}")){
                    date = dateFormat.parse(s);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            if (date == null) {
                System.out.println("Вы ввели некоректные данные, повторите попытку");
            }
            else{
                person.setBirthday(date);
                isCorrect = true;
            }
        }
        isCorrect = false;

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
                person.setHeight(height);
                isCorrect = true;
            }
        }
        isCorrect = false;

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
                person.setWeight(weight);
                isCorrect = true;
            }
        }
        isCorrect = false;

        // Location

        Location location = new Location();

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
                location.setX(x);
                isCorrect = true;
            }
        }
        isCorrect = false;

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
                location.setY(y);
                isCorrect = true;
            }
        }
        isCorrect = false;

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
                location.setZ(z);
                person.setLocation(location);
                lab.setAuthor(person);
                isCorrect = true;
            }
        }
    }

    public static boolean Add_Foundation_non_interact(LabWork lab, String name, String x_cor, String y_cor, String min_s, String max_s, String average_s, String diff_s, String per_name_s, String date_s, String height_s, String weight_s, String x_loc, String y_loc, String z_loc){

        if (!name.matches("\\w+")){
            System.out.println("Некорректный праметр 'название проекта' ");
            return false;
        }
        else{
            lab.setName(name);
        }





        //Coordinates
        Coordinates coordinates = new Coordinates();
        Double x_coordinate = null;
        if (x_cor.matches("-?[0-9]+\\.?[0-9]*")) {
            x_coordinate = Double.valueOf(x_cor);
            if (x_coordinate == null || x_coordinate <= -28) {
                System.out.println("Некорректный праметр 'координата х' ");
                return false;
            }
            else{
                coordinates.setX(x_coordinate);
            }
        }
        else {
            System.out.println("Некорректный праметр 'координата х' ");
            return false;
        }



        float y = -886;
        if (y_cor.matches("[0-9]+\\.?[0-9]*")) {
            y = Float.valueOf(y_cor);
            if (y <= -886) {
                System.out.println("Некорректный праметр 'координата y' ");
                return false;
            }
            else{
                coordinates.setY(y);
                lab.setCoordinates(coordinates);
            }
        }
        else {
            System.out.println("Некорректный праметр 'координата y' ");
            return false;
        }







        //Minimal point

        int min = 0;
        if (min_s.matches("[0-9]+\\.?[0-9]*")) {
            min = Integer.valueOf(min_s);
            if (min <= 0) {
                System.out.println("Некорректный праметр 'минимальная оценка' ");
                return false;
            }
            else {
                lab.setMinimalPoint(min);
            }
        }
        else {
            System.out.println("Некорректный праметр 'минимальная оценка' ");
            return false;
        }




        double max = 0;
        if (max_s.matches("[0-9]+\\.?[0-9]*")) {
            max = Double.valueOf(max_s);
            if (max <= 0) {
                System.out.println("Некорректный праметр 'максимальная оценка' ");
                return false;
            } else {
                lab.setMaximumPoint(max);
            }
        }
        else{
            System.out.println("Некорректный праметр 'максимальная оценка' ");
            return false;
        }


        // Average point
        Double average = null;
        if (average_s.matches("[0-9]+\\.?[0-9]*")) {
            average = Double.valueOf(average_s);
            if (average == null || average <= 0 ) {
                System.out.println("Некорректный праметр 'средняя оценка' ");
                return false;
            }
            else{
                lab.setAveragePoint(average);
            }
        }
        else {
            System.out.println("Некорректный праметр 'средняя оценка' ");
            return false;
        }


        // Difficulty


        String diff = null;
        if (diff_s.matches("[A-Z,a-z]+_?[A-Z,a-z]*")){
            diff = diff_s;
            if (diff == null){
                System.out.println("Некорректный праметр 'сложность' ");
                return false;
            }
            else if (diff.toUpperCase().equals("HOPELESS")) {
                lab.setDifficulty(Difficulty.HOPELESS);

            }
            else if(diff.toUpperCase().equals("EASY")){
                lab.setDifficulty(Difficulty.EASY);

            }
            else if(diff.toUpperCase().equals("VERY_HARD")){
                lab.setDifficulty(Difficulty.VERY_HARD);
            }
        }
        else {
            System.out.println("Некорректный праметр 'сложность' ");
            return false;
        }

        // Author

        Person person = new Person();

        String per_name = null;

        if (per_name_s.matches("[A-Z,a-z]+")){
            per_name = per_name_s;
            if (name == null) {
                System.out.println("Некорректный праметр 'имя автора' ");
                return false;
            }
            else{
                person.setName(per_name);
            }
        }
        else {
            System.out.println("Некорректный праметр 'имя автора' ");
            return false;
        }


        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        if (date_s.matches("[0-3]?[0-9]{1}\\.[0-1]?[0-2]\\.[1-9]{1}[0-9]{3}")){
            try {
                date = dateFormat.parse(date_s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date == null) {
                System.out.println("Некорректный праметр 'дата' ");
                return false;
            }
            else{
                person.setBirthday(date);
            }
        }
        else {
            System.out.println("Некорректный праметр 'дата' ");
            return false;
        }


        float height = 0;

        if (height_s.matches("[0-9]+\\.?[0-9]*")) {
            height = Float.valueOf(height_s);
            if (height <= 0) {
                System.out.println("Некорректный праметр 'высота' ");
                return false;
            } else {
                person.setHeight(height);
            }
        }
        else {
            System.out.println("Некорректный праметр 'высота' ");
            return false;
        }



        Long weight = null;

        if (weight_s.matches("[0-9]+\\.?[0-9]*")) {
            weight = Long.valueOf(weight_s);
            if (weight == null || weight <= 0 ) {
                System.out.println("Некорректный праметр 'вес'");
                return false;
            }
            else{
                person.setWeight(weight);
            }
        }
        else {
            System.out.println("Некорректный праметр 'вес'");
            return false;
        }


        // Location

        Location location = new Location();

        Double x_location = null;
        if (x_loc.matches("[0-9]+\\.?[0-9]*")) {
            x_location = Double.valueOf(x_loc);
            if (x_location == null) {
                System.out.println("Некорректный праметр 'координата локации х' ");
                return false;
            }
            else{
                location.setX(x_location);
            }
        }
        else {
            System.out.println("Некорректный праметр 'координата локации х' ");
            return false;
        }




        long y_location = 0;

        if (y_loc.matches("[0-9]+\\.?[0-9]*")) {
            y_location = Long.valueOf(y_loc);
            if (y == 0) {
                System.out.println("Некорректный праметр 'координата локации y' ");
                return false;
            }
            else{
                location.setY(y_location);
            }
        }
        else {
            System.out.println("Некорректный праметр 'координата локации y' ");
            return false;
        }


        Integer z_location = null;

        if (z_loc.matches("[0-9]+\\.?[0-9]*")) {
            z_location = Integer.valueOf(z_loc);
            if (z_location == null) {
                System.out.println("Некорректный праметр 'координата локации z' ");
                return false;
            }
            else{
                location.setZ(z_location);
                person.setLocation(location);
                lab.setAuthor(person);
            }
        }
        else {
            System.out.println("Некорректный праметр 'координата локации z' ");
            return false;
        }

        return true;
    }

    public static void remove_by_id_non_interact(HashSet<LabWork> hashSet, long id){
        for (LabWork lab : hashSet) {
            if (lab.getId() == id) {
                hashSet.remove(lab);
                break;
            }
        }
    }

    static void add( HashSet<LabWork> hashSet){
        boolean isCorrect = false;
        LabWork lab = new LabWork();

        Add_Foundation(lab);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String content = gson.toJson(lab);

        hashSet.add(lab);
        System.out.println("Элемент успешно добавлен: ");
        System.out.println(content);
    }

    static void update_id(HashSet<LabWork> hashSet, long id){
        boolean flag = false;
        for(LabWork lab : hashSet){
            if (lab.getId() == id){
                hashSet.remove(lab);
                lab.setId(id);

                Add_Foundation(lab);

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String content = gson.toJson(lab);

                hashSet.add(lab);
                flag = true;

                System.out.println("Элемент успешно обновлён: ");
                System.out.println(content);
                break;
            }

        }
        if (flag == false){
            System.out.println("Элемента с данным id не существует");
        }
    }

    static void remove_by_id(HashSet<LabWork> hashSet, long id){
        boolean flag = false;
        for (LabWork lab : hashSet) {
            if (lab.getId() == id) {
                hashSet.remove(lab);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String content = gson.toJson(lab);

                flag = true;

                System.out.println("Элемент успешно удалён: ");
                System.out.println(content);
                break;
            }
        }
        if (flag == false) {
            System.out.println("Элемента с данным id не существует");
        }
    }

    static void clear(HashSet<LabWork> hashSet){
        hashSet.clear();
    }

    static void help(){
        System.out.println("Доступные команды: \n add \n update 'id' \n remove_by_id 'id' \n  clear \n save \n add_if_max \n" +
                " add_if_min \n remove_lower \n  min_by_creation_date \n filter_starts_with_name \n print_field_descending_average_point " +
                " show \n info \n execute_script");
    }

    static void save(HashSet<LabWork> hashSet, String filename){
        JsonWriter.toDataFile(hashSet, filename);
    }

    static void add_if_max(HashSet<LabWork> hashSet){
        LabWork labWork = new LabWork();
        Add_Foundation(labWork);
        double max = labWork.getMaximumPoint();

        for(LabWork lab : hashSet){
            if(lab.compareTo(labWork, true) > 0){
                max = lab.getMaximumPoint();
            }
        }
        if(labWork.getMaximumPoint() >= max){
            hashSet.add(labWork);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String content = gson.toJson(labWork);
            System.out.println("Элемент успешно добавлен: ");
            System.out.println(content);
        }
        else {
            System.out.println("Элемент не является максимальным");
        }
    }

    static void add_if_min(HashSet<LabWork> hashSet){
        LabWork labWork = new LabWork();
        Add_Foundation(labWork);
        double min = labWork.getMinimalPoint();

        for(LabWork lab : hashSet){
            if(lab.compareTo(labWork, false) < 0){
                min = lab.getMinimalPoint();
            }
        }
        if(labWork.getMinimalPoint() <= min){
            hashSet.add(labWork);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String content = gson.toJson(labWork);
            System.out.println("Элемент успешно добавлен: ");
            System.out.println(content);
        }
        else {
            System.out.println("Элемент не является минимальным");
        }
    }

    static void remove_lower(HashSet<LabWork> hashSet){
        LabWork labWork = new LabWork();
        Add_Foundation(labWork);
        long max = labWork.getAuthor().getWeight();
        int counter1 = 0;
        int counter2 = 0;
        boolean isLower = false;
        boolean isDeleted = false;
        while (!isDeleted){
            for (LabWork lab : hashSet) {
                if (lab.getAuthor().getWeight() - max < 0) {
                    remove_by_id(hashSet, lab.getId());
                    isLower = true;
                    counter1++;
                    break;
                }
            }
            if (counter1 != counter2) {
                counter2 = counter1;
            }
            else {
                isDeleted = true;
            }
        }

        if (!isLower){
            System.out.println("Элементов меньше заданного не существует: ");
        }
    }

    static void min_by_creation_date(HashSet<LabWork> hashSet){
        long min = 0;
        long max = 0;
        for (LabWork lab : hashSet){
            if (max < lab.getCreationDate().getTime()){
                max = lab.getCreationDate().getTime();
            }
        }
        min = max;

        for (LabWork lab : hashSet){
            if (min > lab.getCreationDate().getTime()){
                min = lab.getCreationDate().getTime();
            }
        }

        for (LabWork lab : hashSet){
            if (lab.getCreationDate().getTime() == min){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String content = gson.toJson(lab);
                System.out.println("Элемент с минимальной датой : ");
                System.out.println(content);
                break;
            }
        }
    }

    static void filter_starts_with_name(HashSet<LabWork> hashSet, String name){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String content = null;
        boolean flag = true;
        for (LabWork lab : hashSet){
            if(lab.getAuthor().getName().toLowerCase().matches(name.toLowerCase() + ".*")){
                if (flag){
                    System.out.println("Элементы с совпадениями : ");
                    flag = false;
                }
                content = gson.toJson(lab);
                System.out.println(content);
            }
        }
        if (flag){
            System.out.println("Совпадений не найдено");
        }
    }

    static void print_field_descending_average_point(HashSet<LabWork> hashSet){
        List<Double> array = new ArrayList();
        for (LabWork lab : hashSet){
            array.add(lab.getAveragePoint());
        }
        Collections.sort(array);
        Collections.reverse(array);
        System.out.println("Средние значения отсортированы по убыванию : ");
        for (Double average : array){
            System.out.println("Average : " + average);
        }
    }

    static void show(HashSet<LabWork> hashSet){
        TreeSet treeSet = sort_collection(hashSet);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String content = gson.toJson(treeSet);
        System.out.println(content);
    }

    static void info(HashSet<LabWork> hashSet, Date ini_Date){
        System.out.println("Тип коллекции : " + hashSet.getClass());
        System.out.println("Дата инициализации : " + ini_Date);
        System.out.println("Количество элементов : " + hashSet.size());
    }

    static void execute_script(HashSet<LabWork> labWorks, String scriptname, Date ini_date, String filename){
        File file = new File(scriptname);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fr);
        ArrayList<String> arr = new ArrayList();
        String script_com = null;
        try {
            script_com = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (script_com != null){

            if (script_com.length() != 0 ){
                arr.add(script_com);
            }
            try {
                script_com = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(String command : arr){
            boolean isCorrect = true;
            try {
                String[] cl = command.split(" ");
                if (cl[0].equals("add")){
                    if (cl.length != 15){
                        System.out.println("Некорректное кол-во аргументов функции 'add'");
                        return;
                    }
                    LabWork lab = new LabWork();
                    isCorrect = Interactive_App.Add_Foundation_non_interact(lab, cl[1], cl[2], cl[3], cl[4], cl[5], cl[6], cl[7], cl[8],cl[9],cl[10],cl[11],cl[12],cl[13], cl[14]);
                    if (!isCorrect){
                        System.out.println("Аргументы введены некорректно");
                        return;
                    }
                    labWorks.add(lab);
                }
                else if(cl[0].equals("show")){
                    Interactive_App.show(labWorks);
                }
                else if(cl[0].equals("update")){
                    if (cl.length != 16){
                        System.out.println("Некорректное кол-во аргументов функции 'update'");
                        return;
                    }
                    if (cl[1].matches("[1-9]{1}[0-9]{5}")){
                        long id = Long.valueOf(cl[1]);
                        for(LabWork lab : labWorks){
                            if (lab.getId() == id){
                                labWorks.remove(lab);
                                lab.setId(id);
                                isCorrect = Interactive_App.Add_Foundation_non_interact(lab, cl[2], cl[3], cl[4], cl[5], cl[6], cl[7], cl[8], cl[9],cl[10],cl[11],cl[12],cl[13],cl[14], cl[15]);
                                if (!isCorrect){
                                    System.out.println("Аргументы введены некорректно");
                                    return;
                                }
                                labWorks.add(lab);
                            }

                        }
                    }
                }
                else if (cl[0].equals("exit")){
                    if (cl.length == 1){
                        break;
                    }
                    else {
                        System.out.println("Некорректное кол-во аргументов функции 'exit'");
                        return;
                    }
                }
                else if (cl[0].equals("add_if_max")){
                    if (cl.length != 15){
                        System.out.println("Некорректное кол-во аргументов функции 'add_if_max'");
                        return;
                    }
                    LabWork labWork = new LabWork();
                    isCorrect = Interactive_App.Add_Foundation_non_interact(labWork, cl[1], cl[2], cl[3], cl[4], cl[5], cl[6], cl[7], cl[8],cl[9],cl[10],cl[11],cl[12],cl[13], cl[14]);
                    if(!isCorrect){
                        System.out.println("Аргументы введены некорректно");
                        return;
                    }
                    double max = labWork.getMaximumPoint();

                    for(LabWork lab : labWorks){
                        if(lab.compareTo(labWork, true) > 0){
                            max = lab.getMaximumPoint();
                        }
                    }
                    if(labWork.getMaximumPoint() >= max){
                        labWorks.add(labWork);
                    }
                }
                else if (cl[0].equals("add_if_min")){
                    if (cl.length != 15){
                        System.out.println("Некорректное кол-во аргументов функции 'add_if_min'");
                        return;
                    }
                    LabWork labWork = new LabWork();
                    isCorrect = Interactive_App.Add_Foundation_non_interact(labWork, cl[1], cl[2], cl[3], cl[4], cl[5], cl[6], cl[7], cl[8],cl[9],cl[10],cl[11],cl[12],cl[13], cl[14]);
                    if(!isCorrect){
                        System.out.println("Аргументы введены некорректно");
                        return;
                    }
                    double min = labWork.getMinimalPoint();

                    for(LabWork lab : labWorks){
                        if(lab.compareTo(labWork, false) < 0){
                            min = lab.getMinimalPoint();
                        }
                    }
                    if(labWork.getMinimalPoint() <= min){
                        labWorks.add(labWork);
                    }
                }

                else if (cl[0].equals("remove_lower")){
                    if (cl.length != 15){
                        System.out.println("Некорректное кол-во аргументов функции 'remove_lower'");
                        return;
                    }
                    LabWork labWork = new LabWork();
                    isCorrect = Interactive_App.Add_Foundation_non_interact(labWork, cl[1], cl[2], cl[3], cl[4], cl[5], cl[6], cl[7], cl[8],cl[9],cl[10],cl[11],cl[12],cl[13], cl[14]);
                    if (!isCorrect){
                        System.out.println("Аргументы введены некорректно");
                        return;
                    }
                    long max = labWork.getAuthor().getWeight();
                    int counter1 = 0;
                    int counter2 = 0;
                    boolean isDeleted = false;
                    while (!isDeleted){
                        for (LabWork lab : labWorks) {
                            if (lab.getAuthor().getWeight() - max < 0) {
                                remove_by_id_non_interact(labWorks, lab.getId());
                                counter1++;
                                break;
                            }
                        }
                        if (counter1 != counter2) {
                            counter2 = counter1;
                        }
                        else {
                            isDeleted = true;
                        }
                    }

                }

                else if(cl[0].equals("remove_by_id")){
                    if (cl.length != 2){
                        System.out.println("Некорректное кол-во аргументов функции 'remove_by_id'");
                        return;
                    }
                    if(cl[1].matches("[1-9]{1}[0-9]{5}")){
                        long id = Long.valueOf(cl[1]);
                        Interactive_App.remove_by_id_non_interact(labWorks, id);
                    }
                }
                else if (cl[0].equals("save")){
                    if (cl.length != 1){
                        System.out.println("Некорректное кол-во аргументов функции 'save'");
                        return;
                    }
                    Interactive_App.save(labWorks, filename);
                }
                else if (cl[0].equals("clear")){
                    if (cl.length != 1){
                        System.out.println("Некорректное кол-во аргументов функции 'clear'");
                        return;
                    }
                    Interactive_App.clear(labWorks);
                }
                else if (cl[0].equals("min_by_creation_date")){
                    if (cl.length != 1){
                        System.out.println("Некорректное кол-во аргументов функции 'min_by_creation_date'");
                        return;
                    }
                    Interactive_App.min_by_creation_date(labWorks);
                }
                else if (cl[0].equals("print_field_descending_average_point")){
                    if (cl.length != 1){
                        System.out.println("Некорректное кол-во аргументов функции 'print_field_descending_average_point'");
                        return;
                    }
                    Interactive_App.print_field_descending_average_point(labWorks);
                }
                else if(cl[0].equals("filter_starts_with_name")){
                    if (cl.length != 1){
                        System.out.println("Некорректное кол-во аргументов функции 'filter_starts_with_name'");
                        return;
                    }
                    String name = cl[1];
                    Interactive_App.filter_starts_with_name(labWorks, name);
                }

                else if (cl[0].equals("info")){
                    if (cl.length != 1){
                        System.out.println("Некорректное кол-во аргументов функции 'info'");
                        return;
                    }
                    Interactive_App.info(labWorks, ini_date);
                }
                else if (cl[0].equals("execute_script")){
                    if (cl.length != 2){
                        System.out.println("Некорректное кол-во аргументов функции 'execute_script'");
                        return;
                    }
                    scriptname = cl[1];
                    Interactive_App.execute_script(labWorks, scriptname, ini_date, filename);
                }

            } catch (Exception e) {
                System.out.println("Файл скрипта некорректный");
            }

        }
        System.out.println("Скрипт выполнен");

    }

    static TreeSet sort_collection(HashSet<LabWork> hashSet){
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(hashSet);
        return myTreeSet;
    }

}



