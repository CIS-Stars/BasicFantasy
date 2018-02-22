package org.lewisandclark.csd.basicfantasy;

import java.util.Random;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public class AttributeScoreGenerator {

    Random dieRoller = new Random();

    private AttributeScore nextScore(){
        int total = 0;
        for(int i=0; i<3; i++){
            total += dieRoller.nextInt(6)+1;
        }
        return new AttributeScore(total);
    }

    public AttributeScore[] nextSet(){
        AttributeScore[] attributes = new AttributeScore[6];

        for(int i = 0; i < attributes.length; i++) {
            attributes[i] = nextScore();
        }

        return attributes;
    }
}
