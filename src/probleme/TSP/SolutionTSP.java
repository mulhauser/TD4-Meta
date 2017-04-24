package probleme.TSP;

import generic.SolutionAbstract;

import java.util.ArrayList;
import java.util.List;

/**
 * une solution au TSP
 * @author Graou
 *
 */
public class SolutionTSP extends  SolutionAbstract{

	/**
	 * la solution est une liste de villes
	 */
	public ArrayList<Ville> listeVilles;
	
	/**
	 * lien vers le probleme à résoudre
	 */
	TSP probleme;
	
	
	/**
	 * constructeur solution de base juste le trajet
	 */
	public SolutionTSP(TSP tsp)
	{
		probleme=tsp;
		//initialise solution en prenant villes dans l'ordre
		listeVilles=(ArrayList<Ville>) tsp.listeVilles.clone();

	}
	
	/**
	 * constructeur par copie
	 */
	public SolutionTSP(SolutionTSP s)
	{
		//clone la suite
		listeVilles=(ArrayList<Ville>)(s.listeVilles.clone());
	}
	
	
	/**
	 * methode qui calcule la longueur du chemin
	 * @return
	 */
	public double calculerDistanceChemin()
	{
		double res=0;
		//vérifie la bonne solution
		assert (!villesToutesDifferentesInvariant()):"solution non conforme";
		
		//calcul des evaluations
		for (int i=0;i<listeVilles.size()-1;i++)
		{
			res=res+listeVilles.get(i).calculerDistance(listeVilles.get(i+1));
		}
		res=res+listeVilles.get(0).calculerDistance(listeVilles.get(listeVilles.size()-1));
		return(res);
	}
	
	
	/**
	 * methode de verification de solution
	 * @return true si solution valide
	 */
	public boolean villesToutesDifferentesInvariant()
	{
		//taille
		assert listeVilles.size()==probleme.listeVilles.size():"pas bonne taille de solution";
		
		//pas de duplication de villes
		for (int i=0;i<listeVilles.size();i++)
			for (int j=i+1;j<listeVilles.size();j++)
				assert listeVilles.get(i)!=listeVilles.get(j);  		
		return(true);
		
	}
	
	
	/**
	 * permet d'inverser deux villes dans la suite
	 * @param i 
	 * @param j
	 */
	public void inverse(int i, int j)
	{
		Ville temp=listeVilles.get(i);
		listeVilles.set(i,listeVilles.get(j));
		listeVilles.set(j,temp);
	}
	
	/**
	 * tostring
	 */
	public String toString()
	{
		String res="";
		res+=listeVilles;
		return(res);
	}

	@Override
	/**
	 * retourne les solutions voisines
	 * celles ou on a inverse deux villes
	 */
	public List<SolutionAbstract> retourneVoisinage() {		
		
		// TODO a construire
		List<SolutionAbstract> solutionsVoisines=new ArrayList<SolutionAbstract>(); 
		for (int i=0;i<listeVilles.size();i++)
		{
			for (int j=i+1;j<listeVilles.size();j++)
			{
				if (i!=j)
				{
					SolutionTSP voisine=new SolutionTSP(this);
					voisine.inverse(i, j);
					solutionsVoisines.add(voisine);
				}
			}
		}
		// FinTODO a construire
		
		return solutionsVoisines;
	}
	
    /**
     * methode qui retourne un voisin au hasard 
     * consiste simplement à retourner une solution avec une 
     * un echange de deux ville au hasard.
     * 
     */
   
    public SolutionAbstract retourneVoisinHasard(){

	SolutionTSP voisin = new SolutionTSP(this);
	
	// TODO a ecrire etudiant
	


	// FinTODO a ecrire etudiant
	return voisin;
    }


    /**
     * methode qui retourne une solution perturbée 
     * consiste simplement à retourner une solution avec 
     * plusieurs villes echangees.
     * @param n le nombre d'echanges  
     */  
   
    public SolutionAbstract retournePerturbation(int n){
        SolutionTSP perturbed = new SolutionTSP(this);
	
	// TODO a ecrire etudiant
	


	// FinTODO a ecrire etudiant
	
	return perturbed;
    }


    
}
