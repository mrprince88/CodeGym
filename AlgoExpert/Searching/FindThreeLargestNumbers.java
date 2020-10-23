import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class FindThreeLargestNumbers {

	static List<Integer> threeLargest(int []array) {
		List<Integer> list = Arrays.asList(new Integer[3]);

		for (int i : array)
			updateList(list, i);
		return list;
	}

	static void updateList(List<Integer> list, int num) {
		if (list.get(2) == null || num > list.get(2))
			shiftAndUpdate(list, 2, num);
		else if (list.get(1) == null || num > list.get(1))
			shiftAndUpdate(list, 1, num);
		else if (list.get(0) == null || num > list.get(0))
			shiftAndUpdate(list, 0, num);
	}

	static void shiftAndUpdate(List<Integer> list, int idx, int num) {
		for (int i = 0; i < idx; i++)
			list.set(i, list.get(i + 1));
		list.set(idx, num);
	}

	public static void main(String[] args) {
		int []array = {45, 2, 12, 42, -1, 0, 3};
		System.out.println(threeLargest(array));
	}
}