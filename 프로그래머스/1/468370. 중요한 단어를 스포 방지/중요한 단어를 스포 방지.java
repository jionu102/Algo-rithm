import java.util.*;

class Solution {

    public int solution(String message, int[][] spoilerRanges) {
        Set<String> spoilers = new HashSet<>();
        Set<String> messages = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(message, " ");
        
        int currentSearchIndex = 0;
        
        while(st.hasMoreTokens()) {
            String target = st.nextToken();
            int targetStart = message.indexOf(target, currentSearchIndex);
            int targetEnd = targetStart + target.length() - 1;
            
            boolean isSpoilerWord = false;
            for (int i = 0; i < spoilerRanges.length; i++) {
                SpoilerRange range = new SpoilerRange(spoilerRanges[i][0], spoilerRanges[i][1]);
                if (range.contains(targetStart, targetEnd)) {
                    isSpoilerWord = true;
                    break;
                }
            }
            
            if (isSpoilerWord) {
                spoilers.add(target);
            } else {
                messages.add(target);
            }
            
            currentSearchIndex = targetEnd + 1;
        }
        
        for (String m : messages) {
            spoilers.remove(m);
        }
        
        return spoilers.size();
    }
    
    private class SpoilerRange {
        private final int start;
        private final int end;
        
        public SpoilerRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public boolean contains(int targetStart, int targetEnd) {
            for (int i = targetStart; i <= targetEnd; i++) {
                if (i >= start && i <= end) {
                    return true;
                }
            }
            
            return false;
        }
    }
}