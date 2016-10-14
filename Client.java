import java.io.*;
import java.net.*;
public class Client 
{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("127.0.0.1", 1201);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String mIn = "" , mOut = "";
			
			while(!mIn.equals("end"))
			{
				mOut = br.readLine();
				out.writeUTF(mOut);
				mIn = in.readUTF();
				System.out.println(mIn);
			}
			
		}catch(Exception e)
		{
			//Handle Exception
		}
	}
}
