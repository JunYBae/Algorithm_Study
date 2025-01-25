
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	
	static TreeMap<Integer, Integer> map = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
	
		for (int index = 0; index < N; index++)
		{
			String st[] = br.readLine().split(" ");
			int start = 1000000000 + Integer.parseInt(st[0]);
			int end = 1000000000 + Integer.parseInt(st[1]);
			map.put(start, end);
		}
		
		
		Set<Integer> keyset =  map.keySet();
		
		int start_min = 0;
		int end_min = 0;
		int size = 0;
		
		for (int start : keyset) {
			start_min = start;
			end_min = map.get(start);
			break;
		}
		
		for (int start : keyset)
		{
			int end = map.get(start);
			
			if (start_min <= start && end_min >= end) {// 안에 있을 때
			}
			
			else if (start_min >= start && end_min <= end) { // 기본 선보다 더 클 때
				start_min = start;
				end_min = end;
			}
			
			else if (start_min >= start && end >= start_min && end_min >= end) { // 밖에 있을 떄 & 왼쪽
				start_min = start;
			}
			
			else if (start_min <= start && start <= end_min && end_min <= end) { // 밖에 있을 때 & 오른쪽
				end_min = end;
			}
			
			else { // 완전 다른 곳에 있을 떄
				end_min -= 1000000000;
				start_min -= 1000000000;
				size += end_min - start_min;
				start_min = start;
				end_min = end;
			}
			
			//System.out.println("start : " + (start_min - 1000000000) + ", end : " + (end_min - 1000000000)
			//		+ ", size : " + size);
		}
		
		end_min -= 1000000000;
		start_min -= 1000000000;
		size += end_min - start_min;
		
		//System.out.println("size : " + size);
		bw.write(size+"");
		bw.flush();
	}
}
