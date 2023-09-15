import java.util.*;

class Hull implements Comparable<Hull>{
	int x; int y;
	public Hull(int x, int y){
		this.x=x; this.y=y;
	}

	@Override
	public int compareTo(Hull o1) {
		if(x==o1.x) {
			return y-o1.y;
		}
		return x-o1.x;
	}
}
public class Main {

	public static List<Hull> P = new ArrayList<Hull>();
	public static int N;
	public static Hull first = new Hull(40001, 40001);

	public static long dist(Hull a1, Hull a2) {
		return (long)(a2.x-a1.x)*(a2.x-a1.x)+(long)(a2.y-a1.y)*(a2.y-a1.y);
	}

	public static int ccw(Hull a, Hull b, Hull c) {
		long cal=0;
		cal=(long)(b.x-a.x)*(c.y-a.y)-(long)(c.x-a.x)*(b.y-a.y);
		if(cal>0) return 1;
		else if(cal<0) return -1;
		else return 0;
	}

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int x=sc.nextInt(); int y=sc.nextInt();
			P.add(new Hull(x,y));
		}

		// 기준점
		for(int i=0; i<N; i++) {
			Hull target = P.get(i);
			if(target.y < first.y) {
				first = target;
			} else if(target.y == first.y) {
				if(target.x < first.x) {
					first = target;
				}
			}
		}
		
		
		P.sort(new Comparator<Hull>() {
			@Override
			public int compare(Hull a, Hull b) {
				int v=ccw(first, a, b);
				if(v>0) return -1;
				if(v<0) return 1;
				if(v==0) {
					long R1 = dist(first,a);
					long R2 = dist(first,b);
					if(R1 > R2) {
						return 1;
					}
				}
				return -1;
			}
		});

		Stack<Hull> stack=new Stack<>();
		stack.add(first);

		for(int i=1; i<P.size(); i++) {
			while(stack.size()>1&&ccw(stack.get(stack.size()-2), stack.get(stack.size()-1), P.get(i))<=0) {
				stack.pop();
			}
			stack.add(P.get(i));
		
		}
		System.out.println(stack.size());

	}

}
