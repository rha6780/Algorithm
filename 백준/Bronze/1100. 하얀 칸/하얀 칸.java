import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	static String[] chess=new String[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int count=0;
		for(int i=0; i<8; i++) {
			chess[i]=br.readLine();
			
			boolean jjak=false;
			if(i%2==0) {jjak=true;}
			for(int j=0; j<8; j++) {
				if(jjak) {
					if(j%2==0&&chess[i].charAt(j)=='F') {count++;}
				}
				else {
					if(j%2==1&&chess[i].charAt(j)=='F') {count++;}
				}
			}
			
		}
		System.out.println(count);
	}

}
