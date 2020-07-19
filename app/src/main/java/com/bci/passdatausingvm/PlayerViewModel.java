package com.bci.passdatausingvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlayerViewModel extends ViewModel {
    private final MutableLiveData<String> selectedPlayer = new MutableLiveData<String>();

    private PlayersRepository repository = new PlayersRepository();

    public void selectPlayer(String playerName) {
        selectedPlayer.setValue(playerName);
    }

    public MutableLiveData<String> getSelectedPlayer() {
        return selectedPlayer;
    }

    public String[] getPlayerList(){
        return repository.getPlayers();
    }

    public Player getPlayerDetails(String name){
        return repository.getPlayerDetails(name);
    }
}