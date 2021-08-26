// get Strongly Connected Components in directed graph
import java.io.*;
import java.util.*;

public class KosarajuAlgorithm {
	static List<List<Integer>> graph;

	static void getSCCs() {
		Stack<Integer> stack = new Stack<>();
		int n = graph.size();
		boolean []visited = new boolean[n];

		// fill the stack
		for (int i = 0; i < n; i++)
			if (!visited[i])
				dfs(i, visited, stack);

		//transpose of graph
		List<List<Integer>> graph2 = new ArrayList<>();

		for (int i = 0; i < n; i++)
			graph2.add(new LinkedList<>());

		for (int i = 0; i < n; i++) {
			List<Integer> curr = graph.get(i);

			for (int j : curr)
				graph2.get(j).add(i);
		}

		//perform DFS on transpose using stack and get SCCs
		visited = new boolean[n];
		int count = 0;

		System.out.println("Components: ");

		while (!stack.isEmpty()) {
			int v = stack.pop();

			if (!visited[v]) {
				++count;
				dfs2(graph2, v, visited);
				System.out.println();
			}
		}

		System.out.println("Number of components: " + count);

	}

	static void dfs(int v, boolean []visited, Stack<Integer> stack) {
		visited[v] = true;

		for (int i : graph.get(v)) {
			if (!visited[i])
				dfs(i, visited, stack);
		}
		stack.push(v);
	}

	static void dfs2(List<List<Integer>> graph2, int v, boolean []visited) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int i : graph2.get(v))
			if (!visited[i])
				dfs2(graph2, i, visited);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		graph = new ArrayList<>();

		for (int i = 0; i < n; i++)
			graph.add(new LinkedList<>());

		for (int i = 0; i < n; i++) {
			int source = sc.nextInt(), end = sc.nextInt();
			graph.get(source).add(end);
		}
		getSCCs();
	}
}