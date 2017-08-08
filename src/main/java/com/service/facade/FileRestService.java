package com.service.facade;

import java.io.InputStream;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.domain.FileService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Component
@Path("/file")
public class FileRestService {

	@Autowired
	FileService fileService;

	@GET
	@Produces("application/json")
	@Path("/{file}")
	Response get(@PathParam("file") String fileName) {
		return Response.status(200).entity(fileService.get(fileName)).build();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	Response post(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		return Response.status(200).entity(fileService.store(fileInputStream, fileDetail.getFileName())).build();
	}

	@GET
	@Produces("application/json")
	Response search(@QueryParam("id") String fileId) {
		return Response.status(200).entity(fileService.search(fileId)).build();
	}
}
