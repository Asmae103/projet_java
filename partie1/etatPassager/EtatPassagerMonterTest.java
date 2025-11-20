package etatPassager;
import static org.junit.Assert.*;
import org.junit.*;

public class EtatPassagerMonterTest {

	EtatPassagerMonter passager1,passager2,passager3,passager4,passager5,passager6;
    
    @Before
    public void initialiser() throws Exception {
    	passager1 = new EtatPassagerMonter(EtatPassagerMonter.Etat.DEHORS);
    	passager2 = new EtatPassagerMonter(EtatPassagerMonter.Etat.ASSIS);
    	passager3 = new EtatPassagerMonter(EtatPassagerMonter.Etat.DEBOUT);
    	passager4 = new EtatPassagerMonter(EtatPassagerMonter.Etat.ASSIS);
    	passager5 = new EtatPassagerMonter(EtatPassagerMonter.Etat.DEBOUT);
    	passager6 = new EtatPassagerMonter(EtatPassagerMonter.Etat.DEHORS);

    }
    
    
    
    @After
    public void nettoyer() throws Exception {
    	passager1 = null;
    	passager2 = null;
    	passager3 = null;
    	passager4 = null;
    	passager5 = null;
    	passager6 = null;
    }

    
    @Test
    public void testEstExterieur() {
    	
    
    	assertTrue("1",passager1.estExterieur());
    	assertFalse("2",passager1.estAssis());
    	assertFalse("3",passager1.estDebout());
    	
    }
    
    @Test
    public void testEstAssis() {
    	
    
    	assertFalse("4",passager2.estExterieur());
    	assertTrue("5",passager2.estAssis());
    	assertFalse("6",passager2.estDebout());
    	
    }

	@Test
	public void testEstDebout() {
    	assertFalse("7",passager3.estExterieur());
    	assertFalse("8",passager3.estAssis());
    	assertTrue("9",passager3.estDebout());
		
	}
	
	@Test
	public void testEstInterieur() {
		
		assertTrue("10",passager4.estInterieur());
		assertTrue("11",passager5.estInterieur());
		assertFalse("12",passager6.estInterieur());
		
	}
}