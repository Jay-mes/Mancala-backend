package james.games.mancala.entity;

public class SmallHole extends BoardHole{
    private Long id;
    private Integer stones;

    public String toString() {
        return id.toString() + ":" + stones.toString() ;
    } 
}
