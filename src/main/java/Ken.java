import java.util.Scanner;

public class Ken {
    private static final String LINE = ("____________________________________________________________");
    private static final String TWO_SPACE = "  ";
    private static final String ONE_SPACE = " ";
    public static void main(String[] args) {
        String logo = "  _  ________ _   _\n"
                + " | |/ /  ____| \\ | |\n"
                + " | ' /| |__  |  \\| |\n"
                + " |  < |  __| | . ` |\n"
                + " | . \\| |____| |\\  |\n"
                + " |_|\\_\\______|_| \\_|\n";

        String welcomeMsg = (ONE_SPACE + "Hello I'm," + System.lineSeparator()
                + logo + System.lineSeparator()
                + ONE_SPACE + "What can I do for you?\n");
        String exitMsg = (ONE_SPACE + "Bye. Hope to see you again soon!\n");
        System.out.println(LINE + System.lineSeparator() + welcomeMsg + LINE);
        String input;
        Scanner in = new Scanner(System.in);
        input = "";
        while (true) {
            input = in.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println(exitMsg + LINE);
                break;
            }
        }
    }
}
