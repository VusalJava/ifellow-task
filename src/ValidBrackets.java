/*
Пример 1:
               Ввод: "(()"
               Вывод: 2 - ()
Пример 2:
               Ввод: ")()())"
               Вывод: 4 - ()()
Пример 3:
               Ввод: ")(()())"
               Вывод: 6 - (()())
Пример 4:
               Ввод: ")("
               Вывод: 0
Пример 5:
               Ввод: "())(()())(()"
               Вывод: 10 - ()(()())()
*/
public class ValidBrackets {
    public static void main(String[] args) {
        String brackets = ")())()(";
        printLongestValidBrackets(brackets);

    }

    public static void printLongestValidBrackets(String brackets) {
        StringBuilder validBrackets = new StringBuilder();
        int opened = 0;
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                opened++;
                validBrackets.append(brackets.charAt(i));
            }
            if (brackets.charAt(i) == ')' && opened > 0) {
                opened--;
                validBrackets.append(brackets.charAt(i));

            }
        }
        if (opened > 0) {
            int i = validBrackets.length() - 1;
            while (opened > 0) {
                if (validBrackets.charAt(i) == '(') {
                    validBrackets.deleteCharAt(i);
                    opened--;
                }
                i--;
            }
        }
        System.out.println(validBrackets.length() > 0 ?
                validBrackets.length() + " - " + validBrackets :
                validBrackets.length());
    }

}
