import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    /*
    1 and 2D arrays for pictures, roles, and heroes
      */
    String[] roles = {"Vanguard | Tank", 
                      "Duelist | DPS", 
                      "Strategist | Healer"};
    
    ImageFilter[] rolepics = {new ImageFilter("ezgif-49a0f74d0d383.jpg"), 
                          new ImageFilter("ezgif-403e1ec68ebda.jpg"), 
                          new ImageFilter("ezgif-49269ad1aac22.jpg")};
    
    String[][] heroes = {{"Dr. Strange", "Groot", "Peni Parker", "Magneto"},
                         {"Moon Knight", "Hela", "Spider-Man", "Winter Soldier"},
                         {"Rocket Raccoon", "Luna Snow", "Jeff the Land Shark", "Mantis"}};

    ImageFilter[][] heropics = {{new ImageFilter("strange.jpg"), new ImageFilter("groot.jpg"), new ImageFilter("peni.jpg"), new ImageFilter("magneto.jpg")},
                                {new ImageFilter("mkn.jpg"), new ImageFilter("hela.jpg"), new ImageFilter("spidey.jpg"), new ImageFilter("bucky.jpg")},
                                {new ImageFilter("rr.jpg"), new ImageFilter("luna.jpg"), new ImageFilter("jeff.jpg"), new ImageFilter("mantis.jpg")}};

    story s = new story(roles, rolepics, heroes, heropics);

    //calls each screen
    s.title();

    s.roles();

    s.vanguard();

    s.duelist();

    s.strategist();
    Theater.playScenes(s);
  }
}