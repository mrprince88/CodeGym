import java.util.List;
import java.util.ArrayList;

class RiverSizes {

	static List<Integer> getRiverSizes(int [][]matrix) {

		List<Integer> sizes = new ArrayList<>();
		boolean [][]visited = new boolean[matrix.length][matrix[0].length];
		dfs(matrix, 0, 0, sizes, 0, visited);

		return sizes;
	}

	static void dfs(int [][]matrix, int r, int c, List<Integer> sizes, int size, boolean[][]visited) {

		if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || visited[r][c])
			return;

		visited[r][c] = true;
		if (matrix[r][c] == 0) {
			if (size != 0)
				sizes.add(size);
			size = 0;
		} else
			size++;

		dfs(matrix, r + 1, c, sizes, size, visited);
		dfs(matrix, r - 1, c, sizes, size, visited);
		dfs(matrix, r, c + 1, sizes, size, visited);
		dfs(matrix, r, c - 1, sizes, size, visited);

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

// [2, 2, 5, 1, 2]