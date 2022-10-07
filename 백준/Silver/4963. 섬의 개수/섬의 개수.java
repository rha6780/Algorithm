import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int w=0, h=0, count=0;
	public static ArrayList<ArrayList<Integer>>Land=new ArrayList<ArrayList<Integer>>();
	public static int[][] island=new int[51][51];
	public static boolean[][] visit=new boolean[51][51];
	public static Queue<Integer> que=new LinkedList<Integer>();
	public static void Gr() {
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				Land.add(new ArrayList<Integer>());
				island[i][j]=sc.nextInt();
				
			}
		}
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(island[i][j]==1) {
					if(j-1>=0&&island[i][j-1]==1) {Land.get((i*w)+j-1).add((i*w)+j);Land.get((i*w)+j).add(((i)*w)+j-1);}//왼쪽
					if(j+1<w&&island[i][j+1]==1) {Land.get((i*w)+j+1).add((i*w)+j);Land.get((i*w)+j).add(((i)*w)+j+1);}//오른쪽
					
					if(i-1>=0&&j-1>=0&&island[i-1][j-1]==1) {Land.get(((i-1)*w)+j-1).add((i*w)+j); Land.get((i*w)+j).add(((i-1)*w)+j-1);}//왼쪽위 대각선
					if(i-1>=0&&island[i-1][j]==1) {Land.get(((i-1)*w)+j).add((i*w)+j);Land.get((i*w)+j).add(((i-1)*w)+j);}//위
					
					if(j+1<w&&i-1>=0&&island[i-1][j+1]==1) {Land.get(((i-1)*w)+j+1).add((i*w)+j);Land.get((i*w)+j).add(((i-1)*w)+j+1); }//오른쪽 대각선
					if(i+1<h&&island[i+1][j]==1) {Land.get(((i+1)*w)+j).add((i*w)+j); Land.get((i*w)+j).add((((i+1)*w)+j));}//아래
					if(i+1<h&&j-1>=0&&island[i+1][j-1]==1) {Land.get(((i+1)*w)+j-1).add((i*w)+j); Land.get((i*w)+j).add((((i+1)*w)+j-1));}//왼쪽 아래대각선
					if(i+1<h&&j+1<w&&island[i+1][j+1]==1) {Land.get(((i+1)*w)+j+1).add((i*w)+j); Land.get((i*w)+j).add((((i+1)*w)+j+1));}//오른쪽 아래 대각선
				}
			}
		}
	
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(visit[i][j]==false&&island[i][j]==1) {
					count++;
				que.add((i*w)+j);
				visit[i][j]=true;
				while(!que.isEmpty()) {
					int t=que.poll();
					for(int k=0; k<Land.get(t).size(); k++) {
						int hh=Land.get(t).get(k);
						if(island[hh/w][hh%w]==1&&visit[(hh/w)][(hh%w)]==false) {
							que.add(hh);
							visit[hh/w][hh%w]=true;
						}
					}
				}
			}
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
	
		while(true) {
			Land=new ArrayList<ArrayList<Integer>>();
			w=sc.nextInt();
			h=sc.nextInt();
			count=0; visit=new boolean[51][51];
			island=new int[51][51];
			if(w==0&&h==0) break;
			else {
				Gr();
			}
		}
		sc.close();
	}
}