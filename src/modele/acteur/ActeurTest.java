package src.modele.acteur;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.modele.Environnement;
import src.modele.Terrain;

class ActeurTest {
	Terrain map = new Terrain();
	Environnement env = new Environnement(960, 639, map);
	Link link = new Link(env);
	Gobelin Gobelin = new Gobelin(env, 544, 416);
	Archers archers = new Archers(env, 100, 200);
	@Test
	void testCollisionsEntreActeurs() {
		this.link.setX(544);
		this.link.setY(416);
		assertTrue(this.link.getX() / 16 == this.Gobelin.getX() / 16);
		this.link.setX(542);
		this.link.setY(416);
		assertFalse(this.link.getX() / 16 == this.Gobelin.getX() / 16);
	}
	@Test
	void testDeplacerDown() {
		if (this.link.getY() == 600) {
			assertEquals("Passer a l'autre en haut ", -1, this.link.getY());
			assertEquals("Passer a l'autre en haut ", 283, this.link.getX());
		}
	}
	@Test
	void testAttaque() {
		link.decrementerPv(50);
		assertEquals("Test link est Mort ", 0, link.getPtv());
		Gobelin.decrementerPv(10);
		assertEquals("Decrementer Gobelin Ptv 12-10 :", 2, Gobelin.getPtv());
	}

}
