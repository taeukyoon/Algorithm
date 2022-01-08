import java.util.PriorityQueue;

/*
 Programmers 더맵게
 heap
 */
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            int val1 = pq.poll();
            int val2 = pq.poll();
            int newScoville = val1 + val2 * 2;

            pq.add(newScoville);
            answer++;
        }
        return answer;
    }
}