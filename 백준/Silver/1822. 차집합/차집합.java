	import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
	import java.util.Collection;
import java.util.Collections;
import java.util.Set; 
	import java.util.Scanner;
	import java.io.*;
	public class Main {

	public static void main(String[] args) throws IOException {
	    HashSet<Integer> S=new HashSet<Integer>();
	    HashSet<Integer> T=new HashSet<Integer>();
	    Scanner sc=new Scanner(System.in);
	    int NA=sc.nextInt(); 
	    int NB=sc.nextInt();
	    for(int i=0; i<NA; i++) {
	        S.add(sc.nextInt());
	    }
	    for(int i=0; i<NB; i++) {
	        T.add(sc.nextInt());
	    }sc.close();
	    S.removeAll(T);
	    ArrayList U=new ArrayList(S);
	    Collections.sort(U);
	    if(0==S.size()) System.out.print("0");
	    else {
	    System.out.println(S.size());
	   for(Object s:U) {
		   System.out.print(s+" ");}
	    }
	}
}