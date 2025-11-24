import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Wheel> wheelList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            List<Integer> tooth = new ArrayList<>();
            for (char c : input) {
                tooth.add(c - '0');
            }
            wheelList.add(new Wheel(tooth));
        }
        Wheels wheels = new Wheels(wheelList);

        int k = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int wheelIdx = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            wheels.turn(wheelIdx, direction);
        }

        List<Wheel> wheels1 = wheels.wheels;
        int sum = 0;
        sum += wheels1.get(0).toothes.get(0) == 0 ? 0 : 1;
        sum += wheels1.get(1).toothes.get(0) == 0 ? 0 : 2;
        sum += wheels1.get(2).toothes.get(0) == 0 ? 0 : 4;
        sum += wheels1.get(3).toothes.get(0) == 0 ? 0 : 8;
        System.out.println(sum);
    }

    private static class Wheels {
        List<Wheel> wheels;

        public Wheels(List<Wheel> wheels) {
            this.wheels = wheels;
        }

        void turn(int index, int direction) {
            int left = index;
            int right = index;
            for (int i = index; i > 0; i--) {
                if (!wheels.get(i).isSameOnLeft(wheels.get(i - 1))) {
                    left = i - 1;
                } else {
                    break;
                }
            }
            for (int i = index; i < wheels.size() - 1; i++) {
                if (!wheels.get(i).isSameOnRight(wheels.get(i + 1))) {
                    right = i + 1;
                } else {
                    break;
                }
            }
            wheels.get(index).turn(direction);
            int currDirection = direction;
            for (int i = index - 1; i >= left; i--) {
                currDirection *= -1;
                wheels.get(i).turn(currDirection);
            }
            currDirection = direction;
            for (int i = index + 1; i <= right; i++) {
                currDirection *= -1;
                wheels.get(i).turn(currDirection);
            }
        }
    }

    private static class Wheel {
        List<Integer> toothes;

        Wheel(List<Integer> toothes) {
            this.toothes = toothes;
        }

        boolean isSameOnRight(Wheel right) {
            return this.toothes.get(2).equals(right.toothes.get(6));
        }

        boolean isSameOnLeft(Wheel left) {
            return this.toothes.get(6).equals(left.toothes.get(2));
        }

        void turn(int direction) {
            if (direction == 1) {
                toothes.add(0, toothes.remove(toothes.size() - 1));
            } else {
                toothes.add(toothes.size() - 1, toothes.remove(0));
            }
        }
    }
}