package model;

/**
 *
 * @author Haidir
 */
public class GameRecord {
    
    public String categoryGame;
    public String nameGame;
    public int priceGame;
    
    public String categoryGame() {return this.categoryGame;}
    public String nameGame() {return this.nameGame;}
    public int priceGame() {return this.priceGame;}
    
    public GameRecord (String categoryGame, String nameGame, int priceGame) {
        this.categoryGame = categoryGame;
        this.nameGame = nameGame;
        this.priceGame = priceGame;
    }
     
    public String getNameGame(){
        return nameGame;
    }
    public int getPriceGame(){
        return priceGame;
    }
    
    public String getCategory(){
       return this.categoryGame;
    }

    

   
}
