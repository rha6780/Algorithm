import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	static boolean[] visit=new boolean[40];
	static String[] ss=new String[120];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(st.nextToken());
		ss=new String[a];int count=0;
		for(int i=0; i<a; i++) {
			visit=new boolean[40];
			ss[i]=br.readLine();
			boolean isgr=true;
			for(int j=0; j<ss[i].length(); j++) {
				char ind=ss[i].charAt(j);
				if(!visit[ind-'a']||(j>0&&ss[i].charAt(j)==ss[i].charAt(j-1))) {visit[ind-'a']=true;}
				else {isgr=false; break;}
			}
			if(isgr) {count++;}
		}
		System.out.println(count);
		
	}

}
