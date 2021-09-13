import java.util.*;
import java.io.*;
public class B2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int[][] person=new int[15][15];
		for(int i=0; i<15; i++) {
			for(int j=1; j<15; j++) {
				if(i==0) {person[i][j]=j;}
				if(j==1) {person[i][j]=1;}
				if(i>0&&j>1) {person[i][j]=person[i-1][j]+person[i][j-1];}
			}
		}
		for(int i=0; i<T; i++) {
			int a=Integer.parseInt(br.readLine());
			int b=Integer.parseInt(br.readLine());
			System.out.println(person[a][b]);
		}

	}

}
