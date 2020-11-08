class SingleCycleCheck {

	// O(n) time | O(1) space

	static boolean checkSingleCycle(int []array) {

		int currentIdx = 0, visited = 0;

		while (visited < array.length) {

			if (visited > 0 && currentIdx == 0)
				return false;

			visited++;
			currentIdx = nextEntry(array, currentIdx);
		}

		return currentIdx == 0;
	}

	static int nextEntry(int []array, int currentIdx) {
		int jump = array[currentIdx];
		int nextIdx = (currentIdx + jump) % array.length;
		return (nextIdx >= 0) ? nextIdx : nextIdx + array.length; //as -ve integers may be present
	}

	public static void main(String[] args) {
		int []array = {2, 3, 1, -4, -4, 2};
		System.out.println(checkSingleCycle(array));
	}
}