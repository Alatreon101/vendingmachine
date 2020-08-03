import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Matcher;

public class UserInteract {

    Logger log = Logger.getLogger(UserInteract.class);
    Scanner sc = new Scanner(System.in);
    VendingMachine vendMachine = new VendingMachine();

    public static void main(String[] args) {
        new UserInteract().userInput();
    }

    public void userInput() {
        log.info("Application started!");
        String input = "";
        System.out.println("Если Вы хотите");

        while (!(input = sc.nextLine().toUpperCase()).equals("Q")) {
            final Matcher matcher = VendingMachine.BUY.matcher(input);
            if (input.equals("M")) {
                vendMachine.getMenu();
            } else if (input.equals("B")) {
                System.out.println(vendMachine.getBalance());
            } else if (input.equals("A")) {
                getMoney();
            } else if (matcher.find()) {
                vendMachine.buyDrink(Integer.parseInt(matcher.group()));
            } else {
                System.out.println("Команда не распознана ");
            }
        }
        log.info("Application finished!");
    }

    private void getMoney() {
        System.out.println("Введите необходимое количество средств!");
        String input;
        do {
            try {
                input = sc.nextLine();
                int input1 = (Integer.parseInt(input));
                vendMachine.addBalance(input1);
                System.out.println("Баланс успешно обновлен!");
                return;
            } catch (NumberFormatException e) {
                log.warn("Warn ", e);
                System.out.println("Введите нормальное значение в числовом формате!");
            }
        } while (true);
    }
}
