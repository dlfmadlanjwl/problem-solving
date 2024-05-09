import java.util.*;

public class Solution {
    private static class Student{
        int score;
        int number;

        Student(int score, int number){
            this.score = score;
            this.number = number;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] result = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            List<Student> students = new ArrayList<>();
            for(int i=0;i<N;i++){
                int mid = sc.nextInt();
                int end = sc.nextInt();
                int homework = sc.nextInt();
                students.add(new Student(mid*35 + end*45 + homework*20, i+1));
            }
            Collections.sort(students, (a,b)-> b.score - a.score);

            for(int i=0;i<N;i++){
                if(students.get(i).number==K){
                    System.out.println("#"+(t+1)+" "+result[i/(N/10)]);
                }
            }
        }
    }
}