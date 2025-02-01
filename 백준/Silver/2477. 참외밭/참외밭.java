import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	static ArrayList<Integer> gak = new ArrayList<>();
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 1m^2 당 참외 개수
		
		int dir_len[][] = new int[6][6]; // 거리 및 방향 배열
		
		for (int i = 0; i < 6; i++)
		{
			dir_len[i][0] = sc.nextInt();
			dir_len[i][1] = sc.nextInt();
		}
		
		long max_width_len = 0, max_length_len = 0;
		int max_width_index = 0, max_length_index = 0;
		
		for (int i = 0; i < 6; i++)
		{
			if (dir_len[i][0] <= 2 && max_width_len < dir_len[i][1]) { // 동, 서
				max_width_index = i;
				max_width_len = dir_len[i][1];
			}
			
			else if (dir_len[i][0] >= 3 && max_length_len < dir_len[i][1]) { // 남, 북
				max_length_index = i;
				max_length_len = dir_len[i][1];
			}
		}
		
		long min_width_len = Math.abs(dir_len[((max_length_index - 1) % 6 + 6) % 6][1] - dir_len[(max_length_index + 1) % 6][1]);
		long min_length_len = Math.abs(dir_len[(max_width_index + 1) % 6][1] - dir_len[((max_width_index - 1) % 6 + 6) % 6][1]);
		
		//System.out.println(min_width_len + ", " + min_length_len);
		
		System.out.println(((max_width_len * max_length_len) - (min_width_len * min_length_len)) * T);
		
		sc.close();
	}
}