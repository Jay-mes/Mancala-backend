package james.games.mancala.entity;

import java.util.List;

public abstract class BoardHole
{
    private Long id;
    private List<Stone> stones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Stone> getStones()
    {
        return stones;
    }

    public void setStones(List<Stone> stones)
    {
        this.stones = stones;
    }
}
