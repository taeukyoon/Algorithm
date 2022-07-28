import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 BOJ 5568 카드 놓기
 Date: 22-07-28
 Author: taeuk
 */
public class Main {
	static int n, k, cnt;
	static int[] card;
	static boolean[] visited;
	static HashSet<String> set;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        visited = new boolean[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
        	card[i] = Integer.parseInt(br.readLine());
		}

        perm(0, "");
		System.out.println(set.size());
    }

	private static void perm(int depth, String num) {
    	if (depth == k) {
    		set.add(num);
    		return;
		}

    	for (int i = 0; i < n; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			perm(depth + 1, num + card[i]);
    			visited[i] = false;
			}
		}
	}
}
