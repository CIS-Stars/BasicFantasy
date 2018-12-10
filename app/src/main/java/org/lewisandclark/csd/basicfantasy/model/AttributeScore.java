package org.lewisandclark.csd.basicfantasy.model;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public class AttributeScore {

    //Instance Variables
    private int mScore;

    //Private Methods

    /**
     * returns true if mScore is between lower and upper bound (inculsive)
     * @param lower - the lower bound
     * @param upper - the upper bound
     * @return true or false
     */
    private boolean isBetween(int lower, int upper){
        return lower <= this.mScore && this.mScore <= upper;
    }


    public AttributeScore(int score) {
        mScore = score;
    }

    public int getScore() {return mScore;}

    public String getScoreString() {return String.valueOf(mScore);}

    public void setScore(int score) {
        mScore = score;
    }

    /**
     * This function returns the modifier for the score.
     * Since scores can change in the game, this should always just be calculated.
     *
     * modifiers are calculated as follows:
     *
     *  score   mod
     *    3     -3
     *   4-5    -2
     *   6-8    -1
     *   9-12    0
     *  13-15   +1
     *  16-17   +2
     *   18     +3
     *   19     +4
     *   20     +5
     *   21+    +6
     *
     * @return the score modifier as a string
     */
    public String getModifierString(){
        int modifier = -12;

        if(isBetween(1,3)){
            modifier = -3;
        }
        else if(isBetween(4,5)){
            modifier = -2;
        }
        else if(isBetween(6,8)){
            modifier = -1;
        }
        else if(isBetween(9,12)){
            modifier = 0;
        }
        else if(isBetween(13,15)){
            modifier = 1;
        }
        else if(isBetween(16,17)){
            modifier = 2;
        }
        else if(isBetween(18,18)){
            modifier = 3;
        }
        else if(isBetween(19,19)){
            modifier = 4;
        }
        else if(isBetween(20,20)){
            modifier = 5;
        }
        else {
            modifier = 6;
        }

        return String.valueOf(modifier);
    }

    /**
     * This function returns the modifier for the score.
     * Since scores can change in the game, this should always just be calculated.
     *
     * modifiers are calculated as follows:
     *
     *  score   mod
     *    3     -3
     *   4-5    -2
     *   6-8    -1
     *   9-12    0
     *  13-15   +1
     *  16-17   +2
     *   18     +3
     *   19     +4
     *   20     +5
     *   21+    +6
     *
     * @return the score modifier
     */
    public int getModifier(){
        int modifier = -12;

        if(isBetween(1,3)){
            modifier = -3;
        }
        else if(isBetween(4,5)){
            modifier = -2;
        }
        else if(isBetween(6,8)){
            modifier = -1;
        }
        else if(isBetween(9,12)){
            modifier = 0;
        }
        else if(isBetween(13,15)){
            modifier = 1;
        }
        else if(isBetween(16,17)){
            modifier = 2;
        }
        else if(isBetween(18,18)){
            modifier = 3;
        }
        else if(isBetween(19,19)){
            modifier = 4;
        }
        else if(isBetween(20,20)){
            modifier = 5;
        }
        else {
            modifier = 6;
        }

        return modifier;
    }
}
