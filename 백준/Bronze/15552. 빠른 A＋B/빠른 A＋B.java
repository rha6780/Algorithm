import java.io.*;
import java.util.StringTokenizer;
public class Main {
		
	public static void main(String[] args) {
		int a, b, c;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter res=new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			StringTokenizer st=new StringTokenizer(br.readLine());
			c=Integer.parseInt(st.nextToken());
			for(int i=0; i<c;i++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				res.write((a+b)+"\n");
			}
			res.flush();
		}
		catch(IOException e) {
			System.out.println("Error: "+e);
		}
	}
}