import org.code.theater.*;
import org.code.media.*;

public class story extends Scene{

  //instance variables
  private String[] roles;
  private ImageFilter[] rolepics;
  private String[][] heroes;
  private ImageFilter[][] heropics;

  //parameterized constructor
  public story(String[] roles, ImageFilter[] rolepics, String[][] heroes, ImageFilter[][] heropics) {
    this.roles = roles;
    this.rolepics = rolepics;
    this.heroes = heroes;
    this.heropics = heropics;
  }

  
  /*
  Draws title screen
  Image of logo
  Characters in:
  */
  public void title() {
    drawImage("mr-logo.png", 0, 80, 400);
    setTextHeight(30);
    drawText("Characters in: ", 120, 65);
    pause(2);
  }

  /*
  Shows all roles
  3 roles
  Changes color depending on role
  Has text for roles
  */
  public void roles() {
    Color c = new Color(75, 75, 75);
    clear(c);
    setTextColor("white");
    setTextHeight(20);
    drawText("Choose a role", 130, 30);

    playNote(70, 0.5);
    
    rolepics[0].keepColor("blue");
    drawImage(rolepics[0], 0, 60, 100);
    rolepics[1].keepColor("red");
    drawImage(rolepics[1], 300, 160, 100);
    
    rolepics[2].keepColor("green");
    drawImage(rolepics[2], 0, 260, 100);
    
    drawText(roles[0], 110, 110);
    drawText(roles[1], 170, 210);
    drawText(roles[2], 110, 310);
    pause(2);
  }

  /*
  Vanguards
  Draws all pictures
  Prints names
  */
  public void vanguard() {
    clear("white");
    setTextColor("black");
    drawText("Vanguard", 150, 30);
    setTextHeight(15);
    
    check(0);
    drawImage(heropics[0][0], 0, 50, 160);
    drawText(heroes[0][0], 50, 45);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[0][1], 220, 50, 160);
    drawText(heroes[0][1], 275, 45);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[0][2], 0, 245, 160);
    drawText(heroes[0][2], 50, 235);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[0][3], 220, 245, 160);
    drawText(heroes[0][3], 275, 235);
    playNote(70, 0.2);
    
    pause(0.5);
    
    pause(2);
  }

  /*
  Duelists
  Draws all pictures
  Prints names
  */
  public void duelist() {
    clear("white");
    setTextColor("black");
    setTextHeight(20);
    drawText("Duelist", 160, 30);

    check(1);
    setTextHeight(15);
    
    drawImage(heropics[1][0], 0, 50, 160);
    drawText(heroes[1][0], 50, 45);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[1][1], 220, 50, 160);
    drawText(heroes[1][1], 275, 45);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[1][2], 0, 245, 160);
    drawText(heroes[1][2], 50, 235);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[1][3], 220, 245, 160);
    drawText(heroes[1][3], 275, 235);
    playNote(70, 0.2);
    
    pause(0.5);
    
    pause(2);
  }

  /*
  Strategists
  Draws all pictures
  Prints names
  */
  public void strategist() {
    clear("white");
    setTextColor("black");
    setTextHeight(20);
    drawText("Strategist", 160, 30);

    check(2);
    setTextHeight(15);
    
    drawImage(heropics[2][0], 0, 50, 160);
    drawText(heroes[2][0], 50, 45);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[2][1], 220, 50, 160);
    drawText(heroes[2][1], 275, 45);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[2][2], 0, 245, 160);
    drawText(heroes[2][2], 50, 235);
    playNote(70, 0.2);
    
    pause(0.5);
    
    drawImage(heropics[2][3], 220, 245, 160);
    drawText(heroes[2][3], 275, 235);
    playNote(70, 0.2);
    
    pause(0.5);
    
    pause(2);
  }

  /*
  if hero name has a space
  filter will run depending on the role
  */
  public void check(int index) {
    for(int i = 0; i < heropics[index].length; i++) {
      if((heroes[index][i].indexOf(" ") != -1) && (heroes[index][i].length() >= 11)) {
        if(index == 0) {
          heropics[index][i].sharpen();
        } else if (index == 1) {
          heropics[index][i].mirrorVertical();
        } else {
          heropics[index][i].upsidedown();
        }
      }
    }
  }
}