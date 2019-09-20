package programmers;

class Network {

    int[] network;
    int count = 0;

    public int solution(int n, int[][] computers) {

        network = new int[n];

        for (int i = 0; i < n; i++) {
            dfs(computers, i);
        }

        return count;
    }

    private void dfs(int[][] computers, int idx) {
        if (network[idx] == 0) {
            count++;
            network[idx] = count;
        } else {
            return;
        }

        for (int i = 0; i < computers.length; i++) {
            if (computers[idx][i] == 1) {
                network[i] = network[idx];
                dfs(computers, i);
            }
        }
    }
}