import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String[] file=new String[N];
		for(int i=0; i<N; i++) {
			file[i]=sc.next();
		}
		String result="";
		for(int i=0; i<file[0].length(); i++) {
			char c=file[0].charAt(i);
			boolean isadd=true;
			for(int j=0; j<N; j++) {
				if(c==file[j].charAt(i)) {isadd=true;}
				else {
					isadd=false; break;
				}
			}
			if(isadd) {result+=c;}
			else {result+="?";}
		}
		System.out.println(result);
	}

}
