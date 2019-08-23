package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

class ShuttleBus {
	public String solution(int n, int t, int m, String[] timetable) {

		int firstDeparture = 9 * 60; // 9:00
		int term = t;
		int lastDeparture = firstDeparture + (n - 1) * term;
		int maxSeat = m;
		int lastPassenger = 0;
		String answer = "";

		Queue<Integer> crew = new PriorityQueue<Integer>();

		for (String crewComeTime : timetable) {
			int hour = Integer.parseInt(crewComeTime.substring(0, 2));
			int min = Integer.parseInt(crewComeTime.substring(3));
			crew.offer(hour * 60 + min);
		}

		for (int time = firstDeparture; time <= lastDeparture; time += term) {
			int occupied = 0;

			while (occupied < maxSeat && !crew.isEmpty() && crew.peek() <= time) {
				lastPassenger = crew.poll();
				occupied++;
			}

			if (time == lastDeparture) {
				if (occupied < maxSeat) {
					answer = String.format("%02d:%02d", lastDeparture / 60, lastDeparture % 60);
				} else {
					answer = String.format("%02d:%02d", (lastPassenger - 1) / 60, (lastPassenger - 1) % 60);
				}
			}
		}

		return answer;
	}
}
