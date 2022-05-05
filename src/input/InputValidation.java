package input;

import java.util.Scanner;

class InputValidation {
    final private Scanner console = new Scanner(System.in);

    int validationIntValue() {
        int number;
        while (true) {
            if (console.hasNextInt()) {
                number = console.nextInt();
                if (number >= 0) {
                    break;
                } else {
                    System.out.println("The number must be greater than zero");
                }
            } else {
                System.out.println("Enter an integer please!");
                System.out.print("Enter an integer: ");
            }
            console.nextLine();
        }
        console.nextLine();
        return number;
    }

    String askString() {
       return console.nextLine();
    }
}
