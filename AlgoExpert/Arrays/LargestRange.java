import java.util.Hashtable;

class LargestRange {

	static void solve(int []a, int n) {
		Hashtable<Integer, Boolean> h = new Hashtable<>();
		for (int i : a)
			h.put(i, true);
		int longestLength = Integer.MIN_VALUE, pos1 = 0, pos2 = 0;
		for (int i : a) {
			if (!h.get(i))
				continue;

			int leftIndex = i - 1, currLength = 1, rightIndex = i + 1;
			while (h.containsKey(leftIndex)) {
				currLength++;
				leftIndex--;
			}
			while (h.containsKey(rightIndex)) {
				currLength++;
				rightIndex++;
			}
			if (currLength > longestLength) {
				longestLength = currLength;
				pos1 = leftIndex + 1;
				pos2 = rightIndex - 1;
			}
		}
		System.out.println(pos1 + " " + pos2);
	}

	public static void main(String[] args) {
		int n = 9;
		int []a = {2, 3, 4, 1, 5, 7, 8, 9, 11};
		solve(a, n);
	}
}