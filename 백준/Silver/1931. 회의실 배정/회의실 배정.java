import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int[][] time=new int[N][2];
	public static int[] num=new int[N];
	public static int Max=1;
	
	public static void counting(int i) {
		if(i>=N-1)return;
		int j=1;
		while(i<N&&i+j<N) {
		if(time[i][1]<=time[i+j][0]) {
		num[i+j]=num[i]+1;
		if(Max<num[i+j]) {Max=num[i+j];}
		break;
		}
		else j++;
		}
		counting(i+j);
	}

	public static void main(String[] args) {
		
		for(int i=0; i<N; i++) {
			num[i]=1;
			time[i][0]=sc.nextInt();
			time[i][1]=sc.nextInt();	
		}
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				final Integer ti1=entry1[1];
				final Integer ti2=entry2[1];
				if(ti1==ti2) {return Integer.compare(entry1[0], entry2[0]);}
				else
				return ti1.compareTo(ti2);
			}
			
		});
		
		counting(0);
		System.out.println(Max);
	}
}
