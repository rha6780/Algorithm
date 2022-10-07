import java.util.*;
import java.io.*;
public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String r=br.readLine();
		StringTokenizer st=new StringTokenizer(r);
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=b-a;
		if(c==0) {System.out.println(0);}
		else {
		int sq=(int) Math.sqrt(c);
		if(Math.sqrt(c)%1>0) {
			if(c-sq*sq>sq) {System.out.println(sq+sq+1);}
			else if(c-sq*sq<=sq) {System.out.println(sq+sq);}
		}
		else if(Math.sqrt(c)%1==0) {System.out.println(sq+sq-1);}
		}
		
	}

}
