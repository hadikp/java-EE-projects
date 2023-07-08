package org.example.itext;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/pdf")
@Stateless
public class MakePdf {

    @Inject
    private Itext pdfGenerator;

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response createPdf() throws IOException {
        return Response.ok(pdfGenerator.createPdf(), MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"iTextP.pdf\"").build();
    }
}
