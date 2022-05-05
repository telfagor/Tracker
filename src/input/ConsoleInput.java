package input;

public class ConsoleInput implements Input {
    private final InputValidation input = new InputValidation();

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return input.askString();
    }

    @Override
    public int askInt(String question) {
        System.out.print(question);
        return input.validationIntValue();
    }
}
