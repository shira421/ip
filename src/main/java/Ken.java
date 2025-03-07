import java.util.Scanner;

public class Ken {
    public static void main(String[] args) {
        String logo = "  _  ________ _   _\n"
                + " | |/ /  ____| \\ | |\n"
                + " | ' /| |__  |  \\| |\n"
                + " |  < |  __| | . ` |\n"
                + " | . \\| |____| |\\  |\n"
                + " |_|\\_\\______|_| \\_|\n";

        String welcomeMsg = ("Hello I'm," + System.lineSeparator()
                + logo + System.lineSeparator()
                + "What can I do for you?\n");
        String exitMsg = ("Bye. Hope to see you again soon!\n");
        System.out.println(Constants.LINE + System.lineSeparator() + welcomeMsg + Constants.LINE);

        String input;
        Scanner in = new Scanner(System.in);
        TaskList taskList = new TaskList();

        while (true) {
            input = in.nextLine();
            switch (input.toLowerCase()) {
            case "bye":
                System.out.println(Constants.LINE
                        + System.lineSeparator() + exitMsg
                        + Constants.LINE);
                return;
            case "list":
                taskList.listTasks();
                break;
            default:
                taskList.addTask(input);
                break;
            }
        }
    }
}
