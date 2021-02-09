package com.tp.gamemanagementsystem.daos.mappers;

import com.tp.gamemanagementsystem.models.Game;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameIDMapper implements RowMapper<Integer> {

    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt("gameID");
    }
}
