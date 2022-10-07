import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
class RPoint implements Comparable<RPoint>{
	int x,y;
	RPoint(){
		x=0;y=0;
	}
	@Override
	public int compareTo(RPoint o) {
		return (this.y-o.y);
		//return (o.y-this.y);
	}
}
public class Main {
	static RPoint[] rail;
	static int N;
	
	public static void show() {
		for(int i=0; i<N; i++)
			System.out.println(rail[i].x+" "+rail[i].y);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PriorityQueue <Integer> road=new PriorityQueue <Integer> ();
		PriorityQueue <Integer> road1=new PriorityQueue <Integer> ();
		int max=0;
		N=sc.nextInt();
		rail=new RPoint[N]; 
		int temp=0;

		for(int i=0; i<N; i++) rail[i]=new RPoint();
		for(int i=0; i<N; i++) {
			rail[i].x=sc.nextInt();
			rail[i].y=sc.nextInt();
			if(rail[i].x>rail[i].y) {
				temp=rail[i].x;
				rail[i].x=rail[i].y;
				rail[i].y=temp;
			}
		}
		int d=sc.nextInt();
	
		Arrays.sort(rail);
	
		for(int i=0;i<N; i++) {
		road.add(rail[i].x); road1.add(rail[i].y);
		if(!road.isEmpty()) {
		for(int j=0;!road.isEmpty(); j++)
			if(road.peek()<rail[i].y-d) {
				road.remove();
		}
			else break;
		if(road.size()>=max) max=road.size();
		}
	}
		
		System.out.println(max);
	}
}
