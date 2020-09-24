import java.util.Hashtable;
import java.util.ArrayList;

class FourNumberSum {

	static void solve(int []a, int n, int targetSum) {
		Hashtable<Integer, ArrayList<int[]>> h = new Hashtable<>();
		for (int i = 1; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int currentSum = a[i] + a[j];
				int currentDiff = targetSum - currentSum;
				if (h.containsKey(currentDiff)) {
					ArrayList<int[]>list = h.get(currentDiff);
					for (int[]k : list) {
						System.out.println(k[0] + " " + k[1] + " " + a[i] + " " + a[j]);
					}
				}
			}
			for (int k = 0; k < i; k++) {
				int currentSum = a[i] + a[k];
				if (h.containsKey(currentSum)) {
					int []pair = {a[k], a[i]};
					h.get(currentSum).add(pair);
				} else {
					int []pair = {a[k], a[i]};
					ArrayList<int[]> list = new ArrayList<>();
					list.add(pair);
					h.put(currentSum, list);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 8, k = 10;
		int []a = {1, 2, 3, 4, 9, 7, 5, 10};
		solve(a, n, k);
	}
}