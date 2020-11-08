import java.util.*;

class DepthFirstSearch {

	static class Graph {

		Map<Integer, List<Integer>> graph = new HashMap<>();
		int vertex;

		Graph(int v) {
			vertex = v;
			for (int i = 0; i <= v; i++)
				graph.put(i, new LinkedList<Integer>());
		}

		void addEdge(int src, int dest) {
			graph.get(src).add(dest);
		}

		void depthFirstTraversal(int n, boolean[]visited) {
			System.out.println(n);
			visited[n] = true;
			for (int i : graph.get(n)) {
				if (!visited[i])
					depthFirstTraversal(i, visited);
			}
		}

		void dfs(int v) {
			boolean[] visited = new boolean[vertex + 1];
			depthFirstTraversal(v, visited);
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(3);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.dfs(2);
	}
}