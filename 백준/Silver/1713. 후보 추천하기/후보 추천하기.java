import java.util.*;
import java.io.*;

class Cache {
	int id, referenced, stamp;
	Cache() {
		id =-1; referenced =0;
		stamp=-1;
	}
}
public class Main {

	static Cache[] cache ;
	static int N, M;
	
	static int FindV() { //교체 당할 아이디.
		int min = Integer.MAX_VALUE;
		int mini=-1, ts=-1;
		
		for(int i=0; i<N; i++) {
			if(cache[i].id == -1) {
				return i;
			}
			if(min>cache[i].referenced) {
				min = cache[i].referenced;
				mini = i; ts = cache[i].stamp;
			}
			else if (min==cache[i].referenced) {
				if(cache[i].stamp < ts) {
					ts = cache[i].stamp;
					mini=i;
				}
			}
		}
		return mini;
	}
	
	static int Hit(int id) {
		for(int i=0; i<N; i++) {
			if(id == cache[i].id) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		cache = new Cache[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cache[i]=new Cache();
		}
		
		for(int i =0; i<M; i++) {
			int r = Integer.parseInt(st.nextToken());
			int h = Hit(r);
			
			if(h!=-1) {
				cache[h].referenced++;
			}
			else {
				int v = FindV();
				cache[v].id=r;
				cache[v].referenced = 1;
				cache[v].stamp = i;
			}
		}
		
		ArrayList<Integer> Arr = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			if(cache[i].id!=-1) {
				Arr.add(cache[i].id);
			}
		}
		Collections.sort(Arr);
		for(int a: Arr) {
			System.out.print(a+" ");
		}
		
	}

}
