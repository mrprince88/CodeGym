import java.util.Arrays;

class SmallestDifference {
	public static void main(String[] args) {
		int n = 5;
		int m = 5;
		int []arr1 = {2, 4, 1, 3, 5};
		int []arr2 = {6, 7, 8, 9, 11};
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i = 0, j = 0, sm = Integer.MAX_VALUE, c = 0;
		while (i < n && j < m) {
			if (arr1[i] == arr2[j]) {
				++c;
				System.out.println("0");
				break;
			} else if (arr1[i] < arr2[j]) {
				sm = Math.min(sm, arr2[j] - arr2[i]);
				i++;
			} else if (arr1[i] > arr2[j]) {
				sm = Math.min(sm, arr2[j] - arr2[i]);
				j++;
			}
		}
		if (c == 0)
			System.out.println(sm);
	}
}