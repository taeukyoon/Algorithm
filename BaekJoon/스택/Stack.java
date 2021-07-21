/*
 Stack 구현해보기
 */

class Main {
    interface Stack {
        boolean isEmpty();

        boolean isFull();

        void push(char item);

        char pop();

        char peek();
    }

    public static class ArrayStack implements Stack {
        private int top;
        private int stackSize;
        private char stackArr[];

        //스택 생성하는 생성자
        public ArrayStack(int stackSize) {
            top = -1; //스택 포인터 초기화
            this.stackSize = stackSize; //사이즈 설정
            stackArr = new char[stackSize]; //배열 생성
        }

        public boolean isEmpty() {
            return (top == -1); //스택 포인터가 -1이면 데이터가 없다 그래서 ture 아니면 false 반환
        }

        public boolean isFull() {
            return (top == stackSize - 1);
        }

        //스택에 데이터 추가
        public void push(char item) { // 데이터 추가
            if (isFull()) { // 스택이 가득찼으면 full이라고
                System.out.println("isFull!");
            } else {
                stackArr[++top] = item;
                System.out.println("Insert item :" + item);
            }
        }

        //top 데이터 추출후 삭제
        public char pop() {
            if (isEmpty()) { // 데이터가 없을시
                System.out.println("Stack Empty!");
                return 0;
            } else {
                System.out.println("Delete item" + stackArr[top]);
                return stackArr[top--]; //top부분의 데이터를 삭제해준다.
            }
        }

        //top 데이터 추출
        public char peek() {
            if (isEmpty()) { //데이터 없을시
                System.out.println("Peeking fail");
                return 1;
            } else { //top 데이터 추출만 (삭제는x)
                System.out.println("peek item:" + stackArr[top]);
                return stackArr[top];
            }
        }

        public void printStack() {
            if (isEmpty()) {
                System.out.println("Stack Empty!");
            } else {
                for (int i = 0; i <= top; i++) {
                    System.out.println(stackArr[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int stackSize = 7;
        ArrayStack arrayStack = new ArrayStack(stackSize);

        arrayStack.push('t');
        arrayStack.printStack();
        arrayStack.push('a');
        arrayStack.printStack();
        arrayStack.push('e');
        arrayStack.printStack();

        arrayStack.pop();
        arrayStack.printStack();

        arrayStack.peek();
        arrayStack.printStack();

        arrayStack.push('Y');
        arrayStack.printStack();
    }

}