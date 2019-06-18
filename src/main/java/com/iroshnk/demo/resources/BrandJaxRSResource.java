package com.iroshnk.demo.resources;

import com.iroshnk.demo.model.Brand;
import com.iroshnk.demo.service.inter.BrandService;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/brand_resource")
public class BrandJaxRSResource {
    @Inject
    BrandService brandServiceImpl;

    @Path("create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid Brand brand) {
        Brand brand1 = brandServiceImpl.create(brand);

        return Response.ok(brand1).build();
    }
}
