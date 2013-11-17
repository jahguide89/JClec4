package net.sf.jclec.exprtree;

import net.sf.jclec.ISpecies;

import net.sf.jclec.base.AbstractCreator;

/**
 * Expression tree individuals creator.
 * 
 * @author Sebastian Ventura
 */

public class ExprTreeCreator extends AbstractCreator 
{
	/////////////////////////////////////////////////////////////////
	// --------------------------------------- Serialization constant
	/////////////////////////////////////////////////////////////////

	/** Generated by Eclipse */
	
	private static final long serialVersionUID = 4365866784680115536L;

	/////////////////////////////////////////////////////////////////
	// ------------------------------------------- Internal variables
	/////////////////////////////////////////////////////////////////

	/** Individual species */
	
	protected transient ExprTreeSpecies species;
	
	/** Individuals schema */
	
	protected transient ExprTreeSchema schema;
	
	/////////////////////////////////////////////////////////////////
	// ------------------------------------------------- Constructors
	/////////////////////////////////////////////////////////////////

	/**
	 * Empty (default) constructor.
	 */
	
	public ExprTreeCreator() 
	{
		super();
	}

	/////////////////////////////////////////////////////////////////
	// ----------------------------------------------- Public methods
	/////////////////////////////////////////////////////////////////
	
	// java.lang.Object methods
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean equals(Object other)
	{
		if (other instanceof ExprTreeCreator){
			return true;
		}
		else {
			return false;
		}
	}

	/////////////////////////////////////////////////////////////////
	// -------------------------- Overwriting AbstractCreator methods
	/////////////////////////////////////////////////////////////////

	// AbstractCreator methods

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	protected void prepareCreation() 
	{
		ISpecies spc = context.getSpecies();
		if (spc instanceof ExprTreeSpecies) {
			// Type conversion 
			this.species = (ExprTreeSpecies) spc;
			// Sets genotype schema
			this.schema = ((ExprTreeSpecies) spc).getGenotypeSchema();
		}
		else {
			throw new IllegalStateException("Illegal species in context");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	protected void createNext() 
	{
		// Select expression size
		int minSize = schema.getMinTreeSize();
		int maxSize = schema.getMaxTreeSize();
		int actSize = randgen.choose(minSize, maxSize);
		// Create Expression tree
		ExprTree genotype = schema.createExprTree(actSize, randgen);
		// Put new son in created buffer
		createdBuffer.add(species.createIndividual(genotype));
	}
}
