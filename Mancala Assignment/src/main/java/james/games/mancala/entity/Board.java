package james.games.mancala.entity;

import java.util.List;

public class Board
{
    private long id;

    private List<BoardHole> holes;

    public List<BoardHole> getHoles()
    {
        return holes;
    }

    public void setHoles(List<BoardHole> holes)
    {
        this.holes = holes;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
}
