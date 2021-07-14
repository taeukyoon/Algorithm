
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 2752 백준
 */
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String num[] = str.split(" "); //문자를 입력받아서 잘라서 사용
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(num[i]));
        }
        Collections.sort(list);

        for(int i = 0; i < 3; i++){
            System.out.print(list.get(i) + " ");
        }


    }
}