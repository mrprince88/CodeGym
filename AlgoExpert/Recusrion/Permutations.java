import java.util.*;

class Permutations {

	// O(n*n!) time | O(1) space
	static void permutations(List<Integer> array, int i) {
		if (i == array.size() - 1)
			System.out.println(array);
		else {
			for (int j = 0; j < array.size(); j++) {
				swap(array, i, j);
				permutations(array, i + 1);
				swap(array, i, j);
			}
		}
	}

	static void swap(List<Integer> array, int i, int j) {
		int t = array.get(i);
		array.set(i, array.get(j));
		array.set(j, t);
	}

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(1, 2, 3);
		permutations(array, 0);
	}
}