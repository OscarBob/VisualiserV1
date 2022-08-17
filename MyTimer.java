public class MyTimer implements Runnable {
    private static SortingPanel panel;
    private boolean rev;

    public MyTimer(SortingPanel panel) {
        this.panel = panel;
        boolean rev = false;
    }

    public void run() {
        try {
            while (true) {
                if (panel.getIsRunning() == false) {
                    Thread.currentThread().interrupt();
                    return;
                }

                if (panel.isSorted() && rev == false) {
                    if (this.rev == false) {
                        this.rev = true;
                        panel.getZeroed();
                        panel.setCompareIndex(0);
                    }
                }

                if ((panel.getCompareIndex()+1) >= panel.getArray().length) {
                    if (this.rev == true) {
                        this.rev = false;
                        panel.getZeroed();
                        panel.setCompareIndex(0);
                    }
                }

                if (rev) {
                    System.out.print("hmmm");
                    if (panel.getIsRunning() == true) panel.randomOnlyOneItem();
                    Thread.sleep(5);
                } else {

                    if (panel.getIsRunning() == true) panel.sortOnlyOneItem();
                }
                Thread.sleep(0, 1);
                panel.repaint();

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
