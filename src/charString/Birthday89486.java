package charString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Birthday89486 {
    public static void main(String[] args) {
        Birthday89486 q = new Birthday89486();
        String[] birthday = {"9/27", "10/13", "5/9", "9/4"};

        System.out.println(Arrays.toString(q.solution(birthday)));
    }

    private String[] solution(String[] birthday) {
        ArrayList<LocalDate> list = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        for (String b : birthday) {
            String[] tmp = b.split("/");
            String month = tmp[0].length() != 2 ? "0" + tmp[0] : tmp[0];
            String day = tmp[1].length() != 2 ? "0" + tmp[1] : tmp[1];
            StringBuilder sb = new StringBuilder();
            list.add(LocalDate.parse(sb.append("2023/").append(month).append("/").append(day).toString(), formatter));
        }

        Collections.sort(list);

        String[] answer = new String[birthday.length];
        int idx = 0;
        for (LocalDate l : list) {
            answer[idx++] = l.format(DateTimeFormatter.ofPattern("MM/dd"));
        }

        return answer;
    }
}
