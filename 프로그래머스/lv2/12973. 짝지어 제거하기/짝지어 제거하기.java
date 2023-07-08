import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(char chr:s.toCharArray()){
            if(stack.isEmpty()){
                stack.add(chr);
            } else {
                char peeked = stack.peek();
                if(peeked == chr){
                    stack.pop();
                } else {
                    stack.add(chr);
                }
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }
}