import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, korean, english, math));
        }
        Collections.sort(list, (a,b)->{
            if(a.korean != b.korean) return b.korean - a.korean;
            if(a.english != b.english) return a.english - b.english;
            if(a.math != b.math) return b.math - a.math;
            for(int i=0;i<Math.min(a.name.length(), b.name.length());i++){
                if(a.name.charAt(i) != b.name.charAt(i)) return a.name.charAt(i) - b.name.charAt(i);
            }
            return a.name.length() - b.name.length();
        });
        list.forEach(student -> System.out.println(student.name));
    }

    static class Student{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
