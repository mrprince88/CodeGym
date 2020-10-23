class SearchInSortedMatrix {

	// O(n+m) time
	static void search(int [][]matrix, int num) {

		int row = 0, col = matrix[0].length - 1, c = 0;

		while (row < matrix.length || col >= 0) {
			if (matrix[row][col] > num)
				col--;
			else if (matrix[row][col] < num)
				row++;
			else {
				System.out.println(row + " " + col);
				++c;
				break;
			}
		}

		if (c == 0)
			System.out.println(-1);
	}

	public static void main(String[] args) {
		int [][]matrix = {
			{1,    4,   7,  12,  15, 1000},
			{2,    5,  19,  31,  32, 1001},
			{3,    8,  24,  33,  35, 1002},
			{40,  41,  42,  44,  45, 1003},
			{99, 100, 103, 106, 128, 1004}
		};
		int num = 44;
		search(matrix, num);
	}
}