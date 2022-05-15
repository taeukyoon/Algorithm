import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 3029 경고
 Date: 22-05-13
 Author: taeuk
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String current = br.readLine();
		String event = br.readLine();

		if (current.equals(event)) {
			System.out.print("24:00:00");
			System.exit(0);
		}

		int hour = Integer.parseInt(event.split(":")[0]) - Integer.parseInt(current.split(":")[0]);
		int minute = Integer.parseInt(event.split(":")[1]) - Integer.parseInt(current.split(":")[1]);
		int second = Integer.parseInt(event.split(":")[2]) - Integer.parseInt(current.split(":")[2]);

		if (second < 0) {
			second += 60;
			minute--;
		}

		if (minute < 0) {
			minute += 60;
			hour--;
		}

		if (hour < 0) {
			hour += 24;
		}

		System.out.format("%02d:%02d:%02d", hour, minute, second);
	}
}
