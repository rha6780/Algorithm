import java.util.*;
import java.io.*;

class segmentLog {
	static int N;
	static long[] Stree;
	
	segmentLog(long[] a, int n) { // 트리 최하단 노드 구성
		N=n;
		int h = (int) Math.ceil(Math.log((double)N)/Math.log(2));
		int t = 1;
		for(int i=0; i<=h; i++) {
			t*=2;
		}
		build(a, 0, 0, N-1);
	}
	segmentLog(int n) { //트리 크기 구성
		N=n;
		int h = (int) Math.ceil(Math.log((double)N)/Math.log(2));
		int t = 1;
		for(int i=0; i<=h; i++) {
			t*=2;
		}
		Stree = new long[t];
	}
	void build (long[] a, int index, int start, int end) { // 트리 부모 노드 구성
		if (start == end) Stree[index] = a[start];
		else {
			int mid = (int)((start+end)>>1);
			build(a, index*2+1, start, mid);
			build(a, index*2+2, mid+1, end);
			Stree[index]=Stree[2*index+1]+Stree[2*index+2];
		}
	}
	
	void Update(int old, long amt, int sid, int start, int end) { // 노드 업데이트
		if(old<start || old>end) return;
		if(start != end) {
			Update(old, amt, sid*2+1, start, (start+end)/2);
			Update(old, amt, sid*2+2, (start+end)/2+1, end);
			Stree[sid] = Stree[sid*2+1] + Stree[sid*2+2];
		}
		else {
			Stree[sid] = amt;
		}
	}
	
	void Increase (int oid, long amt, int sid, int start, int end) { //합해서 구성하기
		if(oid<start || oid>end) return;
		if(start != end) {
			Increase(oid, amt, sid*2+1, start, (start+end)/2);
			Increase(oid, amt, sid*2+2, (start+end)/2+1, end);
			Stree[sid] = Stree[sid*2+1] + Stree[sid*2+2];
		}
		else {
			Stree[sid] += amt;
		}
	}
	
	int Kth (long k, int sid, int start, int end) {// k를 기준으로 구하기.
		int res;
		if(start == end) res = start;
		else if(Stree[sid*2+1] > k) {
			res =Kth(k, sid*2+1, start, (start+end)/2);
		}
		else {
			res =Kth(k-Stree[sid*2+1], sid*2+2, (start+end)/2+1, end);
		}
		return res;
	}
	
	long Query (int left, int right, int sid, int start, int end) { // 구간합구하기
		long res;
		if (left > end || right < start) res=0;
		else if (start >= left && end <= right) res= Stree[sid];
		else {
			res = Query(left, right, sid*2+1, start, (start+end)/2)+
				Query(left, right, sid*2+2, (start+end)/2+1, end);
			//System.out.println(left+" "+right+" "+res);
		}
		return res;
	}
	
	int Kth(long k) { return Kth(k, 0, 0, N-1); }
	long Query(int left, int right) { return Query(left, right, 0, 0, N-1); }
	void Update(int oid, long amt) { Update(oid, amt, 0, 0, N-1); }
	void Increase(int oid, long amt) { Increase(oid, amt, 0, 0, N-1); }
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		segmentLog tree;
		tree = new segmentLog(N);
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				tree.Increase(b-1, c);
			}
			else if(a==2) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				System.out.println(tree.Query(b-1, c-1));
			}
			
		}

	}

}
