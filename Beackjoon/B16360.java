import java.util.*;
import java.io.*;

public class B16360 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] word = new String[N];
		
		for(int i=0; i<N; i++) {
			String a=sc.next();
			char[] ch = a.toCharArray();
			
			if(ch[a.length()-1] == 'a') {
				a+="s";
				word[i] = a;
			}
			else if (ch[a.length()-1] == 'i') {
				a+="os";
				word[i] = a;
			}
			else if(ch[a.length()-1] == 'y') {
				ch[a.length()-1] = 'i';
				word[i] = String.copyValueOf(ch)+"os";
			}
			else if (ch[a.length()-1] == 'l'||ch[a.length()-1] == 'r'||ch[a.length()-1] == 'v') {
				a+="es"; 
				word[i] = a;
			}
			else if (ch[a.length()-1] == 'n') {
				ch[a.length()-1] = 'a';
				word[i] = String.copyValueOf(ch)+"nes";
			}
			else if(ch[a.length()-1] =='e'&&ch[a.length()-2]=='n') {
				ch[a.length()-2] = 'a'; ch[a.length()-1]='n';
				word[i] = String.copyValueOf(ch)+"es";
			}
			else if (ch[a.length()-1] == 'o'||ch[a.length()-1]=='u') {
				a+="s";
				word[i] = a;
			}
			else if (ch[a.length()-1] == 'w'||ch[a.length()-1]=='t') {
				a+="as";
				word[i] = a;
			}
			else {
				a+="us";
				word[i] = a;
			}
			System.out.println(word[i]);
		}
		
		
	}

}
