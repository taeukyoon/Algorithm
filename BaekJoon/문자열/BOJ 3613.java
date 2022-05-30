import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 3613
 */
public class Main {
    static boolean flag, isJava, isCpp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        char[] ch = str.toCharArray();

        // 1. '_'로 시작
        // 2. '_'로 끝나는 경우
        // 3. 대문자 시작

        if (ch[0] == '_' || ch[str.length() - 1] == '_' || ch[0] < 'a') {
            System.out.println("Error!");
            return;
        }

        isJava = true;
        isCpp = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                if (ch[i] == '_' && ch[i - 1] == '_') {
                    System.out.println("Error!");
                    return;
                }
                isJava = false;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') isCpp = false;
        }

        if (!isJava && !isCpp) {
            System.out.println("Error!");
            return;
        }

        if (isJava && isCpp) {
            System.out.println(str);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (isJava) {
            for (char c : ch) {
                if ('A' <= c && c <= 'Z') { // 대문자 소문자로 변환 앞에 '_'추가
                    sb.append('_').append((char)(c + 32));
                    continue;
                }
                sb.append(c);
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (ch[i] == '_' && i < str.length() - 1) {
                    sb.append((char)(ch[++i] - 32));
                    continue;
                }
                sb.append(ch[i]);
            }
        }
        System.out.println(sb.toString());
    }
}