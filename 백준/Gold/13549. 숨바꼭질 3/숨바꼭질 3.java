import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;




class Point implements Comparable<Point> {
	int distance, minute;
	
	Point(int distance, int minute) {
		this.distance = distance;
		this.minute = minute;
	}
	
	@Override
	public int compareTo(Point other) {
		if (this.minute == other.minute)
			return Integer.compare(Math.abs(this.distance - Main.K), 
					Math.abs(other.distance - Main.K));
		
		return Integer.compare(this.minute, other.minute);
	}

}


public class Main {
	
	static int N, K, answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 수빈이 위치 
		K = sc.nextInt(); // 동생 위치 
		
		answer = search_minute(new Point(N, 0));
		
		System.out.println(answer);
	}
	
	public static int search_minute(Point start) {
		
		PriorityQueue<Point> queue = new PriorityQueue<>();
		HashSet<Integer> visit = new HashSet<>(); // 이미 방문한 위치인지?
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
			visit.add(point.distance);
			
			//System.out.println("cur_distance : " + point.distance);
			
			if (point.distance == K) 
				return point.minute;
			
			if (!visit.contains(point.distance-1)) 
					queue.add(new Point(point.distance-1, point.minute+1)); // X-1 이고 1초 걸린다.
			
			if (!visit.contains(point.distance+1)) 
				queue.add(new Point(point.distance+1, point.minute+1)); // X+1 이고 1초 걸린다.
	
			// 만약, 2배 했을 때 기존 거리보다 짧아진다면?
			if (!visit.contains(point.distance * 2) 
					&& Math.abs(point.distance*2 - K) < Math.abs(point.distance - K))
				queue.add(new Point(2*point.distance, point.minute)); // 2*X 이고 0초 걸린다.
			
			//queue.stream().forEach(p-> System.out.println(p.distance + " - " + p.minute));			
		}
		
		return -1;
	}
}