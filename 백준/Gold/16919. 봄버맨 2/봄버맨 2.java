import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static int R, C, N;
    static int map[][], extend_map[][], fill_map[][], final_map[][];
    static int dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static ArrayList<Point> init_bomb = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 기준 초
        
        map = new int[R][C];
        extend_map = new int[R][C];
        fill_map = new int[R][C];
        final_map = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            
            Arrays.fill(fill_map[i], 1);
            Arrays.fill(extend_map[i], 1);
            Arrays.fill(final_map[i], 1);
            
            for (int j = 0; j < C; j++) {
                if(str.charAt(j) == '.')
                    map[i][j] = 0;
                else {
                    map[i][j] = 1;
                    init_bomb.add(new Point(i, j));
                }
            }        
        }
        
        // 초기 폭탄 터진 맵 만들기 위해 사용 
        for (Point point : init_bomb) {
            
            extend_map[point.x][point.y] = 0;
            
            for (int i = 0; i < 4; i++) {
                
                int x = point.x + dir[i][0];
                int y = point.y + dir[i][1];
                
                if (is_In(x, y)) {
                    extend_map[x][y] = 0;
                }
            }
        }
        
        // 두번쨰 폭탄 터진 맵 만들기 위해 사용
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		if(extend_map[i][j] == 1) {
        				final_map[i][j] = 0;
        			for (int index = 0; index < 4; index++) {
        				
        				int x = i + dir[index][0];
        				int y = j + dir[index][1];
        				
        				if (is_In(x, y)) {
        					final_map[x][y] = 0;
        				}
        			}
        			
        		}
        	}
        }
        
        
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(extend_map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        
        
        if (N <= 1) {
            print_map(map);
        } else if (N % 2 == 0) {
            print_map(fill_map);
        } else if (N % 4 == 1) {
            print_map(final_map);
        } else if (N % 4 == 3) {
            print_map(extend_map);
        }
        
         
        
    }
    
    public static void print_map(int arr[][]) {
        
                
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = 0; j < arr[i].length; j++) 
            {
                if (arr[i][j] == 0) 
                    System.out.print(".");
                else
                    System.out.print("O");
            }
            System.out.println();
        }
        
    }
    
    
    public static boolean is_In(int x, int y) {
        if(x >= 0 && y >= 0 && x < R && y < C)
            return true;
        return false;
    }
}