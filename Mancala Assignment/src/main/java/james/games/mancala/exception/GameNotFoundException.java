package james.games.mancala.exception;

public class GameNotFoundException extends Exception
{
    public GameNotFoundException (String message){
        super(message);
    }
}
