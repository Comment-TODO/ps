package programmers;

class TargetNum {
	public int solution(int[] numbers, int target) {
		int size = 1;
		for (int i = 1; i <= numbers.length; i++) {
			size += (int) Math.pow(2, i);
		}
		int[] graph = new int[size];
		for (int i = 1, k = 1; k <= numbers.length; i = i + (int) Math.pow(2, k), k++) {
			for (int j = 0; j < (int) Math.pow(2, k); j++) {
				if (j % 2 == 0)
					graph[i + j] = numbers[k - 1];
				else
					graph[i + j] = -numbers[k - 1];
			}
		}

		dfs(graph, 0, target, 0);
		return count;
	}
	
	static int count = 0;
	static int dfs(int[] graph, int idx, int target, int sum) {
		if (idx >= graph.length)
			return 0;
		
		if (sum + graph[idx] == target && idx * 2 + 1 >= graph.length) {
			count++;
		}

		dfs(graph, idx * 2 + 1, target, sum + graph[idx]);
		dfs(graph, idx * 2 + 2, target, sum + graph[idx]);
		return 0;
	}
}