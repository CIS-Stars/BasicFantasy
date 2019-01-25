package org.lewisandclark.csd.basicfantasy.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class CharacterList {
    private static CharacterList sCharacterList;
    private List<PlayerCharacter> mPlayerCharacters;

    public static CharacterList getPlayerCharacterList(Context context){
        if (sCharacterList == null){
            sCharacterList = new CharacterList(context);
        }
        return sCharacterList;
    }

    private CharacterList(Context context){
        mPlayerCharacters = new ArrayList<>();
    }

    public PlayerCharacter getPlayerCharacter(int id){
        for (PlayerCharacter playerCharacter: mPlayerCharacters){
            if(playerCharacter.getID() == id){
                return playerCharacter;
            }
        }
        return null;
    }

    public void addCharacter(PlayerCharacter newOne){
        int ID = mPlayerCharacters.size();
        newOne.setID(ID);
        mPlayerCharacters.add(newOne);
    }

    public void updateCharacter(PlayerCharacter currentOne, int currentOneIndex){
        mPlayerCharacters.set(currentOneIndex, currentOne);
    }

    public int sizeOf(){
        return mPlayerCharacters.size();
    }

    public List<PlayerCharacter> getList() {return mPlayerCharacters;}
}
