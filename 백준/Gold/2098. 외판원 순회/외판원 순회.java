import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
	public static int N=0 ,INF=Integer.MAX_VALUE-1000000;
	public static int[][] dp=new int[20][1<<20];
	public static int[][] map=new int[20][1<<20];
	public static int tsp(int cur, int vis){
		
		if(vis==(1<<N)-1){ //모두 방문하였고,
			if(map[cur][0]==0){ //원래도시로 갈 방법이 없다면 최댓값을 리턴한다.
				return INF;
			}
			return map[cur][0];
		}
		
		if(dp[cur][vis]!=0){ //현재 도시에서 지금까지 방문한 도시들의 비용이 0이 아니라면?
			return dp[cur][vis];
		}
		
		dp[cur][vis]=INF;// 비용이 아니면 최댓값넣기
		
		for(int k=0; k<N; k++){
			int next=1<<k;
			if(map[cur][k]==0||(vis&next)>0){
				continue; //갈방법이 없거나 방문하면 다음걸로
			}
			dp[cur][vis]=Math.min(dp[cur][vis], tsp(k, vis|next)+map[cur][k]);
		}
		return dp[cur][vis];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String nn=br.readLine();
		StringTokenizer st=new StringTokenizer(nn);
		N=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++){
			String r=br.readLine();
			st=new StringTokenizer(r);
			for(int j=0; j<N; j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1));
	}

}
