/**This program reads an infix expression, converts it to a postfix expression, then evaluates that postfix expression
 * and outputs the result. A stack is used to both convert from an infix expression to a postfix expression and to
 * evaluate the postfix expression. A generic stack class is created, with an inner generic Node class. The stack has
 * push, pop, peek, and isEmpty methods. The stack has generic Nodes so that multiple data types can be used during
 * implementation.
 * </p>
 * Maggie Cowher
 * March 20, 2022
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class eCalc extends JFrame implements ActionListener {
    // create a frame
    static JFrame f;

    // create labels
    static JLabel infixLabel, postfixLabel, resultLabel;

    // create textfields
    static JTextField infix, postfix, result;

    // store operator and operands
    String infixExp, postfixExp, resultExp;

    // default constructor
    eCalc() {
        infixExp = postfixExp = resultExp = "";
    }


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
    static int precedence(Character ch) {
        switch (ch) {
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

        for (int i = 0; i < exp.length(); i++) { // For loop to iterate through each element in the string
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

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9')) { // if the value is a number
            infixExp += s;
            infix.setText(infixExp);
        } else if (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/') { // operator
            // make sure not two operators in a row
            if (infixExp.charAt(infixExp.length() - 1) == '+' || infixExp.charAt(infixExp.length() - 1) == '-' ||
                    infixExp.charAt(infixExp.length() - 1) == '-' || infixExp.charAt(infixExp.length() - 1) == '/') {
                infixExp = infixExp.substring(0, infixExp.length() - 1); // remove last character for replace
            }
            infixExp += s;
            infix.setText(infixExp);
        } else if (s.charAt(0) == '(' || s.charAt(0) == ')') { // parentheses
            infixExp += s;
            infix.setText(infixExp);
        } else if (s.charAt(0) == 'C') { // clear everything
            // clear everything
            infixExp = postfixExp = resultExp = "";

            infix.setText(infixExp);
            postfix.setText(postfixExp);
            result.setText(resultExp);
        } else if (s.charAt(0) == '=') { // evaluate expression
            // set the textfields with the result of the calculations
            infix.setText(infixExp);

            // convert infix expression to postfix expression and show
            postfixExp = InfixToPostfix(infixExp);
            postfix.setText(postfixExp);

            //evaluate postfix expression and show result
            resultExp = Integer.toString(EvaluatePostFix(postfixExp));
            result.setText(resultExp);

        } else { // all other cases (for debugging)
            infix.setText("Error");
            postfix.setText("Error");
            result.setText("Error");
        }
    }

    // main function
    public static void main(String args[]) {
        // create a frame
        f = new JFrame("ePhone eCalc (TM)");

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // create a object of class
        eCalc c = new eCalc();

        // create label to display text
        infixLabel =   new JLabel("Infix:    ");
        infixLabel.setForeground(Color.yellow);
        postfixLabel = new JLabel("Postfix: ");
        postfixLabel.setForeground(Color.yellow);
        resultLabel =  new JLabel("Result:  ");
        resultLabel.setForeground(Color.yellow);

        // create textfields
        infix = new JTextField(20);
        postfix = new JTextField(20);
        result = new JTextField(20);

        // set the textfields to non editable
        infix.setEditable(false);
        postfix.setEditable(false);
        result.setEditable(false);

        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, lp, rp, bcl, beq;

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // equals button
        beq = new JButton("=");

        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        lp = new JButton("(");
        rp = new JButton(")");

        // clear button
        bcl = new JButton("C");

        // create a panel
        JPanel p = new JPanel();

        // add action listeners
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        bcl.addActionListener(c);
        beq.addActionListener(c);
        lp.addActionListener(c);
        rp.addActionListener(c);

        // add elements to panel
        p.add(infixLabel);
        p.add(infix);
        p.add(postfixLabel);
        p.add(postfix);
        p.add(resultLabel);
        p.add(result);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(ba);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bs);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bm);
        p.add(bcl);
        p.add(b0);
        p.add(beq);
        p.add(bd);
        p.add(lp);
        p.add(rp);

        // set Background of panel
        p.setBackground(Color.blue);

        // add panel to frame
        f.add(p);

        // set frame size and make it unresizable
        f.setSize(350, 290);
        f.setResizable(false);
        f.show();
    }
}
