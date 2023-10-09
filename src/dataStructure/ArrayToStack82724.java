package dataStructure;
/**
 * 82724. 스택 구현하기_빈칸채우기
 * 모든 연산을 마친 후 스택에 남아있는 원소의 개수?
 */
public class ArrayToStack82724 {

    int[] stack = new int[10000];
    int top = -1;
    int answer = 0;

    public static void main(String[] args) {
        ArrayToStack82724 q = new ArrayToStack82724();
        String[] command = {"push 3", "push 1", "pop", "push 5"};

        System.out.println(q.solution(command));
    }

    private int solution(String[] command) {
        for (int i = 0; i < command.length; i++) {
            if (command[i].equals("pop")) {
                funcC();
            } else { // push
                int x = command[i].charAt(5) - '0';
                funcA(x);
            }
        }
        funcB();
        return answer;
    }

    void funcA(int x) {
        top++;
        stack[top] = x;
    }

    void funcB() {
        answer = top+1;
    }

    void funcC() {
        top--;
    }
}
