import java.util.Scanner;

public class Drink extends Order{

    private String drinkType;
    private String temperature;
    private static Scanner scanner = new Scanner(System.in);

    public Drink(String drinkType, double price, String temperature) {
        super();
        this.drinkType = drinkType;
        this.price = price;
        this.temperature = temperature;
    }

    public void setDrinkType(){
        boolean isValidInput = false;

        do {
            System.out.println("""
                    Please select your drink, Please input:
                    'C' for Coca-cola £2.00
                    'F' for Fanta £2.00
                    'O' for orange juice £2.50
                    'W' for bottled water £1.00""");
            this.drinkType = scanner.nextLine();

            switch (drinkType.toUpperCase().charAt(0)){

                case 'C' ->{
                    drinkType = "Coca-cola";
                    price += 2.00;
                    isValidInput = true;
                }
                case 'F' ->{
                    drinkType = "Fanta";
                    price += 2.00;
                    isValidInput = true;
                }
                case 'O' ->{
                    drinkType = "Orange juice";
                    price += 2.50;
                    isValidInput = true;
                }
                case  'W' ->{
                    drinkType = "water";
                    price += 1.00;
                    isValidInput = true;
                }
                default -> {
                    System.out.println("Please enter a valid option");
                }
            }
        }while (!isValidInput);
    }

    public void selectSize() {
        boolean isValidInput = false;

        do {
            System.out.println("""
                    Please select your drink size, Please input:
                    'S' for small
                    'M' for medium for additional £0.50
                    'L' for large for additional £1.00""");
            this.size = scanner.nextLine();

            switch (size.toUpperCase().charAt(0)){

                case 'S' -> {
                    this.size = "Small";
                    isValidInput = true;
                }
                case 'M' -> {
                    this.size = "Medium";
                    isValidInput = true;
                    price += 0.50;
                }
                case 'L' -> {
                    this.size = "Large";
                    isValidInput = true;
                    price += 1.00;
                }
                default -> {
                    System.out.println("Incorrect size entered, please try again");
                }
            }
            }while (!isValidInput);
    }

    public void setTemperature(){
        boolean isValueTrue = false;

        System.out.println("""
                Would you like your drink cold? Please enter
                'C' for cold drink
                'R' for room temperature""");
        this.temperature = scanner.nextLine();
     do {
        switch (temperature.toUpperCase().charAt(0)) {

            case 'C' -> {
                this.temperature = "Cold";
                isValueTrue = true;
            }
            case 'R' -> {
                this.temperature = "Medium";
                isValueTrue = true;
            }
            default -> {
                System.out.println("Please enter a valid input");
            }
        }
        }while (!isValueTrue);
    }

    public static Drink createDrink(){
        Drink newDrink = new Drink(null,0.00,null);
        newDrink.setDrinkType();
        newDrink.setTemperature();
        newDrink.selectSize();
        return newDrink;
    }

    public String getDrink(){
        return drinkType + ", " + size + ", " + temperature + ", Price: £" + getPrice();
    }

    public double getPrice() {
        return price;
    }
}
