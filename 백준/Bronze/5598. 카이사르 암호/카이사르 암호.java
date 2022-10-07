import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		sc.close();
		char[] cc=s.toCharArray();
		char[] alp=new char[26];
		for(int i=0; i<26; i++) {
			alp[i]=(char)('A'+i);
		}
		for(int i=0; i<s.length(); i++) {
			if(cc[i]-'D'>=0) {System.out.print(alp[cc[i]-'D']);}
			else {
				System.out.print(alp[26-('D'-cc[i])]);
			}
		}

	}

}
