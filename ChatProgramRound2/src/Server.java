import java.io.*;
import java.net.*;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;


public class Server implements ActionListener
{
	boolean run = true;
	boolean running = true;
	private static ServerSocket ss;
	static Socket s;
	DataInputStream in;
	DataOutputStream out;
	BufferedReader br;
	String mIn = "", mOut = "";
	private JTextArea textArea;
	private JTextField textField;
	
	public static void main(String[] args)
	{
		Server s = new Server();
		s.guisetup();
		s.setup();
		s.chat();
	}
	
	private void setup()
	{
		try {
			ss  = new ServerSocket(1201);
			s   = ss.accept();
			in  = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
			br  = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void guisetup()
	{
		JFrame window = new JFrame();
		window.setSize(960, 660);
		
		textArea = new JTextArea();
		textArea.setColumns(10);
		
		window.getContentPane().add(textArea, BorderLayout.NORTH);
		
		textField = new JTextField();
		window.getContentPane().add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(this);
		window.getContentPane().add(btnSend, BorderLayout.CENTER);
		window.setVisible(true);
	}
	
	private void chat()
	{
		try
		{
			while (running)
			{
			while(run)
			{
				mIn = in.readUTF();
				System.out.println(mIn);
				textArea.append(mIn + "\n");
				run = false;
			}
			
			}
			s.close();
		}
		catch (Exception e)
		{
			//Handle Exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try
		{
		
			mOut = textField.getText();
			textField.setText("");
			textArea.append(mOut+"\n");
			out.writeUTF(mOut);
			out.flush();
			run = true;
		}
		catch (Exception d)
		{
			d.printStackTrace(System.out);
		}

		
	}
}
