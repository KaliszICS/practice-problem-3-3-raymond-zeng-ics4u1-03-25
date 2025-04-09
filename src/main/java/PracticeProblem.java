import java.util.ArrayList;
import java.util.Arrays;
public class PracticeProblem {

	public static void main(String args[]) {

	}
    public static ArrayList<String> perms(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            result.add("");
            return result;
		}
        generatePermutations(str, "", result);
        return result;
    }
    private static void generatePermutations(String str, String prefix, ArrayList<String> result) {
        if (str.length() == 0) {
            result.add(prefix);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(newStr, prefix + ch, result);
        }
    }
	
    public static ArrayList<String> permsUnique(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> result = new ArrayList<>();
        generatePermutations(chars, "", result, new boolean[chars.length]);
        return result;
    }

    private static void generatePermutations(char[] chars, String prefix, ArrayList<String> result, boolean[] used) {
        if (prefix.length() == chars.length) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
			if ((used[i] || (i > 0 && chars[i] == chars[i - 1] && used[i - 1] == false)) == false) {
				used[i] = true;
				generatePermutations(chars, prefix + chars[i], result, used);
				used[i] = false;
			}
        }
    }

}

