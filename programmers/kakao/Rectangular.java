// 데모
package programmers;

class Rectangular {
	public int[] solution(int[][] v) {

		int x = 0, y = 0;

		double s1 = (Math.pow((v[0][0] - v[1][0]), 2) + Math.pow((v[0][1] - v[1][1]), 2)); // 0 과 1
		double s2 = (Math.pow((v[1][0] - v[2][0]), 2) + Math.pow((v[1][1] - v[2][1]), 2)); // 1 과 2
		double s3 = (Math.pow((v[0][0] - v[2][0]), 2) + Math.pow((v[0][1] - v[2][1]), 2)); // 0 과 2

    // 길이가 가장 긴 변을 이루는 점의 중점이 나머지 한 점과 (x, y)의 중점
		if (s1 > s2 && s1 > s3) {
			x = v[0][0] + v[1][0] - v[2][0];
			y = v[0][1] + v[1][1] - v[2][1];
		} else if (s2 > s1 && s2 > s3) {
			x = v[2][0] + v[1][0] - v[0][0];
			y = v[2][1] + v[1][1] - v[0][1];
		} else if (s3 > s1 && s3 > s2) {
			x = v[0][0] + v[2][0] - v[1][0];
			y = v[0][1] + v[2][1] - v[1][1];
		}
		
		int[] answer = {x, y};

		return answer;
	}
}
