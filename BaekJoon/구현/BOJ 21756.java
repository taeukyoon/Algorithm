import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 BOJ 21756 지우개
 */
public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() >= 2) {
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
            }
        }
        System.out.println(list.get(0));
    }
}
