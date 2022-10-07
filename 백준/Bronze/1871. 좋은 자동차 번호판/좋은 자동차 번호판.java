import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String plate=br.readLine();
			char[] worth=plate.toCharArray();
			int w1=0, w2=0;
			String temp="";
			int rate=26*26;
			for(int j=0; j<plate.length(); j++) {
				if(j<=2) {
					w1=w1+((worth[j]-'A')*rate);
					rate/=26;
				}
				else if(j>3) {
					if(worth[j]!=0) {temp+=worth[j];}
				}
			}
			w2=Integer.parseInt(temp);

			if(Math.abs(w1-w2)<=100) {System.out.println("nice");}
			else {System.out.println("not nice");}
		}

	}

}
