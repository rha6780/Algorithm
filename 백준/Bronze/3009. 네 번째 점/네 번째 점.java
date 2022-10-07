import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] count=new int[3][2];
		int[][] cc=new int[3][2];
		for(int j=0; j<3; j++) {
			count[j][0]=sc.nextInt();
			count[j][1]=sc.nextInt();
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<i; j++) {
				if(count[i][0]==count[j][0]) {
					cc[i][0]++; cc[j][0]++;
				}
				if(count[i][1]==count[j][1]) {
					cc[i][1]++; cc[j][1]++;
				}
			}
			
		}
		int a=0; int b=0;
		for(int i=0; i<3; i++) {
			if(cc[i][0]==0) {a=count[i][0];}
			if(cc[i][1]==0) {b=count[i][1];}
		}
		System.out.println(a+" "+b);

	}

}
