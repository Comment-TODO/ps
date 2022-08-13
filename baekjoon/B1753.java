package baekjoon;

import java.io.*;
import java.util.*;

public class B1753 {
    static class Node implements Comparable<Node> {
        private final int v;
        private final int dist;

        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        final int INF = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] dist = new int[V + 1];
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }
        dist[K] = 0;
        PriorityQueue<Node> pque = new PriorityQueue<>();
        pque.offer(new Node(K, 0));

        for (int i = 1; i <= E; i++) {
            token = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        while (!pque.isEmpty()) {
            Node n = pque.poll();

            if (dist[n.v] < n.dist) continue;
            for (int i = 0; i < graph.get(n.v).size(); i++) {
                Node targetNode = graph.get(n.v).get(i);
                int viaDist = dist[n.v] + targetNode.dist;

                if (viaDist < dist[targetNode.v]) {
                    dist[targetNode.v] = viaDist;
                    pque.offer(new Node(targetNode.v, viaDist));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            bw.write((dist[i] == INF ? "INF" : dist[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
