import java.util.*;

// Topological Sort is defined for only directed acyclic graph(DAG).
// Time Complexity: O(V+E), Space Complexity: O(V+E).

class TopologicalSort {

	static boolean dfs(int[][]graph, int vertices, int v, boolean visiting[],
	                   boolean visited[], List<Integer> list) {

		if (visited[v])
			return false;

		if (visiting[v])
			return true;

		visiting[v] = true;

		for (int i = 1; i <= vertices; i++) {

			if (graph[v][i] == 1 && dfs(graph, vertices, i, visiting, visited, list))  //checking if there is a cycle in graph
				return true;
		}

		visited[v] = true;
		visiting[v] = false;

		list.add(v);

		return false;
	}

	static List<Integer> topologicalSort(int [][]graph, int vertices) {
		List<Integer> list = new ArrayList<>();
		boolean visited[] = new boolean[vertices + 1];
		boolean visiting[] = new boolean[vertices + 1];

		for (int i = 1; i <= vertices; i++)
			if (dfs(graph, vertices, i, visiting, visited, list))   //if there is a cycle in graph return empty list
				return new ArrayList<>();

		Collections.reverse(list);
		return list;
	}

	public static void main(String[] args) {
		int [][]graph = {
			{0, 0, 0, 0, 0},
			{0, 0, 1, 1, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 1, 1, 0}
		};
		int vertices = 4;
		System.out.println(topologicalSort(graph, vertices));
	}
}








