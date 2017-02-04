//package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.util.Scanner;
public class BlingRunner {

	public static void main(String[] args) {
		
		Bling lights = new Bling();
		boolean isGo = true;
		String tell = "";
		String light = "";
		String segment = "";
		String speed = "";
		int min = 0;
		int max = 0;
		Scanner input = new Scanner(System.in);
		while(isGo)
		{
			System.out.println("What do you want to do? (B)uild, (S)pecific build, (C)olor change, or (Q)uit");
			String answer = input.next();
			if(answer.equalsIgnoreCase("B"))
				{
				
				lights.disableLeds();
				System.out.println("What pattern do you want to select?");
				tell = input.next();
			
				System.out.println("What color do you want the strips to light up?");
				light = input.next();
				
				System.out.println("What segment of the strips do you want to light up?");
				segment = input.next();
				
				System.out.println("What speed do you want to run at?");
				speed = input.next();
				
				System.out.println("What minimum light do you want to activate?");
				min = input.nextInt();
							
				System.out.println("What maximum light do you want to activate?");
				max = input.nextInt();
				
				
				System.out.println(lights.setPattern(tell, light, segment, speed, min, max));
				
				System.out.print("Do you want to push this code? (Y)es or (N)o ");
				String tell2 = input.next();
				if(tell2.equalsIgnoreCase("n"))
					System.out.println("The code was not pushed.");
					
				else
					System.out.println("The code was pushed successfully");
					lights.send();
					//send the string to the pi.
				}
			
			else if(answer.equalsIgnoreCase("C"))
			{
				System.out.println("What color would you like to change the lights to?");
				String newCol = input.next();
				lights.setColor(newCol);
				lights.setPattern(tell, light, segment, speed, min, max);
			}
			
			else if(answer.equalsIgnoreCase("S"))
			{
				lights.disableLeds();
				System.out.println("What do you want to do? Blink the (L)eft of (R)ight? ");
				String answer2 = input.next();
				if(answer2.equalsIgnoreCase("L"))
				{
					lights.blinkLeft();
					System.out.println("What color do you want the lights to blink?");
					String lights2 = input.next();
					lights.setColor(lights2);
					min = 1;
					max = 18;
					System.out.println("Do you want to change the speed? (Y)es or (N)o");
					String answer3 = input.next();
					if(answer3.equals("Y"))
					{
						System.out.println("What color would you like to change the lights to?");
						String newCol = input.next();
						lights.setColor(newCol);
						lights.setPattern(tell, light, segment, speed, min, max);
					}
				}
				
				else
				{
					lights.blinkRight();
					System.out.println("What color do you want the lights to blink?");
					String lights2 = input.next();
					lights.setColor(lights2);
					System.out.println("Do you want to change the speed? (Y)es or (N)o");
					String answer3 = input.next();
					if(answer3.equals("Y"))
					{
						System.out.println("What color would you like to change the lights to?");
						String newCol = input.next();
						lights.setColor(newCol);
						lights.setPattern(tell, light, segment, speed, min, max);
					}
				}
				
				System.out.println(lights.setPattern(tell, light, segment, speed, min, max));
				System.out.println("Do you want to push this code?");
				String tell2 = input.next();
				if(tell2.equalsIgnoreCase("n"))
					System.out.println("The code was not pushed.");
					
				else
					System.out.println("The code was pushed successfully");
					lights.send();
				//send code to the pi
			}
			
			else
			{
				lights.disableLeds();
				isGo = false;
			}
		}
	}
}