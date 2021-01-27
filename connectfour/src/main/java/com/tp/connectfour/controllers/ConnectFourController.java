package com.tp.connectfour.controllers;


import com.tp.connectfour.ConnectfourApplication;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.services.ConnectFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectFourController {

    @Autowired
    ConnectFourService service;

    @GetMapping("/game/{gameID}")
    public ConnectFourViewModel getGameById(@PathVariable Integer gameID)
    {
        return service.getGameById(gameID);
    }


}
