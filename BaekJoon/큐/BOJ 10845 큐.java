import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 BOJ 10845 큐
 LinkedList로 구현된 큐를 이용한 문제풀이
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else System.out.println(queue.removeFirst());
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }else System.out.println(0);
                    break;

                case "front":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else System.out.println(queue.get(0));
                    break;

                case "back":
                    if(queue.isEmpty()){
                        System. out.println(-1);
                    }else System.out.println(queue.get(queue.size()-1));
                    break;
            }
        }
    }
}
