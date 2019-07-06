package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1927 {
	static void downHeap(int[] arr, int smallest, int size) {
		int i = smallest;
		int l = smallest * 2 + 1;
		int r = l + 1;

		if (l < size && arr[l] < arr[smallest])
			smallest = l;
		if (r < size && arr[r] < arr[smallest])
			smallest = r;

		if (i != smallest) {
			int tmp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = tmp;

			downHeap(arr, smallest, size);
		}
	}
	
	static void upHeap(int[] arr, int curr, int size) {
		while (curr > 0) {
			int p = (curr - 1) / 2;
			if (arr[p] > arr[curr]) {
				int tmp = arr[p];
				arr[p] = arr[curr];
				arr[curr] = tmp;
				
				curr = p;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t_case = Integer.parseInt(br.readLine());
		StringBuffer buff = new StringBuffer();
		int[] heap = new int[t_case];
		int size = 0;

		while (t_case-- > 0) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				if (size == 0) {
					buff.append(0 + "\n");
				} else {
					buff.append(heap[0] + "\n");
					heap[0] = heap[size - 1];
					size--;
					downHeap(heap, 0, size);
				}
			} else {
				heap[size++] = input;
				upHeap(heap, size - 1, size);
			}
		}

		System.out.print(buff.toString());
	}
}