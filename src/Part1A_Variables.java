import java.util.Scanner;

public class Part1A_Variables {
    public static void main(String[] args) {
        int age = 20;
        long big = 10000000000L;
        double price = 99.5;
        char grade = 'A';
        boolean active = true;
        String name = "Milfar";
        final double PI = 3.14;

        int x = (int) 9.7;
        double y = 5;

        int a = 10, b = 3;
        System.out.println(a + b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println((double) a / b);
        a++;
        a += 5;

        System.out.println(a > b && b > 0);
        System.out.println(a < b || b > 0);
        System.out.println(!(a > b));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String nm = sc.nextLine();
        System.out.println(nm + " is " + num);
        sc.close();
    }
}
