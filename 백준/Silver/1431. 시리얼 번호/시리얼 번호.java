import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String[] ss=new String[N];
		char[][] ar=new char[N][50];
		for(int i=0; i<N; i++) {
			ss[i]=sc.next();
		}
		Arrays.sort(ss, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					int sum1=0, sum2=0;
					for(int i=0; i<s1.length(); i++) {
						if(s1.charAt(i)>='0'&&s1.charAt(i)<='9') {
							sum1+=s1.charAt(i)-'0';
						}
						if(s2.charAt(i)>='0'&&s2.charAt(i)<='9') {
							sum2+=s2.charAt(i)-'0';
						}
					}
					if(sum1==sum2) {
						return s1.compareTo(s2);//이부분 공부 필요 내생각에 String 값 비교인듯
					}
					else {
						return Integer.compare(sum1, sum2);
					}
				}
				return Integer.compare(s1.length(), s2.length());
			}
			
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(ss[i]);
		}
		
	}

}
