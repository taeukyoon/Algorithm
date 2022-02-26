import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 BOJ 20291 파일 정리
 */
public class Main {
    static int n;
    static HashMap<String, Integer> map;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            String name = st.nextToken();
            String ex = st.nextToken();

            if (map.containsKey(ex)) {
                map.put(ex, map.get(ex) + 1);
            } else {
                list.add(ex);
                map.put(ex, 1);
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ").append(map.get(list.get(i))).append("\n");
        }
        System.out.println(sb);
    }
}
