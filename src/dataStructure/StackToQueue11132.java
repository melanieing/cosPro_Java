package dataStructure;

import java.util.ArrayList;

/**
 * 11132. 스택으로 큐 구현_빈칸채우기
 * stack1과 stack2로 구현한 큐에서 pop(또는 dequeue)한 값
 */
public class StackToQueue11132 {
    public static void main(String[] args) {
        StackToQueue11132 q = new StackToQueue11132();

        ArrayList<Integer> stack1 = new ArrayList<>();
        ArrayList<Integer> stack2 = new ArrayList<>();
        stack1.add(1);
        stack1.add(2);
        stack2.add(3);
        stack2.add(4);

        System.out.println(q.solution(stack1, stack2));
    }

    private int solution(ArrayList<Integer> stack1, ArrayList<Integer> stack2) {
        if (isStackEmpty(stack2)) { // 스택2가 비었으면 스택1 -> 스택2로 옮기기
            moveData(stack1, stack2);
        }

        return popFromStack(stack2); // 스택2에서 pop
    }

    private Integer popFromStack(ArrayList<Integer> stack) { // 스택에서 pop
        return stack.remove(stack.size()-1);
    }

    private void moveData(ArrayList<Integer> stack1, ArrayList<Integer> stack2) { // 스택1에서 스택2로 옮기기
        while (!isStackEmpty(stack1)) {
            Integer item = popFromStack(stack1);
            stack2.add(item);
        }
    }

    private boolean isStackEmpty(ArrayList<Integer> stack) { // 스택이 비었는지 판별
        return stack.isEmpty();
    }


}
