package net.sf.jclec.selector;

import java.util.ArrayList;

import net.sf.jclec.IIndividual;
import net.sf.jclec.ISelectorTest;

/**
 * StochasticUniversalSampling selector tests.
 * 
 * @author Rafael Aguilera 
 */

public class StochasticUniversalSamplingTest extends ISelectorTest<StochasticUniversalSampling> 
{
	/////////////////////////////////////////////////////////////////
	// ------------------------------------------------- Constructors
	/////////////////////////////////////////////////////////////////

	/**
	 * Default constructor
	 * 
	 * @param name
	 */
	
	public StochasticUniversalSamplingTest(String name) 
	{
		super(StochasticUniversalSampling.class, name);
	}

	/////////////////////////////////////////////////////////////////
	// -------------------------------------------- Protected methods
	/////////////////////////////////////////////////////////////////
	
	@Override
	protected void initTool() 
	{
		// Do nothing
	}
	
	@Override
	protected void createExpected() 
	{
		expected = new ArrayList<IIndividual>();
		expected.add(source.get(0));
		
	}	
}
