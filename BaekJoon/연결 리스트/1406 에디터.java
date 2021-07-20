import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
/*
 BOJ 1406 에디터
 연결리스트
 */
class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int tset =  Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<Character>();

        for(int i = 0; i < N.length(); i++) {
                list.add(N.charAt(i));
            }


        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }
        for(int i = 0; i < tset; i++) {
            String method = br.readLine();
            char c = method.charAt(0);
            switch (c) {
                case 'L':
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char a = method.charAt(2);
                    iter.add(a);

                    break;
                default:
                    break;
            }
        }
        for(Character ch: list) {
            bw.write(ch);
        }
        bw.flush();
        bw.close();
    }
}