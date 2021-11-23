/**
 *
 * @author Mason Garrett
 */

package assg1_garrettm19;

public class ComplexNum {

    /**
     * Double variables to make complex number.
     */
    double real;
    double imaginary;

    /**
     * Default constructor which sets variables to zero.
     */
    public ComplexNum() {
        this.real = 0;
        this.imaginary = 0;
    }

    /**
     * Parameterized constructor which sets real to inputed value and sets imaginary to zero.
     *
     * @param real A variable of the real number of the complex number.
     */
    public ComplexNum(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    /**
     * Parameterized constructor which sets real and imaginary to inputed values.
     *
     * @param real The real number of the complex number.
     * @param imaginary The imaginary number of the complex number.
     */
    public ComplexNum(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /*
     * Returns the real variable.
     * 
     * @return real The real number of the complex number.
     */
    public double getReal() {
        return real;
    }

    /*
     * Returns the imaginary variable.
     *
     * @return imaginary The imaginary number of the complex number.
     */
    public double getImaginary() {
        return imaginary;
    }

    /*
     * Sets the real variable.
     *
     * @param real The real number of the complex number.
     */
    public void setReal(double real) {
        this.real = real;
    }

    /*
     * Sets the imaginary variable.
     *
     * @param imaginary The imaginary number of the complex number.
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /*
     * Adds the current complex number to the paramter and returns new complex number.
     *
     * @param ComplexNum n Inputed complex number.
     * @return new ComplexNum New complex number formed by addition.
     */
    public ComplexNum add(ComplexNum n) {
        return new ComplexNum(this.real + n.real, this.imaginary + n.imaginary);
    }

    /*
     * Subtracts the current complex number with the parameter and returns new complex number.
     *
     * @param ComplexNum n Inputed complex number.
     * @return new ComplexNum New complex number formed by subtraction.
     */
    public ComplexNum sub(ComplexNum n) {
        return new ComplexNum(this.real - n.real, this.imaginary - n.imaginary);
    }

    /*
     * Multiplies the current complex number with the parameter and returns the new complex number.
     *
     * @param ComplexNum n Inputed complex number.
     * @return new ComplexNum New complex number formed by multiplication.
     */
    public ComplexNum mul(ComplexNum n) {
        return new ComplexNum(((this.real * n.real)-(this.imaginary * n.imaginary)), ((this.real * n.imaginary)+(this.imaginary * n.real)));
    }

    /*
     * Negates the current complex number and returns the new complex number.
     *
     * @param ComplexNum n Inputed complex number.
     * @return new ComplexNum New complex number formed by negation.
     */
    public ComplexNum neg(ComplexNum n) {
        return new ComplexNum(-this.real, -n.imaginary);
    }

    /*
     * Converts the current complex number in the form of a string.
     *
     * @return thisString Returns the complex number in string form.
     */
    @Override
    public String toString() {
    String thisString = "";

    if (this.real != 0) {
        thisString = thisString + this.real;
    }
    if (this.imaginary != 0 && this.imaginary > 0) {
        thisString = thisString + " + " + this.imaginary + "i";
    }
    if (this.imaginary != 0 && this.imaginary < 0) {
        thisString = thisString + " - " + -this.imaginary + "i";
    }
    if(thisString.isEmpty()){
        thisString = "0";
    }
    return thisString;
    }

    /*
     * Checks if the current complex number is equal with the paramter and returns the results.
     *
     * @param Object z Object inputed that could or could not be a complex number.
     * @return true or false Returns value based on comparison of complex numbers.
     */
    @Override
    public boolean equals(Object z) {
    ComplexNum that = (ComplexNum)z;
    return this.real == that.real && this.imaginary == that.imaginary;
    }
};
