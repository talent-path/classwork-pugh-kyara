package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.models.Platform;

public interface PlatformDAO {
    Platform getPlatformByID(Integer platID) throws NullIDException, InvalidIDException;
}
