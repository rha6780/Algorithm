import java.util.Scanner;
public class Main {
	
	public static boolean issosu(int a) {
		if(a==1) return false;
		int bb=(int)Math.sqrt(a);
		for(int h=2; h<=bb; h++) {
			if(a%h==0) return false;
		}
		return true;
	}
	public static int count=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int D=sc.nextInt();
		String dd=D+"";
		for(int a=A; a<B; a++) {
			String st=a+"";
			char[] su=st.toCharArray();
			
			if(issosu(a)==true&&st.contains(dd)) {
				count++;
			}
		}
		System.out.println(count);
	}

}