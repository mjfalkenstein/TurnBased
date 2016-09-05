package com.mystudio.enums;

public enum CharacterType {
	
	/* TIER 1 */
	
	GHOST,				//fast, squishy, melee dps, uses a short dagger
	FIELD_MEDIC,		//healer, can self heal and deal medium damage, no weapons, but carries a first aid kit and large syringe
	GUNMAN,				//standard soldier, uses an anti-personell rifle and run-of-the-mill body armor
	CYBORG,				//a simple augmented soldier, uses electrical discharges at close range, charges stored in robotic arms
	
	/* TIER 2 */
	
	ENFORCER,			//close-range fighter, tanky and short ranged, lots of damage, uses a shotgun that fires electricity
	SHARPSHOOPER,		//long-range, lots of damage, squishy, uses a large rifle
	PHANTOM,			//close range melee fighter, can go invisible, does bonus damage if attacking from stealth, uses daggers
	TECHNOMANCER, 		//uses technology as "magic" in the form of nano swarms, relatively long ranged
	NOVA,				//purely a healer, can heal from a range, no weapons, uses nano swarms for mecical purposes
	MIRAGE,				//one who creates small drones to fight on their behalf, has no weapons but builds fighters
	BULWARK,			//uses a large energy shield, very low damage, very high health, punches with the shield in combat
	SCION,			//one with amazing intellect, has forgone physical prowess for a powerful exoskeleton with a medium ranged rifle
	
	/* TIER 3 */

	JUNKIE,				//low combat effectiveness without their drugs, bursts of extreme strength and speed, uses metal gauntlets
	NEUROMANCER,		//medium range magic user, can heal or damage, carries a PDA to control their "magic"
	JUGGERNAUT,			//uses enormous cybernetic fists, melee range, low damage, high health, no other weapon
	PRODIGY,			//A fully realized scion, uses their enormous brain power to control a mech, uses shotguns for close-range combat
	ARCHITECT,			//A master builder, creates multiple very powerful robots simultaneously, carries a PDA to control robots
	EXECUTIONER,		//a melee-range killer, can go invisible, does double damage if attacking from stealth, uses laser daggers
	SNIPER,				//Extremely long range, chance to headshot for double damage, uses a large railgun for max range combat
	COMMANDER,			//Close-range explosives user, can damage enemies in an AOE, carries grenades and C4 bombs
	
	/* TIER-LESS CLASSES (NPC's and ENEMIES MOSTLY) */
	
	TECHNOBEAST,		//a single-minded servant animal (usually canine), made up of large hounds and robotic parts, punches in combat
	HARPY,				//human with robotic wings, can fly, high mobility, melee damage, fights with leg-mounted talons
	BASILISK,			//a robotic serpent, used as an anti-personell weapon in riots, uses large teeth in combat
	REJECT,				//Someone whose augmentations have been rejected and fallen into disrepair, no combat effectiveness
	DRONE,				//a creation of a mirage, small melee suicide bomber with repulsers for flight
	PURIST,				//one who is outwardly opposed to any cybernetic augmentations, uses a long, slim blade and thin armor
	COURIER,			//not combat effective, used as an item carrier
	ABERRATION,			//grotesque combination of flesh and technology, mindless combatant, doesn't carry weapons
	TECHNOHORROR,		//An amalgamation of human bodies and technology, an enormous, unstoppable monster, uses claws and fists for combat
	ANDROID,			//An improved drone, with ranged capabilities, uses a balistic assault rifle
	RECONSTRUCTOR,		//A mobile lab that itself cannot attack, but generates technobeasts, harpies, basilisks, aberrations, and revenants 
	REVENANT,			//an ex-soldier who still uses his gun in combat, but has gone mad after augmentation rejection
	
}