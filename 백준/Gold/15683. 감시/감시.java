import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    private static List<Map<Position, Integer>> choices = new ArrayList<>();
    private static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        List<Position> cctvs = new ArrayList<>();
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (room[i][j] >= 1 && room[i][j] < 6) {
                    cctvs.add(new Position(i, j));
                }
            }
        }

        dfs(cctvs, new HashMap<>(), 0);

        int answer = Integer.MAX_VALUE;
        for (Map<Position, Integer> choice : choices) {
            int[][] check = new int[room.length][room[0].length];
            for (int i = 0; i < check.length; i++) {
                check[i] = Arrays.copyOf(room[i], room[i].length);
            }
            for (Position position : choice.keySet()) {
                int direction = choice.get(position);
                if (check[position.y][position.x] == 1) {
                    checkOne(check, position.y, position.x, direction);
                } else if (check[position.y][position.x] == 2) {
                    checkTwo(check, position.y, position.x, direction);
                } else if (check[position.y][position.x] == 3) {
                    checkThree(check, position.y, position.x, direction);
                } else if (check[position.y][position.x] == 4) {
                    checkFour(check, position.y, position.x, direction);
                } else if (check[position.y][position.x] == 5) {
                    checkFive(check, position.y, position.x, direction);
                }
            }

            answer = Math.min(count(check), answer);
        }
        System.out.println(answer);
    }

    private static int count(int[][] room) {
        int count = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (room[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void checkOne(int[][] arr, int y, int x, int direction) {
        if (direction == 0) {
            for (int i = y - 1; i >= 0; i--) {
                if (arr[i][x] == 6) {
                    break;
                }
                if (arr[i][x] != -1 && arr[i][x] != 0) {
                    continue;
                }
                arr[i][x] = -1;
            }
        } else if (direction == 1) {
            for (int i = x - 1; i >= 0; i--) {
                if (arr[y][i] == 6) {
                    break;
                }
                if (arr[y][i] != -1 && arr[y][i] != 0) {
                    continue;
                }
                arr[y][i] = -1;
            }
        } else if (direction == 2) {
            for (int i = y + 1; i < arr.length; i++) {
                if (arr[i][x] == 6) {
                    break;
                }
                if (arr[i][x] != -1 && arr[i][x] != 0) {
                    continue;
                }
                arr[i][x] = -1;
            }
        } else if (direction == 3) {
            for (int i = x + 1; i < arr[0].length; i++) {
                if (arr[y][i] == 6) {
                    break;
                }
                if (arr[y][i] != -1 && arr[y][i] != 0) {
                    continue;
                }
                arr[y][i] = -1;
            }
        }
    }

    private static void checkTwo(int[][] room, int y, int x, int direction) {
        if (direction == 0 || direction == 2) {
            checkOne(room, y, x, 0);
            checkOne(room, y, x, 2);
        } else if (direction == 1 || direction == 3) {
            checkOne(room, y, x, 1);
            checkOne(room, y, x, 3);
        }
    }

    private static void checkThree(int[][] room, int y, int x, int direction) {
        if (direction == 0) {
            checkOne(room, y, x, 0);
            checkOne(room, y, x, 3);
        } else if (direction == 1) {
            checkOne(room, y, x, 1);
            checkOne(room, y, x, 0);
        } else if (direction == 2) {
            checkOne(room, y, x, 2);
            checkOne(room, y, x, 1);
        } else if (direction == 3) {
            checkOne(room, y, x, 3);
            checkOne(room, y, x, 2);
        }
    }

    private static void checkFour(int[][] room, int y, int x, int direction) {
        if (direction == 0) {
            checkOne(room, y, x, 0);
            checkOne(room, y, x, 1);
            checkOne(room, y, x, 3);
        } else if (direction == 1) {
            checkOne(room, y, x, 1);
            checkOne(room, y, x, 0);
            checkOne(room, y, x, 2);
        } else if (direction == 2) {
            checkOne(room, y, x, 2);
            checkOne(room, y, x, 1);
            checkOne(room, y, x, 3);
        } else if (direction == 3) {
            checkOne(room, y, x, 3);
            checkOne(room, y, x, 2);
            checkOne(room, y, x, 0);
        }
    }

    private static void checkFive(int[][] room, int y, int x, int direction) {
        checkOne(room, y, x, 0);
        checkOne(room, y, x, 1);
        checkOne(room, y, x, 3);
        checkOne(room, y, x, 2);
    }

    private static void dfs(List<Position> cctvs, Map<Position, Integer> choice, int index) {
        if (index == cctvs.size()) {
            choices.add(new HashMap<>(choice));
            return;
        }
        Position cctv = cctvs.get(index);
        for (int direction = 0; direction < 4; direction++) {
            choice.put(cctvs.get(index), direction);
            dfs(cctvs, choice, index + 1);
            choice.remove(cctvs.get(index));
            if (room[cctv.y][cctv.x] == 5) {
                break;
            }
        }
    }

    private static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}