import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gui implements ActionListener {
    JTextField textField;
    JTextField hasilTextField;
    public static void main(String[] args) {
        new gui();//buat instance


    }
    
    public gui() {
        initComponent();

    }
    private void initComponent() {
        /**
         * GUI design
         */

        //------frame-----
        JFrame frame = new JFrame();//buat frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//keluar dari app
        frame.setTitle("Algoritma Welch Powell");//judul frame
        frame.setSize(600,800);//ukuran frame
        frame.setVisible(true);//tampil frame
        frame.setLayout(null);//layout manual

        ImageIcon image = new ImageIcon("src/logo/peaky_blinders.jpg");
        frame.setIconImage(image.getImage());//set logo

        //----------label--------
        JLabel label = new JLabel("ALGORITMA WELCH POWELL");//buat label judul utama
        
        label.setBounds(120,30,300,30); //set ukuran
        JLabel icon = new JLabel(image);//masukan label gambar
        icon.setBounds(130,80,150,130);
        //label masukan
        JLabel label2 = new JLabel("masukan input");
        label2.setBounds(20,250,150,30);
        
        frame.add(label);//add label ke frame
        frame.add(icon);
        frame.add(label2);
        
        //------textfield----- 
        textField = new JTextField();//masukan
        textField.setBounds(150,250,150,30);
        frame.add(textField);

        //-----combobox------
        JLabel comboBox = new JLabel("banyak vertex");
        comboBox.setBounds(20,300,150,30);
        frame.add(comboBox);
        String vertex[] = {"1", "2", "3", "4", "5"};//isi dari combobox
        JComboBox simpul= new JComboBox(vertex);
        simpul.setBounds(150,300,50,30);

        JLabel banyakwarna = new JLabel("banyak warna");
        banyakwarna.setBounds(20,350,150,30);
        frame.add(banyakwarna);
        String warna[] = {"1", "2", "3", "4","5"};
        JComboBox color = new JComboBox(warna);
        color.setBounds(150,350,50,30);
        frame.add(color);
        frame.add(simpul);

        //hasil label
        JLabel hasil = new JLabel("hasil");
        hasil.setBounds(20,450,150,30);
        //hasil textfield
        hasilTextField = new JTextField();
        hasilTextField.setBounds(150,450,150,100);

        frame.add(hasilTextField);
        frame.add(hasil);

        




        //button
        JButton button = new JButton("Start");//buat tombol
        button.setBounds(100,400,70,30);
        frame.add(button);

        //block event
        button.addActionListener(this);
        button.setActionCommand("start");


    }
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        String userfield = textField.getText();
        if (command.equals("start")){
            if(userfield.equals("halo")){
                hasilTextField.setText("helo");
            }else{
                hasilTextField.setText("helo");
            }
            JOptionPane.showMessageDialog(null, "berhasil");
        }else{
            System.out.println("tidak ada");
        }
    }
    
    
    
}
