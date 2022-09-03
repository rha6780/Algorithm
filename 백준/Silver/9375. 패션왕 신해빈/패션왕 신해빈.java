import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		int T=Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++){
			HashMap<String, String> hm=new HashMap<String, String>();
			HashMap<String, Integer> hcount=new HashMap<String, Integer>();
			
			String ss=br.readLine();
			st=new StringTokenizer(ss);
			int N=Integer.parseInt(st.nextToken());
			for(int j=0; j<N; j++){
				String line=br.readLine();
				st=new StringTokenizer(line);
				String name=st.nextToken();
				String category=st.nextToken();
				hm.put(name, category);
				if(hcount.containsKey(category)){
					hcount.replace(category, hcount.get(category).intValue(), hcount.get(category).intValue()+1);
				}
				else{
					hcount.put(category, 1);
				}
			}
			int result=0;
			int dump=1;
			for(String key: hcount.keySet()){
				int a=hcount.get(key).intValue();
				dump*=a+1;
			}
			dump--;
			result=dump;
			System.out.println(result);
		}
	}

}
