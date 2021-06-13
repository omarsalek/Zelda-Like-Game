package src.modele.acteur;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import src.modele.Environnement;
import src.modele.Terrain;

class LinkTest {
	Terrain map = new Terrain();
	Environnement env = new Environnement(960, 639, map);
	Link link = new Link(env);


	@Test
	void testAcheterPistolet() {
		assertEquals("Link essayes d'acheter les munitions pour la premiere fois sans tuer des ennemies et sans parler au magasinier :", false, link.acheterPistolet());
		}


}
