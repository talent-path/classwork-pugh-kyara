package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.exceptions.NullPlatformException;
import com.tp.gamemanagementsystem.exceptions.NullTitleException;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;

import java.util.List;

public interface PlatformDAO {
    Platform getPlatformByID(Integer platID) throws NullIDException, InvalidIDException;

    List<Game> getGamesByPlatformID(Integer platID) throws NullIDException, InvalidIDException;
    List<Game> getGamesByPlatformName(String name) throws NullTitleException;
}