package dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 100716. 사진 붙이기_빈칸채우기
 * 마지막에 게시판에 붙어있는 사진 종류를 오름차순 정렬한 결과 출력
 */
public class PicBoard100716 {
    public static void main(String[] args) {
        PicBoard100716 q = new PicBoard100716();
        int n = 3;
        int[] photo = {1, 2, 1, 5, 5, 4, 3};

        System.out.println(Arrays.toString(q.solution(n, photo)));
    }

    private int[] solution(int n, int[] photo) {
        Queue<Integer> board = new LinkedList<>();

        for (int p : photo) {
            if (board.contains(p)) {        // 게시판에 있는 사진 종류라면 사진을 붙이지 않기
                continue;
            } else if (board.size() < n) {  // 게시판에 빈 공간이 있다면, 붙이기
                board.add(p);
            } else {                        // 게시판에 빈 공간이 없다면, 처음에 붙인 사진 제거하고 붙이기
                board.poll();
                board.add(p);
            }
        }


        int[] answer = new int[board.size()];
        for (int i = 0; i < answer.length; i++) { // 큐를 배열로
            answer[i] = board.poll();
        }

        Arrays.sort(answer);
        return answer;
    }


}
