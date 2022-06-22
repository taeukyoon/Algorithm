import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 BOJ 13913 숨바꼭질 4
 */
public class Main{
    static int N, K;
    static int[] visited = new int[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(visited[K] - 1);

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    public static void bfs() {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(N);
        visited[N] = 1;

        while(!qu.isEmpty()) {
            int cur = qu.poll();
            if(cur == K) return;

            for(int i = 0; i < 3; i++) {
                int nx;

                if(i == 0) nx = cur + 1;
                else if(i == 1) nx = cur - 1;
                else nx = cur * 2;

                if(nx < 0 || nx > 100000) continue;
                if(visited[nx] == 0) {
                    qu.add(nx);
                    visited[nx] = visited[cur] + 1;
                    parent[nx] = cur;
                }
            }
        }
    }
}