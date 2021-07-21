import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 BOJ 1158 요세푸스
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            list.offer(i+1);
        }
        while (list.size() != 1 ) {
            for(int i = 0; i < k-1; i++) {
                list.offer(list.poll());
            }
            sb.append(list.poll()+", ");
        }
        sb.append(list.poll() +">");
        System.out.println(sb);
    }
}
