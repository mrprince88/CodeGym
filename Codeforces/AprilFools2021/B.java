import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
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
