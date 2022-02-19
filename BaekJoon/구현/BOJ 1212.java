import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 1212 8진수 2진수
 */
public class Main {
    static String[] binaryOctalArr = {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        if (str.charAt(0) == '0' && str.length() == 1) {
            sb.append(0);
        } else {
            for (int i = 0; i < str.length(); i++) {
                int val = Character.getNumericValue(str.charAt(i));

                if (i == 0 && val < 4) { // 1 ~ 3 맨앞에 0의 올경우
                    switch (val) {
                        case 1:
                            sb.append("1");
                            break;

                        case 2:
                            sb.append("10");
                            break;

                        case 3:
                            sb.append("11");
                            break;
                    }
                } else {
                    sb.append(binaryOctalArr[val]);
                }
            }
        }
        System.out.println(sb);
    }
}
