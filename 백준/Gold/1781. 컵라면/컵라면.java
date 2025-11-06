import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Problem> problems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            Problem problem = new Problem(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            problems.add(problem);
        }

        problems.sort((p1, p2) -> p1.deadline - p2.deadline);
        PriorityQueue<Integer> cups = new PriorityQueue<>();
        for (Problem problem : problems) {
            if (cups.isEmpty()) {
                cups.add(problem.cups);
                continue;
            }
            if (cups.size() < problem.deadline) {
                cups.add(problem.cups);
            } else {
                if (cups.peek() < problem.cups) {
                    cups.poll();
                    cups.add(problem.cups);
                }
            }
        }

        System.out.println(cups.stream().mapToInt(i -> i).sum());
    }

    private static class Problem {
        int deadline;
        int cups;

        public Problem(int deadline, int cups) {
            this.deadline = deadline;
            this.cups = cups;
        }
    }
}