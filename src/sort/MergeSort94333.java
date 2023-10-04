package sort;

import java.util.Arrays;

/**
 * 94333. 병합 정렬_빈칸채우기
 * 병합정렬을 사용해서 오름차순 정렬
 */
public class MergeSort94333 {
    public static void main(String[] args) {
        MergeSort94333 q = new MergeSort94333();
        int[] sequence = {6, 2, -3, 0};

        System.out.println(Arrays.toString(q.solution(sequence)));
    }

    public int[] solution(int[] sequence) {
        int size = sequence.length;
        int[] temp = new int[size];

        mergeSort(sequence, temp, 0, size - 1);

        return sequence;
    }

    private void mergeSort(int[] sequence, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 분할
            mergeSort(sequence, temp, left, mid);
            mergeSort(sequence, temp, mid + 1, right);

            // 정복 (병합)
            merge(sequence, temp, left, mid, right);
        }
    }

    private void merge(int[] sequence, int[] temp, int left, int mid, int right) {
        int i = left;       // 좌측 배열 인덱스
        int j = mid + 1;    // 우측 배열 인덱스
        int k = left;       // 병합한 배열 인덱스

        // 두 배열을 비교하며 작은 값부터 임시 배열에 저장
        while (i <= mid && j <= right) {
            if (sequence[i] <= sequence[j]) {
                temp[k++] = sequence[i++];
            } else {
                temp[k++] = sequence[j++];
            }
        }

        // 남은 원소들을 임시 배열에 복사
        while (i <= mid) {
            temp[k++] = sequence[i++];
        }
        while (j <= right) {
            temp[k++] = sequence[j++];
        }

        // 임시 배열의 내용을 원래 배열에 복사
        if (right + 1 - left >= 0) System.arraycopy(temp, left, sequence, left, right + 1 - left);

//        for (int idx = left; idx <= right; idx++) {
//            sequence[idx] = temp[idx];
//        }

    }
}
