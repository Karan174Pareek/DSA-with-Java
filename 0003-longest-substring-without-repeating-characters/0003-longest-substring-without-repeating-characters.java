import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1); // -1 indicates character hasn't been seen

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character was seen inside the current window, shift left boundary
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }

            lastIndex[ch] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}