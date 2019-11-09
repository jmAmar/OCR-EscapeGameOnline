package com.ocr.gameplay_studio;

import java.util.Random;

/**
 * @author JMichel AMAR
 * @version 1.0
 *
 * Executes the Challenger Mode
 */
public class ChallengerMode extends AbstractMode
{
    public ChallengerMode()
    {   super();
        resultatEssai = new String[nbEssais];
        combinaison = new int[nbChiffres];
        serieJoueur = new int[nbChiffres];
    }
    /**/

    protected void showDeveloperMode(boolean enabled)
    {   if(enabled == true) { this.showRandomDigits(); }
    }
    /**/

    protected void showDescription(boolean enabled)
    {   if(enabled == true) { System.out.print(GameWording.DESCRIPTION_CHALLENGER); }
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
        System.out.print("\n\tcombinaison secrète\t:  " + chiffresCombinaison + "\n");
    }
    /**/

    protected void showMenu()
    {   System.out.print(GameWording.MENU_PARTIE_CHALLENGER);
        System.out.print("\n\n\tvotre choix\t?  ");
        try { choix = GameExecution.scanner.nextInt(); }
        catch(Exception Err)
        {   GameLogging.logError("Selection Error : errClass:" + Err.getClass()
                + " / errCause:" + Err.getCause()
                + " / errMsg:" + Err.getMessage());
            GameExecution.scanner.nextLine();
        }
        System.out.print("\n\tvotre choix\t:  " + String.valueOf(choix));
        switch(choix)
        {   case 1:
            {   System.out.print("  >> Lancer une Partie\n");
                System.out.print(GameWording.NOUVELLE_PARTIE);
                this.setRandomDigits();
                this.showDeveloperMode(GameSetting.getIsDeveloperModeEnable());
                GameExecution.scanner.nextLine();
                this.runMatch();
                break;
            }
            case 2:
            {   System.out.print("  >> Quitter Challenger\n");
                ModeSelection selection = new ModeSelection();
                selection.selectMode();
                break;
            }
            case 8:
            {   System.out.print("  >> Modifier la Configuration\n");
                GameSetting.showSetting();
                GameSetting.showMenu();
                GameSetting.saveSetting();
                this.showDescription(GameSetting.getIsDescriptionEnable() ? true : false);
                this.showMenu();
                break;
            }
            case 9:
            {   System.out.print("  >> Quitter le Jeu");
                this.exitGame();
                break;
            }
            default:
            {   System.out.print("  ! choix invalide !\n");
                this.showDescription(GameSetting.getIsDescriptionEnable() ? true : false);
                this.showMenu();
                break;
            }
        }
    }
    /**/

    protected void runMatch()
    {   System.out.print("\n\t! partie en " + nbEssais + " essais maximum !");
        System.out.print("\n\t! combinaisons de " + nbChiffres + " chiffres !\n");
        for(noEssai = 0; noEssai < nbEssais; noEssai++)
        {   System.out.print("\n\t--essai no." + (noEssai+1) + "--\n");
            resultatEssai[noEssai] = "";
            resultatEssai[noEssai] = this.runTrial(noEssai);
            //System.out.print("\tresultat essai\t:  " + resultatEssai + "\n");
            System.out.print(showResult(resultatEssai[noEssai], "joueur ") + "\n");
            if(resultatEssai[noEssai].equals("===="))
            {   System.out.print("\n\t! vous avez gagné la partie en " + (noEssai+1) + " essais ! félicitations !\n");
                this.showMenu();
                break;
            }
            else if(noEssai >= nbEssais-1)
            {   System.out.print("\n\t! vous avez perdu la partie après " + (noEssai+1) + " essais autorisés ! désolé !\n");
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
        return(this.computeTrial(noEssai));
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
        return(resultatEssai[noEssai]);
    }
    /**/

}
/**/
