import java.io.*;
public class ChatMessage implements Serializable
{
		protected static final long serialVersionUID = 1112122200L;
		//People counts the number of users
		//message = ordinary message
		//Logout to disconnect from the server
		static final int PEOPLE = 0, MESSAGE = 1, LOGOUT = 2;
		private int type;
		private String message;
		
		//constructors
		
		ChatMessage(int type, String message)
		{
			this.type = type;
			this.message = message;
		}
		
		//get
		
		int getType()
		{
			return type;
		}
		
		String getMessage()
		{
			return message;
		}
}
