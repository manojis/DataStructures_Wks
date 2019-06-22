package com.HackerRank.Algorithms;

/**
 * @author Manoj.Mohanan Nair
 * @Date 6/11/19
 */
public class occurencesafterbigram {

    public static void main(String[] args) {
        String[] result = findOcurrences("alice is a good girl she is a good student", "a", "good");
        // System.out.println(result);
    }

    /*OccurrenceAfterBigram occurrenceAfterBigram;

    @BeforeEach
    public void init() {
        occurrenceAfterBigram = new OccurrenceAfterBigram();
    }

    @Test
    public void firstTest() {
        String[] result = findOcurrences("alice is a good girl she is a good student", "a", "good");
        Arrays.stream(result).forEach(val -> System.out.println(val));
    }

    @Test
    public void SecondTest() {
        String[] result = findOcurrences("we will we will rock you", "we", "will");
        Arrays.stream(result).forEach(val -> System.out.println(val));
    }

    @Test
    public void thirdTest(){
        String[] result = findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
                "kcyxdfnoa",
                "jkypmsxd");
        Arrays.stream(result).forEach(val -> System.out.println(val));
    }*/

    public static String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        int len = arr.length;
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        while (pos < len) {
            if (pos + 1 < len && arr[pos].equalsIgnoreCase(first) && arr[pos + 1].equalsIgnoreCase(second)) {
                if (pos + 2 < len) {
                    sb.append(arr[pos + 2]);
                    sb.append(",");
                }
            }
            pos++;
        }
        // System.out.println(sb.toString());
        String[] result = new String[0];
        if (sb.toString().length() > 1) {
            result = sb.toString().substring(0, sb.toString().length() - 1).split(",");
        }
        System.out.println(result);
        return result;
    }
}
