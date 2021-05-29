import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-05-12 14:40
 **/
public class Test5 {

   // char[] arr= new char[]{'{','}','(',')','[',']'};

    @Test
    public void test(){
        System.out.println(getValid("([)]"));
    }


    boolean getValid(String str){
        if(str == null || str.length() == 0 || str.trim().length() == 0) return false;
        HashMap<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('}','{');
        map.put('(',')');
        map.put(')','(');
        map.put('[',']');
        map.put(']','[');
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
        for(char ch: chars){
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                Character pop = stack.peek();
                Character character = map.get(pop);
                if(character == ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }

            }
        }
        return stack.isEmpty();
       // Character pop = stack.pop();



       // return false;
    }

}
