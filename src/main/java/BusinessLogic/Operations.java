package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;

import java.util.*;

public class Operations {
    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : polynomial1.getMonomials().entrySet())
        {
            result.addMonomial(entry.getValue());
        }
        for(Map.Entry<Integer, Monomial> entry : polynomial2.getMonomials().entrySet())
        {
            result.addMonomial(entry.getValue());
        }
        return result;
    }
    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : polynomial1.getMonomials().entrySet())
        {
            result.addMonomial(entry.getValue());
        }
        for(Map.Entry<Integer, Monomial> entry : polynomial2.getMonomials().entrySet())
        {
            Number number = entry.getValue().getCoefficient();
            Monomial monomial = entry.getValue();
            if(number instanceof Integer)
            {
                monomial.setCoefficient(-(int)number);
            }
            else{
                monomial.setCoefficient(-(double)number);
            }
            result.addMonomial(monomial);
        }
        return result;
    }
    public Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : polynomial1.getMonomials().entrySet())
        {
            for(Map.Entry<Integer,Monomial> entry1 : polynomial2.getMonomials().entrySet())
            {
                Number coefficient;
                if(entry.getValue().getCoefficient() instanceof Integer && entry1.getValue().getCoefficient() instanceof Integer)
                {
                    coefficient  = (int)entry.getValue().getCoefficient() * (int)entry1.getValue().getCoefficient();

                } else if(entry.getValue().getCoefficient() instanceof Double && entry1.getValue().getCoefficient() instanceof Double) {

                    coefficient  = (double)entry.getValue().getCoefficient() * (double)entry1.getValue().getCoefficient();

                } else if (entry.getValue().getCoefficient() instanceof Integer) {

                    coefficient  = (int)entry.getValue().getCoefficient() * (double)entry1.getValue().getCoefficient();
                }
                else{
                    coefficient  = (double)entry.getValue().getCoefficient() * (int)entry1.getValue().getCoefficient();
                }
                int degree = entry.getValue().getDegree() + entry1.getValue().getDegree();
                Monomial monomial = new Monomial(degree, coefficient);
                result.addMonomial(monomial);
            }
        }
        return result;
    }
    public Polynomial divide(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();
        Polynomial p, q;

        if(polynomial1.getDegree() > polynomial2.getDegree())
        {
            p = polynomial1;
            q = polynomial2;
        }
        else{
            p = polynomial2;
            q = polynomial1;
        }
        while(p.getMonomials().size()!=0 && q.getMonomials().size()!=0 && p.getDegree() >= q.getDegree()) {

            Number coefficient;
            Number c1 = p.getMonomials().get(p.getDegree()).getCoefficient();
            Number c2 = q.getMonomials().get(q.getDegree()).getCoefficient();
            if (c1 instanceof Integer && c2 instanceof Integer) {
                if ((int) c1 % (int) c2 == 0) {

                    coefficient = (int) c1 / (int) c2;

                } else {

                    coefficient = (int) c1 / c2.doubleValue();
                }
            } else if (c1 instanceof Double && c2 instanceof Double) {

                coefficient = (double) c1 / (double) c2;

            } else if (c1 instanceof Integer) {

                coefficient = (int) c1 / (double) c2;

            } else {

                coefficient = (double) c1 / (int) c2;
            }
            int degree = p.getMonomials().get(p.getDegree()).getDegree() - q.getMonomials().get(q.getDegree()).getDegree();
            Monomial monomial = new Monomial(degree, coefficient);
            quotient.addMonomial(monomial);
            Polynomial lastQuotient = new Polynomial();
            lastQuotient.addMonomial(monomial);
            remainder = this.subtract(p, this.multiply(lastQuotient, q));
            p = remainder;
        }
       return quotient;
    }
    public Polynomial derivative(Polynomial polynomial1)
    {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : polynomial1.getMonomials().entrySet())
        {
                Number coefficient = null;
                if(entry.getValue().getCoefficient() instanceof Integer)
                {
                    coefficient  = (int)entry.getValue().getCoefficient() * entry.getValue().getDegree();

                } else if(entry.getValue().getCoefficient() instanceof Double) {

                    coefficient  = (double)entry.getValue().getCoefficient() * entry.getValue().getDegree();

                }
                int degree = entry.getValue().getDegree()-1;
                if(degree != -1) {

                    Monomial monomial = new Monomial(degree, coefficient);
                    result.addMonomial(monomial);
                }
        }
        return result;
    }
    public Polynomial integrate(Polynomial polynomial1)
    {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : polynomial1.getMonomials().entrySet())
        {
            Number coefficient = null;
            if(entry.getValue().getCoefficient() instanceof Integer)
            {
                if((int)entry.getValue().getCoefficient() % (entry.getValue().getDegree()+1) == 0)
                {
                    coefficient = ((int)entry.getValue().getCoefficient()) / (entry.getValue().getDegree()+1);
                }
                else {
                    coefficient = (int) entry.getValue().getCoefficient() / (Double.valueOf(entry.getValue().getDegree()) + 1);
                }

            } else if(entry.getValue().getCoefficient() instanceof Double) {
                if((double)entry.getValue().getCoefficient() % (entry.getValue().getDegree()+1) == 0)
                {
                    coefficient = ((int)entry.getValue().getCoefficient()) / (entry.getValue().getDegree()+1);
                }

                coefficient  = (double)entry.getValue().getCoefficient() / (Double.valueOf(entry.getValue().getDegree())+1);
            }
            int degree = entry.getValue().getDegree()+1;
            Monomial monomial = new Monomial(degree, coefficient);
            result.addMonomial(monomial);

        }
        return result;
    }
}
