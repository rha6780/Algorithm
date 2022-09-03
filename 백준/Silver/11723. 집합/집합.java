import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String st=br.readLine();
		int M=Integer.parseInt(st);
		HashSet <Integer> hs=new HashSet<Integer>();
		HashSet <Integer> tmp=new HashSet<Integer>();
		for(int h=1; h<=20; h++){
			tmp.add(h);
		}
		for(int i=0; i<M; i++){
			String ss1=br.readLine();
			StringTokenizer ss=new StringTokenizer(ss1);
			String s=ss.nextToken();
		    if(s.equals("add")){
		    	int x=Integer.parseInt(ss.nextToken());
				hs.add(x);
			}
			else if(s.equals("remove")){
				int x=Integer.parseInt(ss.nextToken());
				hs.remove(x);
			}
			else if(s.equals("check")){
				int x=Integer.parseInt(ss.nextToken());
				if(hs.contains(x)){bw.write(1+"\n");}
				else{bw.write(0+"\n");}
			}
			else if(s.equals("toggle")){
				int x=Integer.parseInt(ss.nextToken());
				if(hs.contains(x)){hs.remove(x);}
				else{hs.add(x);}
			}
			else if(s.equals("all")){
				hs=tmp;
			}
			else if(s.equals("empty")){
				hs=new HashSet<Integer>();
			}
		}
		bw.flush();

	}

}
