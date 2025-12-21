package tec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.IJauge;

public interface IJaugeTest{
 
	public IJauge creerJauge(long i , long j, long val);
	
    @After
	public void setUp() throws Exception;
	
    @Before
	public void tearDown() throws Exception;

	@Test
	public void testDansIntervalle();
	
	@Test
    public void testInferieurIntervalle();
 
	
	@Test
    public void testSuperieurIntervalle();

	
	@Test
    public void testDeplacement();

	@Test
    public void testLimiteVigieMaxInferieurVigieMin();

	@Test
    public void testMaxEgaleMin();
    
  }
    

