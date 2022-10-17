package james.games.mancala.resource;


import james.games.mancala.entity.Game;
import james.games.mancala.entity.Player;
import james.games.mancala.exception.GameNotFoundException;
import james.games.mancala.service.GamesService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("games")
public class GameResource
{
    @Inject
    GamesService gamesService;

    @POST
    @Path("/join")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response createNewGame(Player player)
    {
        //Game will start automatically
        var game = gamesService.join(player);

        return Response.ok(game).build();
    }

    @PUT
    @Path("/update")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response updateGames(Game game)
    {
        try
        {
            gamesService.updateGame(game);

            return Response.ok().build();
        }
        catch (GameNotFoundException exception)
        {
            return Response.status(NOT_FOUND).build();
        }
    }
}
