// Maximum sum subset problem

class KadanesAlgorithm {

	static int KadanesAlgorithm(int []array) {

		int maxSoFar = array[0], maxSum = Integer.MIN_VALUE;

		for (int i = 1; i < array.length; i++) {
			maxSoFar = Math.max(maxSoFar + array[i], array[i]);
			maxSum = Math.max(maxSum, maxSoFar);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int []array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
		System.out.println(KadanesAlgorithm(array));
	}
}