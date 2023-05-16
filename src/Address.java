public class Address {
        private String decimalDottedQuad;
        private String binary;
        private int decimal;

        private String DottedBinary;

        public Address(String decimalDottedQuad) {
                this.decimalDottedQuad = decimalDottedQuad;
                this.binary = convertToBinary(decimalDottedQuad);
                this.decimal = convertToDecimal(decimalDottedQuad);
                this.DottedBinary = convertToDottedBinary();
        }

        public Address(int decimal) {
                this.decimal = decimal;
                this.decimalDottedQuad = convertToDecimalDottedQuad(decimal);
                this.binary = convertToBinary(decimal);
                this.DottedBinary = convertToDottedBinary();
        }

        public String getDecimalDottedQuad() {
                return decimalDottedQuad;
        }

        public String getBinary() {
                return binary;
        }

        public long getDecimal() {
                return decimal;
        }
        public String getDottedBinary(){
                return DottedBinary;
        }

        private String convertToBinary(String decimalDottedQuad) {
                StringBuilder binaryBuilder = new StringBuilder();

                String[] parts = decimalDottedQuad.split("\\.");
                for (String part : parts) {
                        int decimalPart = Integer.parseInt(part);
                        String binaryPart = Integer.toBinaryString(decimalPart);
                        // Pad the binary part with leading zeros to ensure it has 8 bits
                        binaryPart = String.format("%8s", binaryPart).replace(' ', '0');
                        binaryBuilder.append(binaryPart);
                }

                return binaryBuilder.toString();
        }
        private String convertToBinary(int decimal){
                return Integer.toBinaryString(decimal);
        }

        private int convertToDecimal(String decimalDottedQuad) {
                String[] parts = decimalDottedQuad.split("\\.");

                int decimal = 0;
                for (String part : parts) {
                        int decimalPart = Integer.parseInt(part);
                        decimal = (decimal << 8) + decimalPart;
                }

                return decimal;
        }

        private String convertToDecimalDottedQuad(int decimal) {
                StringBuilder decimalDottedQuadBuilder = new StringBuilder();

                for (int i = 0; i < 4; i++) {
                        int decimalPart = (int) (decimal >> (24 - i * 8)) & 0xFF;
                        decimalDottedQuadBuilder.append(decimalPart);
                        if (i < 3) {
                                decimalDottedQuadBuilder.append(".");
                        }
                }

                return decimalDottedQuadBuilder.toString();
        }
        public String convertToDottedBinary() {
                StringBuilder dottedBinaryBuilder = new StringBuilder();

                String[] parts = binary.split("(?<=\\G.{8})");
                for (String part : parts) {
                        dottedBinaryBuilder.append(part);
                        dottedBinaryBuilder.append(".");
                }

                dottedBinaryBuilder.deleteCharAt(dottedBinaryBuilder.length() - 1);
                return dottedBinaryBuilder.toString();
        }
}