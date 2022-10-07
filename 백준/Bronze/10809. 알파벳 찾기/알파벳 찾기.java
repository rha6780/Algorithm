import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int[] position=new int[30];
		int[] count=new int[30];
		for(int i=0; i<30; i++) {position[i]=-1;}
		for(int i=0; i<s.length(); i++) {
			int kk=s.charAt(i)-'a';
			if(count[kk]==0) {
				position[kk]=i;
				count[kk]++;
			}
		}
		for(int i=0; i<26; i++) {
			System.out.print(position[i]+" ");
		}
	}

}
