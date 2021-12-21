import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 BOJ 16637 괄호추가하기
 재귀이용
 */
public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> num;
    static ArrayList<Character> op;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        num = new ArrayList<>();
        op = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                op.add(ch);
            } else {
                num.add(Character.getNumericValue(ch));
            }
        }

        int start = num.get(0);
        dfs(0, start);
        System.out.println(max);
    }
    public static void dfs(int opIdx, int sum) {
        if (opIdx >= op.size()) {
            max = Math.max(max, sum);
            return;
        }

        //괄호없이 계산
        int res1 = cal(opIdx, sum, num.get(opIdx + 1));
        dfs(opIdx + 1, res1);

        //괄호 o (오른쪽부터)
        if (opIdx + 1 < op.size()) {
            int res2 = cal(opIdx + 1, num.get(opIdx + 1), num.get(opIdx + 2));
            int ans = cal(opIdx, sum, res2);
            dfs(opIdx + 2, ans);
        }
    }

    public static int cal(int opIdx, int a, int b) {
        switch (op.get(opIdx)) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return -1;
    }
}