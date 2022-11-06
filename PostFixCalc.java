/**This program reads an infix expression, converts it to a postfix expression, then evaluates that postfix expression
 * and outputs the result. A stack is used to both convert from an infix expression to a postfix expression and to
 * evaluate the postfix expression. A generic stack class is created, with an inner generic Node class. The stack has
 * push, pop, peek, and isEmpty methods. The stack has generic Nodes so that multiple data types can be used during
 * implementation.
 * </p>
 * Maggie Cowher
 * March 20, 2022
 */

import java.util.Scanner;

public class PostFixCalc {


    public static Integer EvaluatePostFix(String exp) {
        Stack<Integer> stack = new Stack<>(null);

        // Booleans to assure that there are digits and operators in the expression
        boolean digit = false;
        boolean operator = false;

        Node<Character> curr; // Declare node for the current value being looked at
        Node<Integer> temp; // Declare node for the stack that will be made solely of integers

        for (int i = 0; i < exp.length(); i++) { // For loop to iterate through each element in the postfix expression
            curr = new Node<>(exp.charAt(i)); // Set curr to the current element in the list

            if (Character.isDigit(curr.data)) { // If element is a digit
                digit = true;
                temp = new Node<>(Integer.parseInt(String.valueOf(exp.charAt(i))));
                stack.push(temp); // Add element to the top of the stack
            } else if (curr.data == '+' || curr.data == '-' || curr.data == '*' || curr.data == '/') { // If element is an operator
                operator = true;
                // Pop two numbers and convert them to integer values so that the operator can be applied
                int val1 = stack.pop().data;
                int val2 = stack.pop().data;
                int result; // Declare result integer to be calculated and later pushed onto the stack
                // If-else block to determine what operation to apply to the values
                if (curr.data == '+') {
                    result = val2 + val1;
                } else if (curr.data == '-') {
                    result = val2 - val1;
                } else if (curr.data == '*') {
                    result = val2 * val1;
                } else { // Do not need to specify division sign here because the outer else if statement assures that it is all that is left
                    result = val2 / val1;
                }
                // Convert the result integer to a character value, declare and initialize it as a node, and add it to the stack
                Node<Integer> res = new Node<>(result);
                stack.push(res);
            } else {
                System.out.println(curr.data + " is not a valid operation");
            }
        }

        if (!digit || !operator) { // Check if there are  no operators or digits in the expression
            System.out.println("This expression is invalid");
        }

        return stack.pop().data; // Pop the result that is left after completing the operation
    }



    // A utility function to return the precedence of a given operator
    public static int precedence(Character ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

        }
        return -1;
    }

    public static String InfixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>(null);
        String output = ""; // Declare a string variable to be outputted and initialize as null

        Node<Character> curr; // Declare node for the current value being looked at

        // Booleans to assure that there are digits and operators in the expression
        boolean digit = false;
        boolean operator = false;

        for (int i = 0; i < exp.length(); i++) { // For loop to iterate through each element in the infix expression
            curr = new Node<>(exp.charAt(i)); // Initialize node for the current value
            if (Character.isDigit(curr.data)) { // If the element is an operand "output it" by adding it to the output string to be returned later
                digit = true;
                output += curr.data;
            } else if (curr.data == '(') { // If the element is a left parenthesis, put it on the top of the stack
                stack.push(curr);
            } else if (curr.data == ')') { // If the element is a right parenthesis
                boolean leftReached = false; // Boolean to keep track of if the left parenthesis has been reached
                while (!leftReached) { // Pop and output each element until the left parenthesis is reached
                    if (stack.isEmpty()) { // If the stack is empty before the left parenthesis is reached, it is invalid
                        System.out.println("There is a mismatched parenthesis");
                    }
                    else if (stack.peek().data == '(') { // Check if the top of stack is a left parenthesis
                        leftReached = true;
                        Character trash = stack.pop().data;
                    } else { // Pop and output elements that aren't left parentheses
                        output += stack.pop().data;
                    }
                }
            } else if (curr.data == '+' || curr.data == '-' || curr.data == '*' || curr.data == '/') { // If the element is an operator
                operator = true;
                if (stack.isEmpty()) { // If the stack is empty, automatically add the element to the top of the stack
                    stack.push(curr);
                } else { // Compare precedence of the current element and the element at the top of the stack
                   int prec = precedence(curr.data);
                   int topPrec = precedence(stack.peek().data);

                    if (prec > topPrec) { // If the precedence of the current element is greater, add that element to the top of the stack
                        stack.push(curr);
                    } else {
                        boolean end = false; // Boolean for below conditions
                        do { // Continue popping and outputting elements until certain conditions are met, do one first
                            topPrec = precedence(stack.peek().data);
                            if (prec > topPrec) { // If the original operator is lower in precedence than the top element
                                end = true;
                            } else if (stack.peek().data == '(') { // If a left parenthesis is reached
                                end = true;
                            } else if (stack.isEmpty()) { // If the stack is empty
                                end = true;
                            } else { // Pop and output elements
                                output += stack.pop().data;
                            }
                        } while (!end);

                        stack.push(curr);
                    }
                }
            } else {
                System.out.println(curr.data + " is not a valid operation");
            }
        }

        if (!digit || !operator) {
            System.out.println("This expression is invalid");
        }

        while (!stack.isEmpty()) { // When there are no more elements in the expression, pop and output the rest of the stack
            output += stack.pop().data;
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Infix Expression: ");
        String InFixExpression = input.nextLine();

        String PostFixExpression = InfixToPostfix((InFixExpression));
        System.out.println(PostFixExpression);

        Integer result = EvaluatePostFix(PostFixExpression);
        System.out.println(result);

    }
}
