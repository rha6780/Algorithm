import java.util.*;
import java.io.*;

public class B17826 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String scores = br.readLine();
		int myscore = Integer.parseInt(br.readLine());
		Integer[] score = new Integer[50];
		StringTokenizer st = new StringTokenizer(scores);
		for(int i=0; i<50; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			//System.out.println(score[i]);
		}
		Arrays.sort(score, Collections.reverseOrder());
		int index = 0;
		for(int i=0; i<50; i++) {
			if(score[i] == myscore) {
				index = i+1;
				break;
			}
		}
		if (index <=5) {
			System.out.println("A+");
		} else if (5 < index && index <= 15) {
			System.out.println("A0");
		} else if (15 < index && index <= 30) {
			System.out.println("B+");
		} else if (30 < index && index <= 35) {
			System.out.println("B0");
		} else if (35 < index && index <= 45) {
			System.out.println("C+");
		} else if (45 < index && index <= 48) {
			System.out.println("C0");
		} else {
			System.out.println("F");
		}
		

	}

}
