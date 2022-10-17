package james.games.mancala.resource;

import james.games.mancala.service.PlayerService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/player")
public class PlayerResource
{
    @Inject
    PlayerService playerService;

    @POST()
    @Path("/connect")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response connect()
    {
        try
        {
            var player = playerService.addNewPlayer();

            return Response.ok(player).build();
        }
        catch(Exception exception) {

            return Response.serverError().build();
        }

    }

    @POST
    @Path("/disconnect")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response disconnect(long playerId)
    {
        playerService.removePlayer(playerId);

        return Response.ok().build();
    }
}