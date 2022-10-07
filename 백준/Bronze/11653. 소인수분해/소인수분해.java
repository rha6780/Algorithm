import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		br.close();
		int count=1;
		int[] sosu=new int[N+1];
		sosu[0]=2;
		int a=2;
		for(int i=2; i*i<=N; i++) {
			while(N%i==0) {
				N/=i;
				bw.write(i+"\n");
			}
		}
		if(N>1) {bw.write(N+"\n");}
		bw.flush();
	
	}

}
