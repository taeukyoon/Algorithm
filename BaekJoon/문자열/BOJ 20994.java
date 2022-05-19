import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 20994 팰린드롬 척화비
 Date: 22-05-19
 Author: taeuk
 */
public class Main {
	static int n;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new char[n];
		Arrays.fill(arr, 'a');
		System.out.println(arr);
	}
}
