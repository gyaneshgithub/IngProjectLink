package com.ing.atm.locator.controller;


import com.ing.atm.locator.message.Response;
import com.ing.atm.locator.model.Location;
import com.ing.atm.locator.service.AtmLocatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/atm")
public class AtmLocatorController
{
    @Autowired
    private AtmLocatorService atmLocatorService;

    @GetMapping(path="/allLocation", produces = "application/json")
    public Response getAllLocation() {

        Response response = new Response("SUCCESS", atmLocatorService.getAllLocation());
        return response;
    }

    @PostMapping(path= "/addLocation", consumes = "application/json", produces = "application/json")
    public Response addEmployee(@RequestBody Location location)
    {
        atmLocatorService.addAtmLocation(location);
        Response response = new Response("SUCCESS", location);
        return response;
    }
}