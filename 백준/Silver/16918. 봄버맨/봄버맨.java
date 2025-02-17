import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int r, c;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        char[][] map = new char[r][c];

        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if(n == 1) {
            printMap(map);
            return;
        }

        if(n % 2 == 0) {
            char[][] full = new char[r][c];
            for(int i = 0; i < r; i++) {
                Arrays.fill(full[i], 'O');
            }

            printMap(full);
            return;
        }

        char[][] boardA = getExplosion(map);
        char[][] boardB = getExplosion(boardA);

        if(n % 4 == 3) {
            printMap(boardA);
        } else {
            printMap(boardB);
        }
    }

    private static char[][] getExplosion(char[][] map) {
        char[][] res = new char[r][c];
        for(int i = 0; i < r; i++) {
            Arrays.fill(res[i], 'O');
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'O') {
                    res[i][j] = '.';

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (isIn(nr, nc)) {
                            res[nr][nc] = '.';
                        }
                    }
                }
            }
        }

        return res;
    }

    private static void printMap(char[][] map) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
