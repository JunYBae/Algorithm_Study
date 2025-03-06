import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int N, map[][];
     
    public static void main(String[] args) throws IOException {
         
        // br, st 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
         
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            String move = st.nextToken();
             
            map = new int[N][N];
             
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine(), " "); 
                for (int y = 0; y < N; y++)
                    map[x][y] = Integer.parseInt(st.nextToken());
            }
             
             
            switch(move) {
            case "left":
                left_move(map);
                break;
            case "right":
                right_move(map);
                break;
            case "up":
                up_move(map);
                break;
            case "down":
                down_move(map);
                break;
            }
             
             
            sb.append("#").append(test_case).append("\n");
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++)
                    sb.append(map[x][y]).append(" ");
                sb.append("\n");
            }
        }
         
        System.out.println(sb.toString());
    }
     
    public static void left_move(int map[][]) {
         
        for (int x = 0; x < N; x++) {
             
            ArrayList<Integer> save = new ArrayList<Integer>();
            int prev_num = -1;
             
            for (int y = 0; y < N; y++) {
                 
                if (map[x][y] == 0)
                    continue;
                 
                else if (prev_num == -1)
                    prev_num = map[x][y];
                 
                else if (prev_num != map[x][y]) {
                    save.add(prev_num);
                    prev_num = map[x][y];
                }
                 
                else if (prev_num == map[x][y]) {
                    save.add(map[x][y] + map[x][y]);
                    prev_num = -1;
                }
   
            }
                     
            if (prev_num != -1)
                save.add(prev_num);
             
            int y = 0;
            for (int num : save)
                map[x][y++] = num;
             
            for (; y < N; y++)
                map[x][y] = 0;
             
        }
    }
     
    public static void right_move(int map[][]) {
         
        for (int x = 0; x < N; x++) {
             
            ArrayList<Integer> save = new ArrayList<Integer>();
            int prev_num = -1;
             
            for (int y = N-1; y >= 0; y--) {
                 
                if (map[x][y] == 0)
                    continue;
                 
                else if (prev_num == -1)
                    prev_num = map[x][y];
                 
                else if (prev_num != map[x][y]) {
                    save.add(prev_num);
                    prev_num = map[x][y];
                }
                 
                else if (prev_num == map[x][y]) {
                    save.add(map[x][y] + map[x][y]);
                    prev_num = -1;
                }
   
            }
             
             
            if (prev_num != -1)
                save.add(prev_num);
             
            int y = N-1;
             
            for (int num : save)
                map[x][y--] = num;
             
            for (; y >= 0; y--)
                map[x][y] = 0;
         
        }
    }
     
    public static void up_move(int map[][]) {
         
        for (int y = 0; y < N; y++) {
             
            ArrayList<Integer> save = new ArrayList<Integer>();
            int prev_num = -1;
             
            for (int x = 0; x < N; x++) {
                 
                if (map[x][y] == 0)
                    continue;
                 
                else if (prev_num == -1)
                    prev_num = map[x][y];
                 
                else if (prev_num != map[x][y]) {
                    save.add(prev_num);
                    prev_num = map[x][y];
                }
                 
                else if (prev_num == map[x][y]) {
                    save.add(map[x][y] + map[x][y]);
                    prev_num = -1;
                }
                 
            }
             
            if (prev_num != -1)
                save.add(prev_num);
             
            int x = 0;
            for (int num : save)
                map[x++][y] = num;
             
            for (; x < N; x++)
                map[x][y] = 0;
             
        }
 
    }
     
    public static void down_move(int map[][]) {
         
        for (int y = 0; y < N; y++) {
             
            ArrayList<Integer> save = new ArrayList<Integer>();
            int prev_num = -1;
             
            for (int x = N-1; x >= 0; x--) {
                 
                if (map[x][y] == 0)
                    continue;
                 
                else if (prev_num == -1)
                    prev_num = map[x][y];
                 
                else if (prev_num != map[x][y]) {
                    save.add(prev_num);
                    prev_num = map[x][y];
                }
                 
                else if (prev_num == map[x][y]) {
                    save.add(map[x][y] + map[x][y]);
                    prev_num = -1;
                }
                 
            }
             
            if (prev_num != -1)
                save.add(prev_num);
             
            int x = N-1;
            for (int num : save)
                map[x--][y] = num;
             
            for (; x >= 0; x--)
                map[x][y] = 0;
             
        }
 
    }
}