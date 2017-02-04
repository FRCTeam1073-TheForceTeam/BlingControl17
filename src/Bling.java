import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Bling 
{
	NetworkTable newtable;
	
	
	//Instance Variables
	private String color;
	private String speed;
	private int min;
	private int max;
	private String pattern;
	private String segment;
	private String put;
	
	//Constructor
	public Bling()
	{
		newtable = NetworkTable.getTable("Bling");
		NetworkTable.initialize();
	}
	
	//Methods
	public String setPattern(String patt, String col, String seg, String spd, int mini, int maxi)
	{
		pattern = patt;
		color = col;
		segment = seg;
		speed = spd;
		min = mini;
		max = maxi;
		put = "Pattern=" + pattern + "," + "Color=" + color + "," + "Segment=" + segment + "," + "Speed=" + speed + "," + "Min=" + min + "," + "Max=" + max; 
		return put;
	}
	
	public void disableLeds()
	{
		
	}
	
	public void blinkRight()
	{
		min = 19;
		max = 36;
	}
	
	public void blinkLeft()
	{
		min = 1;
		max = 18;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void send()
	{
		newtable.putString("command", put);
	}
}
