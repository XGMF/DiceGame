package nz.ac.eit.DiceGame;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        {
            // instantiate game object
            Game game = new Game();
            
            // start game play
            game.play();
        }
    }
}
