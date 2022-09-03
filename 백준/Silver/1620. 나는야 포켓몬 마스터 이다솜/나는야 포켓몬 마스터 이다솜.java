import java.util.Scanner;
import java.util.*;
public class Main{

	public static void main(String[] args) {
		HashMap<Integer, String>pokemon=new HashMap<Integer, String>();
		HashMap<String,Integer>pokemonname=new HashMap<String, Integer>();
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		String names="";
		for(int i=1; i<=N ;i++) {
			names=sc.next();
			pokemon.put(i, names);
			pokemonname.put(names, i);
		}
		for(int j=0; j<M; j++) {
			String question=sc.next();
			char[] q=question.toCharArray();
			if(q[0]<='Z'&&q[0]>='A') {
				System.out.println(pokemonname.get(question));
			}
			else {
				int g=Integer.parseInt(question);
				System.out.println(pokemon.get(g));
			}
		}
	}
}