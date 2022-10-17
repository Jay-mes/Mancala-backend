import james.games.mancala.entity.Game;
import james.games.mancala.entity.Player;
import james.games.mancala.exception.GameNotFoundException;
import james.games.mancala.service.GamesService;
import james.games.mancala.service.PlayerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    private static GamesService gameService;
    private static PlayerService playerService;
    private static Game game;

    @BeforeAll
    public static void initTest() {
        gameService = new GamesService();

        playerService = new PlayerService();

        Player player1 = playerService.addNewPlayer();
        Player player2 = playerService.addNewPlayer();

        gameService.join(player1);
        game = gameService.join(player2);
    }

    /**
     * Test if game exists before updating
     */
    @Test
    public void test_game_not_found() {
        Game game1 = new Game();
        game1.setId(123);

        Exception exception = assertThrows(GameNotFoundException.class, () -> {
            gameService.updateGame(game1);
        });

        String expectedMessage = "Game Does not Exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }
}
