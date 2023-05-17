class IpCalculator {
  private static final String VERSION = "1.0";

    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("-help")) {
            printHelp();
        } else if (args[0].equals("-version")) {
            printVersion();
        } else if (args.length > 1) {
            System.out.println("Attenzione: tutti i parametri ulteriori saranno ignorati.");
            processIpAddress(args[0]);
        } else {
            processIpAddress(args[0]);
        }
    }

    private static void processIpAddress(String ipAddress) {
        try {
            Address address = new Address(ipAddress);
            System.out.println("Indirizzo IP in forma decimale puntata: " + address.getDecimalDottedQuad());
            System.out.println("Indirizzo IP in forma binaria puntata: " + address.getDottedBinary());
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: indirizzo IP non valido.");
            System.exit(1);
        }
    }

    private static void printHelp() {
      System.out.println("Help del programma:");
      System.out.println("-help");
      System.out.println("-version");
      System.out.println("digitare inidrizzo ip");
        
    }

    private static void printVersion() {
        System.out.println("Versione del programma: " + VERSION);
        System.exit(0);
}
}
