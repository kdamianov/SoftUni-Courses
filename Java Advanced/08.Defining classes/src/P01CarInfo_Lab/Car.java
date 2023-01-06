package P01CarInfo_Lab;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    //Constructor
    public Car(String brand, String model, int horsePower) { //ако не напишем никакъв код, това е дефолтен конструктор!!!
        //Construstor chaining може да се пише САМО на 1а стъпка от кода, чрез this(parameters);
        //Винаги се прави от конструкор с по-малко параметри от този, към който го свързваме!!!
        this.brand = brand;
        this.model = this.model;
        this.horsePower = this.horsePower;
    }

    //поставяме setters, тк х-ките на обекта са private!!
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getHorsePower() {
        return horsePower;
    }

    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
        //ако нямаме локални променливи със същите имена, няма нужда от this.
    }
}
