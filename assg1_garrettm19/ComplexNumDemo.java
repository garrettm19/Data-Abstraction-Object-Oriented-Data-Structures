/**
 *
 * @author Mason Garrett
 */

package assg1_garrettm19;

public class ComplexNumDemo {
    public static void main(String[] args) {
        ComplexNum test = new ComplexNum(1, 2);
        ComplexNum test2 = new ComplexNum(3, 4);
        ComplexNum test3 = new ComplexNum(3, 4);
        ComplexNum test4 = new ComplexNum(4);
        ComplexNum test5 = new ComplexNum();

        System.out.println("Complex Number One is set to " + test);
        System.out.println("Complex Number Two is set to " + test2);
        System.out.println("Complex Number Three is set to " + test2);
     
        test.setReal(2);
        test.setImaginary(3);

        test2.setReal(1);
        test2.setImaginary(8);

        System.out.println("Are the first two complex numbers equal to eachother? " + test.equals(test2));
        System.out.println("Are the second and third complex numbers equal to eachother? " + test3.equals(test3));
        
        System.out.println("Complex Number One is now set to " + test);
        System.out.println("Complex Number Two is now set to " + test2);

        System.out.println("a+b = " + test.add(test2));
        System.out.println("a-b = " + test.sub(test2));
        System.out.println("a*b = " + test.mul(test2));
        System.out.println("The negative of Complex Number One is " + test.neg(test));
        
        System.out.println("Complex Number Four is set to " + test4);
        System.out.println("Complex Number Five is set to " + test5);
    }
}
