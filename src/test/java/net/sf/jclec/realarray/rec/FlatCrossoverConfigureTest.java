package net.sf.jclec.realarray.rec;

import net.sf.jclec.IConfigureTest;

public class FlatCrossoverConfigureTest extends IConfigureTest<FlatCrossover> 
{

	public FlatCrossoverConfigureTest(String name) 
	{
		super(FlatCrossover.class, name);
	}

	@Override
	protected void initObject1() 
	{
		object1.setLocusRecProb(0.6);
	}

	@Override
	protected void setConfigurationFilename() 
	{
		configurationFilename = "./src/net/sf/jclec/realarray/rec/FlatCrossover.cfg";
	}

}
