import java.util.ArrayList;
import java.util.Stack;

/*
 Programmers 기능개발
 Stack 이용
 */
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            int val = ((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
            stack.add(val);
        }

        while (!stack.isEmpty())  {
            int top = stack.pop();
            int cnt = 1;

            while (!stack.isEmpty() && stack.peek() <= top) {
                cnt++;
                stack.pop();
            }
            list.add(cnt);
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}