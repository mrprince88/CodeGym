import java.util.List;
import java.util.ArrayList;

class RiverSizes {

	static List<Integer> getRiverSizes(int [][]matrix) {

		List<Integer> sizes = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][i] == 1) {
					int size = dfs(matrix, i, j);
					if (size > 0)
						sizes.add(size);
				}
			}
		}

		return sizes;
	}

	static int dfs(int [][]matrix, int r, int c) {

		if (r == -1 || c == -1 || r == matrix.length || c == matrix[0].length || matrix[r][c] == 0)
			return 0;

		matrix[r][c] = 0;

		return 1 + dfs(matrix, r + 1, c) + dfs(matrix, r - 1, c) + dfs(matrix, r, c + 1) + dfs(matrix, r, c - 1);

	}

	public static void main(String[] args) {
		int [][]matrix = {
			{1, 0, 0, 1, 0},
			{1, 0, 1, 0, 0},
			{0, 0, 1, 0, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 0}
		};
		System.out.println(getRiverSizes(matrix));
	}
}

// [2, 1, 5, 2, 2]