import java.io.File;
import java.util.Date;

public class LabWork implements Comparable{
    private long id = (long) ((1.1 + Math.random()) * 100000);
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate = new Date();
    private int minimalPoint; //Значение поля должно быть больше 0
    private double maximumPoint; //Значение поля должно быть больше 0
    private Double averagePoint; //Поле не может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле не может быть null
    private Person author; //Поле может быть null

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getMinimalPoint() {
        return minimalPoint;
    }

    public void setMinimalPoint(int minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public double getMaximumPoint() {
        return maximumPoint;
    }

    public void setMaximumPoint(double maximumPoint) {
        this.maximumPoint = maximumPoint;
    }

    public Double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(double averagePoint) {
        this.averagePoint = averagePoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public int compareTo(Object o, boolean flag) {
        LabWork labWork = (LabWork) o;
        if(flag == true){
            return (int) (this.getMaximumPoint() - labWork.getMaximumPoint());
        }
        else {
            return (int) (this.getMinimalPoint() - labWork.getMinimalPoint());
        }

    }


    @Override
    public int compareTo(Object o) {
        LabWork labWork = (LabWork) o;
        return (int) (this.getId() - labWork.getId());
    }
}