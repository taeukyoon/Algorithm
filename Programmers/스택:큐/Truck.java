import java.util.LinkedList;
import java.util.Queue;

/*
 Programmers 다리를 지나는 트럭
 Queue 사용
 */
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> qu = new LinkedList<>();

        for (int truck : truck_weights) {
            while (true) {
                if (qu.isEmpty()) {
                    qu.add(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if (qu.size() == bridge_length) {
                    sum -= qu.poll();
                } else {
                    if (weight >= sum + truck) {
                        qu.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    } else {
                        qu.add(0);
                        answer++;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}