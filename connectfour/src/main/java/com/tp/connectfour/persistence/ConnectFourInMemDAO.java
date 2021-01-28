package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.NullBoardException;
import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.models.ConnectFourViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectFourInMemDAO implements ConnectFourDAO{
    private List<ConnectFourGame> allGames = new ArrayList<>();

    public ConnectFourInMemDAO()
    {

        ConnectFourGame onlyGame = new ConnectFourGame(1);
    }


    @Override
    public int startGame(String[] board) throws NullBoardException {
        if(board==null)
        {
            throw  new NullBoardException("Tried to create a game with a null board ");
        }
       int id = 0;
        for(ConnectFourGame toCheck : allGames)
        {
            if(toCheck.getGameID() > id)
            {
                id = toCheck.getGameID();
            }
        }
        id++;
        ConnectFourGame toAdd = new ConnectFourGame(id);
        allGames.add(toAdd);
        return id;
    }

    @Override
    public ConnectFourGame getGameById(Integer gameID) {
        ConnectFourGame toReturn = null;
        for (ConnectFourGame toCheck : allGames) {
            if (toCheck.getGameID().equals(gameID)) {
                toReturn = new ConnectFourGame(toCheck);
                break;
            }
        }
        return toReturn;
    }

    @Override
    public List<ConnectFourGame> getAllGame() {
        List<ConnectFourGame> copyList = new ArrayList<>();
        for(ConnectFourGame toCopy : allGames)
        {
            copyList.add(new ConnectFourGame(toCopy));
        }
        return copyList;
    }

    @Override
    public void updateGame(ConnectFourGame game) {
        for( int i = 0; i < allGames.size(); i++){
            if( allGames.get(i).getGameID().equals(game.getGameID())){
                //we found the game to update
                allGames.set(i, new ConnectFourGame(game) );
            }
        }

    }

    @Override
    public void deleteGame(Integer gameID) throws InvalidGameIdException {
        int removeIndex = -1;

        for( int i = 0; i < allGames.size(); i++ ){
            if( allGames.get(i).getGameID().equals(gameID)){
                removeIndex = i;
                break;
            }
        }
        if( removeIndex != -1 ){
            allGames.remove(removeIndex);
        } else {
            throw new InvalidGameIdException("Could not find game with id " + gameID + "to delete.");
        }


    }
}
