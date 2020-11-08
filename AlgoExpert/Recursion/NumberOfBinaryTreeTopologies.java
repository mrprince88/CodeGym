import java.util.*;

class NumberOfBinaryTreeTopologies {

	//Upper Bound : O((n*(2n)!)/(n!*(n+1)!)) time | O(n) space

	static int getNumberOfTopologies(int n) {

		if (n == 0)
			return 1;

		int numOfTrees = 0;

		for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
			int rightTreeSize = n - 1 - leftTreeSize;
			int numOfLeftTrees = getNumberOfTopologies(leftTreeSize);
			int numOfRightTrees = getNumberOfTopologies(rightTreeSize);
			numOfTrees += numOfLeftTrees * numOfRightTrees;
		}

		return numOfTrees;
	}

	//O(n^2)time | O(n) space

	static int getNumberOfTopologies(int n, int []cache) {

		if (cache[n] != -1)
			return cache[n];

		int numOfTrees = 0;

		for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
			int rightTreeSize = n - 1 - leftTreeSize;
			int numOfLeftTrees = getNumberOfTopologies(leftTreeSize);
			int numOfRightTrees = getNumberOfTopologies(rightTreeSize);
			numOfTrees += numOfLeftTrees * numOfRightTrees;
		}

		cache[n] = numOfTrees;

		return cache[n];
	}

	//O(n^2) time | O(n) space

	static int numOfTopologies(int n) {

		int []cache = new int[n + 1];
		cache[0] = 1;

		for (int m = 1; m <= n; m++) {

			int numOfTrees = 0;

			for (int leftTreeSize = 0; leftTreeSize < m; leftTreeSize++) {
				int rightTreeSize = m - 1 - leftTreeSize;
				int numOfLeftTrees = cache[leftTreeSize];
				int numOfRightTrees = cache[rightTreeSize];
				numOfTrees += numOfLeftTrees * numOfRightTrees;
			}
			cache[m] = numOfTrees;
		}

		return cache[n];
	}

	public static void main(String[] args) {

		int n = 4;
		int []a = new int[n + 1];
		Arrays.fill(a, -1);
		a[0] = 1;

		System.out.println(getNumberOfTopologies(n, a));
	}
}