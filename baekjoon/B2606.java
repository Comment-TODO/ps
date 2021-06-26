import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2606 {
    private static int addQueInfected(Queue que, boolean[][] graph, int maxComp, int row) {
        for (int i = 2; i <= maxComp; i++) {
            if (graph[row][i]) {
                if (!graph[i][0]) {
                    que.offer(i);
                    graph[i][0] = true;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int compCount = Integer.parseInt(bufferedReader.readLine());
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        boolean[][] graph = new boolean[compCount + 1][compCount + 1];


        while (lineCount > 0) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int compA = Integer.parseInt(tokenizer.nextToken());
            int compB = Integer.parseInt(tokenizer.nextToken());
            graph[compA][compB] = true;
            graph[compB][compA] = true;

            lineCount--;
        }

        int infectedCount = 0;
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 2; i <= compCount; i++) {
            if (graph[1][i]) {
                que.offer(i);
                graph[i][0] = true;
            }
        }
        while (!que.isEmpty()) {
            infectedCount += addQueInfected(que, graph, compCount, que.poll());
        }

        System.out.println(infectedCount);
    }
}
