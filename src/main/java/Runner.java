import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        String tokenized = tokenizeInput(System.in);
        //System.out.println(tokenized);
        ANTLRInputStream input = new ANTLRInputStream(tokenized);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        System.out.println(new Roman(parser.getResult()));
    }

    public static String tokenizeInput(InputStream input) {
        StringBuilder res = new StringBuilder();
        Scanner in = new Scanner(input);
        String current;
        while (in.hasNext()) {
            current = in.next();
            if (current.equals("et")) res.append('+');
            else res.append(new Roman(current).toDecimal());
        }
        res.append("\n");
        return res.toString();
    }

}