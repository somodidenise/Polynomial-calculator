package DataModels;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Monomial {
    int degree;
    Number coefficient;

   public Monomial(int d, Number c)
    {
        this.degree = d;
        this.coefficient = c;
    }

    @Override
    public String toString() {
       String string = "";
       String group1;
       if((coefficient instanceof Integer && (int)coefficient == 1) || (coefficient instanceof Double && (double)coefficient == 1.00))
       {
           group1 = "";
       } else if ((coefficient instanceof Integer && (int)coefficient == -1) || (coefficient instanceof Double && (double)coefficient == -1.00)) {
           group1 = "-";
       }
       else{
            if(coefficient instanceof Integer)
            {
                group1 = coefficient.toString();
            }
            else{
                //obtinem coeficientul de tip real cu doua cifre dupa virgula si fara a fi aproximat
                int x = (int)((double)coefficient * 100);
                double res = x / 100.00;
                group1 = String.valueOf(res);

            }
       }
       if(degree == 0)
       {
           if(coefficient instanceof Integer)
           {
               return coefficient.toString();
           }
           else{
                 int x = (int)((double)coefficient * 100);
                 double res = x / 100.00;
                 return String.valueOf(res);
           }
       }
       if (degree == 1)
       {
           return group1 + "x";
       }
       else{
           return group1 + "x^" + degree;
       }
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }
}
