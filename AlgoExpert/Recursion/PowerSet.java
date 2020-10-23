import java.util.*;

class PowerSet {

	//O(n*2^n) time | O(n*2^n) space
	static List<List<Integer>> getPowerSet(List<Integer> set) {

		List<List<Integer>> subset = new ArrayList<>();
		subset.add(new ArrayList<>());

		for (int i : set) {
			int n = subset.size();
			for (int j = 0; j < n; j++) {
				List<Integer> currSet = new ArrayList<>(subset.get(j));
				currSet.add(i);
				subset.add(currSet);
			}
		}

		return subset;
	}

	//O(n*2^n) time | O(n*2^n) space
	static List<List<Integer>> getPowerSetRecursive(List<Integer> set, int idx) {

		if (idx < 0) {
			List<List<Integer>> subset = new ArrayList<>();
			subset.add(new ArrayList<>());
			return subset;
		}

		int ele = set.get(idx);

		List<List<Integer>> subset = (getPowerSetRecursive(set, idx - 1));
		int n = subset.size();

		for (int i = 0; i < n; i++) {

			List<Integer> currSet = new ArrayList<>(subset.get(i));
			currSet.add(ele);

			subset.add(currSet);
		}

		return subset;
	}

	public static void main(String[] args) {
		List<Integer> set = Arrays.asList(1, 2, 3, 4);
		System.out.println(getPowerSetRecursive(set, 3));
	}
}