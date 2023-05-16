public class Address {
    private final String decimalDottedQuad;
    private final String[] binary;

    private final String DottedBinary;

    //private final long decimal;
    public Address(String decimalDottedQuad) {
        this.decimalDottedQuad = decimalDottedQuad;
        this.binary = decimalDottedQuad.split("//.",4);
        this.DottedBinary = binary[0]+"."+binary[1]+"."+binary[2]+"."+binary[3];
    }
    /*public Address(long decimal) {
        this.decimal = decimal;
        this.decimalDottedQuad = decimalToDottedQuad(decimal);
        this.binary = decimalToBinary(decimalDottedQuad);
    }
    */
    public String getDecimalDottedQuad() {
        return decimalDottedQuad;
    }
    public String getDottedBinary(){
        return DottedBinary;
    }


}

