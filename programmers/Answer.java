package programmers;

import java.util.Arrays;

public class Answer {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// 여기 이후부터 소스

		Tower tw = new Tower();
		int[] heights = {1,5,3,6,7,6,5 };
		System.out.println(Arrays.toString(tw.solution(heights)));

		// 여기까지 소스
		long endTime = System.nanoTime();
		System.out.printf("Used Time in milliseconds: %.5f\n", (endTime - startTime) / 1000000.0);
		// 메모리 확인 소스
		Runtime runtime = Runtime.getRuntime();
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory in bytes: " + memory);
	}
}
