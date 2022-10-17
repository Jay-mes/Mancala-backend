package james.games.mancala.entity;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private long id;
    private List<Player> Players = new ArrayList<>();
    private Board board;

    public Game()
    {
        this.id = 1231; //ToDo: generate random id
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public List<Player> getPlayers()
    {
        return Players;
    }

    public void setPlayers(List<Player> players)
    {
        Players = players;
    }

    public Board getBoard()
    {
        return board;
    }

    public void setBoard(Board board)
    {
        this.board = board;
    }
}
