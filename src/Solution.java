
import java.util.*;

public class Solution {


    public static void main(String[] args) {

    }
//----------------------------------------------------------------------------------------------------------
    // Remove Duplicates from Sorted List - 83     https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

    public ListNode deleteDuplicates(ListNode head){

        if(head == null){
            return head;
        }
        ListNode currentNode = head;
        while(currentNode != null && currentNode.next != null){
            if(currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }
        }

        return head;
    }


//----------------------------------------------------------------------------------------------------------
    // Maximum Distance in Arrays - 624     https://leetcode.com/problems/maximum-distance-in-arrays/description/

    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;

        for (int i = 0; i < arrays.size() - 1; i++) {
            List<Integer> current = arrays.get(i);

            int localMin = current.get(0);
            int localMax = current.get(current.size() - 1);

            result = Math.max(result, Math.max(localMax - globalMin, globalMax - localMin));

            globalMin = Math.min(localMin, globalMin);
            globalMax = Math.max(localMax, globalMax);
        }
        return result;
    }


//----------------------------------------------------------------------------------------------------------
    // Kth Distinct String in an Array - 2053     https://leetcode.com/problems/kth-distinct-string-in-an-array/description/

    public String kthDistinct(String[] arr, int k) {
        Set<String> moreSeen = new HashSet<>();
        Set<String> distinctSet = new LinkedHashSet<>();

        for (String s : arr) {
            if (moreSeen.contains(s)) {
                distinctSet.remove(s);
            } else if (!distinctSet.add(s)) {
                moreSeen.add(s);
                distinctSet.remove(s);
            }
        }

        int count = 0;
        for (String str : distinctSet) {
            count++;

            if (count == k) {
                return str;
            }
        }
        return "";
    }

//----------------------------------------------------------------------------------------------------------
    // Make Two Arrays Equal by Reversing Subarrays - 1460     https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }

        int[] frequency = new int[1001];    //1 <= target =< 1000

        for (int i : target)
            frequency[i]++;
        for (int i : arr)
            frequency[i]--;

        for (int f : frequency) {
            if (f != 0) return false;
        }
        return true;
    }

//----------------------------------------------------------------------------------------------------------
    // Number of Senior Citizens - 2678     https://leetcode.com/problems/number-of-senior-citizens/description/

    public int countSeniors(String[] details) {
        int count = 0;
        for (int i = 0; i < details.length; i++) {
            String age = details[i].substring(11, 13);

            int ageInt = Integer.parseInt(age);

            if (ageInt > 60) {
                count++;
            }
        }

        return count;
    }


//----------------------------------------------------------------------------------------------------------
    // Sort The People - 2418     https://leetcode.com/problems/sort-the-people/description

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> peopleMap = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            peopleMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights);

        String[] sortedPeople = new String[names.length];
        for (int i = names.length - 1; i >= 0; i++) {
            sortedPeople[names.length - i - 1] = peopleMap.get(heights[i]);
        }
        return sortedPeople;
    }


//----------------------------------------------------------------------------------------------------------
    // Group Anagrams - 49     https://leetcode.com/problems/group-anagrams/description/

    public List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] strChar = s.toCharArray();
            Arrays.sort(strChar);
            String sortedStr = new String(strChar);

            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(s);
        }

        return new ArrayList<>(anagramMap.values());
    }
//----------------------------------------------------------------------------------------------------------
    // Remove Duplicates From Sorted Array - 26     https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public int removeDuplicates(int[] nums) {
        int index = 1;                               //      index = 5
        for (int i = 0; i < nums.length - 1; i++) { //      i = 7
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i + 1];          //      [0,1,2,3,4,2,2,3,3,4]
                index++;
            }
        }
        return index;
    }

    //{1,2,2,3,4,4,5,6,6,7}


//----------------------------------------------------------------------------------------------------------
    // Gas Station - 134     https://leetcode.com/problems/gas-station/description/

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;
        for (int g : gas) {
            totalGas += g;
        }

        for (int c : cost) {
            totalCost += c;
        }

        if (totalGas < totalCost) {
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                startIndex = i + 1;
            }
        }
        return startIndex;
    }

//    public int canCompleteCircuit(int[] gas, int[] cost){
//        int position = 0;
//        int sum = 0;
//        int total = 0;
//
//        for (int i = 0; i < gas.length; i++) {
//            sum += gas[i] - cost[i];
//
//            if(sum < 0){
//                total += sum;
//                sum = 0;
//                position = i + 1;
//            }
//        }
//        total += sum;
//
//        return total >= 0 ? position : -1;
//    }

//----------------------------------------------------------------------------------------------------------
    // Crawler Log Folder - 1598     https://leetcode.com/problems/crawler-log-folder/description/

    public int minOperations(String[] logs) {
        int step = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (step > 0) {
                    step--;
                }
            } else if (!log.equals("./")) {
                step++;
            }
        }
        return step;
    }


    //----------------------------------------------------------------------------------------------------------
    // Remove Element - 27     https://leetcode.com/problems/remove-element/description/
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }


    //----------------------------------------------------------------------------------------------------------
    // Kids with the greatest number of candies - 1431     https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxElement = 0;
        for (int candy : candies) {
            if (candy > maxElement) {
                maxElement = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            if (candy + extraCandies >= maxElement) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }


    //----------------------------------------------------------------------------------------------------------
    // Plus One - 66     https://leetcode.com/problems/plus-one/description/
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {  //Eger her hansi eded 9dan balacadirsa prosta ededi artirib return edirik.simple
                digits[i]++;
                return digits;
            }
            digits[i] = 0; //Eger her hansi eded 9dursa o zaman onu 0-a ceviririk
        }

        //Eger meselen [9,9,9] hali bas verirse,yeni array yaradiriq ve olcusunu bir defe artiririq -> [1,0,0,0]
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;  //[9,9,9] halinda ilk ededi 1 edirik  --> [1,0,0,0].digerleri zaten evvelden 0 olmusdu
        return newNumber;
    }
    //[1,2,9] --> [1,3,0] //buna gore de loop-a arxadan baslayacagiq
    //[9,9,9] --> [1,0,0,0]


//----------------------------------------------------------------------------------------------------------
    // Merge Strings Alternately - 1768     https://leetcode.com/problems/merge-strings-alternately/description

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();  // append etmek ucun stringbuilder obyekti yaradilir
        int i = 0;

        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i)); //word1-in her bir herfi append olunur strinbuildere
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));  //word2-in her bir herfi append olunur strinbuildere
            }
            i++;
        }
        return sb.toString();
    }


//-------------------------------------------------------------------------------------------------------
    // Minimum-difference-between-largest-and-smallest - 1509     https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description

    public int minDifference(int[] nums) {
        if (nums.length <= 4) {  //[4,9,10,15] zaten 3 gedisim var.Digerlerini birine beraber ede bilirem
            return 0;
        }
        Arrays.sort(nums); //yariya bolub yoxlaya bilmeyim ucun sort eledim
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, nums[nums.length - 1 - 3 + i] - nums[i]);
        }
        return result;
    }


//-------------------------------------------------------------------------------------------------------
    //Three Consecutive Odds - 1550     https://leetcode.com/problems/three-consecutive-odds/description/

    public boolean threeConsecutiveOdds(int[] arr) {
        int score = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                score++;
                if (score == 3) {
                    return true;
                }
            } else if (arr[i] % 2 == 0) {
                score = 0;

            }
        }
        return false;
    }


//-------------------------------------------------------------------------------------------------------
    //Find Common Characters - 1002     https://leetcode.com/problems/find-common-characters/description/

    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;
    }


//-------------------------------------------------------------------------------------------------------
    //Longest Palindrome - 409     https://leetcode.com/problems/longest-palindrome/description/


    public int longestPalindrome(String s) {
        int[] characters = new int[128];
        for (char c : s.toCharArray()) {
            characters[c]++;
        }
        int result = 0;
        for (int i : characters) {
            result += (i / 2) * 2;
        }
        if (result < s.length()) {
            result++;
        }
        return result;
    }


//--------------------------------------------------------------------------------------------
    //Reverse String - 344     https://leetcode.com/problems/reverse-string/description/

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


//--------------------------------------------------------------------------------------------
    //Score of a String - 3110      https://leetcode.com/problems/score-of-a-string/description/

    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return sum;
    }


//--------------------------------------------------------------------------------------------
    //  Roman To Integer


//        public int romanToInt(String s) {
//            int result = 0, number = 0;
//            for (int i = s.length()-1; i >= 0; i--) {
//                switch(s.charAt(i)) {
//                    case 'I':
//                        number = 1; break;
//                    case 'V':
//                        number = 5; break;
//                    case 'X':
//                        number = 10; break;
//                    case 'L':
//                        number = 50; break;
//                    case 'C':
//                        number = 100; break;
//                    case 'D':
//                        number = 500; break;
//                    case 'M':
//                        number = 1000; break;
//                }
//                if (4 * number < result) {
//                    result -= number;
//
//                } else {
//                    result += number;
//                }
//            }
//            return result;
//        }


    public int romanToInt(String s) {
        char[] elements = s.toCharArray();
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        for (int i = 1; i < elements.length; i++) {
            if (i + 1 < elements.length && romanMap.get(elements[i]) < romanMap.get(elements[i + 1])) {
                result -= romanMap.get(elements[i]);
            } else {
                result += romanMap.get(elements[i]);
            }
        }
        return result;
    }


//--------------------------------------------------------------------------------------------
    //Longest Common Prefix


    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];
        int index = 0;

        while (index < firstWord.length() && index < lastWord.length()) {
            if (firstWord.charAt(index) == lastWord.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return firstWord.substring(0, index);
    }


//--------------------------------------------------------------------------------------------
    //PalindromeNumber


    public static int findReverse(int x) {
        int reverse = 0;
        while (x > 0) {   //1
            reverse *= 10; //1220
            reverse += x % 10;    //1221
            x /= 10;
        }
        return reverse;
    }


    public boolean isPalindrome(int x) {
        return x == findReverse(x);
    }

//--------------------------------------------------------------------------------------------
    //  Search Insert Position


//    public int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while(left <= right) {
//            int middle = left + (right - left)/2;
//            if(target > nums[middle]) {
//                left = middle + 1;
//            }else if(target < nums[middle]) {
//                right = middle - 1;
//            }else{
//                return middle;
//            }
//        }
//        return left;
//
//    }

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;

            if (i < nums.length - 1 && nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return nums.length;
    }


//--------------------------------------------------------------------------------------------
//    Get Equal Substrings Within Budget

    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int window = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            window += Math.abs(s.charAt(right) - t.charAt(right));
            while (window > maxCost) {
                window -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


//---------------------------------------------------------------------------------------------------------
    //Two Sum - 1  https://leetcode.com/problems/two-sum/description/

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


//--------------------------------------------------------------------------------------------
    //Valid Palindrome

    public boolean isPalindrome(String s) {
        StringBuilder newS = new StringBuilder();
        char[] arrayChar = s.toCharArray();

        for (char ch : arrayChar) {
            if (Character.isLetterOrDigit(ch)) {
                newS.append(Character.toLowerCase(ch));
            }
        }
        return newS.toString().equals(newS.reverse().toString());
    }


//--------------------------------------------------------------------------------------------
    //Invert Binary Tree

//    public TreeNode invertTree(TreeNode root) {
//        if(root == null ){
//            return root;
//        }
//
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//
//        root.left = right;
//        root.right = left;
//        return root;
//    }


//--------------------------------------------------------------------------------------------
    //Binary Search

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }



    //------------------------------------------------------------------------------------------------------------
    //ListNode class
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

}