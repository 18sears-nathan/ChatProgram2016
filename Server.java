import java.io.*;
import java.net.*;

public class Server 
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(1201);
			Socket s = ss.accept();
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String mIn = "", mOut = "";
			
			while(!mIn.equals("end"))
			{
				mIn = in.readUTF();
				System.out.println(mIn);
				mOut = br.readLine();
				out.writeUTF(mOut);
				out.flush();
			}
			s.close();
			
		}catch (Exception e)
		{
			//Handle Exception
		}
	}
}
