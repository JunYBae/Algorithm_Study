import java.util.ArrayList;
import java.util.Comparator;
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
	public int compareTo(Point o) {
		if (this.minute == o.minute) {
			return Integer.compare(Math.abs(this.distance - Main.K), 
					Math.abs(o.distance - Main.K));
		} 
			
		return Integer.compare(this.minute, o.minute);
	}
}

public class Main {
	
	static int N, K, count, min_minute;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		min_minute = Integer.MAX_VALUE;
		count = 0;
		
		search(new Point(N, 0));
		
		System.out.println(min_minute);
		System.out.println(count);
	}
	
	public static void search(Point start) {
		
		PriorityQueue<Point> queue = new PriorityQueue<>();
		HashSet<Integer> visit = new HashSet<>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			
			Point point = queue.poll();
			visit.add(point.distance);
			
			if (point.minute > min_minute)
				continue;
			
			
			if (point.distance == K) {
				if (min_minute > point.minute) {
					min_minute = point.minute;
					count = 1;
				} 
				else if (min_minute == point.minute) {
					count++;
				}
				continue;
			}
		
			
			if (!visit.contains(point.distance-1)) {
				queue.add(new Point(point.distance-1, point.minute+1));
			}
			
			if (!visit.contains(point.distance+1)) {
				queue.add(new Point(point.distance+1, point.minute+1));
			}
			
			if (!visit.contains(point.distance*2) && 
					Math.abs(point.distance*2-K) < Math.abs(point.distance - K)) {
				queue.add(new Point(point.distance*2, point.minute+1));
			}
			
			//System.out.println("cur_distance : " + point.distance);
			
			//queue.stream().forEach(t -> System.out.println(t.distance + " - " + t.minute));
		}
	}
}









