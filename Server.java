import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server 
{
	private static int uniqueID;
	private ArrayList<CLientThread> al;
	private ServerGUI sg;
	private SimpleDateFormat sdf;
	private int port;
	private boolean keepGoing;
	
	//Wait for server to get the port connection
	public Server(int port)
	{
		this(port, null);
	}

	public Server(int port, ServerGUI sg)
	{
		this.sg = sg;
		//port
		this.port = port;
		sdf = new SimpleDateFormat("HH:mm:ss");
		
		al = new ArrayList<ClientThread>();
	}
	
	public void start()
	{
		keepGoing = true;
		
		try
		{
			ServerSocket serverSocket = new ServerSocket();
			while(keepGoing)
			{
				display("Server waitong for CLients on port "+ port +".");
				
				Socket socket = new serverSocket.accept();
				if(!keepGoing)
					break;
				ClientThread t = new ClientThread(socket);
				al.add(t);
				
				t.start();
			}
			try
			{
				serverSocket.close();
				for(int i = 0; i < al.size(); i++)
				{
					ClientThread tc = al.get(i);
					try
					{
						tc.sInput.close();
						tc.sOutput.close();
						tc.socket.close();
					}
					catch(IOException ioE)
					{
					}
				}
			}
			catch (Exception e)
			{
				display("Execption closing the server and Clients" + e);
			}
		}
	}
}
