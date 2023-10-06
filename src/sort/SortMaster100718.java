package sort;

import java.util.Arrays;

/**
 * 100718. 정렬 마스터_빈칸채우기
 * 삽입정렬 : 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입
 * 선택정렬 : 배열의 가장 작은 요소부터 선택하여 알맞은 위치로 옮겨 정렬
 * 버블정렬 : 서로 인접한 두 원소의 대소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬
 */
public class SortMaster100718 {
    public static void main(String[] args) {
        SortMaster100718 q = new SortMaster100718();
        int[] sequence = {5,2,3,1};
        String sorting = "Selection Sort";

        System.out.println(Arrays.toString(q.solution(sequence, sorting)));
    }

    private int[] solution(int[] sequence, String sorting) {
        int n = sequence.length;

        switch (sorting) {
            case "Insertion Sort" -> { // 삽입 정렬
                for (int i = 1; i < n; i++) {
                    int key = sequence[i];
                    int j = i - 1;
                    while (j >= 0 && sequence[j] > key) { // 더 큰 값을 뒤로 이동
                        sequence[j + 1] = sequence[j];
                        j--;
                    }
                    sequence[j + 1] = key;
                }
            }
            case "Selection Sort" -> { // 선택 정렬
                for (int i = 0; i < n; i++) {
                    int minIdx = i;
                    for (int j = i + 1; j < n; j++) {
                        if (sequence[j] < sequence[minIdx]) {
                            minIdx = j;
                        }
                    }
                    int temp = sequence[i];
                    sequence[i] = sequence[minIdx];
                    sequence[minIdx] = temp;
                }
            }
            case "Bubble Sort" -> { // 버블 정렬
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (sequence[j] > sequence[j + 1]) {
                            int temp = sequence[j];
                            sequence[j] = sequence[j + 1];
                            sequence[j + 1] = temp;
                        }
                    }
                }
            }
        }
        return sequence;
    }
}
