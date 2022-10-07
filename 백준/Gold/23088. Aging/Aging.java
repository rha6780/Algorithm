import java.util.*;
import java.io.*;

class Job implements Comparable<Job> {
	int id, exe, pri;
	public Job(int ii, int pp, int ee) {
		this.id=ii;
		this.pri=pp;
		this.exe=ee;
	}

	@Override
	public int compareTo(Job o) {
		int result = this.pri-o.pri;
		if(result!=0) return result;
		return (this.id-o.id);
	}
}

class Event implements Comparable<Event> {
	int ts, id, ev, pri;
	
	public Event(int tt, int ii, int pp, int ee) {
		ts=tt; id=ii; pri=pp; ev=ee;
	}
	@Override
	public int compareTo(Event o) {
		int result = this.ts-o.ts;
		if(result != 0 ) return result;
		result = this.ev-o.ev;
		if(result != 0) return result;
		return this.pri-o.pri;
	}
	
}

public class Main {

	static PriorityQueue<Job> pq;
	static PriorityQueue<Event> eq;
	static int[][] A;
	static int N;
	static final int On=1, Off=2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		eq = new PriorityQueue<Event>();
		pq = new PriorityQueue<Job>();
		
		N = Integer.parseInt(br.readLine());
		A = new int[N][4];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i][0]=i;
			A[i][1]=Integer.parseInt(st.nextToken());
			A[i][2]=-Integer.parseInt(st.nextToken()) + A[i][1]; //숫자를 작게 만들기 위해 - 붙임. -> 우선 순위 큐 작은 순으로 출력하기 때문.
			A[i][3]=Integer.parseInt(st.nextToken());
			A[i][2]=A[i][2]*1001+A[i][3];
			eq.add(new Event(A[i][1], i, A[i][2], On));
		}
		
		StringBuilder sb = new StringBuilder();
		boolean isrunning = false;
		while(eq.isEmpty() == false) {
			Event ee = eq.poll();
			if(ee.ev == On) {
				int id = ee.id;
				if(isrunning == false) { //수행중이지 않다면 바로 수행
					sb.append((id+1)+" ");
					isrunning = true;
					eq.add(new Event(ee.ts+A[id][3], id, A[id][2], Off));
				}
				else { //수행 중이면 어떤걸 먼저할지 결정해야함.
					pq.add(new Job(id, A[id][2], A[id][3]));
				}
			}
			else {
				if (pq.isEmpty() == true) {
					isrunning= false;
				}
				else {
					Job j = pq.poll(); //우선순위로 결정됨
					int id = j.id;
					sb.append((id+1)+" ");
					eq.add(new Event(ee.ts+A[id][3], id, A[id][2], Off));
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
