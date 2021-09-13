import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        Queue<Character> que=new LinkedList<Character>();
        int count=0;
		for(int i=0; i<skill_trees.length; i++) {
			boolean isc=true;
			que.clear();
			for(int h=0; h<skill.length(); h++) {
				que.add(skill.charAt(h));
			}
			for(int j=0; j<skill_trees[i].length(); j++) {
				if(que.contains(skill_trees[i].charAt(j))) {
				if(skill_trees[i].charAt(j)==que.peek()) {que.poll();}
				else {isc=false;break;}}
			}
			if(isc) {count++;}
		}

        return count;
    }
}