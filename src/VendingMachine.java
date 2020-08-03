import java.util.regex.Pattern;

public class VendingMachine {
    public static final Pattern BUY = Pattern.compile("(\\d+)");
    private double balance = 0.0d;

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void getMenu() {
        for (Drink drink : Drink.values()) {
            System.out.println(drink);
        }
    }

    public void buyDrink(int number) {
        Drink drink = getDrink(number);

        if (drink == null) {
            System.out.println("Данный напиток не найден ");
            return;
        }

        if (drink.getCost() > balance) {
            System.out.println("недостаточно денег ");
            return;
        }

        balance -= drink.getCost();
        System.out.println("поздравляем с покупкой: " + drink.getDescription());
    }


    private Drink getDrink(int number) {
        for (Drink drink : Drink.values()) {
            if (drink.getNumber() == number) {
                return drink;
            }
        }
        return null;
    }
}
