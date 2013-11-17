package net.sf.jclec.selector;

import java.util.ArrayList;

import net.sf.jclec.IIndividual;
import net.sf.jclec.ISelectorTest;

/**
 * SobranteStocastico selector tests.
 * 
 * @author Rafael Aguilera 
 */

public class StochasticRemainingSelectorTest extends ISelectorTest<StochasticRemainingSelector> 
{
	/////////////////////////////////////////////////////////////////
	// ------------------------------------------------- Constructors
	/////////////////////////////////////////////////////////////////

	/**
	 * Default constructor
	 * 
	 * @param name
	 */
	
	public StochasticRemainingSelectorTest(String name) 
	{
		super(StochasticRemainingSelector.class, name);
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
		expected.add(source.get(1));
		
	}	
}
