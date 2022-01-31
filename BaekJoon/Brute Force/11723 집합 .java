import java.io.*;
import java.util.StringTokenizer;

/*
 백준 11723 집합
 BitMask 사용
 */
class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int bitMask = 0;

        while(M-- > 0) {
            //case 입력부분
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            String op = st.nextToken();
            int num;

            switch (op) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bitMask |= (1 << (num-1));
                    break;

                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bitMask &= ~(1 << (num-1));
                    break;
                //bitmask에 check 연산이 실행되면 sb에 더해준다.
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bitMask & (1 << (num-1))) != 0 ? "1\n" : "0\n");
                    break;

                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bitMask ^= (1 << (num-1));
                    break;

                case "all":
                    bitMask = ~0;
                    break;

                case "empty":
                    bitMask = 0;
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}