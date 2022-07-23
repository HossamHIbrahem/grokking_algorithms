package chapter_09;

public class DynamicProgramming {

    public static void main(String[] args) {
        String word_a = "fosh";
        String word_b = "fish";
        int maxSubSequence = findLongestSubSequence(word_a, word_b);
        System.out.println("the longest public sub sequence is : " + maxSubSequence);
        int maxSubString = findLongestSubString(word_a, word_b);
        System.out.println("the longest public sub string is : " + maxSubString);
    }

    private static int findLongestSubString(String word_a, String word_b) {
        int[][] cell = new int[word_a.length()][word_b.length()];
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                if (word_a.charAt(i) == word_b.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    cell[i][j] = 0;
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                maxLength = Math.max(maxLength, cell[i][j]);
            }
        }
        return maxLength;
    }

    private static int findLongestSubSequence(String word_a, String word_b) {
        int[][] cell = new int[word_a.length()][word_b.length()];
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                if (word_a.charAt(i) == word_b.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j > 0) {
                        cell[i][j] = Math.max(cell[i - 1][j], cell[i][j - 1]);
                    } else if (i > 0) {
                        cell[i][j] = cell[i - 1][j];
                    } else if (j > 0) {
                        cell[i][j] = cell[i][j - 1];
                    } else {
                        cell[i][j] = 0;
                    }
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                maxLength = Math.max(maxLength, cell[i][j]);
            }
        }
        return maxLength;
    }
}