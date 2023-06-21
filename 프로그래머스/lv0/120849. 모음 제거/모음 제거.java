class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] strs = {"a", "e", "i", "o", "u"};
        char[] chars = my_string.toCharArray();
        for(char c : chars) {
            boolean is_contain = false;
            for (int i =0; i<5; i++){
                if (strs[i].contains(String.valueOf(c))) {
                    is_contain = true;
                }
            }
            if(!is_contain){
                answer+=""+c;
            }
        }
        return answer;
    }
}