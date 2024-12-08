package StackAsArrayList;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value){
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }

    public static String reverseString(String string) {
        // Create a new stack of characters.
        Stack<Character> stack = new Stack<>();
        // Create an empty string for the reversed characters.
        String reversedString = "";

        // Loop through each character in the original string and push it onto the stack.
        for (char c : string.toCharArray()) {
            stack.push(c);
        }

        // Pop each character off the stack and add it to the reversed string.
        // This will reverse the order of the characters in the original string.
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        // Return the reversed string.
        return reversedString;
    }
    

    public static boolean isBalancedParentheses(String parentheses) {
        // Create an empty stack of characters
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string
        for (char p : parentheses.toCharArray()) {
            // If the current character is an opening parenthesis, push it onto the stack
            if (p == '(') {
                stack.push(p);
            }
            // If the current character is a closing parenthesis, check if the stack is empty or
            // if the top element of the stack is not an opening parenthesis. If either of these
            // conditions is true, return false, because the parentheses are not balanced.
            else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        // After iterating through all the characters in the input string, check if the stack is
        // empty. If the stack is empty, return true, because all the opening parentheses have been
        // matched with closing parentheses. Otherwise, return false, because there are still some
        // opening parentheses left on the stack that have not been matched with closing parentheses.
        return stack.isEmpty();
    }




}

