import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class TestResource {
    private ObjectMapper mapper;

    public TestResource(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @GET
    public Response get(@QueryParam("type") String type) throws JsonProcessingException {
        if(Strings.isNullOrEmpty(type)) {
            type = MediaType.APPLICATION_JSON;
        }
        String representation = null;
        if(type.equals(MediaType.APPLICATION_JSON)) {
            representation = mapper.writeValueAsString(new Name("Santanu", "Sinha"));
            return Response.ok().entity(representation)
                    .header("content-length", representation.length())
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .build();
        }
        representation = "<html><body>Hello World</body></html>";
        return Response.ok().entity(representation)
                        .header("content-length", representation.length())
                        .header("Content-Type", MediaType.TEXT_HTML)
                        .build();

    }
}
