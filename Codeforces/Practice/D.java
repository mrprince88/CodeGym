import java.util.*;
public class D {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			int i, so = 0;
			ArrayList one = new ArrayList();
			ArrayList two = new ArrayList();
			for (i = 0; i < n; i++) {
				if (b[i] == 1) {
					one.add(a[i]);
					so = so + a[i];
				} else
					two.add(a[i]);
			}
			Collections.sort(one);
			Collections.sort(two);
			System.out.println(one);
			// i = one.size() - 1;
			// int l2 = two.size();
			// int j = 0, c = 0, s = i + 1;
			// while (i >= 0 || j < l2) {
			// 	if ((int)one.get(i) > m) {
			// 		so = so - (int)one.get(i);
			// 		--s;
			// 		--i;
			// 	}
			// 	if ((int)one.get(i) == m) {
			// 		++c;
			// 		System.out.println(s);
			// 		break;
			// 	}
			// 	if ((int)one.get(i) < m || i < 0) {
			// 		so = so + (int)two.get(j);
			// 		s = s + 2;
			// 		if (so == m) {
			// 			System.out.println(s);
			// 			++c;
			// 			break;
			// 		}
			// 		if (so > m) {
			// 			break;
			// 		}
			// 		++j;
			// 	}
			// 	if (c == 0)
			// 		System.out.println(-1);
			--t;
		}
	}
}