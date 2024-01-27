public class Order {

    protected String size;
    protected double price;
    private Burger burger;
    private Drink drink;

    public Order() {
        this.burger = null;
        this.drink = null;
    }
    public static void createAndShowOrder() {
        Order newOrder = new Order();
        newOrder.createOrder();
        newOrder.displayOrder();
        newOrder.getPrice();
    }

    public void createOrder(){

        this.burger = Burger.createCustomBurger();

        this.drink = Drink.createDrink();

    }

    public void displayOrder(){
        System.out.println("Your Order:");
        if (this.burger != null){
            System.out.println("Burger: " + burger.getBurger());
        }
        if (this.drink != null){
            System.out.println("Drink: " + drink.getDrink());
        }
        System.out.println("Total Price: £" + getPrice());
    }


    public double getPrice() {
        double total = 0;
        if (this.burger != null) {
            total += this.burger.getPrice();
        }
        if (this.drink != null) {
            total += this.drink.getPrice();
        }
        return total;
    }

    public void selectSize() {

    }
}
