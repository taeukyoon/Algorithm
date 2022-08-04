import java.io.IOException;

/*
 BOJ 4690
 Date: 22-08-03
 Author: taeuk
 */
public class Main {
	public static void main(String[] args) throws IOException {
		for (int a = 6; a <= 100; a++) {
			for (int b = 2; b < a; b++) {
				for (int c = b + 1; c < a; c++) {
					for (int d = c + 1; d < a; d++) {

						if (pow(a) == pow(b) + pow(c) + pow(d)) {
							System.out.println("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")");
						}
					}
				}
			}
		}
	}

	private static int pow(int i) {
		return (int)Math.pow(i, 3);
	}
}
