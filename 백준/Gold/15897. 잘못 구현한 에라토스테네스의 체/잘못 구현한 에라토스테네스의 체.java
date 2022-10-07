import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); //N--를 하고 아래 N을 전부 +1 해주어도 된다.
		long result=0;
		
		//문제의 핵심: N/((N/i)+1)이 다음 횟수증가의 인덱스값을 반환한다는 것이다. 이 규칙을 이용해 O(N)을 줄일 수 있다.
		//어떻게 이런 생각을 할 수 있을까...
		for(int i=N; i!=0; i=(N-1)/(((N-1)/i)+1)){ // i 는 N이 만약 12라면 12부터 시작해...?
			result+=((N-1)/i+1)*(i-((N-1)/(((N-1)/i)+1)));
		}
		System.out.println(result);
	}

}

