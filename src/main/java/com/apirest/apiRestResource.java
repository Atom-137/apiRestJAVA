/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.apirest;

import com.api.bean.Json;
import com.api.bean.Respuesta;

import com.api.bean.vehiculo;
import com.google.gson.Gson;
import com.utils.ejecutar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author administrator
 */
@Path("apirest")
public class apiRestResource {

    @Context
    private UriInfo context;

    
    private static List<vehiculo> vehiculos = new ArrayList<>();
    private static int idCounter = 1;
    /**
     * Creates a new instance of apiRestResource
     */
    public apiRestResource() {
    }

    /**
     * Retrieves representation of an instance of com.apirest.apiRestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String consultaPersona(  @QueryParam("Placa")String Placa,
                                    @QueryParam("Modelo")String Modelo,
                                    @QueryParam("Color")String Color,
                                    @QueryParam("Puertas")int Puertas) {
        //TODO return proper representation object
        vehiculo vehiculo1 = new vehiculo();
        
        vehiculo1.setPlaca(Placa);
        vehiculo1.setColor(Color);
        vehiculo1.setModelo(Modelo);
        vehiculo1.setPuertas(Puertas);
        
        
        Json obj = new Json();
        obj.setVehiculo(vehiculo1);
        
           
        Gson gson = new Gson();
        String jsonString = gson.toJson(obj);
         
        return jsonString;

        
    }

    /**
     * PUT method for updating or creating an instance of apiRestResource
     * @param content representation for the resource
     */

    @PATCH
    @Path("/{id},{placa},{color},{modelo},{peurtas}")
    @Consumes(MediaType.APPLICATION_JSON)
   
    public String actualizarUsuario(@PathParam("id") int id,
                                    @PathParam("placa") String placa,
                                    @PathParam("color") String color,
                                    @PathParam("modelo") String modelo,
                                    @PathParam("puertas") String puertas) {
       

        Respuesta resp = new Respuesta();
        Gson gson = new Gson();
        ejecutar eje  = new ejecutar();
       
        
        
        String query = " UPDATE  vehiculo SET placa = '"+placa+"',color='"+color+"',modelo='"+modelo+"',puertas="+puertas+" where id ="+id+"";
        
        resp.setMensaje("No se reailizo ninguna accion");
        resp.setRespuesta("info");
        
        String respuesta = gson.toJson(resp);
        
        if(eje.ejecutarQuery(query))
        {
                resp.setMensaje("Vehiculo actualizado correctamente");
                resp.setRespuesta("success");
                respuesta  = gson.toJson(resp);

        }else
        {
                resp.setMensaje("Error creando el vehiculo");
                resp.setRespuesta("warning");
                respuesta  = gson.toJson(resp);
                
        }
        
        return respuesta;
       
        
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String crearVehiculo(String vehiculo) {
    
        Respuesta resp = new Respuesta();
//        // Crear una instancia de Gson
        Gson gson = new Gson();
        ejecutar eje  = new ejecutar();
        
        // Utilizar Gson para convertir la cadena JSON en un objeto Map
        Map<String, String> Vehiculo = gson.fromJson(vehiculo, Map.class);
        
        String placa    = Vehiculo.get("placa");
        String modelo   = Vehiculo.get("modelo");
        String color    = Vehiculo.get("color");
        String puertas  = Vehiculo.get("puertas");
        
        String query = "INSERT INTO vehiculo(  placa,modelo,color,puertas)"+
                       " values ('"+placa+"','"+modelo+"','"+color+"',"+puertas+")";
        
        resp.setMensaje("No se reailizo ninguna accion");
        resp.setRespuesta("info");
        
        String respuesta = gson.toJson(resp);
        
        if(eje.ejecutarQuery(query))
        {
                resp.setMensaje("Vehiculo creado correctamente");
                resp.setRespuesta("success");
                respuesta  = gson.toJson(resp);

        }else
        {
                resp.setMensaje("Error creando el vehiculo");
                resp.setRespuesta("warning");
                respuesta  = gson.toJson(resp);
                
        }
        
        return respuesta;

      


    }
}
