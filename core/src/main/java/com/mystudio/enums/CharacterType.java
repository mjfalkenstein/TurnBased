package com.mystudio.enums;

public enum CharacterType {
	
	/* TIER 1 */
	
	GHOST,				//fast, squishy, melee dps
	FIELD_MEDIC,		//healer, can self heal and deal medium damage
	GUNMAN,				//standard soldier, uses an anti-personell rifle
	CYBORG,				//a simple augmented soldier, uses electrical discharges at close range
	
	/* TIER 2 */
	
	ENFORCER,			//close-range fighter, tanky and short ranged, lots of damage
	SHARPSHOOPER,		//long-range, lots of damage, squishy
	PHANTOM,			//close range magic user, can go invisible, does bonus damage if attacking from stealth
	TECHNOMANCER, 		//uses technology as magic, long ranged
	NOVA,				//purely a healer, can heal from a range
	MIRAGE,				//one who creates small drones to fight on their behalf
	BULWARK,			//uses a large energy shield, very low damage, very high health
	PRODIGY,			//one with amazing intellect, has forgone physical prowess for a powerful exoskeleton
	
	/* TIER 3 */

	JUNKIE,				//low combat effectiveness without their drugs, bursts of extreme strength and speed
	NEUROMANCER,		//medium range magic user, can heal or damage
	JUGGERNAUT,			//uses cybernetic fists, melee range, low damage, high health
	VISIONARY,			//A fully realized prodigy, uses their enormous brain power to control a mech, virtually no body
	ARCHITECT,			//A master builder, creates multiple very powerful robots simultaneously
	EXECUTIONER,		//a melee-range killer, can go invisible, does double damage if attacking from stealth
	SNIPER,				//Extremely long range, chance to headshot for double damage
	COMMANDER,			//Close-range explosives user, can damage enemies in an AOE
	
	/* TIER-LESS CLASSES (NPC's and ENEMIES MOSTLY) */
	
	TECHNOBEAST,		//a single-minded servant animal, made up of large hounds and robotic parts
	HARPY,				//human with robotic wings, can fly, high mobility, melee damage
	BASILISK,			//a robotic serpent, used as an anti-personell weapon in riots
	REJECT,				//Someone whose augmentations have been rejected and fallen into disrepair, cannon fodder
	DRONE,				//a creation of a mirage, small melee suicide bomber
	PURIST,				//one who is outwardly opposed to any cybernetic augmentations, uses a long, slim blade
	COURIER,			//not combat effective, used as an item carrier
	ABERRATION,			//grotesque combination of flesh and technology, mindless combatant
	TECHNOHORROR		//An amalgamation of human bodies and technology, an enormous, unstoppable monster
}