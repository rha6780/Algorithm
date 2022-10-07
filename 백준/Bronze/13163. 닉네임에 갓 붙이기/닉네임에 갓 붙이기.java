import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ss=br.readLine();
		StringTokenizer st=new StringTokenizer(ss);
		int N=Integer.parseInt(st.nextToken());
		String[][] name=new String[N][2];
		for(int i=0; i<N; i++) {
			String s=br.readLine();
			st=new StringTokenizer(s);
			name[i][0]=st.nextToken();
			name[i][1]="";
			while(st.hasMoreTokens()) {
			name[i][1]+=st.nextToken();}
		}
		for(int i=0; i<N; i++) {
			System.out.println("god"+name[i][1]);
		}
		

	}

}
