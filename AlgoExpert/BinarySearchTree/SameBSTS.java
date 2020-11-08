import java.util.*;

class SameBSTS {

	// Approach 1: O(n^2) time | O(n^2) space

	static boolean sameBSTs(List<Integer> tree1, List<Integer> tree2) {

		if (tree1.size() != tree2.size())
			return false;

		if (tree1.size() == 0 && tree2.size() == 0)
			return true;

		if (tree1.get(0) != tree2.get(0))
			return false;

		List<Integer> smaller1 = getSmaller(tree1);
		List<Integer> greater1 = getGreater(tree1);
		List<Integer> smaller2 = getSmaller(tree2);
		List<Integer> greater2 = getGreater(tree2);

		return sameBSTs(smaller1, smaller2) && sameBSTs(greater1, greater2);
	}

	static List<Integer> getSmaller(List<Integer> tree) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < tree.size(); i++)
			if (tree.get(i) < tree.get(0))
				list.add(tree.get(i));

		return list;
	}

	static List<Integer> getGreater(List<Integer> tree) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < tree.size(); i++)
			if (tree.get(i) > tree.get(0))
				list.add(tree.get(i));

		return list;
	}


	// Approach 2: O(n^2) time | O(d) space

	static boolean sameBSTs(List<Integer> tree1, List<Integer> tree2, int idx1, int idx2, int min, int max) {
		if (idx1 == -1 || idx2 == -1)
			return idx1 == idx2;

		if (tree1.get(idx1) != tree2.get(idx2))
			return false;

		int smaller1 = getSmaller(tree1, idx1, min);
		int greater1 = getGreater(tree1, idx1, max);
		int smaller2 = getSmaller(tree2, idx2, min);
		int greater2 = getGreater(tree2, idx2, max);

		return sameBSTs(tree1, tree2, smaller1, smaller2, min, tree1.get(idx1)) &&
		       sameBSTs(tree1, tree2, greater1, greater2, tree1.get(idx1), max);
	}

	static int getSmaller(List<Integer> tree, int idx, int min) {
		for (int i = idx + 1; i < tree.size(); i++)
			if (tree.get(i) < tree.get(idx) && tree.get(i) > min)
				return i;

		return -1;
	}

	static int getGreater(List<Integer> tree, int idx, int max) {
		for (int i = idx + 1; i < tree.size(); i++)
			if (tree.get(i) > tree.get(idx) && tree.get(i) < max)
				return i;

		return -1;
	}

	public static void main(String[] args) {
		List<Integer> tree1 = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11);
		List<Integer> tree2 = Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81);
		System.out.println(sameBSTs(tree1, tree2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
