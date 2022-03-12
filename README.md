Voici mon générateur de calculs mentaux pour Dynseo. 

Générateur de calculs mentaux:

  Niveau facile:
  
    Je génere deux nombre aléatoirement entre 1 et 15, qui seront mes valeurs pour mon opération.
    Je fais ensuite un pile ou face, pour savoir si mon opération est une addition ou une soustraction. 
    Pour finir, je change le texte de ma Textview qui affiche mon opération et je renvois de ma fonction le résultat de l'opération. 
    
  Niveau moyen: 
  
    Comme pour le niveau facile, mais maintenant je génere deux nombres entre 15 et 45. 
    Je rajoute aussi 1/4 de chance que le premier nombre de l'opération soit négatif, pour plus de difficulté. 
    
  Niveau difficile:
  
    Cette fois si, j'ai 4 opérations:
    
      Addition et soustraction:
        Comme pour le niveau moyen mais entre 15 et 65. 
        
      Multiplication:
        Je génere deux nombre entre 1 et 15. 
        J'ajoute 1/4 de probabilité que l'un des deux nombre soit négatif et 1/4 que les deux le soient. 
        
      Division:
        Je génere deux nombres, l'un entre 1 et 25 et l'autre entre 1 et 11. 
        Je fais un pile ou face, pour savoir si la réponse que je renvoie est entre 1 et 11 ou 1 et 25. 
        Ensuite, je multiplie mes deux nombre ensemble pour faire le numérateur de ma division. 
        J'affiche mon opération et je renvoie la réponse générer aléatoirement comme résultat de mon opération. 


Générateurs de réponses: 
  
  3 fonctions : 
    
    gPlus : ajoute un nombre aléatoire entre 1 et 5 au résultat que j'ai récuperer du générateur d'opérations.
    gMoins : Comme pour gPlus mais avec un nombre négatif. 
    gSigne : Pour les additions et soustractions : 
                Inverse le signe de l'opération, si 4 + 3, alors retourne 4 - 3 = 1 
             Pour les multiplications et divisions : 
                Enlève ou ajoute une dizaine au résultat, si res = 25, retourne 15 ou 35
