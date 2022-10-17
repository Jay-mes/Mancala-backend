package james.games.mancala.service;


import james.games.mancala.entity.Player;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class PlayerService
{
    List<Player> players;

    public Player addNewPlayer()
    {
        if (players == null)
        {
            players = new ArrayList<>();
        }

        var player = new Player();
        players.add(player);

        return player;
    }

    public void removePlayer(long playerId)
    {
        Optional<Player> player = players.stream().filter(p -> p.getId() == playerId).findFirst();

        player.ifPresent(value -> this.players.remove(value));
    }
}
