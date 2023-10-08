package combination;

import java.util.ArrayList;
/**
 * 75070. 햄버거 만들기_함수 작성
 * 칼로리가 k 이하이면서 만족도가 s 이상이 되도록 햄버거를 만드는 방법의 수?
 */
public class MakeBurger75070 {

    static int answer = 0; // 방법의 수
    static int caloryLimit = 0; // 칼로리 제한
    static int pointLimit = 0; // 만족도 제한

    public static void main(String[] args) {
        MakeBurger75070 q = new MakeBurger75070();
        int[][] ingredient = {{100, 5}, {200, 20}, {100, 15}};
        int k = 200;
        int s = 20;

        System.out.println(q.solution(ingredient, k, s));
    }

    private int solution(int[][] ingredient, int k, int s) {

        // 객체화해서 배열에 담기
        Food[] foods = new Food[ingredient.length];
        for (int i = 0; i < ingredient.length; i++) {
            foods[i] = new Food(ingredient[i][0], ingredient[i][1]);
        }

        // 정적 변수 초기화
        caloryLimit = k;
        pointLimit = s;

        // 조합 만들기
        for (int r = 1; r <= ingredient.length; r++) {
            combination(foods, new boolean[foods.length], 0, 0, r);
        }

        return answer;
    }

    private void combination(Food[] foods, boolean[] visited, int start, int depth, int r) {
        ArrayList<Food> list = new ArrayList<>();
        if (depth == r) {
            for (int i = 0; i < foods.length; i++) {
                if (visited[i]) {
                    list.add(foods[i]);
                }
            }

            validateCombi(list); // 해당 조합이 조건에 해당하는지 검증
        }

        for (int i = start; i < foods.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(foods, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }

    }

    private void validateCombi(ArrayList<Food> list) {
        int totalCalory = 0;
        int totalPoint = 0;

        for (Food f : list) {
            totalCalory += f.getCalory();
            totalPoint += f.getPoint();
        }

        if (totalCalory <= caloryLimit && totalPoint >= pointLimit) {
            answer++;
        }
    }

    static class Food {
            int calory;
            int point;

            public Food(int calory, int point) {
                this.calory = calory;
                this.point = point;
            }

            public int getCalory() {
                return calory;
            }

            public int getPoint() {
                return point;
            }

        }
    }
