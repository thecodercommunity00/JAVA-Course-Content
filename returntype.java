
// import java.util.Scanner;
import java.util.ArrayList;

public class returntype {
    // public static Scanner scn = new Scanner(System.in);

    public static void main(String args[]) {
        // System.out.println(factorial(5));
        // System.out.println(fibonacci(7));
        // System.out.println(removeHi("iihhhihihiihhii", 0));
        // System.out.println(removeHi2("iihhhihihiihhii"));
        // System.out.println(removeHileavehit("iihhithihihiihit"));
        // System.out.println(remove_dupli("aa", 0));
        // System.out.println(allSubsequence("abcd"));

        // ArrayList<String> ans;

        // ans = towerOfHanoi(3, 10, 11, 12);

        // ans = mazepath(0, 0, 3, 3);
        // ans = mazepathD(0, 0, 3, 3);

        // System.out.println(maxpath(0, 0, 3, 3));
        // pair p = (maxpath_withpath(0, 0, 3, 3));
        // System.out.println(p.steps + " " + p.path);

        // ans = multimazepath(0, 0, 3, 3);

        // ans = floodfill(new boolean[4][4], 0, 0, 3, 3);

        // ans = wordbreak("ilikemangoicecream");

        // ans = permutations("abc");

        // ans = keypad("4567");

        // ans = encoding("1018");

        // System.out.println(MY_minPallindromicCuts("abaabcacd"));
        // System.out.println(SIR_minPallindromicCuts("abaabcacd", 0, 8));

        // System.out.println(removeExtraHi("ihhhhhiiihiiihhhii"));

        // System.out.println(compression("abbcccddddaeeeee", 1));

        // System.out.println(removeExtraHiLeaveHit("hhhiihiihitihi"));

        int arr[] = { 10, 20, 30, 40, 50, 60, 70 };
        int idx = 0;
        int set1 = 0;
        int set2 = 0;
        ArrayList<ArrayList<String>> bigAns = combiDivideDiffSetsBasisofSum(arr, idx, set1, set2);

        if (bigAns.size() > 0) {
            ArrayList<String> set1Sums = bigAns.get(0);
            ArrayList<String> set2Sums = bigAns.get(1);

            for (int i = 0; i < set1Sums.size(); i++) {
                System.out.println(set1Sums.get(i) + " = " + set2Sums.get(i));
            }
        }

        // for (String s : ans) {
        // System.out.println(s);
        // }
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static String removeHi(String str, int idx) {
        if (idx == str.length())
            return "";
        if (str.charAt(idx) == 'h' && idx < str.length() - 1 && str.charAt(idx + 1) == 'i') {
            return removeHi(str, idx + 2);
        }
        return str.charAt(idx) + removeHi(str, idx + 1);
    }

    public static String removeHi2(String str) {
        if (str.length() == 0)
            return "";
        if (str.charAt(0) == 'h' && str.length() > 1 && str.charAt(1) == 'i') {
            return removeHi2(str.substring(2));
        }
        return str.charAt(0) + removeHi2(str.substring(1));
    }

    public static String removeHileavehit(String str) {
        if (str.length() == 0) {
            return "";
        }

        if (str.charAt(0) == 'h' && str.length() > 1 && str.charAt(1) == 'i') {
            if (str.length() > 2 && str.charAt(2) == 't') {
                return "hit" + removeHileavehit(str.substring(3));
            }
            return removeHileavehit(str.substring(2));
        }
        return str.charAt(0) + removeHileavehit(str.substring(1));
    }

    public static String remove_dupli(String str, int idx) {
        if (idx == str.length())
            return "";

        if (idx == 0)
            return str.charAt(0) + remove_dupli(str, idx + 1); // first char always addded.

        if (str.charAt(idx) == str.charAt(idx - 1)) { // if same as previous dont add,return the ans of the rst of the
                                                      // string
            return remove_dupli(str, idx + 1);
        }

        return str.charAt(idx) + remove_dupli(str, idx + 1); // add the char if it appears first time.
    }

    public static ArrayList<String> allSubsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = allSubsequence(str.substring(1));
        ArrayList<String> myAns = new ArrayList<>();
        for (String s : recAns) {
            String st = str.charAt(0) + s;
            myAns.add(st);
        }

        recAns.addAll(myAns);

        return recAns;
    }

    public static ArrayList<String> towerOfHanoi(int n, int t1, int t2, int t3) {
        if (n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("1[" + t1 + " -> " + t2 + "]");
            return base;
        }

        ArrayList<String> recAns = towerOfHanoi(n - 1, t1, t3, t2);
        recAns.add(n + "[" + t1 + " -> " + t2 + "]");
        recAns.addAll(towerOfHanoi(n - 1, t3, t2, t1));
        return recAns;
    }

    public static ArrayList<String> mazepath(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = new ArrayList<>();
        if (sc + 1 <= er) {
            ArrayList<String> smallAnsH = mazepath(sr, sc + 1, er, ec);
            for (String s : smallAnsH) {
                recAns.add("H" + s);
            }
        }
        if (sr + 1 <= er) {
            ArrayList<String> smallAnsV = mazepath(sr + 1, sc, er, ec);
            for (String s : smallAnsV) {
                recAns.add("V" + s);
            }
        }
        return recAns;
    }

    public static ArrayList<String> mazepathD(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = new ArrayList<>();
        if (sc + 1 <= ec) {
            ArrayList<String> smallAnsH = mazepathD(sr, sc + 1, er, ec);
            for (String s : smallAnsH) {
                recAns.add("H" + s);
            }
        }
        if (sr + 1 <= er) {
            ArrayList<String> smallAnsV = mazepathD(sr + 1, sc, er, ec);
            for (String s : smallAnsV) {
                recAns.add("V" + s);
            }
        }
        if (sc + 1 <= ec && sr + 1 <= er) {
            ArrayList<String> smallAnsD = mazepathD(sr + 1, sc + 1, er, ec);
            for (String s : smallAnsD) {
                recAns.add("D" + s);
            }
        }
        return recAns;
    }

    public static int maxpath(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            return 0;
        }

        int hori = 0;
        if (sc + 1 <= ec)
            hori = maxpath(sr, sc + 1, er, ec);

        int verti = 0;
        if (sr + 1 <= er)
            verti = maxpath(sr + 1, sc, er, ec);

        int diag = 0;
        if (sr + 1 <= er && sc + 1 <= ec)
            diag = maxpath(sr + 1, sc + 1, er, ec);

        return Math.max(Math.max(hori, verti), diag) + 1;
    }

    public static class pair {
        int steps;
        String path;
    }

    public static pair maxpath_withpath(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            pair base = new pair();
            base.steps = 0;
            base.path = "";
            return base;
        }
        pair recAns = new pair();

        pair hori = new pair();
        if (sc + 1 <= ec) {
            hori = maxpath_withpath(sr, sc + 1, er, ec);
            hori.path = "H" + hori.path;
            if (recAns.steps > hori.steps)
                recAns = hori;
        }

        pair verti = new pair();
        if (sr + 1 <= er) {
            verti = maxpath_withpath(sr + 1, sc, er, ec);
            verti.path = "V" + verti.path;
            if (recAns.steps > verti.steps)
                recAns = verti;
        }

        pair diag = new pair();
        if (sc + 1 <= ec && sr + 1 <= er) {
            diag = maxpath_withpath(sr + 1, sc + 1, er, ec);
            diag.path = "D" + diag.path;
            if (recAns.steps > diag.steps)
                recAns = diag;
        }

        recAns.steps++;
        return recAns;
    }

    public static ArrayList<String> multimazepath(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> recAns = new ArrayList<>();

        for (int i = 1; i + sc <= ec; i++) {
            ArrayList<String> smallAnsH = multimazepath(sr, sc + i, er, ec);
            for (String s : smallAnsH) {
                String st = "H" + i + " " + s;
                recAns.add(st);
            }
        }

        for (int i = 1; i + sr <= er; i++) {
            ArrayList<String> smallAnsV = multimazepath(sr + i, sc, er, ec);
            for (String s : smallAnsV) {
                String st = "V" + i + " " + s;
                recAns.add(st);
            }
        }

        for (int i = 1; i + sc <= ec && i + sr <= er; i++) {
            ArrayList<String> smallAnsD = multimazepath(sr + i, sc + i, er, ec);
            for (String s : smallAnsD) {
                String st = "D" + i + " " + s;
                recAns.add(st);
            }
        }

        return recAns;
    }

    public static int d[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

    public static String dir[] = { "U", "1", "R", "2", "D", "3", "L", "4" };

    public static boolean isSafe(int x, int y, boolean board[][]) {
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && !board[x][y])
            return true;
        return false;
    }

    public static ArrayList<String> floodfill(boolean[][] board, int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = new ArrayList<>();

        board[sr][sc] = true;
        for (int i = 0; i < 8; i++) {
            if (isSafe(sr + d[i][0], sc + d[i][1], board)) {
                ArrayList<String> smallAns = floodfill(board, sr + d[i][0], sc + d[i][1], er, ec);
                for (String s : smallAns) {
                    String st = dir[i] + s;
                    recAns.add(st);
                }
            }
        }
        board[sr][sc] = false;
        return recAns;
    }

    public static String dictionary[] = { "i", "like", "sam", "sung", "samsung", "your", "mobile", "name", "mango",
            "ice", "man", "and", "go", "cream", "icecream", "is", "what" };

    public static boolean findInDict(String str) {
        for (String s : dictionary) {
            if (str.equals(s))
                return true;
        }
        return false;
    }

    public static ArrayList<String> wordbreak(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = new ArrayList<>();

        for (int i = 1; i <= str.length(); i++) {
            String s = str.substring(0, i);
            if (findInDict(s)) {
                ArrayList<String> smallAns = wordbreak(str.substring(i));
                for (String st : smallAns) {
                    recAns.add(s + " " + st);
                }
            }
        }

        return recAns;
    }

    public static ArrayList<String> permutations(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(str);
            return base;
        }

        ArrayList<String> recAns = new ArrayList<>();
        ArrayList<String> smallAns = permutations(str.substring(1));
        for (String s : smallAns) {
            for (int i = 0; i <= s.length(); i++) {
                String st = s.substring(0, i) + str.charAt(0) + s.substring(i);
                recAns.add(st);
            }
        }

        return recAns;
    }

    public static String[] keys = { "_", "+-/", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "*()%",
            "#@$" };

    public static ArrayList<String> keypad(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = new ArrayList<>();

        ArrayList<String> smallAns = keypad(str.substring(1));
        int num = str.charAt(0) - '0';
        for (String s : smallAns) {
            for (int i = 0; i < keys[num].length(); i++) {
                recAns.add(keys[num].charAt(i) + s);
            }
        }

        if (str.length() > 1) {
            num = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            if (num >= 10 && num <= 11) {
                smallAns = keypad(str.substring(2));
                for (String s : smallAns) {
                    for (int i = 0; i < keys[num].length(); i++) {
                        recAns.add(keys[num].charAt(i) + s);
                    }
                }

            }
        }

        return recAns;
    }

    public static ArrayList<String> encoding(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = new ArrayList<>();

        if (str.charAt(0) == '0')
            return recAns;

        ArrayList<String> smallAns = encoding(str.substring(1));
        char ch = (char) (str.charAt(0) - '0' - 1 + 'a');
        for (String s : smallAns) {
            recAns.add(ch + s);
        }

        if (str.length() > 1) {
            int num = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');

            if (num >= 10 && num <= 26) {
                ch = (char) (num + 'a' - 1);
                smallAns = encoding(str.substring(2));
                for (String s : smallAns) {
                    recAns.add(ch + s);
                }
            }
        }

        return recAns;
    }

    public static boolean isPallindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int MY_minPallindromicCuts(String str) {

        if (str.length() == 1)
            return 0;

        if (isPallindrome(str))
            return 0;

        int _min = Integer.MAX_VALUE;
        for (int cut = 1; cut < str.length(); cut++) {
            int leftCuts = MY_minPallindromicCuts(str.substring(0, cut));
            int rightCuts = MY_minPallindromicCuts(str.substring(cut, str.length()));
            _min = Math.min(leftCuts + rightCuts + 1, _min);
        }
        return _min;
    }

    public static int SIR_minPallindromicCuts(String str, int i, int j) {
        if (i == j)
            return 0;
        if (isPallindrome(str.substring(i, j + 1)))
            return 0;

        int min_ = Integer.MAX_VALUE;
        for (int cut = i; cut < j; cut++) {
            int min_leftCuts = SIR_minPallindromicCuts(str, i, cut);
            int min_rightCuts = SIR_minPallindromicCuts(str, cut + 1, j);
            min_ = Math.min(min_leftCuts + min_rightCuts + 1, min_);
        }
        return min_;
    }

    public static String removeExtraHi(String str) {
        if (str.length() == 0) {
            return "";
        }

        if (str.length() > 1 && str.charAt(0) == 'h' && str.charAt(1) == 'i') {
            return removeExtraHi(str.substring(2));
        } else {
            String recAns = removeExtraHi(str.substring(1));
            if (str.charAt(0) == 'h' && recAns.length() > 0 && recAns.charAt(0) == 'i')
                return recAns.substring(1);
            else
                return str.charAt(0) + recAns;
        }
    }

    public static String compression(String str, int count) {
        if (str.length() == 0) {
            return "";
        }

        if (str.length() > 1 && str.charAt(0) == str.charAt(1)) // char will come inserted with its compression number.
            return compression(str.substring(1), count + 1);
        else {
            if (count == 1) // also handles the case if there was only one character.
                return str.charAt(0) + compression(str.substring(1), 1);
            else // time to add the no of chars with the char.
                return str.charAt(0) + (count + "") + compression(str.substring(1), 1);
        }
    }

    public static String removeExtraHiLeaveHit(String str) {
        if (str.length() == 0) {
            return "";
        }

        if (str.length() > 1 && str.charAt(0) == 'h' && str.charAt(1) == 'i') {
            if (str.length() > 2 && str.charAt(2) == 't') {
                return "hit" + removeExtraHiLeaveHit(str.substring(3));
            } else {
                return removeExtraHiLeaveHit(str.substring(2));
            }
        } else {
            String ans = removeExtraHiLeaveHit(str.substring(1));
            if (ans.length() > 0 && ans.charAt(0) == 'i' && str.charAt(0) == 'h')
                return ans.substring(1);
            else
                return str.charAt(0) + ans;
        }
    }

    public static ArrayList<ArrayList<String>> combiDivideDiffSetsBasisofSum(int arr[], int idx, int set1, int set2) {
        if (idx == arr.length) {
            ArrayList<ArrayList<String>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            base.add(new ArrayList<>());
            if (set1 == set2) {
                base.get(0).add("");
                base.get(1).add("");
            }
            return base;
        }

        ArrayList<ArrayList<String>> myAns = new ArrayList<>();
        myAns.add(new ArrayList<>());
        myAns.add(new ArrayList<>());

        
        ArrayList<ArrayList<String>> recAns1 = combiDivideDiffSetsBasisofSum(arr, idx + 1, set1 + arr[idx], set2);
        ArrayList<String> smallAns1 = recAns1.get(0);
        for (String s : smallAns1) {
            myAns.get(0).add(arr[idx] + " " + s);
        }
        myAns.get(1).addAll(recAns1.get(1));

        ArrayList<ArrayList<String>> recAns2 = combiDivideDiffSetsBasisofSum(arr, idx + 1, set1, set2 + arr[idx]);
        ArrayList<String> smallAns2 = recAns2.get(1);
        for (String s : smallAns2) {
            myAns.get(1).add(arr[idx] + " " + s);
        }
        myAns.get(0).addAll(recAns2.get(0));

        return myAns;

    }
}