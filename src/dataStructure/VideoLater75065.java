package dataStructure;

import java.util.LinkedList;
/**
 * 75065. 나중에 볼 동영상_디버깅
 * 영희가 보지 못한 동영상의 개수는?
 */
public class VideoLater75065 {
    public static void main(String[] args) {
        VideoLater75065 q = new VideoLater75065();
        int[] watch = {1, 1, 1, 1, 1, 0, 0};

        System.out.println(q.solution(watch));
    }

    private int solution(int[] watch) {
        int answer = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        int day = 1;

        for (int i = 0; i < watch.length; i++, day++) {
            while (!queue.isEmpty() && day - queue.peek() > 3) { // 현재일 기준 3일이 지난 동영상 비공개
                queue.poll();
                answer++; // 못 본 동영상 개수에 추가
            }
            if (watch[i] == 1) { // 동영상 담기
                queue.offer(day);
            } else if (!queue.isEmpty() && watch[i] == 0) { // 동영상 보기
                queue.poll();
            }
        }
        answer += queue.size();
        return answer;
    }
}
