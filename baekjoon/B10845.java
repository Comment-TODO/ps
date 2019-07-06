package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue que = new Queue();
		int commandNo = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (commandNo-- > 0) {
			String command = br.readLine();

			if (command.startsWith("push")) {
				que.push(Integer.parseInt(command.substring(5)));
			} else if (command.startsWith("pop")) {
				System.out.println(que.pop());
			} else if (command.startsWith("size")) {
				System.out.println(que.size());
			} else if (command.startsWith("empty")) {
				System.out.println(que.isEmpty());
			} else if (command.startsWith("front")) {
				System.out.println(que.front());
			} else if (command.startsWith("back")) {
				System.out.println(que.back());
			}
		}
	}
}

class Queue {
	private int size = 0;
	private int front = -1;
	private int rear = -1;
	private int[] que = new int[10000];

	public int isEmpty() {
		return size == 0 ? 1 : 0;
	}

	public void push(int x) {
		size++;
		if (isEmpty() == 1) {
			front = rear = 0;
			que[0] = x;
		} else {
			que[++rear] = x;
		}
	}

	public int pop() {
		if (isEmpty() == 1) {
			return -1;
		}
		if (size == 1) {
			front = rear = -1;
			size--;
			return que[0];
		}
		int pop = que[0];
		for (int i = 0; i < rear; i++) {
			que[i] = que[i + 1];
		}
		size--;
		rear--;
		return pop;
	}

	public int size() {
		return size;
	}

	public int front() {
		if (isEmpty() == 1) {
			return -1;
		}
		return que[0];
	}

	public int back() {
		if (isEmpty() == 1) {
			return -1;
		}
		return que[rear];
	}
}