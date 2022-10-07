import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		int N=sc.nextInt();
		int len=0, j=0;
		for(int i=0; i<N;i++) {
			Stack stack=new Stack();
			j=0;
			String a;
			a=sc.next();
			
			char[] n=a.toCharArray();
			len=a.length();
			
			while(true) {
				if(n[j]=='(') {
					stack.push(n[j]);
					
				}
				else if(n[j]==')') {
					if(stack.isEmpty()==true) {
						System.out.println("NO");break;
					}
					stack.pop();
				}
				j++;
				
				if(j==len) {
					if(stack.empty()==true)
					System.out.println("YES");
					else System.out.println("NO");
					
					break;
				}
			}
		}

	}

}