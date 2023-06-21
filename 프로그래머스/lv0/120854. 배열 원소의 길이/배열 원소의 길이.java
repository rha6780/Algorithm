class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int count =0;
        for(String s: strlist) {
            answer[count] = s.length();
            count++;
        }
        return answer;
    }
}