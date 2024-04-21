import java.util.Stack;

public class ConvertString {


    public static void main(String[] args) {
        ConvertString convertString = new ConvertString();
        System.out.println(convertString.convertString2("0002210"));
    }

    public String convertString(String input) {
        String output = "";
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < input.length(); index++) {


            if (!stack.isEmpty()) {

                if (input.charAt(index) != stack.peek()) {

                    output += stack.size();
                    output += stack.peek();
                    while (!stack.isEmpty()) {
                        stack.pop();
                    }
                    stack.push(input.charAt(index));

                } else {
                    stack.push(input.charAt(index));
                }
            } else {
                stack.push(input.charAt(index));
            }
        }

        if (!stack.isEmpty()) {
            output += stack.size();
            output += stack.peek();

        }
//        System.out.println(output);

        return output;

    }

    public String convertString2(String input) {
        String output = "";

        int lastIndex = 0;
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(lastIndex) != input.charAt(index)) {
                output += (index - lastIndex);
                output += input.charAt(lastIndex);
                lastIndex = index;
            }

        }

        output += (input.length() - lastIndex);
        output += input.charAt(lastIndex);



        return output;

    }
}
