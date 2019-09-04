import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {

	static Graph[] graphArr;
	static boolean[] visit;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());

		graphArr = new Graph[N + 1];
		for (int i = 1; i <= N; i++) {
			graphArr[i] = new Graph();
		}

		for (int i = 1; i <= M; i++) {
			token = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(token.nextToken());
			int adjVertex = Integer.parseInt(token.nextToken());
			graphArr[vertex].addAdj(adjVertex);
			graphArr[adjVertex].addAdj(vertex);
		}

		// DFS
		sb = new StringBuilder();
		visit = new boolean[N + 1];

		sb.append(V).append(" ");
		visit[V] = true;
		dfs(graphArr[V]);
		System.out.println(sb.substring(0, sb.length() - 1).toString());

		// BFS
		sb = new StringBuilder();
		visit = new boolean[N + 1];

		sb.append(V).append(" ");
		visit[V] = true;
		bfs(V);
		System.out.println(sb.substring(0, sb.length() - 1).toString());
	}

	static void dfs(Graph graph) {
		if (graph.getAdj().isEmpty())
			return;

		Integer[] adj = graph.getAdj().toArray(new Integer[0]); // 인접 정점 배열

		for (int i = 0; i < adj.length; i++) {
			if (!visit[adj[i]]) {
				visit[adj[i]] = true;
				sb.append(adj[i]).append(" ");
				dfs(graphArr[adj[i]]);
			}
		}
	}

	static void bfs(int V) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(V);

		while (!que.isEmpty()) {
			int curr = que.poll();

			for (int i : graphArr[curr].getAdj().toArray(new Integer[0])) {
				if (!visit[i]) {
					visit[i] = true;
					sb.append(i).append(" ");
					que.offer(i);
				}
			}
		}
	}

}

class Graph {
	private Set<Integer> adj;

	void addAdj(int vertex) {
		adj.add(vertex);
	}

	Set<Integer> getAdj() {
		return this.adj;
	}

	Graph() {
		adj = new TreeSet<>();
	}
}
