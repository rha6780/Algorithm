import java.util.*;
public class Main {

	public static String[] ss={"U","R","D","L"};
	public static int[][] board;
	public static Queue<Integer> quex=new LinkedList<Integer>();
	public static Queue<Integer> quey=new LinkedList<Integer>();
	public static int N;
	/*
	public static void proc(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}*/
	public static int move(int x, int y){
		int ex=0; int ey=0;
		if(x<0||y<0||x>=N||y>=N)return -1;
		if(!quex.isEmpty()&&!quey.isEmpty()){ex=quex.peek(); ey=quey.peek();}
		if(board[x][y]==1){
			board[x][y]=9;
			board[ex][ey]=9;
			quex.add(x);quey.add(y);
		}
		else if(board[x][y]==9){
			board[x][y]=10;
			board[ex][ey]=10;
			quex.add(x);quey.add(y);
			return -1;
		}
		else if(board[x][y]==0){
			board[x][y]=9;
			board[ex][ey]=0;
			quex.poll(); quey.poll();
			quex.add(x);quey.add(y);
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		board=new int[N][N];
		board[0][0]=9;quex.add(0);quey.add(0);
		int K=sc.nextInt();
		for(int i=0; i<K; i++){
			int a=sc.nextInt(); int b=sc.nextInt();
			board[a-1][b-1]=1;
		}
		int L=sc.nextInt();
		int[] command=new int[L];
		String[] comm=new String[L];
		for(int i=0; i<L; i++){
			command[i]=sc.nextInt();
			comm[i]=sc.next();
		}
		
		//move 시뮬
		int count=0; int cc=0; int ii=0;
		int flag=1;
		int x=0, y=0;
		while(true){
			if(x<0||y<0||x>=N||y>=N){count++;break;}
			if(ii<L&&count==command[ii]){
				if(comm[ii].equals("D")){
					flag++;
					if(flag==4){
						flag=0;
					}
				}
				else if(comm[ii].equals("L")){
					flag--;
					if(flag<0){flag=3;}
				}
				ii++;
			}
			if(flag==0){//up
				x--; 
			}
			else if(flag==1){//right
				y++; 
			}
			else if(flag==2){//down
				x++; 	
			}
			else{//left
				y--;
			}
			count++;
			if(move(x,y)==-1){break;}
			
		}
		System.out.println(count);

	}

}
