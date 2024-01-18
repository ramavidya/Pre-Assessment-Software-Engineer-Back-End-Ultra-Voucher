import java.util.*;

public class GroupAnagram {

        private static boolean areAnagrams(String str1, String str2) {
            //  Memeriksa apakah dua string (str1 dan str2) adalah anagram atau tidak.
            if (str1.length() != str2.length()) {
                return false;
            }
            // Menghitung frekuensi karakter pada masing-masing string
            int[] charCount = new int[26];
            // Menambahkan frekuensi karakter
            for (char c : str1.toCharArray()) {
                charCount[c - 'a']++;
            }
            // Mengurangkan frekuensi karakter dan memeriksa apakah setiap karakter memiliki frekuensi yang sama
            for (char c : str2.toCharArray()) {
                charCount[c - 'a']--;
                if (charCount[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
        public static List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }

            // Membuat ArrayList untuk menyimpan kelompok anagram
            List<List<String>> anagramGroups = new ArrayList<>();

            // Iterasi melalui setiap string dalam array input paramter
            for (String str : strs) {
                boolean isAddedToGroup = false;

                for (List<String> group : anagramGroups) {
                    if (areAnagrams(group.get(0), str)) {
                        group.add(str);
                        isAddedToGroup = true;
                        break;
                    }
                }
                if (!isAddedToGroup) {
                    List<String> newGroup = new ArrayList<>();
                    newGroup.add(str);
                    anagramGroups.add(newGroup);
                }
            }
            return anagramGroups;
        }

        public static void main(String[] args) {
            String[] input = {"cook", "save", "taste", "aves", "vase", "state", "map"};
            List<List<String>> result = groupAnagrams(input);

            System.out.println("[");
            for (List<String> group : result) {
                System.out.println("  " + group + ",");
            }
            System.out.println("]");
        }
    }
