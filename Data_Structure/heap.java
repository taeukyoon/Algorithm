import java.util.ArrayList;

/*
 Data Structure (heap)
 Array 방식을 사용하여 구현
 */
public class Main {

    class Minheap {
        private ArrayList<Integer> heap;

        public Minheap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        //힙 삽입
        private void insert(int val) {
            heap.add(val);
            int pos = heap.size() - 1;

            //루트 노드에 도달하거나, 부모노드가 자식노드보다 작아질 때 까지 반복
            while (pos > 1 && heap.get(pos / 2) < heap.get(pos)) {
                //swap
                int tmp = heap.get(pos / 2);
                heap.set(pos / 2, heap.get(pos));
                heap.set(pos, tmp);
                pos /= 2;
            }
        }

        private int delete() {
            if (heap.size() < 1) {
                return 0;
            }

            int deleteData = heap.get(1); //루트 노드 삭제

            //가장 아래에 있는 노드 루트 노드로
            heap.set(1, heap.size() - 1);

            //옮겨진 노드 삭제
            heap.remove(heap.size() - 1);

            int pos = 1;
            while ((pos * 2) < heap.size()) {
                int min = heap.get(pos * 2); //값
                int minPos = pos * 2; //왼쪽 자식 인덱스

                //왼쪽 자식과 오른쪽 자식값 비교
                if ((pos * 2 + 1) < heap.size() && heap.get(pos * 2 + 1) > min) {
                    //오른쪽 값이 더크면 왼쪽이랑 바꿔준다.
                    min = heap.get(pos * 2 + 1);
                    minPos = pos * 2 + 1;
                }

                if (heap.get(pos) < min) break;

                //swap
                int tmp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, tmp);
                pos = minPos;
            }
            return deleteData;
        }
    }
}
