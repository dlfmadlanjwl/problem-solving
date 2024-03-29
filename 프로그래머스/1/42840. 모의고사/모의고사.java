import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    final static int[] student1 = {1, 2, 3, 4, 5};
    final static int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    final static int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        int[] scores = new int[3];

        for(int i=0;i<answers.length;i++){
            int student1Answer = student1[i%5];
            int student2Answer = student2[i%8];
            int student3Answer = student3[i%10];

            if(student1Answer==answers[i]) scores[0]++;
            if(student2Answer==answers[i]) scores[1]++;
            if(student3Answer==answers[i]) scores[2]++;
        }
        int max = Arrays.stream(scores).max().getAsInt();

        return IntStream.range(0,3).filter(i->scores[i]==max).map(i->i+1).toArray();
    }
}