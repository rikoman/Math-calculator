public class RigthExpression {
    public String Expression(String exp){
        String current ="";
        int num = 0;
        int prioriret;
        for(int i = 0;i<exp.length();i++){
            prioriret = getPrioritets(exp.charAt(i));
            if(prioriret == 0)current+=exp.charAt(i);
            if(prioriret > 1)current += " "+ exp.charAt(i) +" ";
            if(prioriret == 1)current +=  exp.charAt(i)+ " ";
            if(prioriret < 0)current += " "+ exp.charAt(i);

        }
        return current;
    }
    public int getPrioritets(char i){
        if(i == '*' || i == '/')return 3;
        if(i == '+' || i == '-')return 2;
        if(i == '(')return 1;
        if(i==')')return -1;
        return 0;
    }
}
