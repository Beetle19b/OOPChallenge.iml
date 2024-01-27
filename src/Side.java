import java.util.Scanner;

public class Side extends Order {

    private static Scanner scanner = new Scanner(System.in);

    private boolean isDelux = false;
    private boolean sideType;


    public Side(boolean isDeluex, boolean sideType) {
        super();
        this.isDelux = isDeluex;
        this.sideType = sideType;
    }

    public void isDeluexBurger(){
        System.out.println("Would you like a deluex burger?");


    }
}
