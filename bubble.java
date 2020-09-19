import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class bubble {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton[] list = new JButton[25];

    /*
     A simple program that implements bubble sort
    */
    public static void main(String[] args) {
        frame = new JFrame();
        frame.setSize(new Dimension(650, 500));
        frame.setResizable(false);
        frame.setTitle("Bubble Sort");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        frame.add(panel);

        JMenuBar menuBar = new JMenuBar();
        JMenu sortOptions = new JMenu("Sort");
        JMenuItem bubble = new JMenuItem("Bubble Sort");
        bubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method to bubble sort
                bubbleSort();

            }
        });
        sortOptions.add(bubble);
        menuBar.add(sortOptions);
        frame.setJMenuBar(menuBar);

        int x = 6;
        for (int i = 0; i < 25; i++) {
            int random = (int)(Math.random() * 500);
            JButton temp = new JButton();
            temp.setSize(20, random);
            temp.setLocation(x, 0);
            temp.setBackground(Color.PINK);
            panel.add(temp);
            list[i] = temp;
            x += 25;
        }

        frame.setVisible(true);

        int[] test = {2, 5, 3, 1, -4, 6, -5, 0};
        bubbleSort(test);
    }

    //text bubble sort method
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

    //gui implementation of bubble sort
    public static void bubbleSort() {
        Thread thread = new Thread(() -> {

            for (int i = 0; i < list.length - 1; i++) {
                for (int j = 0; j < list.length - i - 1; j++) {
                    if (list[j].getHeight() > list[j + 1].getHeight()) {
                        JButton temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                        //swap locations
                        Point temploc = list[j].getLocation();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            System.out.println("exception caught: " + ex);
                        } catch (NullPointerException e){}
                        list[j].setLocation(list[j + 1].getLocation());
                        list[j + 1].setLocation(temploc);
                    }
                }
            }
        });
        thread.start();
    }


}