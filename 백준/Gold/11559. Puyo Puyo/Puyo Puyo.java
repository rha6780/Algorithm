import java.util.*;
public class Main{

	public static int[] directr={1, -1, 0, 0};
	public static int[] directc={0, 0, 1, -1};
	public static char[][] field=new char[15][10];
	public static boolean[][] visit=new boolean[15][10];
	public static boolean[][] Rvisit=new boolean[15][10];
	public static char[][] dummy=new char[15][10];
	public static int chain=0;
	public static boolean ischain=false;
	
	public static void BFS(int a, int b){
		dummy=new char[102][102];
		Queue<Integer> quer=new LinkedList<Integer>();
		Queue<Integer> quec=new LinkedList<Integer>();
		int count=1;
		quer.add(a); quec.add(b); visit[a][b]=true;
		while(!quer.isEmpty()&&!quec.isEmpty()){
			int r=quer.poll();int c=quec.poll();
			for(int j=0; j<4; j++){
				if(r+directr[j]>=0&&c+directc[j]>=0&&r+directr[j]<12&&c+directc[j]<6){
				if(visit[r+directr[j]][c+directc[j]]==false&&field[r][c]==field[r+directr[j]][c+directc[j]]){
					quer.add(r+directr[j]);quec.add(c+directc[j]);
					visit[r+directr[j]][c+directc[j]]=true;
					count++;
					
				}}
				
			}
			dummy[r][c]='.';
		}
		
		if(count>=4){ischain=true;makebool();}
		
		
	}
	public static void makebool(){
		for(int i=0; i<12; i++){
			for(int j=0; j<6; j++){
				if(dummy[i][j]=='.'){
					field[i][j]='.';
				}
			}
		}
	}
	
	public static void gravity(){
		
		
		for(int i=10; i>=0; i--){
			for(int j=0; j<6; j++){
				if(field[i][j]!='.'){
					int hhh=0;
					for(int h=i+1; h<12; h++){
						if(field[h][j]=='.'){hhh=h;}
					}
					if(hhh!=0){field[hhh][j]=field[i][j]; field[i][j]='.'; }
				}
			}
		}
		for(int i=0; i<12; i++){
			for(int j=0; j<6; j++){
				
				if(field[i][j]!='.'){visit[i][j]=false;}
			}
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		for(int i=0; i<12; i++){
			String ss=sc.next();
			field[i]=ss.toCharArray();
		}
		while(true){
		for(int i=0; i<12; i++){
			for(int j=0; j<6; j++){
				if(field[i][j]=='.'){visit[i][j]=true;}
				else if(visit[i][j]!=true){BFS(i,j);}
			}
		}
		if(ischain==false){break;}
		if(ischain==true){chain++;gravity(); ischain=false;}
		
		}
		System.out.println(chain);
	}

}
