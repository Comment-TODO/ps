package topcoder;

public class Cryptography {
	 public long encrypt(int[] numbers) {
		 int min = numbers[0];
		 int idx = 0;
		 for (int i = 1; i < numbers.length; i++) {
			 if (min > numbers[i]) {
				 idx = i;
			 }
		 }
		 numbers[idx]++;
		 
		 long answer = 1;
		 for (int i = 0; i < numbers.length; i++) {
			 answer *= numbers[i];
		 }
		 
		 return answer;
	 }
	 
	 public static void main(String[] args) {
		 Cryptography cg = new Cryptography();
		 int[] arr = {1000,999,998,997,996,995};
		 System.out.println(cg.encrypt(arr));
	 }
}
