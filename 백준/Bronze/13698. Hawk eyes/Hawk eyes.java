import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		String mix = br.readLine();
		
		int small = 1;
		int big = 4;
		int[] cup = new int[5];
		cup[small] =1;
		cup[big] =1;
		for(int i=0; i<mix.length(); i++) {
			char a = mix.charAt(i);
			int c1 = 0; int c2 =0;
			if(a == 'A') {
				c1=1; c2=2;
			}
			else if (a == 'B'){
				c1=1; c2=3;
			}
			else if (a == 'C') {
				c1=1; c2=4;
			}
			else if (a == 'D') {
				c1=2; c2=3;
			}
			else if (a == 'E') {
				c1=2; c2=4;
			}
			else {
				c1=3; c2=4;
			}
			
			if(c1 == small) {small=c2;}
			else if(c2 == small) {small = c1;}
			
			if(c1 == big) {big = c2;}
			else if(c2 == big) {big = c1;}
			
		}
		System.out.println(small);
		System.out.println(big);
		
	}

}
