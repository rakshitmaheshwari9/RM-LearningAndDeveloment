package String.Medium;

public class StringToInteger {

    public static String trim(String str) {

        if (str.length() == 0) return str;
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        int lastIndex = index;

        for (; lastIndex < str.length(); lastIndex++) {
            if (!((str.charAt(lastIndex) >= '0' && str.charAt(lastIndex) <= '9') || (str.charAt(lastIndex) == '+') || str.charAt(lastIndex) == '-'))
                break;
        }

        return str.substring(index, lastIndex);
    }

    public static int sign(String str) {
        if (str.length() == 0) return 1;
        int ans = 1;

        if (str.charAt(0) == '-') {
            return -1;
        }

        return ans;
    }

    public static String removeSign(String str) {
        if (str.length() == 0) return str;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') return str.substring(1);
        return str;
    }

    public static int convertToInteger(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int ans = 0;

        int n = str.length();
        for (int i = n - 1; i >= 0; i--) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) return 0;
            ans += (str.charAt(i) - '0') * Math.pow(10, (n - i - 1));
        }

        return ans;
    }

    public static void main(String[] args) {

        String tempString = "  -2147483647";
        if (tempString.length() == 0) System.out.println(0);
        String trimedString = trim(tempString);
        int sign = sign(trimedString);
        String removeSign = removeSign(trimedString);

        // int ans = convertToInteger(removeSign);
        int ans = 0;

        int n = removeSign.length();
        for (int i = n - 1; i >= 0; i--) {
            if (!(removeSign.charAt(i) >= '0' && removeSign.charAt(i) <= '9')) {
                System.out.println(0);
                break;
            }

            if (ans > Integer.MAX_VALUE / 10) {
                if (sign == -1) {
                    System.out.println(Integer.MIN_VALUE);
                } else {
                    System.out.println(Integer.MAX_VALUE);
                }
                break;
            } else ans += (removeSign.charAt(i) - '0') * Math.pow(10, (n - i - 1));
        }
        if (ans == 2147483647) {
            if (sign == -1) {
                System.out.println(Integer.MIN_VALUE);
            }
        } else {
            System.out.println(ans * sign);
        }

        System.out.println(ans);
    }
}
