package com.ocr.gameplay_studio;

public class Wording
{
    static final String BIENVENUE
    = "\n\t\t**** BIENVENUE ****"
    + "\n\tdans notre jeu ESCAPE GAME ONLINE"
    + "\n\t\t! prenez-y plaisir !"
    + "\n\tGAMEPLAY STUDIO , éditeur"
    ;

    static final String AU_REVOIR
    = "\n\n\t... Nous espèrons vous être bien amusés !"
    + "\n\t\t\t**** AU REVOIR ****"
    + "\n"
    ;

    static final String DESCRIPTION_JEU
    = "\n\t\t** Description Générale **"
    + "\nCe jeu est inspiré de celui où une équipe de joueurs est enfermée dans une pièce."
    + "\nPour en sortir ils doivent résoudre des égnimes scénarisées."
    + "\nDans notre jeu les égnimes sont concrétisées par des séries de chiffres (de 1 à 9) à deviner et/ou déduire."
    + "\nLe nombre de chiffres de chaque série est déterminé en début de partie (4 par défaut)."
    + "\nUn chiffre peut être redondant une ou plusieurs fois dans une même série (exemples: 12325 , 2222)."
    + "\n3 modes sont proposés :"
    + "\n- mode CHALLENGER (le joueur doit deviner les chiffres de la série déterminés aléatoirement par le logiciel)."
    + "\n- mode DEFENDER (le joueur détermine les chiffres de la série et le logiciel doit les deviner)."
    + "\n- mode DUEL (le joueur et le logiciel jouent à tour. Le gagnant est le premier qui a trouvé la combinaison de l'autre)."
    + "\nRemarque: le nombre d'essais pour chaque partie est limitée."
    ;

    static final String MENU_JEU
    = "\n\n\t\t** Menu **"
    + "\n- mode CHALLENGER\t:  1"
    + "\n- mode DEFENDER\t\t:  2"
    + "\n- mode DUEL\t\t\t:  3"
    + "\n- QUITTER le Jeu\t:  9"
    ;

    static final String DESCRIPTION_CHALLENGER
    = "\n\t\t** Description du Mode Challenger **"
    + "\nLe logiciel génère aléatoirement une combinaison de chiffres entre 1 et 9 (4 par défaut)."
    + "\nUn même chiffre peut être contenu une ou plusieurs fois dans la même combinaison."
    + "\nIl vous demande ensuite de saisir les chiffres que vous pensez composer la combinaison."
    + "\nA la fin de votre saisie le logiciel vous indique un résultat intermédiaire sous forme de chaîne contenant des \"=\", \"-\", ou \"+\""
    + " relativement à la position de chaque chiffre."
    + "\n\"=\" signifie que le chiffre de la combinaison est égal à celui saisi."
    + "\n\"-\" signifie que le chiffre de la combinaison est plus petit que celui saisi."
    + "\n\"+\" signifie que le chiffre de la combinaison est plus grand que celui saisi."
    + "\nExemple: si la combinaison générée est 3562 est que vous avez saisi les chiffres 1264, le résultat intermédiaire sera ++=-."
    + "\nLe nombre d'essais (générant des résultats intermédiaires) est limité."
    + "\nLe résultat final de la partie est celui de votre dernier essai."
    ;

    static final String NOUVELLE_PARTIE
    = "\n\n\t\t** Nouvelle Partie **"
    + "\n... La partie démarre ..."
    ;
}
