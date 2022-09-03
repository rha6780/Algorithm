import java.util.HashMap;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int T=sc.nextInt();
	
	public static char[][] phone=new char[10001][10];
	public static HashMap<String, Integer> pp=new HashMap<String,Integer>();
	public static void iscon(int n){
		for(int i=0; i<n; i++){
			String ss="";
			for(int j=0; j<phone[i].length-1; j++){
				ss+=phone[i][j];
				if(pp.containsKey(ss)){
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
		return;
	}
	public static void main(String[] args) {
		for(int y=0; y<T; y++){
			pp=new HashMap<String, Integer>();
			int n=sc.nextInt();
		for(int i=0; i<n; i++){
			String s=sc.next();
			phone[i]=s.toCharArray();
			pp.put(s,i);
		}
		iscon(n);
	}
	}
}