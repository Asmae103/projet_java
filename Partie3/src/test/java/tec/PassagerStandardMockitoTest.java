package tec;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class PassagerStandardMockitoTest {

    @Test
    public void testMonterDansAssis() throws UsagerInvalideException {
        PassagerStandard p = new PassagerStandard("Tom", 6, new EtatPassager(EtatPassager.Etat.DEHORS));

        Transport t = mock(Transport.class, withSettings().extraInterfaces(Bus.class));
        Bus bus = (Bus) t;

        when(bus.aPlaceAssise()).thenReturn(true);

        p.monterDans(t);

        verify(bus).demanderPlaceAssise(p);
        verify(bus, never()).demanderPlaceDebout(p);
    }

    @Test
    public void testMonterDansDebout() throws UsagerInvalideException {
        PassagerStandard p = new PassagerStandard("Tom", 6, new EtatPassager(EtatPassager.Etat.DEHORS));

        Transport t = mock(Transport.class, withSettings().extraInterfaces(Bus.class));
        Bus bus = (Bus) t;

        when(bus.aPlaceAssise()).thenReturn(false);
        when(bus.aPlaceDebout()).thenReturn(true);

        p.monterDans(t);

        verify(bus).demanderPlaceDebout(p);
        verify(bus, never()).demanderPlaceAssise(p);
    }
}