import java.util.*;

// Topological Sort is defined for only directed acyclic graph(DAG).
// Time Complexity: O(V+E), Space Complexity: O(V+E).

class TopologicalSort {

	static class Graph {

		static class Node {
			List<Node> prereqs; int val;
			Node(int val) {
				this.val = val;
				prereqs = new ArrayList<>();
			}
		}

		List<Node> jobs; int vertices;

		Graph(int v) {
			vertices = v;
			jobs = new ArrayList<>();
		}

		void addJob(int x, int y) {
			Node a = getNode(x);
			Node b = getNode(y);
			b.prereqs.add(a);
		}

		Node getNode(int x) {
			for (Node i : jobs)
				if (i.val == x)
					return i;
			Node n = new Node(x);
			jobs.add(n);
			return n;
		}

		List<Integer> topologicalSort() {
			List<Integer> list = new ArrayList<>();
			int []visited = new int[vertices];

			for (int i = 0; i < jobs.size(); i++)
				if (dfs(jobs.get(i), visited, list)) //if there is a cycle in graph return empty list
					return new ArrayList<>();
			return list;
		}

		boolean dfs(Node v, int []visited, List<Integer> list) {

			if (visited[v.val] == 2) return false;
			if (visited[v.val] == 1) return true;

			for (int i = 0; i < v.prereqs.size(); i++) {
				if (dfs(v.prereqs.get(i), visited, list)) //checking if there is a cycle in graph
					return true;
			}

			visited[v.val] = 2;
			list.add(v.val);
			return false;
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(12);
		graph.addJob(7, 11);
		graph.addJob(5, 11);
		graph.addJob(11, 2);
		graph.addJob(11, 9);
		graph.addJob(11, 10);
		graph.addJob(8, 9);
		graph.addJob(3, 10);
		graph.addJob(3, 8);
		System.out.println(graph.topologicalSort());
	}
}




