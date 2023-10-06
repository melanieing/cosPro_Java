package sort;

import java.util.Arrays;

/**
 * 75061. 티케팅_빈칸채우기
 * seats를 문제에 주어진 조건대로 정렬
 */
public class Ticketing75061 {
    public static void main(String[] args) {
        Ticketing75061 q = new Ticketing75061();
        int[][] seats = {{15, 15}, {10, 10}, {5, 5}, {30, 15}, {1, 15}};

        System.out.println(Arrays.deepToString(q.solution(seats)));
    }

    private int[][] solution(int[][] seats) {
        for (int i = seats.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (seats[j][1] > seats[j + 1][1]) { // 열 번호가 작은 좌석
                    int[] temp = seats[j];
                    seats[j] = seats[j + 1];
                    seats[j + 1] = temp;
                } else if (seats[j][1] == seats[j + 1][1]) { // 열 번호가 같다면
                    if (Math.abs(seats[j][0] - 15) > Math.abs(seats[j + 1][0] - 15)) { // 행 번호가 무대 중앙에 더 가까운 좌석
                        int[] temp = seats[j];
                        seats[j] = seats[j + 1];
                        seats[j + 1] = temp;
                    }
                }
            }
        }
        return seats;
    }
}
