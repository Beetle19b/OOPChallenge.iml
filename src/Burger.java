import java.util.Scanner;

public class Burger extends Order {
    private static final Scanner scanner = new Scanner(System.in);
    private String bunType;
    private String selectedSlides = "";
    private static final int MAX_SIDES = 3;

    public Burger(String bunType, double price) {
        super();
        this.bunType = bunType;
        this.price = price;
    }

    public void isSide() {
        boolean isValidAnswer = false;
        do {
            System.out.println("""
                    Are you having any sides: Please enter
                    'Y' for yes
                    'N' for no""");
            String answer = scanner.nextLine();

            if (answer.toUpperCase().contentEquals("Y")) {
                selectNumberOfSides();
                isValidAnswer = true;
            } else if (answer.toUpperCase().contentEquals("N")) {
                System.out.println("No sides selected.");
                isValidAnswer = true;
            } else {
                System.out.println("Please enter valid answer");
            }
        } while (!isValidAnswer);

    }

    public void selectNumberOfSides() {
        System.out.println("how many sides would you like? (up to " + MAX_SIDES + " are allowed)");
        int noOfSlides;
        try {
            noOfSlides = Integer.parseInt(scanner.nextLine());

            if (noOfSlides >= 1 && noOfSlides <= MAX_SIDES) {
                selectedSlides = "";
                for (int i = 0; i < noOfSlides; i++) {
                    System.out.println("Select side " +(i +1) + ":");
                    selectedSlides += selectSlide() + " ";
                }
                selectedSlides = selectedSlides.trim();
            } else {
                System.out.println("Please select between 1 and " + MAX_SIDES + " sides.");
                selectNumberOfSides();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a number");
            selectNumberOfSides();
        }

    }

    public String selectSlide() {
        boolean isValidAnswer = false;
        String selectedSlide = "";
        System.out.println("""
                Please input the following character for the following sides:
                'C' for carrots for £0.50
                'A' for apples for £0.20
                'O' for onions for £0.10""");
        String input = scanner.nextLine();

        switch (input.toUpperCase().charAt(0)) {

            case 'C' -> {
                selectedSlide = " Carrots ";
                isValidAnswer = true;
                price += 0.50;
            }
            case 'A' -> {
                selectedSlide = " apples ";
                isValidAnswer = true;
                price += 0.20;
            }
            case 'O' -> {
                selectedSlide = " onion ";
                isValidAnswer = true;
                price += 0.10;
            }
            default -> {
                System.out.println("Please enter a valid side input");
                return selectSlide();
            }

        }
        return selectedSlide;
    }
    public void burgerBunType() {
        boolean isValidInput = false;

        do {
            System.out.println("""
                    Select your bun type, Please enter:
                    'P' for plain\s
                    'B' for brioche
                    'S' for seeded""");
            this.bunType = scanner.nextLine();

            switch (bunType.toUpperCase().charAt(0)) {

                case 'P' -> {
                    this.bunType = "Plain";
                    isValidInput = true;
                    System.out.println("You have selected plain bun type.");
                }
                case 'B' -> {
                    this.bunType = "Brioche";
                    isValidInput = true;
                    System.out.println("You have selected brioche bun type.");
                }
                case 'S' -> {
                    this.bunType = "Seeded";
                    isValidInput = true;
                    System.out.println("You have selected seeded bun type.");
                }
                default -> System.out.println("Please enter a valid input");
            }

        } while (!isValidInput);
    }
@Override
    public void selectSize() {
        boolean isValidInput = false;

        do {
            System.out.println("""
                    Select your burger size, Please enter:
                    'S' for small
                    'M' for medium for additional £0.50
                    'L' for large for additional £2.00""");
            this.size = scanner.nextLine();

            switch (size.toUpperCase().charAt(0)) {
                case 'S' -> {
                    System.out.println("small");
                    this.size = "small";
                    isValidInput = true;
                }
                case 'M' -> {
                    this.size = "medium";
                    System.out.println("medium");
                    isValidInput = true;
                    this.price += 1.50;
                }
                case 'L' -> {
                    this.size = "large";
                    System.out.println("large");
                    isValidInput = true;
                    this.price += 2.50;
                }
                default -> System.out.println("Invalid character entered, please try again");
            }
        } while (!isValidInput);
    }

    public String describeBurger() {
        return "Regular";
    }

    public static Burger burgerType() {

        Burger selectedBurger = null;
        boolean isValidInput = false;
        do {
            System.out.println("""
                    Select your burger type, Please enter:
                    'C' for chicken burger
                    'B' for beef burger
                    'E' for bean burger
                    'L' for lamb burger
                    'V' for vegetable Burger""");
            char choice = scanner.nextLine().toUpperCase().charAt(0);
            switch (choice) {

                case 'C' -> {
                    selectedBurger = new ChickenBurger();
                    isValidInput = true;
                }
                case 'B' -> {
                    selectedBurger = new BeefBurger();
                    isValidInput = true;
                }
                case 'E' -> {
                    selectedBurger = new BeanBurger();
                    isValidInput = true;
                }
                case 'L' -> {
                    selectedBurger = new LambBurger();
                    isValidInput = true;
                }
                case 'V' -> {
                    selectedBurger = new VegetableBurger();
                    isValidInput = true;
                }
                default -> System.out.println("Please enter a valid burger type.");

            }
        } while (!isValidInput);
        return selectedBurger;
    }

    public double getPrice() {
        return price;
    }

    public static Burger createCustomBurger() {
        Burger selectedBurger = burgerType();
        if (selectedBurger != null) {
            selectedBurger.burgerBunType();
            selectedBurger.selectSize();
            selectedBurger.isSide();
            selectedBurger.describeBurger();
            String burgerDescription = selectedBurger.describeBurger();
        }
        return selectedBurger;
    }

    public String getBurger(){
        String burgerDetails =  bunType + " bun," + size + " sized " + describeBurger();
        if (!selectedSlides.isEmpty()){
            return burgerDetails + ", with sides: " + selectedSlides.trim() + " Price:" + getPrice();
        }
        burgerDetails += ", price: £" + getPrice();
        return burgerDetails;
    }
}
class ChickenBurger extends Burger {

    public ChickenBurger() {
        super(null, 5.00);
    }

    public String describeBurger() {
        return "succulent Chicken burger";
    }
}

class BeefBurger extends Burger {

    public BeefBurger() {
        super(null, 8.00);
    }

    public String describeBurger() {
        return "succulent beef burger";
    }
}

class BeanBurger extends Burger {

    public BeanBurger() {
        super(null, 4.00);
    }

    public String describeBurger() {
        return "healthy bean burger";
    }
}

class LambBurger extends Burger {

    public LambBurger() {
        super(null, 6.00);
    }

    public String describeBurger() {
        return "juicy lamb burger";
    }
}

class VegetableBurger extends Burger {

    public VegetableBurger() {
        super(null, 4.00);
    }

    public String describeBurger() {
        return "organic vegetable burger";
    }
}

