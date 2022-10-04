package baekjoon;

import java.io.*;
import java.util.*;

public class B2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        int n = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(token.nextToken())).add(Integer.parseInt(token.nextToken()));
        }

        int kinship = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            kinship = Math.min(kinship, bfs(list, targets, i));
        }
        System.out.println(kinship == Integer.MAX_VALUE ? -1 : kinship);

        br.close();
    }

    private static int bfs(ArrayList<ArrayList<Integer>> list, String[] targets, int n) {
        Queue<Integer> que = new ArrayDeque<>();
        Queue<Integer> kinshipQue = new ArrayDeque<>();
        int l = 0, r = 0;
        boolean lf = false, rf = false;

        que.offer(n);
        kinshipQue.offer(0);

        while (!que.isEmpty()) {
            int targetA = Integer.parseInt(targets[0]);
            int targetB = Integer.parseInt(targets[1]);

            int ltr = que.poll();
            int kinship = kinshipQue.poll();

            if (ltr == targetA) {
                l = kinship;
                lf = true;
            }
            if (ltr == targetB) {
                r = kinship;
                rf = true;
            }

            ArrayList<Integer> children = list.get(ltr);
            for (int child : children) {
                if (child == targetA) {
                    l = kinship + 1;
                    lf = true;
                }
                if (child == targetB) {
                    r = kinship + 1;
                    rf = true;
                }

                que.offer(child);
                kinshipQue.offer(kinship + 1);
            }
        }

        return (lf == rf && lf) ? l + r : Integer.MAX_VALUE;
    }
}
