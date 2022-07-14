import java.util.LinkedList;

public class Graph {
	private int vertices;
	private LinkedList<Integer>[] list;

	Graph(int vertices) {
		this.vertices = vertices;
		list = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			list[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int destination) {
		list[v].add(destination);
		list[destination].add(v);
	}

	void dfsRecursion(int start) {
		boolean[] visited = new boolean[vertices];
		dfs(start, visited);
	}

	void dfs(int start, boolean[] visited) {
		visited[start] = true;
		System.out.println(start + " ");
		for (int i = 0; i < list[start].size(); i++) {
			int destination = list[start].get(i);
			if (!visited[destination]) {
				dfs(destination, visited);
			}
		}
	}

	public static void main(String[] args) {
		int v = 7;
		Graph graph = new Graph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.dfsRecursion(0);
	}
}
