import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int country = Integer.parseInt(stringTokenizer.nextToken());
            int id = Integer.parseInt(stringTokenizer.nextToken());
            int score = Integer.parseInt(stringTokenizer.nextToken());

            students.add(new Student(country, id, score));
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.score - o1.score;
            }
        });

        int[] checked = new int[n + 1];
        List<Student> podium = new ArrayList<>();
        int index = 0;
        while (podium.size() < 3) {
            Student now = students.get(index);
            if (checked[now.country] == 2) {
            } else {
                checked[now.country]++;
                podium.add(now);
            }
            index++;
        }

        for (Student student : podium) {
            System.out.println(student);
        }
    }

    private static class Student {
        int country;
        int id;
        int score;

        public Student(int country, int id, int score) {
            this.country = country;
            this.id = id;
            this.score = score;
        }

        @Override
        public String toString() {
            return country + " " + id;
        }
    }
}