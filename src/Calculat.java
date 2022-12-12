public class Calculat {
    private int i;
    String[] Tokens;
    public Calculat(String arg){
        this.Tokens = arg.split(" ");
        this.i = 0;
    }
    public double calc(){
        double first = multiply();
        while(i< Tokens.length){
            String oper = Tokens[i];
            if(!oper.equals("+")&&!oper.equals("-"))break;
            else  i++;
            double second = multiply();
            if(oper.equals("+"))first+= second;
            else first-=second;

        }
        return first;
    }
    public double multiply(){
        double first = factor();
        while(i< Tokens.length){
            String oper = Tokens[i];
            if(!oper.equals("*")&&!oper.equals("/")) break;
            else i++;
            double second = factor();
            if(oper.equals("*")) first*=second;
            else first/=second;
        }
        return first;
    }
    public double factor(){
        String next = Tokens[i];
        double result;
        if(next.equals("(")){
            i++;
            result=calc();
            String stb = "";
            if(i< Tokens.length) stb = Tokens[i];
            if(stb.equals(")")){
                i++;
                return result;
            }
        }
        i++;
        return Double.parseDouble(next);
    }
}

