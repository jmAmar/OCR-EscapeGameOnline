package com.ocr.gameplay_studio;

import java.util.*;

public class ChallengerMode
{
    private Scanner scn ;
    private int nbChiffres;
    private int[] combinaison;

    public ChallengerMode()
    {   scn = new Scanner(System.in);
        nbChiffres = 4;
        combinaison = new int[nbChiffres];
        System.out.print(Wording.DESCRIPTION_CHALLENGER);
    }
    /**/

    public void setCombination()
    {   for (int i = 0; i < nbChiffres; i++)
            combinaison[i] = getRandomINT();
    }
    /**/

    protected int getRandomINT()
    { int x = (int)(Math.random() * 10);
        while(x == 0)
            x = getRandomINT();
        return(x);
    }
    /**/

    protected void runChallengertSet()
    { System.out.print(Wording.NOUVELLE_PARTIE);
    }
    /**/
}
/**/
