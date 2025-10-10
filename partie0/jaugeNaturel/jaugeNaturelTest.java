package jaugeNaturel;

import static org.junit.Assert.*;

import org.junit.*;

public class jaugeNaturelTest {
    
    jaugeNaturel jauge1,jauge11,jauge2,jauge3,jauge4, jauge5,jauge6,jauge7,jauge8,jauge9, jauge10, jauge12;
    
    
    @Before
    public void initialiser() throws Exception {

    jauge1 = new jaugeNaturel(-345, 67899, 100);
    jauge11 = new jaugeNaturel(100, 200, 102);
    jauge2 = new jaugeNaturel(345, 67899, 100);
    jauge3 = new jaugeNaturel(345, 67899, 345);
    jauge4 = new jaugeNaturel(10,100,12);
    jauge5 = new jaugeNaturel(12,100,10);
    jauge6 = new jaugeNaturel(13,100,13);
    jauge7 = new jaugeNaturel(12,100,101);
    jauge8= new jaugeNaturel(13,100,100);
    jauge9 = new jaugeNaturel(15,13,14);
    jauge10 = new jaugeNaturel(15,15,16);
    jauge12=  new jaugeNaturel(15,15,15);
    }
    
    
    
    @After
    public void nettoyer() throws Exception {
    jauge1 = null;
    jauge11=null;
    jauge2 = null;
    jauge3 =null;
    jauge4 = null;
    jauge5= null;
    jauge6= null;
    jauge7= null;
    jauge8 = null;
    jauge9 = null;
    jauge10= null;
    jauge12 = null;
   
    }

    /**
    * Etat après instanciation pour une valeur de départ dans l'intervalle de vigie.
    *
    * <p> A vérifier :
    *  <p>estBleu() retourne faux.
    *  <p>estVert() retourne vrai.
    *  <p>estRouge() retourne faux.
    */
   
    @Test
    public void DansIntervalle() {
        
       //assertTrue(!jauge1.estBleu());
       assertFalse("gg",jauge11.estBleu());
       assertTrue(jauge11.estVert());
       assertFalse(jauge11.estRouge());
      }
    @Test
    public void testDeplacer() {
    	jauge4.decrementer();
    	jauge4.decrementer();
    	assertTrue("bleu dec",jauge4.estBleu());
    	assertFalse("vert dec",jauge4.estVert());
    	assertFalse("rouge dec",jauge4.estRouge());
    	
    	jauge4.incrementer();
    	assertFalse("bleu inc",jauge4.estBleu());
    	assertTrue("vert inc",jauge4.estVert());
    	assertFalse("rouge inc",jauge4.estRouge());
    }
    
    @Test
    public void testInferieurIntervalle() {
    	assertTrue(jauge5.estBleu());
    	assertFalse(jauge5.estVert());
    	assertFalse("rouge ",jauge5.estRouge());
    	
    	assertTrue(jauge6.estBleu());
    	assertFalse(jauge6.estVert());
    	assertFalse("rouge ",jauge6.estRouge());
    }
    
    @Test
    public void testSuperieurIntervalle() {
    	assertFalse(jauge7.estBleu());
    	assertFalse(jauge7.estVert());
    	assertTrue("rouge ",jauge7.estRouge());
    	
    	assertFalse(jauge8.estBleu());
    	assertFalse(jauge8.estVert());
    	assertTrue("rouge ",jauge8.estRouge());
    }
    @Test
    public void testLimiteVigieMaxInferieurVigieMin() {
    	assertTrue(jauge9.estBleu());
    	assertFalse(jauge9.estVert());
    	assertTrue("rouge ",jauge9.estRouge());
    	
    }
    
    @Test
    public void testMaxEgaleMin(){
    	assertFalse(jauge10.estBleu());
    	assertFalse(jauge10.estVert());
    	assertTrue("rouge ",jauge10.estRouge());
    	
    	assertTrue(jauge12.estBleu());
    	assertFalse(jauge12.estVert());
    	assertTrue("rouge ",jauge12.estRouge());
    	
    }
    
    
}

