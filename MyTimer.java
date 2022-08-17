public class MyTimer implements Runnable {
    // The forks on either side of this Philosopher and his/her philosopher number
    private static SortingPanel panel;

    public MyTimer(SortingPanel panel) {
        this.panel = panel;
    }

    public void run() {
        try {
            while (true) {
                //System.out.print("hmm");
                if (panel.isSorted()) {
                    panel.setCompareIndex(Integer.MAX_VALUE);
                    //System.out.print(panel.getArray());
                    System.out.print("hmm");
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    if (panel.getIsRunning() == true) panel.sortOnlyOneItem();
                }
                Thread.sleep(0, 1);
                panel.repaint();
                //Thread.sleep(1);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
