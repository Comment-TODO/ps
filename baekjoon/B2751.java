package baekjoon;

import java.io.*;

public class B2751 {
	static void merge_div(int[] array, int left, int right, int[] tmpArray) {
		if (left < right) {
			int mid = (left + right) / 2;
			merge_div(array, left, mid, tmpArray);
			merge_div(array, mid + 1, right, tmpArray);
			merge_sort(array, left, right, tmpArray);
		}
	}
	
	static void merge_sort(int[] array, int left, int right, int[] tmpArray) {
		int leftCount = left;
		int mid = (left + right) / 2;
		int rightCount = mid + 1;
		int arrayHeader = left;
		
		while (leftCount <= mid && rightCount <= right) {
			if (array[leftCount] < array[rightCount]) {
				tmpArray[arrayHeader++] = array[leftCount++];
			} else {
				tmpArray[arrayHeader++] = array[rightCount++];
			}
		}
		while (leftCount <= mid) {
			tmpArray[arrayHeader++] = array[leftCount++];
		}
		while (rightCount <= right) {
			tmpArray[arrayHeader++] = array[rightCount++];
		}
		
		for (int i = left; i <= right; i++) {
			array[i] = tmpArray[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] array = new int[num];
		int[] tmpArray = new int[array.length];
		
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		merge_div(array, 0, num - 1, tmpArray);
		
		for (int i = 0; i < num; i++) {
			System.out.println(array[i]);
		}
	}
}
