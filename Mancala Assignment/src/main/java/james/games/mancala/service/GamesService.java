package james.games.mancala.service;

import james.games.mancala.entity.Game;
import james.games.mancala.entity.Player;
import james.games.mancala.exception.GameNotFoundException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class GamesService
{
    @Inject
    PlayerService playerService;

    private final List<Game> games = new ArrayList<>();

    public Game join(Player player)
    {

        var availableGame = games.stream().filter(game -> game.getPlayers().size() == 1).findFirst();

        if(availableGame.isPresent()) {

            availableGame.get().getPlayers().add(player);
            return availableGame.get();
        }

        var game = new Game();
        game.getPlayers().add(player);
        games.add(game);

        return game;
    }

    public void updateGame(Game game) throws GameNotFoundException
    {
        var optionalGame = games.stream().filter(g -> g.getId() == game.getId()).findFirst();

        if(optionalGame.isEmpty()) {

            throw new GameNotFoundException("Game Does not Exist");
        }

        optionalGame.get().setBoard(game.getBoard());

        //ToDo: use web sockets to update other player
    }
}
