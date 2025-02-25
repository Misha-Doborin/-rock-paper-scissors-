

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project  {
    JFrame jFrame = new JFrame("KNB");
    JPanel jPanel = new JPanel();

    String [] list = {"камень", "ножницы", "бумага"};
    JList jList1 = new JList(list);
    JTextArea jTextArea1 = new JTextArea(10,20);
    String a = "вы выиграли";
    String b = "вы проиграли";
    String c = "ничья";


    public void go(){
        jFrame.getContentPane().add(BorderLayout.CENTER, jPanel);
        jPanel.add(jList1);

        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ise) {
                if(!ise.getValueIsAdjusting()){
                    String selection = (String) jList1.getSelectedValue();
                    int rand = (int) (Math.random() * 3);
                    String g = list[rand];
                    if (selection.equals(g)){
                        jTextArea1.setText(c);
                    }
                    if (selection.equals("бумага") & g.equals("камень")){
                        jTextArea1.setText(a);
                    }
                    if (selection.equals("бумага") & g.equals("ножницы")){
                        jTextArea1.setText(b);
                    }
                    if (selection.equals("камень") & g.equals("ножницы")){
                        jTextArea1.setText(a);
                    }
                    if (selection.equals("камень") & g.equals("бумага")){
                        jTextArea1.setText(b);
                    }
                    if (selection.equals("ножницы") & g.equals("бумага")){
                        jTextArea1.setText(a);
                    }
                    if (selection.equals("ножницы") & g.equals("камень")){
                        jTextArea1.setText(b);
                    }
                }
            }
        });

        jPanel.add(jTextArea1);
        jTextArea1.setLineWrap(true);

        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Project project = new Project();
        project.go();
    }
}
