import java.util.LinkedList;
import java.util.Queue;

/*
 프로그래머스 level2 프린터
 stack, queue
 */
public class Solution {
    static class Node {
        int idx, priority;

        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> qu = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            qu.add(new Node(i, priorities[i]));
        }


        int cnt = 0;
        while (!qu.isEmpty()) {
            boolean flag = false;
            Node now = qu.poll();

            for (Node n : qu) {
                if (n.priority > now.priority) {
                    flag = true;
                }
            }
            if (flag) {
                qu.add(now);
            } else {
                cnt++;
                if (now.idx == location) {
                    answer = cnt;
                    break;
                }
            }
        }
        return answer;
    }
}