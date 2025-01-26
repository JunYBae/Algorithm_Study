
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int student[][] = new int[7][2];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int room_count = 0;
		
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[grade][gender]++;
		}
		
		for (int grade = 1; grade <= 6; grade++) 
		{
			for (int gender = 0; gender < 2; gender++) 
			{
				int cur_student_num = student[grade][gender];
				if (cur_student_num == 0)
					continue;
				
				room_count += cur_student_num / K + (cur_student_num % K != 0 ? 1 : 0);
			}
		}
		
		bw.write(room_count+"\n");
		bw.flush();
	}
}

