package resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entity.Ad;
import entity.Click;
import entity.Impression;
import service.AdService;
import service.ClickService;
import service.ImpressionService;

@Stateless
public class ApplicationResources {
	
	@Inject AdService adService;
	@Inject ClickService clickService;
	@Inject ImpressionService impressionService;
	
	@POST
	@Path("/ad")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAd(Ad ad){
		return Response.ok()
				.entity(adService.createAd(ad))
				.build();
	}
	
	@DELETE
	@Path("/ad/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAd(@PathParam("id") int adId){
		return Response.ok()
				.entity(adService.removeAd(adId))
				.build();
	}
	
	@GET
	@Path("/ad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdAlgorithmically(){
		return Response.ok()
				.entity(adService.getAdAlgorithmically())
				.build();
	}
	
	@POST
	@Path("/impression")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createImpression(Impression impression){
		return Response.ok()
				.entity(impressionService.createImpression(impression))
				.build();
	}
	
	@POST
	@Path("/click")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createClick(Click click){
		return Response.ok()
				.entity(clickService.createClick(click))
				.build();
	}
}