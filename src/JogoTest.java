import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JogoTest {

	@Test
	final void testCaso01_getQtdJogos_2() {
		Jogo jogo = new Jogo(12, 2);
		
		assertEquals(2, jogo.getQtdJogos());
	}
	
	@Test
	final void testCaso02_getQtdJogos_50() {
		Jogo jogo = new Jogo(22, 50);
		
		assertEquals(50, jogo.getQtdJogos());
	}
	
	@Test
	final void testCaso03_getPlacar_1000() {
		Jogo jogo = new Jogo(1000, 3);
		jogo.setPlacar(61);
		jogo.setQtdJogos(3);
		jogo.setPlacar(1000);
		
		assertEquals(61, jogo.getPlacar());
	}

}
