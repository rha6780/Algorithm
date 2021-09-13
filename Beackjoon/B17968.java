import java.util.*;
import java.io.*;

public class B17968 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[1002];
		num[0]=1; num[1]=1;
		for(int i=2; i<=N; i++) {
			int count=1;
			while(true) {
				boolean issmall=true;
				for(int j=1; i-j>=0&&i-(2*j)>=0; j++) {
					if(count == (2*num[i-j])-num[i-(2*j)]) {
						issmall=false;
					}
					//System.out.println(i+">"+j+"->"+count);
				}
				if(issmall) {
					//System.out.println(i+"√÷¡æ"+count);
					num[i]= count;
					break;
				}
				else {
					count++;
				}
			}
		}
		System.out.println(num[N]);
	}

}
