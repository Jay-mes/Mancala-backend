package james.games.mancala.entity;

public class Player
{
    long id;

    public Player()
    {
        this.id = 12123131; //Todo: generate id
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
