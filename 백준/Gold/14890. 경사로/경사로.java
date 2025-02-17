import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L, map[][];
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
        for (int x = 0; x < N; x++) // 활주로 건설 (가로) 
            build_road(map[x].clone());
         
        for (int y = 0; y < N; y++) {
            int temp[] = new int[N];
            for (int x = 0; x < N; x++) {
                temp[x] = map[x][y];
            }
            build_road(temp);
        }
        System.out.println(answer);
		
	}
	
	public static void build_road (int arr[]) {
		
		int count = 0;
		int prev_num = arr[0];
			
		for (int i = 0; i < N; i++) {
			
			if (prev_num == arr[i]) {
				count++;
			} else if (Math.abs(prev_num - arr[i]) > 1) {
				return;
			} else if (prev_num < arr[i]) {
				if (count >= L) 
					count = 1;
				else 
					return;
			} else if (prev_num > arr[i]) {
				
				if (is_possible(i, arr)) {
					count = 0;
					i += L - 1;
				}
				else
					return;
			}
			prev_num = arr[i];
		}
		answer++;
	}
	
	public static boolean is_possible(int index, int arr[]) {
		
		int select = arr[index];
		int count = 0;
		
		for (int i = index; i < index+L && i < N; i++) {
			if (arr[i] == select)
				count++;
		}
		
		if (count == L)
			return true;
		else
			return false;
	}
	
}
