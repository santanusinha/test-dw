import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
    private ObjectMapper mapper;

    public TestResource(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @GET
    public Response get() throws JsonProcessingException {
        String representation = mapper.writeValueAsString(new Name("Santanu", "Sinha"));
        return Response.ok().entity(representation).header("content-length", representation.length()).build();
    }
}
