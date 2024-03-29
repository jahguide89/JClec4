package net.sf.jclec.realarray;

import net.sf.jclec.IFitness;
import net.sf.jclec.IIndividual;
import net.sf.jclec.base.AbstractIndividual;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Individual with a double array as genotype.
 *  
 * @author Sebastian Ventura
 */

public class RealArrayIndividual extends AbstractIndividual<double[]> 
{
	/////////////////////////////////////////////////////////////////
	// --------------------------------------- Serialization constant
	/////////////////////////////////////////////////////////////////
	
	/** Generated by Eclipse */
	
	private static final long serialVersionUID = 7013687809733709173L;

	/////////////////////////////////////////////////////////////////
	// ------------------------------------------------- Constructors
	/////////////////////////////////////////////////////////////////
	
	/**
	 * Empty constructor
	 */
	
	public RealArrayIndividual() 
	{
		super();
	}

	/**
	 * Constructor that sets individual genotype
	 * 
	 * @param genotype Individual genotype
	 */
	
	public RealArrayIndividual(double[] genotype) 
	{
		super(genotype);
	}

	/**
	 * Constructor that sets individual genotype and fitness
	 * 
	 * @param genotype Individual genotype
	 * @param fitness  Individual fitness
	 */
	
	public RealArrayIndividual(double[] genotype, IFitness fitness) 
	{
		super(genotype, fitness);
	}

	/////////////////////////////////////////////////////////////////
	// ----------------------------------------------- Public methods
	/////////////////////////////////////////////////////////////////
		
	// IIndividual methods
		
	/**
	 * {@inheritDoc}
	 */
	
	public IIndividual copy() 
	{
		// Genotype length
		int gl = genotype.length;
		// Allocate a copy of genotype
		double [] gother = new double[genotype.length];
		// Copy genotype
		System.arraycopy(genotype, 0, gother, 0, gl);
		// Create new individuals, then return it
		if (fitness != null) {
			return new RealArrayIndividual(gother, fitness.copy());			
		}
		else {
			return new RealArrayIndividual(gother);			
		}
	}

	/**
	 * Euclidean distance.
	 * 
	 * @return Euclidean distance between genotypes
	 */
	
	public double distance(IIndividual other) 
	{
		// Other genotype
		double [] gother = ((RealArrayIndividual) other).genotype;
		// Setting Euclidean distance
		double distance = 0.0;
		int gl = genotype.length;
		for (int i=0; i<gl; i++) {
			double aux = genotype[i] - gother[i];
			distance += aux*aux;
		}	
		// Returns hamming distance
		return Math.sqrt(distance);
	}
	
	// java.lang.Object methods

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean equals(Object other) 
	{
		if (other instanceof RealArrayIndividual) {
			RealArrayIndividual iaother = (RealArrayIndividual) other;
			EqualsBuilder eb = new EqualsBuilder();
			eb.append(genotype, iaother.genotype);
			return eb.isEquals();
		}
		else {
			return false;
		}
	}	
}
