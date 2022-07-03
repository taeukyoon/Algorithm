import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 BOJ 2668
 Date: 22-06-30
 Author: taeuk
 */
public class Main {
    static int n, last;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        visited = new boolean[n + 1];
        list = new ArrayList<>();
        last = 0;
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            last = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer li : list) {
            System.out.println(li);
        }
    }

    private static void dfs(int i) {
        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
        if (arr[i] == last) {
            list.add(last);
        }
    }
}
