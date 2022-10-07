import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.next();
		sc.close();
		char[] cro=ss.toCharArray();
		int count=cro.length;
		for(int i=0; i<ss.length()-1; i++) {
			String s ="";
			String st ="";
			if(i+2<ss.length()) {st+=cro[i];st+=cro[i+1];st+=cro[i+2];}
			s+=cro[i];
			s+=cro[i+1];
		
			if(!st.equals("dz=")) {
			if(s.equals("c=")||s.equals("c-")||s.equals("d-")||s.equals("lj")||s.equals("nj")||s.equals("s=")||s.equals("z=")) {
				count--;
			}}
			else {
				count-=2;
				i+=2;
			}
		}
		System.out.println(count);
		
	}

}
