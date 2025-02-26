import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
	int start, end;
	
	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if (this.start != o.start)
			return Integer.compare(this.start, o.start);
		return Integer.compare(this.end, o.end);
	}
}

public class Main {
	
	static int N, max_time, time[];
	static ArrayList<Meeting> meeting_list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 회의 개수
		meeting_list = new ArrayList<>(N); // 미팅 리스트 
		max_time = 0; // 최고로 늦게끝나는 시간 저장 
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if (end > max_time) 
				max_time = end;
			
			meeting_list.add(new Meeting(start, end));
		}
		
		Collections.sort(meeting_list);
		
		// 타임 배열 만듬 (DP 로 해결하기 위해서)
		time = new int[max_time+1];
		
		// 미팅 리스트를 차례대로 하나씩 빼옴		
		for (Meeting cur_meet : meeting_list) {	
			// 현재 미팅의 시작시간에 해당하는 타임배열의 값을 가져옴
			// 왜? 시작시간 앞에 끝낼 수 있는 회의들 개수를 합해서 더하기 위함 
			int temp = time[cur_meet.start] + 1;
			
			for (int i = cur_meet.end; i <= max_time; i++) {
				if (time[i] < temp)
					time[i] = temp;
			}
		}
		
		
		System.out.println(time[max_time]);
	}
}












