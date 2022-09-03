import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		List<String> s=new ArrayList<String>();
		for(int i=0; i<N; i++) {
			s.add(sc.next());
		}
		List<String> list=new ArrayList<String>(new LinkedHashSet<String>(s));
		
		Comparator<String> c=new Comparator<String>() {
			public int compare(String t1, String t2) {
				int a=Integer.compare(t1.length(), t2.length());
				if(a==0) {int hh=0;
					for(int i=0; i<t1.length(); i++) {
						hh=t1.charAt(i)-t2.charAt(i);
					if(hh!=0) break;
				}return hh;
				}
				else return a;
			}
		};
		Collections.sort(list,c);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
