package src.application.vue;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class VueTerrainTest {

	@Test
	void testCollisions() {

		assertEquals("il y'a de collision dans ce cas :", true, VueTerrain.collisions(1));
		assertEquals("cas 2", true, VueTerrain.collisions(2));
		assertEquals("cas 3", true, VueTerrain.collisions(3));
		assertEquals("cas 4", true, VueTerrain.collisions(4));
		assertEquals("il y'a pas de collision dans ce cas :", false, VueTerrain.collisions(5));
		
	}
	
	@Test
	void testCollisions2() {
		assertEquals("il y'a de collision dans ce cas :", true, VueTerrain.collisions2(1));
		assertEquals("cas 2", true, VueTerrain.collisions2(2));
		assertEquals("cas 3", true, VueTerrain.collisions2(3));
		assertEquals("cas 11", true, VueTerrain.collisions2(11));
		assertEquals("cas 12", true, VueTerrain.collisions2(12));
		assertEquals("il y'a pas de collision dans ce cas :", false, VueTerrain.collisions2(13));

	}

}
