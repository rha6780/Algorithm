import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++) {
			int V=sc.nextInt(); int E=sc.nextInt();
			int result=2-V+E;
			System.out.println(result);
		}
		sc.close();
		

	}

}
