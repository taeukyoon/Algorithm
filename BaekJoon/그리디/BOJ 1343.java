import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 1343 폴리미노
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();
        board = board.replaceAll("XXXX", "AAAA");
        board = board.replaceAll("XX", "BB");

        System.out.println((board.contains("X")) ? -1 : board);
    }
}
