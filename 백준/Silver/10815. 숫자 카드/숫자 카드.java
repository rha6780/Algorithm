import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		int[] Scard=new int[N];
		String ss=br.readLine();
		StringTokenizer st=new StringTokenizer(ss);
		for(int i=0; i<N; i++){
			Scard[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Scard);
		int M=Integer.parseInt(br.readLine());
		int[] Ccard=new int[M];
		int[] pp=new int[M];
		String sp=br.readLine();
		StringTokenizer sst=new StringTokenizer(sp);
		for(int i=0; i<M; i++){
			Ccard[i]=Integer.parseInt(sst.nextToken());
			boolean have=false;
			int left=0; 
			int right=N-1;
			while(left<=right){
				int mid=(right+left)/2;
				if(Ccard[i]<Scard[mid]){right=mid-1;}
				else if(Ccard[i]==Scard[mid]){have=true; break;}
				else{left=mid+1;}
			}
			if(have){pp[i]=1;}
			else{pp[i]=0;}
		}
		for(int i=0; i<M; i++){
			System.out.print(pp[i]+" ");
		}
		

	}

}
