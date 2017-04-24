package probleme.quatreCouleurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import generic.SolutionAbstract;

/**
 * solution au probleme de 4 couleurs
 * 
 * @author vthomas
 * 
 */
public class Solution4Couleurs extends SolutionAbstract {

    // le tableau de couleurs
    int[] couleurs;

    /**
     * construit une solution
     * 
     * @param pb
     *            probleme associe
     */
    public Solution4Couleurs(Probleme4Couleurs pb) {
	couleurs = new int[pb.nombreDeZones];
	for (int i = 0; i < couleurs.length; i++)
	    couleurs[i] = (int) (Math.random() * 4);
    }

    /**
     * construit une solution par copie
     * 
     * @param s
     *            autre solution
     */
    public Solution4Couleurs(Solution4Couleurs s) {
	couleurs = (int[]) s.couleurs.clone();
    }

    /**
     * permet de modifier une solution
     * 
     * @n zone dont on modifie la couleur
     * @c nouvelle couleur
     */
    public void modifieCouleur(int n, int c) {
	// si parametre pas bon
	if (c < 0 || c > 4 || n < 0 || n > couleurs.length - 1)
	    throw new IllegalArgumentException("c:" + c + " n:" + n);

	// sinon,
	couleurs[n] = c;
    }

    boolean memeCouleur(int i, int j) {
	return couleurs[i] == couleurs[j];
    }

    /**
     * methode qui surcharge l'obtention d'un voisinage consiste simplement à
     * retourner la liste avec une seule variation sur la couleur soit 4 fois
     * nombre de zones
     */
    @Override
	public List<SolutionAbstract> retourneVoisinage() {
	
	List<SolutionAbstract> solutionsVoisines = new 
	    ArrayList<SolutionAbstract>();

	// construction des solutions voisines
	// pour chaque zone
	for (int i = 0; i < couleurs.length; i++) {
	    int couleurZoneCourante = this.couleurs[i];
	    // on peut modifier la couleur
	    for (int nouvelleCouleur = 0; nouvelleCouleur<4;nouvelleCouleur++) {
		// si il y a vraiment un changement
		if (nouvelleCouleur != couleurZoneCourante) {
		    // on cree une nouvelle solution
		    Solution4Couleurs nouvelleSolution;
		    nouvelleSolution = new Solution4Couleurs(this);
		    // on l'ajoute à l'ensemble des voisins
		    nouvelleSolution.modifieCouleur(i, nouvelleCouleur);
		    solutionsVoisines.add(nouvelleSolution);
		}
	    }
	}
	return solutionsVoisines;
    }
 

    /**
     * methode qui retourne un voisin au hasard  
     * consiste simplement à retourner une solution avec une 
     * variations sur de couleur aléatoire sur une cases aléatoire.
     * 
     */
   
    public SolutionAbstract retourneVoisinHasard(){
	Solution4Couleurs voisin = new Solution4Couleurs(this);

	// TODO a ecrire etudiant
	Random rand = new Random();

	int n = rand.nextInt(50);
	List<SolutionAbstract> lsa = this.retourneVoisinage();
	voisin = (Solution4Couleurs) lsa.get(n);

	// FinTODO a ecrire etudiant

	return voisin;
    }

    /**
     * methode qui retourne une solution perturbée 
     * consiste simplement à retourner une solution avec une 
     * variations sur de couleur aléatoire sur n cases aléatoire.
     * @param n le nombre de modification 
     */  
   
    public SolutionAbstract retournePerturbation(int n){
        Solution4Couleurs perturbed = new Solution4Couleurs(this);
	
        Random rand = new Random();
        int taille = this.couleurs.length;
        int randPos = 0;
        int randColor = 0;
        int colorEnCours;
        List<Integer> listColor = new ArrayList<Integer>();
	    // TODO a ecrire etudiant
	    for(int i = 0; i < n; i++){
	        boolean selectRand = false;
	        while(!selectRand) {
                randPos = rand.nextInt(taille);
                if (!listColor.contains(randPos)) {
                    listColor.add(randPos);
                    selectRand = true;
                }
            }
            colorEnCours = perturbed.couleurs[randPos];
            selectRand = false;
            while(!selectRand){
                randColor = rand.nextInt(4);
                if(randColor != colorEnCours){
                    perturbed.couleurs[randPos] = randColor;
                    selectRand = true;
                }
            }
        }


	    // FinTODO a ecrire etudiant
	
	    return perturbed;
    }

	

	
    
   
}
