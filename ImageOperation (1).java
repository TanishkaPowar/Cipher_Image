import javax.swing.JButton;// to create buttons
import javax.swing.JFileChooser;// JFileChooser class to create a file chooser dialog
import javax.swing.JFrame;//to create a window
import javax.swing.JOptionPane;//for displaying dialogs
import javax.swing.JTextField;//for text input
import java.awt.FlowLayout;//for arranging components in a flow
import java.awt.Font;//to set the font of components
import java.io.File;//for file operations
import java.io.FileInputStream;//for reading files
import java.io.FileOutputStream;//for writing files
public class ImageOperation {
    
    // Method for image encryption/decryption
    public static void operate(int key)
    {
        // Create a file chooser dialog
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        // Read the image file using FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            
            // Perform XOR operation with the encryption key
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            
            // Write the modified data back to the file using FileOutputStream
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        System.out.println("this is testing");
        
        // Create a JFrame (window)
        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a font
        Font font=new Font("Roboto",Font.BOLD,25);
        
        //creating button
        JButton button=new JButton();
        button.setText("Open Image");
        button.setFont(font);

        //creating text field
        JTextField textField=new JTextField(10);
        textField.setFont(font);

        // Add an action listener to the button
        button.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
        
        // Set the layout manager to FlowLayout
        f.setLayout(new FlowLayout());
        
        // Add components to the frame
        f.add(button);
        f.add(textField);
        f.setVisible(true);

    }
}