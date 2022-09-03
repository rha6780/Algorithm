import java.util.*;
public class Main {

	public static int[] distance=new int[10001];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		int result=0;
		distance=new int[N+1];
		for(int i=0; i<N; i++) {
			distance[i]=sc.nextInt();
		}
		
		distance[N]=0;
		Arrays.sort(distance);
		
		int ind=0;
		while (distance[ind] <0) ind++; //
		if (distance[0]+distance[N] >=0) {	//양의 방향의 책이 더 멀경우
				int ii = 0;
				while (ii < ind) {
					result += -distance[ii]*2;
					ii +=M;
				}
				ii = N;
				result -= distance[ii];
				while (ii >ind) {
					result += distance[ii]*2;
					ii -=M;
				}
		}
		else{	// 음의 방향의 책이 더 멀경우
			int id = N;
			while (id >ind) {
				result += distance[id]*2;
				id -=M;
			}		
			id = 0;
			result -= -distance[id];
			while (id < ind) {
				result += -distance[id]*2;
				id +=M;
			}
		}
		System.out.println(result);
	}
}