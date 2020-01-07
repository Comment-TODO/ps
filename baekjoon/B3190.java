package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B3190 {
    private static int[][] board;
    private static Queue<MvQueue> que = new ArrayDeque<>(); // 방향 전환 큐
    private static int head_x; // 뱀 머리 위치 열
    private static int head_y; // 뱀 머리 위치 행
    private static int dir = 0;
    private static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 뱀 머리 방향
    private static Queue<Integer> tail_x = new ArrayDeque<>();
    private static Queue<Integer> tail_y = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boardSize = Integer.parseInt(br.readLine());
        int appleNum = Integer.parseInt(br.readLine());
        // board에서 0 : 빈공간, 1: 뱀, 2: 사과
        board = new int[boardSize + 1][boardSize + 1];
        head_x = 1;
        head_y = 1;
        tail_x.offer(1);
        tail_y.offer(1);
        board[1][1] = 1;

        for (int i = 0; i < appleNum; i++) {
            String[] input = br.readLine().split(" ");
            board[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 2;
        }

        int snakeMove = Integer.parseInt(br.readLine());
        for (int i = 0; i < snakeMove; i++) {
            String[] input = br.readLine().split(" ");
            que.offer(new MvQueue(Integer.parseInt(input[0]), input[1].charAt(0)));
        }

        int time = 0;
        MvQueue mvQue = que.poll();
        boolean queLeft = true;
        while (true) {
            time++;
            if (queLeft && time - 1 == mvQue.time) {
                switch (mvQue.movement) {
                    case 'D':
                        dir = dir + 1 > 3 ? 0 : dir + 1;
                        break;
                    case 'L':
                        dir = dir - 1 >= 0 ? dir - 1 : 3;
                        break;
                }
                if (que.isEmpty()) {
                    queLeft = false;
                } else {
                    mvQue = que.poll();
                }
            }

            head_x += move[dir][0];
            head_y += move[dir][1];

            if (head_x < 1 || head_x > boardSize || head_y < 1 || head_y > boardSize)
                break;

            if (board[head_y][head_x] == 1)
                break;
            if (board[head_y][head_x] == 0) {
                board[tail_y.poll()][tail_x.poll()] = 0;
            }
            board[head_y][head_x] = 1;
            tail_x.offer(head_x);
            tail_y.offer(head_y);
        }

        System.out.println(time);
    }
}

class MvQueue {
    int time;
    char movement;

    MvQueue(int time, char movement) {
        this.time = time;
        this.movement = movement;
    }
}
