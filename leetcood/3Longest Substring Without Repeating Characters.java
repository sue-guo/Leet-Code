/**Given a string s, find the length of the longest 
substring
 without repeating characters. */


 //method of mine: 字母逐个放入arraylist，如果遇见有相同的字母，删除相同字母前的所有字母
 class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        List<Character> list = new ArrayList();
        int maxSize = s.length()>0? 1:0;
        for(int i=0;i<ch.length;i++){
            if(list.contains(ch[i])){
                maxSize = list.size()>maxSize ? list.size():maxSize;
                int index = list.indexOf(ch[i]);
                while(index>=0){
                    list.remove(index);
                    index--;
                }
            }
            list.add(ch[i]);
        }
        return list.size()>maxSize ? list.size():maxSize;
    }
}


//method of lei:
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        //List<Character> list = new ArrayList();
        int maxSize = s.length()>0? 1:0;
        for(int i=0;i<ch.length-1;i++){
            Set<Character> set = new HashSet();
            int j=i+1;
            set.add(ch[i]);
            while(j<ch.length && !set.contains(ch[j])){
                set.add(ch[j]);
                j++;
            }
            maxSize = set.size()>maxSize ? set.size(): maxSize;
        }
        return maxSize;
    }
}