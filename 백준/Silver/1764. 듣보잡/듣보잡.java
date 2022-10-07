import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String ss=br.readLine();
		StringTokenizer st=new StringTokenizer(ss);
		int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken());
		HashSet<String> hs=new HashSet<String>();
		ArrayList<String> lsname=new ArrayList<String>();
		for(int i=0; i<N; i++){
			String s=br.readLine();
			hs.add(s);
		}

		int count=0;
		for(int i=0; i<M; i++){
			String s1=br.readLine();
			if(hs.contains(s1)){count++;lsname.add(s1);}
		}
		Collections.sort(lsname);
		bw.write(count+"\n");
		for(int j=0; j<count; j++){
			bw.write(lsname.get(j)+"\n");
		}
		bw.flush();
	}

}
