package test;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import javax.swing.JButton;
 
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Txt extends javax.swing.JFrame {
    private JButton jButton_open;
    private JTextArea jTextArea1;
 
    /**
    * Auto-generated main method to display this JFrame
    */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Txt inst = new Txt();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }
     
    public Txt() {
        super();
        initGUI();
    }
     
    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            {
                jButton_open = new JButton();
                getContentPane().add(jButton_open);
                jButton_open.setText("Open");
                jButton_open.setBounds(155, 114, 92, 49);
                jButton_open.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        jButton_openMouseClicked(evt);
                    }
                });
            }
            {
                jTextArea1 = new JTextArea();
                getContentPane().add(jTextArea1);
                jTextArea1.setBounds(0, 0, 384, 262);
            }
            pack();
            setSize(400, 300);
        } catch (Exception e) {
            //add your error handling code here
            e.printStackTrace();
        }
    }
     
    private void jButton_openMouseClicked(MouseEvent evt) {
        //点击了打开
        JFileChooser open=new JFileChooser();
        FileNameExtensionFilter txt= new FileNameExtensionFilter("Txt File", "txt");
        open.setFileFilter(txt);
        int ret=open.showOpenDialog(this);
        if(ret==JFileChooser.APPROVE_OPTION)
        {
            jButton_open.setOpaque(false);
            jButton_open.setVisible(false);
            System.out.println(open.getSelectedFile().getAbsolutePath());
            try {
                BufferedReader br=new BufferedReader(new FileReader(open.getSelectedFile().getAbsolutePath()));
                String line=null;
                while((line=br.readLine())!=null)
                {
                    jTextArea1.append(line+"\n");
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
 
}
