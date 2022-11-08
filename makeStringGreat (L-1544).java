class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // we first add it to stringbuilder first
            sb.append(s.charAt(i));
            // as long as `sb` has a character, 
            // we check if the last character is same letter but in upper-case or vice-versa
            // here we can use XOR and 1 << 5 to convert a lower character to a upper one and vice-versa
            // A: 01[0]00001
            // a: 01[1]00001
            // Z: 01[0]11010
            // z: 01[1]11010
            // a -> A / A -> a
            while (sb.length() > 0 
                   && i + 1 < s.length() 
                   && ((sb.charAt(sb.length() - 1) ^ (1 << 5)) == s.charAt(i + 1))) {
                // if it matches the requirement, we remove the last character in `sb`
                sb.deleteCharAt(sb.length() - 1);
                // increase `i` by 1 here
                // think about "abBAcC"
                i += 1;
            }
        }
        return sb.toString();
    }
}
