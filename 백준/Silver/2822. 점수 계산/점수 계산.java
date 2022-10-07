import java.util.*;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int sum=0;
		boolean[] cal=new boolean[8];
		int[] score=new int[8];
		for(int i=0; i<8; i++) {
			score[i]=sc.nextInt();
		}
		for(int i=0; i<5; i++) {
			int Max=0, ind=0;
			for(int j=0; j<8; j++) {
				if(!cal[j]&&Max<=score[j]) {Max=score[j]; ind=j;}
			}
			cal[ind]=true;
			sum+=score[ind];
		}
		System.out.println(sum);
		for(int i=0; i<8; i++) {if(cal[i]) {System.out.print((i+1)+" ");}}

	}

}
