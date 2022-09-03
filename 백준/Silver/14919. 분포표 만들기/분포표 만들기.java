import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<String> arr = new ArrayList<String>();
		while(st.hasMoreElements()) {
			arr.add(st.nextToken());
		}
		
		String[] num = new String[arr.size()];
		
		for(int i=0; i<arr.size(); i++) {
			num[i]="";
			boolean isnext = false;
			String nn = arr.get(i);
			for(int j=0; j<nn.length(); j++) {
				if(isnext) {
					num[i] += nn.charAt(j);
				}
				if(nn.charAt(j)=='.') {
					isnext = true;
				}
			}
			while(num[i].length()<6) {
				num[i] += '0';
				if(num[i].length()==6) {break;}
			}
			//System.out.println(num[i]);
		}
		int[] N = new int[arr.size()];
		int[] result = new int[M];
		int MM = 1000000;
		for(int i=0; i<arr.size(); i++) {
			N[i] = Integer.parseInt(num[i]);
			N[i] *= M;
			result[(int)Math.ceil(N[i]/MM)]++;
		}
		
		for(int j=0; j<M; j++) {
			System.out.print(result[j]+" ");
		}

	}

}
