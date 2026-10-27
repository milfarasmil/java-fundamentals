public class Part1B_Conditions {
    public static void main(String[] args) {
        int marks = 78;

        if (marks >= 75) System.out.println("A");
        else if (marks >= 60) System.out.println("B");
        else if (marks >= 40) System.out.println("C");
        else System.out.println("Fail");

        int age = 20;
        boolean hasId = true;
        if (age >= 18) {
            if (hasId) System.out.println("Entry allowed");
            else System.out.println("Bring your ID");
        } else {
            System.out.println("Too young");
        }

        String result = (marks >= 40) ? "Pass" : "Fail";

        int day = 3;
        switch (day) {
            case 1: System.out.println("Mon"); break;
            case 2: System.out.println("Tue"); break;
            case 3: System.out.println("Wed"); break;
            default: System.out.println("Other");
        }

        String type = switch (day) {
            case 6, 7 -> "Weekend";
            case 1, 2, 3, 4, 5 -> "Weekday";
            default -> "Invalid";
        };
        System.out.println(result + " " + type);

        String cmd = "stop";
        switch (cmd) {
            case "start" -> System.out.println("Starting");
            case "stop" -> System.out.println("Stopping");
            default -> System.out.println("Unknown");
        }
    }
}
