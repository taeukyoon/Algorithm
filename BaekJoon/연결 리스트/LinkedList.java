/*
 LinkedList 구현
 */
public class LinkedList {

    private Node head; //젤앞부분
    private Node tail; //젤끝부분
    private int size = 0;
    private class Node {
        private Object data;
        private Node next; //다음 노드에대한 정보
        public Node(Object intput) {  //node에 대한 값
            this.data = intput;
            this.next = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }
    //head에 data 추가
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null) tail = head; //다음 head가 존재하지않을때
    }
    //tail에 data 추가
    public void addLast(Object input) {
        Node newNode = new Node(input);
        if(size == 0) {
            addFirst(input);
        }else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    Node node(int index) {
        Node x = head;
        for(int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
    public void add(int k, Object input) {
        if(k == 0) {
            addFirst(input);
        }else {
            Node temp1 = node(k-1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if(newNode.next == null) {
                tail = newNode;
            }
        }
    }
    public String toString() {
        if(head == null) {
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;
        return str +"]";
    }
    public Object removeFirst() {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if(k == 0) {
            return removeFirst();
        }
        Node temp = node(k-1); //그전의 노드
        Node todoDeleted = temp.next; //삭제하려는 노드
        temp.next = temp.next.next;
        Object returnData = todoDeleted;
        if(todoDeleted == tail) {
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return returnData;
    }
    public Object removeLast() {
        return remove(size-1);
    }
}
