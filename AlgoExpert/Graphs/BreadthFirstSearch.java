import java.util.*;

class BreadthFirstSearch {

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

		void breadthFirstTraversal(int val, boolean []visited) {

			Queue<Integer> queue = new LinkedList<>();

			queue.add(val);

			while (queue.size() > 0) {
				int curr = queue.poll();
				if (!visited[curr]) {
					System.out.println(curr);
					visited[curr] = true;
					for (int i : graph.get(curr))
						queue.add(i);
				}
			}

		}

		void bfs(int n) {
			boolean[] visited = new boolean[vertex + 1];
			breadthFirstTraversal(n, visited);
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(3);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.bfs(1);
	}
}

