package KIT_Einheiten.Multithreading.Klassen;

public class SyncThread_1 extends Thread {
    static int zaehler = 0;
    private String name;

    public SyncThread_1(String name) {
        this.name = name;
    }

    /**
     * Absichtlicher Syncfehlers
     * <p>
     * Man beachte, dass in der Main hier mit
     * mehreren Objekten auf den statischen Zähler
     * zugegriffen wird. Dies sorgt dafür, dass
     * z.B. mehrmals auf 2 gezählt wird. Dies bedeutet,
     * dass die Threads nicht synchronisiert sind.
     */
    @Override
    public void run() {
        super.run();

        while (true) {
            // Behebt den obigen Fehler
            // WICHTIG: Muss auf this.GETCLASS
            // aufgerufen werden nicht nur auf this.
            synchronized (this.getClass()) {
                if (SyncThread_1.zaehler >= 90) {
                    break;
                } else {
                    SyncThread_1.zaehler++;
                    System.out.println(this.name + " " + SyncThread_1.zaehler);
                }
            }
        }
    }
}
