package com.ocr.gameplay_studio;

public class DefenderMode extends AbstractMode
{
    public DefenderMode()
    {   super();
        resultatEssai = new String[nbEssais];
        combinaison = new int[nbChiffres];
        serieJoueur = new int[nbChiffres];
        serieEssais = new int[nbEssais][nbChiffres];
        serieCaracteres = new String[nbChiffres];
    }
    /**/

    protected void showDescription(boolean enabled)
    {  if(enabled == true) { System.out.print(GameWording.DESCRIPTION_DEFENDER); }
    }
    /**/

    protected void showMenu()
    {   System.out.print(GameWording.MENU_PARTIE_DEFENDER);
        System.out.print("\n\n\tvotre choix\t?  ");
        try { choix = GameExecution.scanner.nextInt(); }
        catch(Exception Err) {}
        System.out.print("\tvotre choix\t:  " + String.valueOf(choix));
        switch(choix)
        {   case 1:
        {   System.out.print("  >> Lancer la Partie\n");
            System.out.print(GameWording.NOUVELLE_PARTIE + "\n");
            this.setPlayerDigits();
            this.showPlayerDigits();
            this.runMatch();
            break;
        }
            case 2:
            {   System.out.print("  >> Quitter la Partie");
                new GameExecution().selectMode();
                break;
            }
            case 3:
            {   System.out.print("  >> Quitter Defender\n");
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
            }
        }
    }
    /**/

    protected void setPlayerDigits()
    {   this.inputDigits();
        this.convertDigits();
    }
    /**/

    protected void showPlayerDigits()
    {   String chiffresJoueur = "";
        for(int i = 0; i < serieJoueur.length; i++)
            chiffresJoueur += serieJoueur[i];
        System.out.print("\tcombinaison joueur\t:  " + chiffresJoueur + "\n");
    }
    /**/

    protected void runMatch()
    {   System.out.print("\n\t! partie en " + nbEssais + " essais maximum !");
        System.out.print("\n\t! combinaisons de " + nbChiffres + " chiffres !\n");
        for(noEssai = 0; noEssai < nbEssais; noEssai++)
        {   System.out.print("\n\t--essai no." + (noEssai+1) + "--\n");
            resultatEssai[noEssai] = "";
            resultatEssai[noEssai] = this.runTrial(noEssai);
            System.out.print("\tcombinaison logiciel\t:  ");
            for(noChiffre = 0; noChiffre < nbChiffres; noChiffre++)
                System.out.print(combinaison[noChiffre]);
            //System.out.print("\tresultat\t\t:  " + resultatEssai[noEssai] + "\n");
            System.out.print(showResult(resultatEssai[noEssai], "logiciel") + "\n");
            if(resultatEssai[noEssai].equals("===="))
            {   System.out.print("\n\t! partie gagnée par le logiciel en " + (noEssai+1) + " essais !\n");
                this.showMenu();
                break;
            }
        }
    }
    /**/

    protected String runTrial(int noEssai)
    {   resultatEssai[noEssai] = "";
        if(noEssai == 0)
        {   for(int i = 0; i < nbChiffres; i++)
            {   combinaison[i] = 5;
                serieEssais[noEssai][i] = combinaison[i];
            }
        }
        else
        {   serieCaracteres = resultatEssai[noEssai-1].split("");
            for (noChiffre = 0; noChiffre < nbChiffres; noChiffre++)
            {   if(serieCaracteres[noChiffre].equals("-"))
                {
                    switch (serieEssais[noEssai - 1][noChiffre])
                    {
                        case 9:
                            combinaison[noChiffre] = 7;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 7:
                            combinaison[noChiffre] = 5;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 5:
                            combinaison[noChiffre] = 3;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 3:
                            combinaison[noChiffre] = 1;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 1:
                            combinaison[noChiffre] = 0;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                    }
                }
                else if(serieCaracteres[noChiffre].equals("+"))
                {   switch(serieEssais[noEssai-1][noChiffre])
                    {
                        case 1:
                            combinaison[noChiffre] = 2;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 2:
                            combinaison[noChiffre] = 3;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 3:
                            combinaison[noChiffre] = 4;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 4:
                            combinaison[noChiffre] = 5;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 5:
                            combinaison[noChiffre] = 6;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 6:
                            combinaison[noChiffre] = 7;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 7:
                            combinaison[noChiffre] = 8;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 8:
                            combinaison[noChiffre] = 9;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                    }
                }

            }
        }
        return(this.computeTrial(noEssai));
    }
    /**/

    protected String computeTrial(int noEssai)
    {   for (int i = 0; i < nbChiffres; i++)
        {   if (combinaison[i] == serieJoueur[i])
                resultatEssai[noEssai] += "=";
            else if (combinaison[i] > serieJoueur[i])
                resultatEssai[noEssai] += "-";
            else
                resultatEssai[noEssai] += "+";
        }
        return resultatEssai[noEssai];
    }
    /**/

}
/**/
