class BarManager {
    public static void main(final String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui();
            }
        });
    }
}
