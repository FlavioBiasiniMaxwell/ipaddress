class Main {
    public static void main(String[] args) {
        Address ip = new Address("192.168.0.1");
        System.out.println("IP1: " + ip.getDecimalDottedQuads());
        System.out.println("IP1 in binario: " + ip.getDottedBinary());
        System.out.println();

        ip = new Address(-1062731775);
        System.out.println("IP2: " + ip.getDecimalDottedQuads());
        System.out.println("IP2 in binario: " + ip.getDottedBinary());
    }
}