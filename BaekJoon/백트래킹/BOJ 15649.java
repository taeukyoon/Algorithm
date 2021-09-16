    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    /*
    BOJ 15649
    Date: 21-09-14
     */
    public class Main{
        static int N, M;
        static int[] arr;
        static boolean[] visited;
        static StringBuilder sb = new StringBuilder();
        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M];
            visited = new boolean[N];
            dfs(N, M, 0);
            System.out.println(sb);
        }
        public static void dfs(int n, int m, int depth) {
            if(depth == m) {
                for(int val : arr) {
                    sb.append(val).append(" ");
                }
                sb.append('\n');
                return;
            }

            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(n, m, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }