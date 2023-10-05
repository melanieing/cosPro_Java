package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 94338. 큐를 이용한 스택 구현_디버깅
 */
public class QueueToStack94338 {
    public static void main(String[] args) {
        QueueToStack94338 q = new QueueToStack94338();
        String[] command = {"push 1", "push 2", "top", "push 3", "pop"};

        System.out.println(Arrays.toString(q.solution(command)));
    }

    private int[] solution(String[] command) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (String cmd : command) {
            if (cmd.startsWith("push")) {
                int value = Integer.parseInt(cmd.substring(5));
                int size = queue.size();
                queue.offer(value);
                for (int i = 0; i < size; i++) { // 순서 뒤집어주기
                    queue.offer(queue.poll());
                }
            } else if (cmd.equals("pop")) {
                result.add(queue.peek());
                queue.poll();
            } else if (cmd.equals("top")) {
                result.add(queue.peek());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
