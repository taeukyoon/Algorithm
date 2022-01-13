import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 20365 블로그 2
 */
public class Main {
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<String> rCnt = new ArrayList<>();
        ArrayList<String> bCnt = new ArrayList<>();

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, "R");

        while (st.hasMoreTokens()) {
            bCnt.add(st.nextToken());
        }

        st = new StringTokenizer(line, "B");
        while (st.hasMoreTokens()) {
            rCnt.add(st.nextToken());
        }

        int res = 0;
        if (rCnt.size() >= bCnt.size()) {
            res = bCnt.size() + 1;
        } else {
            res = rCnt.size() + 1;
        }

        System.out.println(res);
    }
}
