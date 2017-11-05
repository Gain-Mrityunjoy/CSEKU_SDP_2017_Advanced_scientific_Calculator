package com.example.gain.advance_scientific_calculator;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by GAIN on 10/12/2017.
 */

public class OctMode {
    boolean check_error = false;

    public String standardizeDouble(double num){
        int a = (int)num;
        if (a == num)
            return Integer.toString(a);
        else return Double.toString(num);
    }

    public boolean isCharPi(char c){
        if (c == 'π') return true;
        else return false;
    }

    public boolean isNumPi(double num){
        if (num == Math.PI) return true;
        else return false;
    }

    public boolean isNum(char c){
        if (Character.isDigit(c) || isCharPi(c)) return true;
        else return false;
    }

    public String NumToString(double num){
        if (isNumPi(num)) return "3.141592654 ";
        else return standardizeDouble(num);
    }

    public double StringToNum(String s){
        if (isCharPi(s.charAt(0))) return Math.PI;
        else return Double.parseDouble(s);
    }

    public boolean isOperator(char c){
        char operator[] = { '+', '-', '*', '/' };

        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1)
            return true;
        else return false;
    }
    public int priority(char c){
        switch (c) {
            case '+' : case '-' : return 1;
            case '*' : case '/' : return 2;
        }
        return 0;
    }

    public boolean isOneMath(char c){
        char operator[] = { 's', 'c', 't', '@', '(','l','v','x','y','z','m','n'};
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1)
            return true;
        else return false;
    }

    public String standardize(String s){
        String s1 = "";
        s = s.trim();
        s = s.replaceAll("\\s+"," ");
        int open = 0, close = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') open++;
            if (c == ')') close++;
        }
        for (int i=0; i< (open - close); i++)
            s += ')';
        for (int i=0; i<s.length(); i++){
            if (i>0 && isOneMath(s.charAt(i)) && (s.charAt(i-1) == ')' || isNum(s.charAt(i-1))))
                s1 = s1 + "*";
            if ((i == 0 || (i>0 && !isNum(s.charAt(i-1)))) && s.charAt(i) == '-' && isNum(s.charAt(i+1))) {
                s1 = s1 + "~";
            }
            else if (i>0 && (isNum(s.charAt(i-1)) || s.charAt(i-1) == ')') && isCharPi(s.charAt(i)))
                s1 = s1 + "*" + s.charAt(i);

            else s1 = s1 + s.charAt(i);
        }
        return s1;
    }

    public String[] processString(String sMath){
        String s1 = "", elementMath[] = null;
        sMath = standardize(sMath);
        OctMode OM = new OctMode ();
        for (int i=0; i<sMath.length(); i++){
            char c = sMath.charAt(i);
            if (i<sMath.length()-1 && isCharPi(c) && !OM.isOperator(sMath.charAt(i+1))){
                check_error = true;
                return null;
            }
            else
            if (!OM.isOperator(c))
                s1 = s1 + c;
            else s1 = s1 + " " + c + " ";
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+"," ");
        elementMath = s1.split(" ");
        return elementMath;
    }

    public String[] postfix(String[] elementMath){
        OctMode  OM = new OctMode ();
        String s1 = "", E[];
        Stack<String> S = new Stack<String>();
        for (int i=0; i<elementMath.length; i++){
            char c = elementMath[i].charAt(0);

            if (!OM.isOperator(c))
                s1 = s1 + elementMath[i] + " ";
            else{
                if (c == '(') S.push(elementMath[i]);
                else{
                    if (c == ')'){
                        char c1;
                        do{
                            c1 = S.peek().charAt(0);
                            if (c1 != '(') s1 = s1 + S.peek() + " ";
                            S.pop();
                        }while (c1 != '(');
                    }
                    else{

                        while (!S.isEmpty() && OM.priority(S.peek().charAt(0)) >= OM.priority(c))
                            s1 = s1 + S.pop() + " ";
                        S.push(elementMath[i]);
                    }
                }
            }
        }
        while (!S.isEmpty()) s1 = s1 + S.pop() + " ";
        E = s1.split(" ");
        return E;
    }

    public String decToBin(int num){
        String b;
        b=(Integer.toBinaryString(num));

        return b;
    }
    public String decToOct(int num){
        String b;
        b=(Integer.toOctalString(num));

        return b;
    }

    public String decToHex(int num){
        String b;
        b=(Integer.toHexString(num));

        return b;
    }

    public String valueMath(String[] elementMath){
        Stack <Integer> S = new Stack<Integer>();
        OctMode OM = new OctMode();
        int num = 0;
        for (int i=0; i<elementMath.length; i++){
            char c = elementMath[i].charAt(0);

            if (!OM.isOperator(c)) {
                S.push(Integer.parseInt(elementMath[i]));
            }
            else{

                int num1 = S.pop();
                num1=Integer.parseInt(Integer.toString(num1),8);
                if (!S.empty()){
                    int num2 = S.peek();
                    num2=Integer.parseInt(Integer.toString(num2),8);
                    switch (c) {

                        case '+' : num =num1+num2; S.pop(); break;
                        case '-' : num =num2-num1; S.pop(); break;
                        case '*' : num =num1*num2; S.pop(); break;
                        case '/' : {
                            if (num1 != 0) num = num2/num1;
                            else check_error = true;
                            S.pop(); break;
                        }


                    }
                }
                S.push(num);
            }
        }

        return NumToString(S.pop());
    }



}
