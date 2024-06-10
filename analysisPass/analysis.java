
import java.util.*;
import java.io.Console;

public class analysis {
    static String target;
    static String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
    static int maxLen = 4;

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        char[] passwordArray = console.readPassword("パスワードを入力してください: ");
        target = new String(passwordArray);

        if (yesNoInput()) {
            long start = System.currentTimeMillis();
            String pw = check("", 3);
            if (pw == null) {
                System.out.println("失敗");
            } else {
                System.out.println();
                System.out.println("パスワードが見つかりました ----->>> " + pw);
                long finish = System.currentTimeMillis() - start;
                System.out.println(finish / 1000.0 + "秒 = " + finish / 60000.0 + "分");
            }
        } else {
            System.out.println("program end.");
        }
    }

    static String check(String curr, int len) {
        if (len == maxLen) {
            System.out.println(curr + " 回目の処理 : " + curr);
            if (curr.equals(target)) {
                return curr;
            } else {
                return null;
            }
        } else {
            for (char c : chars.toCharArray()) {
                String result = check(curr + c, len + 1);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }
    }

    static boolean yesNoInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("パスワードの解析を始めますか? [yes/no]: ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("yes")) {
                return true;
            } else {
                return false;
            }
        }
    }
}
