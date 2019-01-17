package se.lexicon.teresia.arena_fighter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ArenaFighterTest {
	
	
	@Test
	public void test_fighter_start_stats() {
		
		Fighter theFighter = new Fighter();
		assertEquals(theFighter.getHealthPoints(), theFighter.getStartHealthPoints());
		assertEquals(theFighter.getStrenght(), theFighter.getStartStrength());

	}
	

	@Test
	public void test_if_fighter_dies_by_hit() {
		
		Fighter theFighter = new Fighter();
		assertTrue(theFighter.isAlive());
		
		theFighter.takeHit(theFighter.getHealthPoints()+1);
		assertFalse(theFighter.isAlive());
	}

}
