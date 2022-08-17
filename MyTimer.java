public class MyTimer implements Runnable {
    // The forks on either side of this Philosopher and his/her philosopher number
    private static SortingPanel panel;

    public MyTimer(SortingPanel panel) {
        this.panel = panel;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1);

                if (panel.isSorted()) {
                    panel.setCompareIndex(Integer.MAX_VALUE);
                    //int i = panel.getCompareIndex();
                    //panel.getCompareIndex()
                    //i = Integer.MAX_VALUE;
                    //compare_index = Integer.MAX_VALUE;
                    return;
                } else {
                    if (panel.getIsRunning() == true) panel.sortOnlyOneItem();
                }
                panel.repaint();

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
