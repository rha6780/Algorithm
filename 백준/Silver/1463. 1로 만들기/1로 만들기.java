import java.util.Scanner;
public class Main {
	
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int[] num=new int[1000001];
	public static int min=1000002;
	
	
	public static int div(int a, int b, int c) {
		min=1000002;
		if(min>a) min=a;
		if(min>b) min=b;
		if(min>c) min=c;
		return min;
	}
	
	public static int del1(int a) {
		int ii=a-1;
		return num[ii-1]+1;
	}
	public static int del3(int a) {
		int ii=a/3;
		if(a%3!=0) return 1000002;
		return num[ii-1]+1;
	}
	public static int del2(int a) {
		int ii=a/2;
		if(a%2!=0) return 1000002;
		return num[ii-1]+1;
	}
	public static int todel(int n) {
		num[0]=0; num[1]=1; num[2]=1;
		if(n>3)
		for(int i=4; i<=n; i++) {
		num[i-1]=div(del1(i),del2(i),del3(i));
		}
		return num[n-1];
	}
	public static void main(String[] args) {
		
		System.out.print(todel(N));
	}

}