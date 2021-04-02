import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        while (a >= 10) {
            int m = a, x = 0;
            while (m > 0) {
                x += m % 10;
                m /= 10;
            }
            a = x;
        }
        System.out.println(a);
    }
}
