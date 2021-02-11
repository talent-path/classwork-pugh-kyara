package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;

import java.util.List;

public interface PlatformDAO {
    Platform getPlatformByID(Integer platID) throws NullIDException, InvalidIDException;

    List<Game> getGamesByPlatformID(Platform somePlatform) throws NullIDException, InvalidIDException;;
}
