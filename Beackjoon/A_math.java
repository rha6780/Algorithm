import java.io.*;
import java.util.*;

public class A_math {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String s= br.readLine();
		//System.out.println(s);
		int result1=0; int result2=0;
		boolean a1=false; boolean a2=false;
		String Start = ""; String End= "";
		for(int i=0; i<s.length()&&i<3; i++) {
			Start+=s.charAt(i);
			//System.out.println(Start+"-----------");
			String next="";
			for(int j=i+1; j<s.length(); j++) {
				next+=s.charAt(j);
				if(next.equals(""+(Integer.parseInt(Start)+1))) {
					result1=Integer.parseInt(Start);
					a1=true;
					//System.out.println("후보"+Start+" "+next);
				}
			}
		}
		//System.out.println("=======");
		for(int i=s.length()-1; i>=0&&i>s.length()-4; i--) {
			End=s.charAt(i)+End;
			//System.out.println(End+"--------");
			String next="";
			for(int j=i-1; j>=0; j--) {
				next=s.charAt(j)+next;
				if(next.equals(""+(Integer.parseInt(End)-1)) ){
					result2=Integer.parseInt(End);
					a2=true;
					//System.out.println("후보"+End+" "+next);
				}
			}
		}
		if(a1&&a2) {
			System.out.println(result1+" "+result2);
		}
		else {
			System.out.println(s+" "+s);
		}
		
	}

}
