package com.ocr.gameplay_studio;

import java.util.*;

public class ChallengerMode extends AbstractMode
{
    public ChallengerMode()
    {   super();
        resultatEssai = new String[nbEssais];
        combinaison = new int[nbChiffres];
        serieJoueur = new int[nbChiffres];
        if(GameSetting.parametreDescription.equals("O"))
            System.out.print(GameWording.DESCRIPTION_CHALLENGER);
        showMenu();
    }
    /**/

    protected void showDescription(boolean enabled)
    {   if(enabled == true)
        GameSetting.parametreDescription = "O";
        else
        GameSetting.parametreDescription = "N";
    }
    /**/

    protected void setRandomDigits()
    {   Random random = new Random();
        for (int i = 0; i < nbChiffres; i++)
            combinaison[i] = random.nextInt(9+1);
    }
    /**/

    protected void showRandomDigits()
    {   String chiffresCombinaison = "";
        for(int i = 0; i < combinaison.length; i++)
            chiffresCombinaison += combinaison[i];
        System.out.print("\n\tcombinaison \t:  " + chiffresCombinaison + "\n");
    }
    /**/

    protected void showMenu()
    {   System.out.print(GameWording.MENU_PARTIE_CHALLENGER);
        System.out.print("\n\n\t\t\tvotre choix ?  ");
        try { choix = GameExecution.scanner.nextInt(); }
        catch(Exception Err) {}
        System.out.print("\t\t\tvotre choix :  " + String.valueOf(choix));
        switch(choix)
        {   case 1:
            {   System.out.println("  >> Lancer la Partie");
                setRandomDigits();
                showRandomDigits();;
                GameExecution.scanner.nextLine();
                this.runMatch();
                break;
            }
            case 2:
            {   System.out.println("  >> Quitter la Partie");
                new GameExecution().selectMode();
                break;
            }
            case 3:
            {   System.out.print("  >> Quitter Challenger");
                ModeSelection selection = new ModeSelection();
                selection.selectMode();
                break;
            }
            case 9:
            {   System.out.print("  >> Quitter le Jeu");
                this.exitGame();
                break;
            }
            default:
            {   System.out.print("  ! choix invalide !\n");
                new ChallengerMode();
                break;
            }
        }
    }
    /**/

    protected void runMatch()
    {   System.out.print("\n\t! partie en " + nbEssais + " essais maximum !");
        System.out.print("\n\t! saisissez " + nbChiffres + " chiffres entre 0 et 9 !\n");
        for(noEssai = 1; noEssai <= nbEssais; noEssai++)
        {   System.out.print("\n\t--essai no." + (noEssai) + "--\n");
            resultatEssai[noEssai] = this.runTrial(noEssai);
            //System.out.print("\tresultat essai\t:  " + resultatEssai + "\n");
            System.out.print(showResult(resultatEssai[noEssai]) + "\n");
            if(resultatEssai[noEssai].equals("===="))
            {   System.out.print("\t! vous avez gagné la partie en " + noEssai + " essais ! félicitations !");
                this.showMenu();
                break;
            }
        }
    }
    /**/

    protected String runTrial(int noEssai)
    {   resultatEssai[noEssai] = "";
        this.inputDigits();
        this.convertDigits();
        return this.computeTrial(noEssai);
    }
    /**/

    protected String computeTrial(int noEssai)
    {   for (int i = 0; i < nbChiffres; i++)
        {   if (combinaison[i] == serieJoueur[i])
                resultatEssai[noEssai] += "=";
            else if (combinaison[i] < serieJoueur[i])
                resultatEssai[noEssai] += "-";
            else
                resultatEssai[noEssai] += "+";
        }
        return resultatEssai[noEssai];
    }
    /**/

}
/**/
