import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int[] num=new int[N];
	public static int[] sub=new int[N];
	public static int DP() {
		for(int i=0; i<N;i++) {
			sub[i]=1;
			for(int j=0; j<i; j++) {//i를 기준으로 인덱스 0에서 i-1까지 체크
			if(num[i]>num[j]&&sub[j]+1>sub[i]) {//i를 기준으로 i보다 작고 sub[j]+1으로 길이가 늘어나는 것
				sub[i]=sub[j]+1;//증가수열
			}
			}
		}
		int Max=sub[0];
		for(int i=0; i<N; i++) {
			if(Max<sub[i]) {
				Max=sub[i];
			}}
		return Max;
	}
	public static void main(String[] args) {
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		System.out.println(DP());
	}
}