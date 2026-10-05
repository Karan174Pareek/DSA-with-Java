class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0; // Minimum possible open brackets
        int cmax = 0; // Maximum possible open brackets

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                cmin++;
                cmax++;
            } else if (ch == ')') {
                cmin--;
                cmax--;
            } else { // ch == '*'
                cmin--; // treat '*' as ')'
                cmax++; // treat '*' as '('
            }

            // More ')' than '(' even if all '*' were '('
            if (cmax < 0) {
                return false;
            }

            // Lower bound cannot be negative
            cmin = Math.max(cmin, 0);
        }

        return cmin == 0;
    }
}