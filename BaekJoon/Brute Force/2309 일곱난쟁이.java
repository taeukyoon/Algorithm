import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*/
 백준 2309 일곱 난쟁이
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarf = new int[9];
        int lim = 100; //총합
        int sum = 0;

        for(int i = 0; i < 9; i ++) {
            dwarf[i] = Integer.parseInt(br.readLine()); //9개의 값 입력
            sum += dwarf[i];
        }
        Arrays.sort(dwarf); //오름차순으로 정리

        int val1 = 0;
        int val2 = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++)
                if(lim == (sum - dwarf[i] - dwarf[j])) {
                    val1 = i;
                    val2 = j;

                    break; //9명의 더한키에서 두명의 키를 빼서 100이면 더이상 반복x
                }
        }
        for(int i=0; i<9; i++) {
            if (i == val1 | i == val2)
                continue;  //조건이 성립하면 건너뛰어라
            System.out.println(dwarf[i]);
        }
    }
}
