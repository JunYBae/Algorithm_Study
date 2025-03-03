import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Shark extends Point {
    int size, cur_eat;

    public Shark(int x, int y, int size, int cur_eat) {
        super(x, y);
        this.size = size;
        this.cur_eat = cur_eat;
    }

    public void eat() {
        cur_eat++;
        if (cur_eat == size) {
            size++;
            cur_eat = 0;
        }
    }
}

class Fish extends Point implements Comparable<Fish> {
	
	int distance;

	public Fish(int x, int y, int distance) {
		super(x, y);
		this.distance = distance;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.distance != o.distance)
			return Integer.compare(this.distance, o.distance);
		else if (this.x != o.x)
			return Integer.compare(this.x, o.x);
		else
			return Integer.compare(this.y, o.y);
	}
	
}

public class Main {
    static int N, answer, map[][];
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Shark shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[N][N];

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < N; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                if (map[x][y] == 9) {
                    shark = new Shark(x, y, 2, 0);
                }
            }
        }

        simulation();

        sb.append(answer).append("\n");
        System.out.println(sb.toString());
    }

    public static void simulation() {

    	while (true) {
    		ArrayList<Fish> fish_list = find_fish();
    		
    		if(fish_list.size() == 0)
    			return;
    		
    		Collections.sort(fish_list);
    		Fish fish = fish_list.remove(0);
    		
    		map[shark.x][shark.y] = 0;
    		shark.x = fish.x;
    		shark.y = fish.y;
    		shark.eat();
    		map[shark.x][shark.y] = 9; 
    		
    		
    		answer += fish.distance;
        }
    }
    
    public static ArrayList<Fish> find_fish() {
    	
    	ArrayList<Fish> fish_list = new ArrayList<>();
    	
    	ArrayDeque<Point> queue = new ArrayDeque<Point>();
    	queue.add(new Point(shark.x, shark.y));
    	
    	int distance = 0;
    	boolean visit[][] = new boolean[N][N];
    	
    	visit[shark.x][shark.y] = true; 
    	
    	while(!queue.isEmpty()) {
    		
    		int size = queue.size();
    		
    		for (int i = 0; i < size; i++) {
    			
    			Point point = queue.poll();
    			
    			if (map[point.x][point.y] < shark.size && map[point.x][point.y] != 0 && map[point.x][point.y] != 9) {
    				fish_list.add(new Fish(point.x, point.y, distance));
    			} 
    			
    			for (int index = 0; index < dir.length; index++) {
    				int x = point.x + dir[index][0];
    				int y = point.y + dir[index][1];
    				
    				if (is_In(x, y) && !visit[x][y] && map[x][y] <= shark.size) {
    					visit[x][y] = true;
    					queue.add(new Point(x, y));
    				}
    			} 			
    		}
    		
    		if (fish_list.size() != 0)
    			return fish_list;
 
    		distance++;
    	}   	
    	
    	return fish_list;
    }

    private static boolean is_In(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}