package DataModels;

import GUI.Calculator;
import GUI.Controller;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    Map<Integer, Monomial> monomials;
    int degree;

    public Polynomial() {
        this.monomials = new HashMap<>();
    }

    public Polynomial(String polynomialText)
    {
        this.monomials = new HashMap<>();
        Pattern termPattern = Pattern.compile("([-+]?\\d*\\.?\\d*)(x)?\\^?(\\d*)?");
        Matcher matcher = termPattern.matcher(polynomialText);
            while (matcher.find()) {
                String coefficientText = matcher.group(1);
                String degreeText = matcher.group(3);
                Number coefficient;
                int degree;

                if (coefficientText.isEmpty() == true || coefficientText.equals("+") || coefficientText.equals("-")) {
                    if (matcher.group(2) != null) {
                        //cazul in care avem x in expresie
                        if (coefficientText.equals("-")) {
                            //coeficient implicit -1
                            coefficient = -1;
                        } else {
                            //coeficient implicit 1
                            coefficient = 1;
                        }
                    } else {
                        //in cazul in care nu avem nici x nici coeficient polinomul nu va avea elemente
                        break;
                    }
                } else {
                    if (coefficientText.contains(".")) {
                        coefficient = Double.parseDouble(coefficientText);
                    } else {
                        coefficient = Integer.parseInt(coefficientText);
                    }
                }

                if (degreeText.isEmpty() == true) {
                    //cazul in care expresia nu are putere
                    if (matcher.group(2) != null) {
                        //daca avem x in expresie puterea sa implicita este 1
                        degree = 1;
                    } else {
                        //daca nu avem x in expresie inseamna ca puterea lui x este 0
                        degree = 0;
                    }
                } else {
                    degree = Integer.parseInt(degreeText);
                }
                //se adauga monomul obtinum in polinom
                Monomial monomial = new Monomial(degree, coefficient);
                this.addMonomial(monomial);
            }
    }

    //metoda care returneaza gradul polinomul = cel mai mare grad gasit in monoamele din componenta sa
    public int getDegree(){
        Map<Integer, Monomial> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(this.monomials);
        List<Integer> list = new ArrayList<>(treeMap.keySet());
        if(list.isEmpty() == false) {
            return list.get(0);
        }
        return 0;
    }

    public Map<Integer, Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(Map<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Polynomial p = (Polynomial) o;
        return Objects.equals(this.toString(),p.toString());
    }

    @Override
    public String toString() {
        String string = "";
        //obtinem o lista cu gradele monoamelor ordonate descrescator
        Map<Integer, Monomial> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(this.monomials);
        List<Integer> list = new ArrayList<>(treeMap.keySet());
        for(Integer i : list)
        {
            Number x = this.monomials.get(i).getCoefficient();
            if(string.equals("") == true || (x instanceof Integer && (int)x < 0)||(x instanceof Double && (double)x < 0) )
            {
                string = string + this.monomials.get(i).toString();
            }
            else{
                 string = string + "+" + this.monomials.get(i).toString();
            }
        }
        if(string.equals(""))
        {
            return "0";
        }
        return string;
    }

    public void addMonomial(Monomial monomial)
    {
        int degree = monomial.getDegree();
        if(monomials.containsKey(degree))
        {
            Monomial monomial1 = monomials.get(degree);
            Number result;
            if(monomial1.getCoefficient() instanceof Integer && monomial.getCoefficient() instanceof Integer)
            {
                result = (int)monomial1.getCoefficient() + (int)monomial.getCoefficient();
            } else if(monomial1.getCoefficient() instanceof Double && monomial.getCoefficient() instanceof Double) {
                result = (double)monomial1.getCoefficient() + (double)monomial.getCoefficient();
            } else if (monomial1.getCoefficient() instanceof Integer) {
                result = (int)monomial1.getCoefficient() + (double)monomial.getCoefficient();
            }
            else{
                result = (double)monomial1.getCoefficient() + (int)monomial.getCoefficient();
            }
            if(result instanceof Integer && (int)result == 0)
            {
                monomials.remove(degree);
            }
            if(result instanceof Double && (double)result == 0)
            {
                monomials.remove(degree);
            }
            monomial1.setCoefficient(result);
        }
        else{
            monomials.put(degree, monomial);
        }

    }
}
