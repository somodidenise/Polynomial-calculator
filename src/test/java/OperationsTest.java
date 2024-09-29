import BusinessLogic.Operations;
import DataModels.Polynomial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class OperationsTest {
    @Test
    public void  addTest(){
        Operations operations = new Operations();

        Polynomial polynomial1 = new Polynomial("2x^3+4x^2+5");
        Polynomial polynomial2 = new Polynomial("4x^4-2x^2+2.2");
        Polynomial polynomial3 = new Polynomial("4x^4+2x^3+2x^2+7.2");
        assertEquals(operations.add(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("3x^3+2x^2+3");
        polynomial2 = new Polynomial("3x^3+2x^2+3");
        polynomial3 = new Polynomial("6x^3+4x^2+6");
        assertEquals(operations.add(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("x^2");
        polynomial2 = new Polynomial("2x^2+4x+5");
        polynomial3 = new Polynomial("3x^2+4x+5");
        assertEquals(operations.add(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("2x^4+3x^2+1");
        polynomial2 = new Polynomial("-x^3-3x^2+3x-1");
        polynomial3 = new Polynomial("2x^4-x^3+3x");
        assertEquals(operations.add(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("");
        polynomial2 = new Polynomial("");
        polynomial3 = new Polynomial("0");
        assertEquals(operations.add(polynomial1,polynomial2), polynomial3 );
    }
    @Test
    public void  subtractTest(){
        Operations operations = new Operations();

        Polynomial polynomial1 = new Polynomial("3x^4+4x^3-x^2+x-3");
        Polynomial polynomial2 = new Polynomial("2x^3+6x^2-x-3");
        Polynomial polynomial3 = new Polynomial("3x^4+2x^3-7x^2+2x");
        assertEquals(operations.subtract(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("2x^3+x^2+5x+1");
        polynomial2 = new Polynomial("2x^3+x^2+5x+1");
        polynomial3 = new Polynomial("0");
        assertEquals(operations.subtract(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("5x^2");
        polynomial2 = new Polynomial("3x^2+x+2");
        polynomial3 = new Polynomial("2x^2-x-2");
        assertEquals(operations.subtract(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("6x^4+3x^3+2x^2+x");
        polynomial2 = new Polynomial("3x^3+2x^2+3x-1");
        polynomial3 = new Polynomial("6x^4-2x+1");
        assertEquals(operations.subtract(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("");
        polynomial2 = new Polynomial("");
        polynomial3 = new Polynomial("0");
        assertEquals(operations.subtract(polynomial1,polynomial2), polynomial3 );
    }
    @Test
    public void  multiplyTest(){
        Operations operations = new Operations();

        Polynomial polynomial1 = new Polynomial("3x^2-2x+5");
        Polynomial polynomial2 = new Polynomial("4x-1");
        Polynomial polynomial3 = new Polynomial("12x^3-11x^2+22x-5");
        assertEquals(operations.multiply(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("2x+1");
        polynomial2 = new Polynomial("2x+1");
        polynomial3 = new Polynomial("4x^2+4x+1");
        assertEquals(operations.multiply(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("x^3");
        polynomial2 = new Polynomial("x^2-3x+2");
        polynomial3 = new Polynomial("x^5-3x^4+2x^3");
        assertEquals(operations.multiply(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("");
        polynomial2 = new Polynomial("");
        polynomial3 = new Polynomial("0");
        assertEquals(operations.multiply(polynomial1,polynomial2), polynomial3 );
    }
    @Test
    public void  divideTest(){
        Operations operations = new Operations();

        Polynomial polynomial1 = new Polynomial("6x^3-3x^2+2x-5");
        Polynomial polynomial2 = new Polynomial("3x-1");
        Polynomial polynomial3 = new Polynomial("2x^2-0.33x+0.55");
        assertEquals(operations.divide(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("x^2+x+1");
        polynomial2 = new Polynomial("x^2+x+1");
        polynomial3 = new Polynomial("1");
        assertEquals(operations.divide(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("4x^3+3x^2-2x+5");
        polynomial2 = new Polynomial("x");
        polynomial3 = new Polynomial("4x^2+3x-2");
        assertEquals(operations.divide(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("4x^3+3x^2-2x+5");
        polynomial2 = new Polynomial("2x-1");
        polynomial3 = new Polynomial("2x^2+2.5x+0.25");
        assertEquals(operations.divide(polynomial1,polynomial2), polynomial3 );

        polynomial1 = new Polynomial("");
        polynomial2 = new Polynomial("");
        polynomial3 = new Polynomial("0");
        assertEquals(operations.divide(polynomial1,polynomial2), polynomial3 );
    }
    @Test
    public void  derivativeTest(){
        Operations operations = new Operations();

        Polynomial polynomial1 = new Polynomial("3x^3");
        Polynomial polynomial2 = new Polynomial("9x^2");
        assertEquals(operations.derivative(polynomial1), polynomial2);

        polynomial1 = new Polynomial("x^4+2x^3+x^2+x+1");
        polynomial2 = new Polynomial("4x^3+6x^2+2x+1");
        assertEquals(operations.derivative(polynomial1), polynomial2);

        polynomial1 = new Polynomial("");
        polynomial2 = new Polynomial("0");
        assertEquals(operations.derivative(polynomial1), polynomial2);
    }
    @Test
    public void  integrateTest(){
        Operations operations = new Operations();

        Polynomial polynomial1 = new Polynomial("4x^3");
        Polynomial polynomial2 = new Polynomial("x^4");
        assertEquals(operations.integrate(polynomial1), polynomial2 );

        polynomial1 = new Polynomial("4x^3+3x^2+2x+1");
        polynomial2 = new Polynomial("x^4+x^3+x^2+x");
        assertEquals(operations.integrate(polynomial1), polynomial2 );

        polynomial1 = new Polynomial("2x^5-5x^3+4x^2-x+3");
        polynomial2 = new Polynomial("0.33x^6-1.25x^4+1.33x^3-0.5x^2+3x");
        assertEquals(operations.integrate(polynomial1), polynomial2 );

        polynomial1 = new Polynomial("");
        polynomial2 = new Polynomial("0");
        assertEquals(operations.integrate(polynomial1), polynomial2 );
    }

}
