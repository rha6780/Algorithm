import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static Scanner sc=new Scanner(System.in);
	public static int T=sc.nextInt();
	
	public static char[][] col=new char[101][101];
	public static boolean[][] visit=new boolean[101][101];

	
	public static void GBFS(int a, int b){
		 Queue<Integer> quer=new LinkedList<Integer>();
		 Queue<Integer> quec=new LinkedList<Integer>();
			
		quer.add(a);
		quec.add(b); 
		visit[a][b]=true;
		while(!quer.isEmpty()&&!quec.isEmpty()){
			int rr=quer.poll(); int cc=quec.poll();
			if(rr-1>=0&&!visit[rr-1][cc]){
				if((col[rr][cc]=='R'||col[rr][cc]=='G')&&(col[rr-1][cc]=='R'||col[rr-1][cc]=='G')){quer.add(rr-1);quec.add(cc);visit[rr-1][cc]=true;}
				else if(col[rr][cc]==col[rr-1][cc]){quer.add(rr-1);quec.add(cc);visit[rr-1][cc]=true;}
			}
			if(rr+1<T&&!visit[rr+1][cc]){
				if((col[rr][cc]=='R'||col[rr][cc]=='G')&&(col[rr+1][cc]=='R'||col[rr+1][cc]=='G')){quer.add(rr+1); quec.add(cc);visit[rr+1][cc]=true;}
				else if(col[rr][cc]==col[rr+1][cc]){quer.add(rr+1); quec.add(cc);visit[rr+1][cc]=true;}
			}
			if(cc-1>=0&&!visit[rr][cc-1]){
				if((col[rr][cc]=='R'||col[rr][cc]=='G')&&(col[rr][cc-1]=='R'||col[rr][cc-1]=='G')){quer.add(rr);quec.add(cc-1);visit[rr][cc-1]=true;}
				else if(col[rr][cc]==col[rr][cc-1]){quer.add(rr);quec.add(cc-1);visit[rr][cc-1]=true;}
			}
			if(cc+1<T&&!visit[rr][cc+1]){
				if((col[rr][cc]=='R'||col[rr][cc]=='G')&&(col[rr][cc+1]=='R'||col[rr][cc+1]=='G')){quer.add(rr); quec.add(cc+1);visit[rr][cc+1]=true;}
				else if(col[rr][cc]==col[rr][cc+1]){quer.add(rr); quec.add(cc+1);visit[rr][cc+1]=true;}
			}
			
		}
	
	}
	public static void BFS(int a,int b){
		 Queue<Integer> quer=new LinkedList<Integer>();
		 Queue<Integer> quec=new LinkedList<Integer>();
			
		quer.add(a);
		quec.add(b);
		
		visit[a][b]=true;
		while(!quer.isEmpty()&&!quec.isEmpty()){
			int rr=quer.poll(); int cc=quec.poll();
			if(rr-1>=0&&!visit[rr-1][cc]){
				if(col[rr][cc]==col[rr-1][cc]){quer.add(rr-1); quec.add(cc);visit[rr-1][cc]=true;}
			}
			if(rr+1<T&&!visit[rr+1][cc]){
				if(col[rr][cc]==col[rr+1][cc]){quer.add(rr+1); quec.add(cc);visit[rr+1][cc]=true;}
			}
			if(cc-1>=0&&!visit[rr][cc-1]){
				if(col[rr][cc]==col[rr][cc-1]){quer.add(rr); quec.add(cc-1);visit[rr][cc-1]=true;}
			}
			if(cc+1<T&&!visit[rr][cc+1]){
				if(col[rr][cc]==col[rr][cc+1]){quer.add(rr); quec.add(cc+1);visit[rr][cc+1]=true;}
			}
		}
	}
	public static void main(String[] args) {
		sc.nextLine();
		for(int i=0; i<T; i++){
			String s=sc.nextLine();
			for(int j=0; j<T; j++){
				col[i][j]=s.charAt(j);
			}
		}
	
		int count=0, Gcount=0;
		for(int i=0; i<T; i++){
			for(int j=0; j<T; j++){
				if(visit[i][j]==false){BFS(i, j); count++;}
			}
		}
		visit=new boolean[T+1][T+1];
		
		for(int i=0; i<T; i++){
			for(int j=0; j<T; j++){
				if(visit[i][j]==false){GBFS(i, j); Gcount++;}
			}
		}
		System.out.println(count+" "+Gcount);

	}

}
