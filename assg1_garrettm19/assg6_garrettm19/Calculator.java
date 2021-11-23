/**
 *
 * @author Mason Garrett
 */
package assg6_garrettm19;

import java.util.Stack;

public class Calculator {
    public String infixExpression;
    public String postfixExpression;
    private boolean calledPostFix; 
    
    /*
     * Parameterized constructor which sets the infix string to the user inputed value, sets the postfix string to "", and sets the converted variable to false.
     * 
     * @param exp A string of the user inputed infix equation.
     */
    public Calculator(String exp) {
        this.infixExpression = exp;
        this.postfixExpression = "";
        this.calledPostFix = false;
    }
    
    /*
     * Converts the current object to a string and returns it.
     *
     * @return this.infixExpression Returns the current infix expression in string form.
     */
    @Override
    public String toString() {
        return this.infixExpression; 
    }
    
    /*
     * Converts the current infix equation to a postfix equation and returns a boolean value.
     * 
     * @return true or false Returns boolean based on if the infix was correctly converted to a postfix expression.
     */
    private boolean convertPostFix() {
        this.calledPostFix = true;
        Stack<Character> characters = new Stack<>();
        char currentChar;
        char previousChar = 0;
        
        for (int i = 0; i < infixExpression.length(); i++) {
            currentChar = infixExpression.charAt(i);
            
            if (currentChar >= '0' && currentChar <= '9') {
                postfixExpression = postfixExpression + currentChar;
            }
        
            else if (currentChar == '(') {
                characters.push(currentChar);
            }
        
            else if (currentChar == ')') {
                postfixExpression = postfixExpression + " ";
                while (characters.peek() != '(') {
                    postfixExpression = postfixExpression + " " + characters.pop();
                }
                characters.pop();
            }
            
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                postfixExpression = postfixExpression + " ";
                while (characters.isEmpty() == false && characters.peek() != '(' && precedence(currentChar) <= precedence(characters.peek())) {
                    postfixExpression = postfixExpression + characters.pop() + " ";
                }
                characters.push(currentChar);
            }
        } 
        
        while (characters.isEmpty() == false) {
            postfixExpression = postfixExpression + " " + characters.pop();
        }
        if (postfixExpression != "") {
            this.postfixExpression = postfixExpression;
            return true;
        }  
        else {
            return false;
        }
    }
    
    /*
     * Gets the current postfix expression and returns it or throws an error if it hasn't been converted yet.
     *
     * @return postFixExpression Returns the current postfixExpression.
     */
    public String getPostFix() throws IllegalStateException {
        this.convertPostFix();
        if (this.calledPostFix == false) {
            throw new IllegalStateException();
        }
        return this.postfixExpression;
        }
    
    /*
     * Evaluates the current postfix expression and returns it or throws an error if it hasn't been converted yet.
     *
     * @return answer.pop() A stack containing the evaluated postfix expression.
     */
    public int evaluate() throws IllegalStateException {
        this.convertPostFix();
        if (calledPostFix == false) {
            throw new IllegalStateException();
        }
        else {
            char currentChar;
            String temp = "";
            Stack<Integer> characters = new Stack<>();
            Stack<Integer> answer = new Stack<>();
            int a, b = 0;
            
            for (int i = 0; i < postfixExpression.length(); i++) {
                currentChar = postfixExpression.charAt(i);
                
                if (currentChar == ' ') {
                   
                }
                
                else if (currentChar >= '0' && currentChar <= '9') {
                    int tempInt = 0;
                    while (currentChar >= '0' && currentChar <= '9') {
                        tempInt = tempInt * 10 + (int)(currentChar - '0');
                        i++;
                        currentChar = postfixExpression.charAt(i);
                    }
                    i--;
                    characters.push(tempInt);
                }
                
                else {

                    b = Integer.parseInt(String.valueOf(characters.pop()));
                    try {
                        a = Integer.parseInt(String.valueOf(characters.pop()));
                    } catch (Exception e) {
                        a = answer.pop();
                    }
                
                    if (currentChar == '+') {
                        answer.push(a + b);
                    }
                
                    else if (currentChar == '-') {
                        answer.push(a - b);
                    }
                
                    else if (currentChar == '*') {
                        answer.push(a * b);
                    }
                
                    else if (currentChar == '/') {
                        answer.push(a / b);
                    }
                }
            }
            return answer.pop();
        }   
    }
    
    /*
     * PEMDAS that is used in the convert to Postfix method.
     */
    int precedence(char currentChar) {
        switch (currentChar) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}

