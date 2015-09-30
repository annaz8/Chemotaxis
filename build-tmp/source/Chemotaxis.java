import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

human anna = new human(350,350);
Virus xiuting;
Virus [] colony;
boolean mouse;
 public void setup()   
 {     
 	size(700,700);
 	xiuting = new Virus(350,350);
 	colony = new Virus[150];
 	for(int a = 0; a < colony.length; a++)
 	{
 		colony[a] = new Virus(350,350);
 	}   
 }   
 public void draw()   
 {  
 	background(0); 
 	anna.show();
 	anna.birth();
 	for (int a = 0; a < colony.length; a++)
 	{
 		colony[a].show();
 		colony[a].activate();  
 		if(mousePressed)
 		{
 			mouse = true;
 			if (mouse == true)
 			{
 				colony[a].myClr1 = 255;
	 			colony[a].myClr2 = 0;
	 			colony[a].myClr3 = 0;
	 			colony[a].wipeout();
 			}

 		}

 	}
 }
 	
 class Virus    
 {     
 	int myX, myY, myClr1, myClr2, myClr3;
 	Virus(int x, int y)
 	{
 		myX = x;
 		myY = y;
 		myClr1 = (int)(Math.random()*255);
 		myClr2 = (int)(Math.random()*255);
 		myClr3 = (int)(Math.random()*255);
 	}  
 	public void show()
 	{
 		fill(myClr1,myClr2,myClr3, 50);
 		ellipse(myX, myY, 20,20);
 	} 
    public void activate()
 	{
 		myX = myX + (int)(Math.random()*3) - 1;
 		myY = myY + (int)(Math.random()*3) - 1;
 		if (myX < mouseX)
	 	{
	 		myX = myX + (int)(Math.random()*5) - 1;
	 	}
	 	if (myX > mouseX)
	 	{
	 		myX = myX + (int)(Math.random()*5) - 3;
	 	}
	 	if (myY < mouseY)
	 	{
	 		myY = myY + (int)(Math.random()*5) - 1;
	 	}
	 	if(myY > mouseY)
	 	{
	 		myY = myY + (int)(Math.random()*5) - 3;
	 	}
 	}  
 	public void wipeout()
 	{
 		myX = (int)(Math.random()*700);
 		myY = (int)(Math.random()*700);
 	}
}
class human
{
	int itsX, itsY;
	human(int x, int y)
	{
		itsX = x;
		itsY = y;
	}
	public void show()
	{
		fill(255);
		stroke(255);
		ellipse(itsX, itsY, 40,40);
		line(itsX,itsY+20,itsX,itsY+50);
		line(itsX-20,itsY+40,itsX,itsY+35);
		line(itsX,itsY+35,itsX+20,itsY+40);
		line(itsX-20,itsY+70,itsX,itsY+50);
		line(itsX,itsY+50,itsX+20,itsY+70);
	}
	public void birth()
	{
		
		itsX = mouseX;
		itsY = mouseY;
		
	}
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
