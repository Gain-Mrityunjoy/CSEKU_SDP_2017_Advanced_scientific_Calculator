package com.example.gain.advance_scientific_calculator;

/**
 * Created by GAIN on 8/5/2017.
 */


        import java.util.Arrays;
        import java.util.Stack;


class InfixToPostfix{
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
        char operator[] = { '+', '-', '*', '/', '^', '~', 's', 'c', 't','l','v', '@','#','$', '!','p', '%', ')', '(','a','x','y','z','m','n'};

        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1)
            return true;
        else return false;
    }
    public int priority(char c){
        switch (c) {
            case '+' : case '-' : return 1;
            case '*' : case '/' : return 2;
            case '@' : case '!' :case'p': case '^' :case '#':case '$':case 'a':case '~': return 3;
            case 's' : case 'c' : case 't' :case 'l':case 'v':case 'x':case 'y':case 'z':case 'm':case 'n': return 4;
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
        InfixToPostfix  ITP = new InfixToPostfix();
        for (int i=0; i<sMath.length(); i++){
            char c = sMath.charAt(i);
            if (i<sMath.length()-1 && isCharPi(c) && !ITP.isOperator(sMath.charAt(i+1))){
                check_error = true;
                return null;
            }
            else
            if (!ITP.isOperator(c))
                s1 = s1 + c;
            else s1 = s1 + " " + c + " ";
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+"," ");
        elementMath = s1.split(" ");
        return elementMath;
    }

    public String[] postfix(String[] elementMath){
        InfixToPostfix  ITP = new InfixToPostfix();
        String s1 = "", E[];
        Stack <String> S = new Stack<String>();
        for (int i=0; i<elementMath.length; i++){
            char c = elementMath[i].charAt(0);

            if (!ITP.isOperator(c))
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

                        while (!S.isEmpty() && ITP.priority(S.peek().charAt(0)) >= ITP.priority(c))
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

    public String valueMath(String[] elementMath){
        Stack <Double> S = new Stack<Double>();
        InfixToPostfix  ITP = new InfixToPostfix();
        double num = 0.0;
        for (int i=0; i<elementMath.length; i++){
            char c = elementMath[i].charAt(0);
            if (isCharPi(c)) S.push(Math.PI);
            else{
                if (!ITP.isOperator(c)) S.push(Double.parseDouble(elementMath[i]));
                else{

                    double num1 = S.pop();
                    switch (c) {
                        case 's' : num = Math.sin(num1*(Math.PI/180)); break;
                        case 'x' : num = Math.asin(num1)*(180/Math.PI); break;
                        case 'c' : num = Math.cos(num1*(Math.PI/180)); break;
                        case 'y' : num = Math.acos(num1)*(180/Math.PI); break;
                        case 't' : {
                            if(num1!=90){
                                num = Math.tan(num1 * (Math.PI / 180));
                                break;}
                            else check_error=true;
                        }
                        case 'z' : num =  Math.atan(num1)*(180/Math.PI); break;
                        case 'l' : num = Math.log10(num1); break;
                        case 'm' : num = Math.pow(10,num1); break;
                        case 'v' : num = Math.log(num1); break;
                        case 'n' : num = Math.exp(num1); break;
                        case '%' : num = num1/100; break;
                        case '#' : num = Math.pow(num1,2 );  break;
                        case '$' : num = Math.pow(num1,3);  break;
                        case '~' : num = Math.pow(num1,-1);  break;
                        case '@' : {
                            if (num1 >=0){
                                num = Math.sqrt(num1); break;
                            }
                            else check_error = true;
                        }
                        case '!' : {
                            if (num1 >= 0 && (int)num1 == num1){
                                num = 1;
                                for (int j=1; j<=(int)num1; j++)
                                    num = num * j;
                            }
                            else check_error = true;
                        }

                        default : break;
                    }
                    if (!S.empty()){
                        double num2 = S.peek();
                        switch (c) {

                            case '+' : num = num2 + num1; S.pop(); break;
                            case '-' : num = num2 - num1; S.pop(); break;
                            case '*' : num = num2 * num1; S.pop(); break;
                            case '/' : {
                                if (num1 != 0) num = num2 / num1;
                                else check_error = true;
                                S.pop(); break;
                            }
                            case '^' : num = Math.pow(num2, num1); S.pop(); break;
                            case 'p' : {
                                if ( num2>=num1){
                                    int number1=1;
                                    int number2=1;
                                    for (int m=1; m<=num2; m++)
                                        number2 = number2 * m;
                                    for (int k=1; k<=(num2-num1); k++)
                                        number1=number1*k;

                                    num=number2/number1;
                                }

                                else check_error = true;
                                S.pop();break;
                            }
                            case 'a' : {
                                if (num2 >= num1) {
                                    int number1 = 1;
                                    int number2 = 1;
                                    int number3 = 1;
                                    for (int m = 1; m <= num2; m++)
                                        number2 = number2 * m;
                                    for (int o = 1; o <= num1; o++)
                                        number3 = number3 * o;
                                    for (int k = 1; k <= (num2 - num1); k++)
                                        number1 = number1 * k;

                                    num = number2 / (number1 * number3);
                                } else check_error = true;
                                S.pop();
                                break;
                            }
                        }
                    }
                    S.push(num);
                }
            }
        }
        return NumToString(S.pop());
    }


}

