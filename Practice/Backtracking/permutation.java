import java.util.Scanner;
public class permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char []s = sc.nextLine().toCharArray();
		int n = s.length;
		permutate(s, 0, n);
	}

	static void permutate(char []s, int start, int n) {
		if (start == n - 1) {
			System.out.println(String.valueOf(s));
			return;
		}
		for (int i = start; i < n; i++) {
			swap(s, start, i);
			permutate(s, start + 1, n);
			swap(s, start, i);
		}
	}

	static void swap(char []a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}