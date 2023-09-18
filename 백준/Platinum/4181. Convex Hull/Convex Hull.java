import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Hull {
	int x,y;

	public Hull(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class Main {

	public static ArrayList<Hull> P = new ArrayList<>();
	public static Hull first=new Hull(1_000_000_001, 1_000_000_001);

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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			Hull tmp = new Hull(x, y);
			String include = st.nextToken();
			if(include.equals("Y")) {
				P.add(tmp);
				if(tmp.x < first.x) {
					first = tmp;
				} else if(tmp.x==first.x){
					if(tmp.y < first.y) {
						first = tmp;
					}
				}
			}
		}
		P.sort(new Comparator<Hull>() {
			@Override
			public int compare(Hull o1, Hull o2) {
				int value=ccw(first, o1, o2);
				if(value>0) return -1;
				if(value<0) return 1;
				if(value==0) { //만약 직선이라면 좌표에 따라 설정
					if(o1.x != o2.x) {return Integer.compare(o1.x, o2.x);}
					else {
						return Integer.compare(o1.y, o2.y);
					}
				}
				return -1;
			}
		});

		List<Hull> result = new ArrayList<>();
		List<Hull> tmp = new ArrayList<>();
		Stack<Hull> stack=new Stack<>();
		stack.add(first); // 스택에 기준점을 두고

		for(int i=1; i<P.size(); i++) {
			while(stack.size()>1&&ccw(stack.get(stack.size()-2), stack.get(stack.size()-1), P.get(i))<0) {
				tmp.add(stack.get(stack.size()-1)); //중간다리는 일단 저장.
				stack.pop(); //시계방향이라면 2번째 값을 뺀다.
			}
			stack.add(P.get(i)); // 반시계라면 추가한다.
		}

		for(int i=tmp.size()-1; i>=0; i--) { // 중간다리를 다시 스택에 추가 
			stack.add(tmp.get(i));
		}
		

		System.out.println(stack.size());
		for(int i=0; i<stack.size(); i++) {
			Hull point = stack.get(i);
			System.out.println(point.x+" "+point.y);
		}
	}
}
