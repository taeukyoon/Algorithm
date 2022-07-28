import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1969 DNA
 Date: 22-07-28
 Author: taeuk
 */
public class Main {
	static int n, m;
	static String[] dna;
	static int[][] alpha;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dna = new String[n];
        alpha = new int[m][26];

        for (int i = 0; i < n; i++) {
        	dna[i] = br.readLine();

        	for (int j = 0; j < m; j++) {
        		alpha[j][dna[i].charAt(j) - 'A'] += 1;
			}
		}

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
			int max = alpha[i][0];
			char ch = 'A';
			for (int j = 0; j < 26; j++) {
				if (alpha[i][j] > max) {
					max = alpha[i][j];
					ch = (char) (j + 'A');
				}
			}
			sb.append(ch);
		}

        int hamming = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (dna[i].charAt(j) != sb.charAt(j)) {
        			hamming++;
				}
			}
		}

		System.out.println(sb.toString());
		System.out.println(hamming);
    }
}
