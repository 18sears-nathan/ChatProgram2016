import java.awt.Color;

public class Body 
{
	public double posX,posY;
	public double velX,velY;
	public double forceX,forceY;
	public double mass;
	public Color color;
	public Body(double posX, double posY, double velX, double velY, double mass, Color color)
	{
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.mass = mass;
		this.color = color;
	}
}