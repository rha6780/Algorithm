import java.util.*;
public class Main {
	public static String[] line=new String[102];
	public static char[][] field=new char[102][102];
	public static int[][] count=new int[102][102];
	public static void discrimi(int i, int j){
		String result="";
		int Rmax=0, Rin=0;
		for(int ii=0; ii<i; ii++){
			for(int jj=0; jj<j; jj++){
			if(field[ii][jj]=='#'){
				count[ii][0]++;
			}}
			if(Rmax<count[ii][0]){Rmax=count[ii][0];Rin=ii;}
		}
		int Cmax=0, Cin=0;
		for(int jj=0; jj<j; jj++){
			for(int ii=0; ii<i; ii++){
				if(field[ii][jj]=='#'){
				count[jj][1]++;}
			}
			if(Cmax<count[jj][1]){Cmax=count[jj][1]; Cin=jj;}
		}
		
		for(int ii=0; ii<i; ii++){
			if(count[ii][0]>2&&Rmax>count[ii][0]){
				
				if(ii<Rin){result="UP";}
				else if(ii>Rin){result="DOWN";}
			}
		}
		if(result==""){
		for(int jj=0; jj<j; jj++){
			if(count[jj][1]>2&&Cmax>count[jj][1]){
				
				if(jj<Cin){result="LEFT";}
				else if(jj>Cin){result="RIGHT";}
			}
		}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int a=sc.nextInt(), b=sc.nextInt();
		for(int i=0; i<a; i++){
				line[i]=sc.next();
				field[i]=line[i].toCharArray();
		}
	
		discrimi(a,b);

	}

}