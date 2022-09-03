import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int G = sc.nextInt();
		
		int result=-1;
		
		boolean[] visit = new boolean[100001];
		int[] count = new int[100001];
		Arrays.fill(count, Integer.MAX_VALUE);
		Queue<Integer> que = new LinkedList<Integer>();
		visit[N]=true;
		count[N]=0;
		que.add(N);
		while (!que.isEmpty()) {
			int nn = que.poll();
			visit[nn]=true;
			if(nn==G) {
				result = count[nn];
				break;
			}
			//B버튼
			int nb = nn*2;
			if(nb<=99999 && nb>0) {
				
				int index = 0;
				String tempb = ""+nb;
				
				for(int i=0; i<tempb.length(); i++) {
					int temp = Integer.parseInt(tempb.charAt(i)+"");
					if(temp > 0) {
						index = i;
						break;
					}
				}
				
				String revert = "";
				
				for(int i=0; i<tempb.length(); i++) {
					if(index==i && tempb.charAt(i)>0) {
						int bb = tempb.charAt(i)-'0';
						bb--;
						revert = revert+""+bb;
					}
					else {
						revert = revert+tempb.charAt(i);
					}
				}
				
				int tt = Integer.parseInt(revert);
				
				if(tt>=0&&!visit[tt] && count[nn]+1<=T) {
					visit[tt]=true;
					count[tt]=count[nn]+1;
					que.add(tt);
				}
			}
			
			
			//A버튼
			int na = nn+1;
			if(na>=0 && na<=99999 && !visit[na] && count[nn]+1<=T) {
				visit[na]=true;
				count[na]=count[nn]+1;
				que.add(na);
			}
			
		}
		
		if(result == -1) {
			System.out.println("ANG");
		}
		else {
			System.out.println(result);
		}
		
		
	}

}
