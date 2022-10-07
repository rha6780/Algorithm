import java.util.Scanner;
public class Main {

	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int[] stack=new int[N];
	public static int[] comd=new int[N];
	public static char[] commend=new char[N*2+2];
	public static int I=1;
	public static int top=-1;
	public static void push(int a) {
		top=top+1;
		stack[top]=a;
		commend[I]='+';
		I++;
	}
	public static void pop() {
		if(top==-1)System.out.println("NO");
		else {
		commend[I]='-';
		stack[top]=0;
		top=top-1;
		I++;}
	}

	public static void main(String[] args) {
		int t3=0, result=0;
		for(int i=0; i<N ;i++) {
			comd[i]=sc.nextInt();
		}
		for(int j=1; j<=comd[0]; j++) {
			push(j);
			t3=j;}
		pop();
		
		for(int i=1; i<N; i++) {
			
		if(top==-1) { push(t3+1);t3++;}
			if(stack[top]<comd[i]) {
				while(stack[top]<comd[i] ) 
				{push(t3+1);t3++;}
				pop();
				}
			else if(stack[top]==comd[i]) {
				pop();
			}
			else {
			System.out.println("NO");
			result=1;
			break;}
			
		}
		
		if(result!=1)
		for(int i=1; i<I ;i++) {
			System.out.println(commend[i]);
		}

	}
}
