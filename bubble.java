import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class bubble {

    private static JFrame frame;
    private static JPanel panel;
    private static JPanel[] list = new JPanel[200];

    /*
     * A simple program that implements bubble sort
     */
    public static void main(String[] args) {
        frame = new JFrame();
        frame.setSize(new Dimension(1025, 520));
        frame.setResizable(false);
        frame.setTitle("Bubble Sort");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        frame.add(panel);

        JMenuBar menuBar = new JMenuBar();
        JMenu sortOptions = new JMenu("sort");
        JMenuItem bubble = new JMenuItem("bubble sort");
        bubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // method to bubble sort
                bubbleSort();
            }
        });
        sortOptions.add(bubble);
        menuBar.add(sortOptions);

        JMenuItem unsort = new JMenuItem("unsort");
        unsort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSort();
            }
        });
        menuBar.add(unsort);

        frame.setJMenuBar(menuBar);
        setup();
        frame.setVisible(true);

    }

    public static void setup() {
        int x = 6;
        for (int i = 0; i < 200; i++) {
            int random = (int) (Math.random() * 440);
            JPanel temp = new JPanel();
            temp.setSize(3, random);
            temp.setLocation(x, 0);
            temp.setBackground(Color.PINK);
            panel.add(temp);
            list[i] = temp;
            x += 5;
        }
    }

    // text bubble sort method
    public static void bubbleSort(int[] array) {
        System.out.println("unsorted: " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("sorted: " + Arrays.toString(array));
    }

    // gui implementation of bubble sort
    public static void bubbleSort() {
        Thread thread = new Thread(() -> {

            for (int i = 0; i < list.length - 1; i++) {
                for (int j = 0; j < list.length - i - 1; j++) {
                    if (list[j].getHeight() > list[j + 1].getHeight()) {
                        JPanel temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                        // swap locations
                        Point temploc = list[j].getLocation();
                        // list[j].setBackground(Color.RED);
                        list[j].setLocation(list[j + 1].getLocation());
                        list[j + 1].setBackground(Color.RED);
                        list[j + 1].setLocation(temploc);

                        try {
                            Thread.sleep(3);
                        } catch (InterruptedException ex) {
                            System.out.println("exception caught: " + ex);
                        } catch (NullPointerException e) {
                        }

                        list[j + 1].setBackground(Color.PINK);

                    }
                }
            }
            for (int i = 0; i < list.length; i++) {
                list[i].setBackground(Color.GREEN);
            }
        });
        thread.start();
        
    }

    public static void unSort() {
        for (int i = 0; i < list.length; i++) {
            list[i].setBackground(Color.PINK);
        }
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                int random = (int) (Math.random() * 440);
                list[i].setSize(3, random);
                try {
                    Thread.sleep(1);
                } catch (Exception e){};
                
            }
        });
        thread.start();
    }

}