/**
 * Ted Mader
 * CSCI 1583 Fall 2013
 * Honors Option Project
 * 12/13/2013
 **/

import java.util.Scanner;
import java.util.Random;
import java.lang.String;
import javax.swing.JOptionPane;

public class DNO{

	public static Scanner input = new Scanner(System.in);
	
	public static int decision;
	public static int randomStory;
	public static int randomMod;
	
	public static String c1; //Choice 1
	public static String c2; //Choice 2
	public static String c3; //Choice 3
	
	public static String choiceText;
	
	public static Character player = new Character("Test",20,500,5,5,5,1,1,false);
	
	public static void main(String[] args){

	player = mainMenu();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();	
	levelStranger();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();	
	levelBlackJack();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	event();
	levelNightmare();
	event();
	event();
	event();
	event();
	event();
	event();
	levelDoppelganger();
	
	}
	
	public static Character mainMenu(){

	int hp = 0;
	int gold = 0;
	int will = 0;
	int str = 0;
	int cun = 0;
	
	int hpRate = 0;
	int goldFind = 0;
	
	boolean blade = false;
	
	story("===|Dungeon of New Orleans|===");
	
	story("Welcome to the GUI version of DNO! The crude tutorial no longer applies here.");
	
	choiceText = "Would you like to BEGIN or EXIT?";
	c1 = "begin";
	c2 = "exit";
	decision = decisionProcess(c1,c2,choiceText);
	
	if(decision == 2){
		story("Well, goodbye I guess."); //Array for random goodbye messages?
		System.exit(0);
	}	
	
	story("Congratulations! You've majored in Dungeoneering and minored in hacking and slashing.");
	
	story("To pass the class, you must delve through the Dungeon of New Orleans and come out bearing its many treasures!");
	
	choiceText = "You feel READY to begin your studies.";
	c1 = "ready";
	decision = decisionProcess(c1, choiceText);

	//Character Creation
	
	story("You walk down the entrance stairs and into a great hall lined with columns of stone.");

	story("Across the room is a colossal gate guarded by an armored man.");

	story("KEEPER: You must answer three questions in order to pass.");

	String playerName = JOptionPane.showInputDialog("KEEPER: What... is your name?");

	choiceText = "KEEPER: What... is your quest?\n* To SURVIVE the dungeon's dangers.\n* To DISCOVER many treasures.\n* To be an absolute BADASS.";
	c1 = "survive";
	c2 = "discover";
	c3 = "badass";
	decision = decisionProcess(c1,c2,c3,choiceText);
	if(decision == 1){
		hp = 40;
		hpRate = 2;
		goldFind = 1;
	}
	else if(decision == 2){
		hp = 20;
		hpRate = 1;
		goldFind = 2;
	}
	else if(decision == 3){
		hp = 10;
		hpRate = 0;
		goldFind = 10;
	}

	choiceText = "KEEPER: What... is your greatest strength?\n* My physical STRENGTH.\n* My unbreakable WILLPOWER.\n* My admirable CUNNING.";
	c1 = "strength";
	c2 = "willpower";
	c3 = "cunning";
	decision = decisionProcess(c1,c2,c3,choiceText);
	
	if(decision == 1){
		str = 7;
		cun = 3;
		will = 5;
	}
	
	else if(decision == 2){
		str = 3;
		will = 7;
		cun = 5;
	}
	
	else if(decision == 3){
		str = 5;
		will = 3;
		cun = 7;
	}
	
	story("The massive gate slowly opens making a heavy, metal sound.");

	story("KEEPER: Your quest begins here, " + playerName + "!");
	
	story("You enter, continuing down yet another flight of stairs.");
	
	Character newPlayer = new Character(playerName, hp, gold, str, will, cun, hpRate, goldFind, blade);
	
	return newPlayer;
	}
	
	//Random Events
	
	public static void event(){

		randomStory = randomizer(7);
		
		if(randomStory == 1){
			eventTreasure();
		}
		else if(randomStory == 2){
			eventMonster();
		}
		else if(randomStory == 3){
			eventMonster();
		}
		else if(randomStory == 4){
			eventStore();
		}
		else{
			eventHallway();
		}
	}
	
	public static void eventHallway(){
		
		randomStory = randomizer(5);
		if(randomStory == 1){
			story("You continue down a dimly-lit corridor.");
		}
		else if(randomStory == 2){
			story("As you walk, you notice how intricate the hallways' walls are built.");
			
			story("You spot an occasional stone carving or decorative pillar.");
			
			story("How much work has been invested into this 'classroom'?");
		}
		else if(randomStory == 3){
			story("During your endless hallway exploration, you begin to think of your close ones, especially 'her'.");
		
			story("You begin to think: would you even live for 'her' to see you again?");
		}
		else if(randomStory == 4){
			story("It has been hours since anything eventful has happened.");
			
			story("You begin to notice how beautiful the torch flames are, lighting your way.");
			
			story("What would you do without them?");
		}
		else{
			story("This dungeon is never going to end, you tell yourself.");
			
			story("Suddenly, a funny smell reaches your nostrils...");

			story("Oh. You just smell your own breath.");
			
			story("You must have caught a cold, since you have to breathe through your mouth.");
			
			story("Then you realize you haven't brushed your teeth in awhile.");
		}
	}
	
	public static void eventTreasure(){
	
		story("Walking further down the dungeon's dark halls, you encounter a tiny chest.");
		
		story("It sits upon a peculiar stone pedestal bearing engravings of unfamiliar creatures, brightly lit by burning torches.");
			
		story("Your curiosity tells you to open the chest, but you remain extremely cautious.");
		
		choiceText = "You could OPEN the chest, IGNORE it, or CHECK the surroundings for traps.";
			c1 = "open";
			c2 = "ignore";
			c3 = "check";
			decision = decisionProcess(c1,c2,c3,choiceText);
		
		if(decision == 1){
			randomStory = randomizer(10);
			if(randomStory < 5){
				story("As you open the chest, you hear a clicking noise, and an arrow shoots to your knee!");
				
				story("You scream in pain, quickly hushing yourself in case something hears you.");
				randomMod = randomizer(10) * -1;
				player.hpMod(randomMod);
			}
			else if(randomStory >= 5){
				randomMod = randomizer(40) + 10;
				story("You open the chest, revealing a pile of " + randomMod * player.getGoldFind() + " gold! You sigh in relief as you pocket the shinies.");
				player.goldMod(randomMod);
			}
		}
		else if(decision == 2){
			story("You decide to resist the temptations of treasure and continue down the path.");
			player.willMod(1);
		}
		else if(decision == 3){
			story("You dilligently search the surroundings for any sort of dangers.");
			randomMod = randomizer(10);
			
			if(randomStory <= player.getCun()){
				
				story("To your expectatons, you spot an arrow trap against the wall, aiming to where one would stand to open the chest.");
				
				story("You open the chest from the opposite side, triggering the trap without harm.");
				randomMod = randomizer(100);
				
				story("The chest contains a pile of " + randomMod * player.getGoldFind() + " gold! You smugly pocket the treasure, having outsmarted the dungeon's follies.");
				player.goldMod(randomMod);
				player.cunMod(1);
			}
				
			else if(randomStory > player.getCun()){
				story("However, you accidentally trigger a pressure plate on the ground, springing an arrow trap! Your shoulder is met with the piercing of an arrowhead.");
				randomMod = randomizer(10);
				player.hpMod(randomMod*-1);
			}
		}
	}
	
	public static void eventStore(){
	
		story("You stumble across a door labeled by a sign reading 'STORE'.");
		
		choiceText = "You can CHECK it out or IGNORE it and keep going.";
		c1 = "check";
		c2 = "ignore";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 1){
			story("You go through the door and enter a brightly-lit room filled with various wares.");
			
			randomStory = randomizer(4);
			
			if(randomStory == 1){
				story("Unexpectedly, you are met with the sight a shoplifter!");
				
				story("SHOPLIFTER: Today is a good day for you to die!");
				
				MonsterBattle shoplifter = new MonsterBattle(20, 5, 50, "SHOPLIFTER");
				
				shoplifter.battle();
			
				story("You see a stone counter with a potion and a blade.");
				
				story("Behind the counter, you see the body of the dead shopkeeper!");
				
				story("Realizing capitalism means nothing to the dead, You help yourself to the wares.");
				
				if(player.getBlade() == true){
					story("You drink the healing potion in a single gulp.");
					player.hpMod(randomizer(10)+10);
				}
				else{
					story("You take the brand-new blade and drink the healing potion.");
					player.bladeMod(true);
					player.hpMod(randomizer(10)+10);
				}
			}
			else{
				story("An old man stands behind a stone counter, eager at the sight of a potential customer.");
				
				story("SHOPKEEPER: Buy somethin', will ya!");
				
				choiceText = "You could BUY something from the man or LEAVE. Alternatively, you could KILL him for his wares.";
				c1 = "buy";
				c2 = "kill";
				c3 = "leave";
				decision = decisionProcess(c1,c2,c3,choiceText);
				
				if(decision == 1){
					story("SHOPKEEPER: Stab your enemies with the fine craftsmanship of this dwarven-forged BLADE!");
						
					story("SHOPKEEPER: I also have this healing POTION, brewed from the blood of fairies!");
					
					int bladeCost = randomizer(100)+100;
					int potionCost = randomizer(50)+50;
					
					while(decision != 3){
						choiceText = "* Do you wish to purchase the BLADE or the POTION or LEAVE?";
						c1 = "blade";
						c2 = "potion";
						c3 = "leave";
						decision = decisionProcess(c1,c2,c3,choiceText);
						
						if(decision == 1){
							if(player.getBlade() == true){
								story("You already have a decent weapon. There's need in carrying more.");
							}							
							else{
								choiceText = "SHOPKEEPER: The blade costs "+bladeCost+" gold. Will you buy?\n* YES\n* NO";
								c1 = "yes";
								c2 = "no";
								decision = decisionProcess(c1,c2,choiceText);
							
								if(decision == 1){
									if(player.getGold() < bladeCost){
										story("SHOPKEEPER: Ya can't afford that! Come back when ya'r a little, hmm... richer.");
									}
									else{
										player.goldMod(bladeCost*-1);
										player.bladeMod(true);
										story("SHOPKEEPER: Thank ya!");
									}
								}
								else{
									story("SHOPKEEPER: Take ya'r time then.");
								}
							}
						}
						else if(decision == 2){
							choiceText = "SHOPKEEPER: The potion costs "+potionCost+" gold. Will you buy?\n* YES\n* NO";
							c1 = "yes";
							c2 = "no";
							decision = decisionProcess(c1,c2,choiceText);
							
							if(decision == 1){
								if(player.getGold() < potionCost){
									story("SHOPKEEPER: Ya can't afford that! Come back when ya'r a little, hmm... richer.");
								}
								else{
									player.goldMod(potionCost*-1);
									story("Tastes like cherries...");
									player.hpMod(randomizer(10)+10);
									story("SHOPKEEPER: Thank ya!");
								}
							}
							else{
								story("SHOPKEEPER: Take ya'r time then.");
							}
						}
					}
				}
				else if(decision == 2){
					MonsterBattle shopkeeper = new MonsterBattle(30, 10, 500, "SHOPKEEPER");
					
					if(player.getBlade() == true){
						story("You draw your blade, ready to take the SHOPKEEPER's goods with force.");
					}
					else{
						story("Like the madman you are, you throw a punch at the SHOPKEEPER across the counter, ready to kill for his goods.");
					}
					story("SHOPKEEPER: That's how it is, eh? Then pay with your blood!");
					
					shopkeeper.battle();
					
					story("After spilling the blood of the innocent SHOPKEEPER.");
					
					if(player.getBlade() == true){
						story("You drink the healing potion without any regrets.");
						player.hpMod(randomizer(10)+10);
					}
					else{
						story("You take the brand-new blade and drink the healing potion.");
						player.bladeMod(true);
						player.hpMod(randomizer(10)+10);
					}
					story("Not bad rewards for murder, right? You heartless monster, you.");
				}
				if(decision == 3){
					story("Finished with your business, you walk towards the exit.");
				
					story("SHOPKEEPER: Come again!");
				}
			}
		}
		else{
			story("With no intentions to give up your hard-earned coin, you continue down the treacherous path.");
		}
	}
	
	public static void eventMonster(){
	
		randomStory = randomizer(6);
		
		if(randomStory == 1){
			eventMonsterSpider();
		}
		else if(randomStory == 2){
			eventMonsterUndead();
		}
		else if(randomStory == 3){
			eventMonsterArmor();
		}
		else{
			eventMonsterSkeleton();
		}
	}
	
	public static void eventMonsterSpider(){

		MonsterBattle spider = new MonsterBattle(10, 3, 20, "CAVE SPIDER");
		
		story("As you travel through the dungeon, you encounter a large room.");
		
		story("...!");
		
		story("To your surprise, your face is met by the touch of a massive web!");
		
		story("You quickly struggle to get the web off...");
		
		story("Suddenly, you are met with glowing red eyes!");
		
		spider.battle();
		
		randomStory = randomizer(2);
		
		if(randomStory == 1){
		
			choiceText = "Another, larger spider crawls towards you! Will you LAST another fight or FLEE?";
			c1 = "last";
			c2 = "flee";
			decision = decisionProcess(c1,c2,choiceText);
			
			if(decision == 1){
		
				spider = new MonsterBattle(15, 3, 40, "GIANT SPIDER");	
				spider.battle();
				
				story("Having bested the eight-legged beasts, you victoriously tear though the dense webbing.");
				
				story("To your surprise, you spot a mysterious potion trapped in the webs!");
				
				choiceText = "Do you wish to DRINK it or LEAVE it be?";
				c1 = "drink";
				c2 = "leave";
				decision = decisionProcess(c1,c2,choiceText);
				
				if(decision == 1){
					randomStory = randomizer(2);	
					
					if(randomStory == 1){
						story("You down the entire bottle, and feel your various injuries quickly repairing themselves!");
						player.hpMod(randomizer(10) + 10);
					}
					else{
						story("You down the entire bottle... Ouch! You feel your insides burning up!");
						
						story("Maybe you shouldn't drink out of random bottles.");
						player.hpMod((randomizer(5) + 5) * -1);
					}
				}
				else{
					story("You ignore the unknown fluid and proceed out of the web-covered room.");
				}
			}
			else{
				story("You flee, hoping to find another route through the dungeon!");
			}
		}
		else{
			story("Shaken by the encounter, you proceed out of the web-covered room.");
		}
	}
	
	public static void eventMonsterUndead(){
	
		story("You pass upon the corpse of a fallen adventurer. You spot a coin purse and a crude-looking sword still grasped by his lifeless hand.");
	
		choiceText = "Do you wish to LOOT the corpse or RESPECT the dead man and leave his body alone?";
		c1 = "loot";
		c2 = "respect";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 1){
		
			MonsterBattle undead = new MonsterBattle(30, 8, 100, "UNDEAD ADVENTURER");
			
			if(player.getBlade() == false){
				story("Knowing that you need the blade more than he does, you reach down to take the weapon.");
			}
			else{
				story("Knowing that coin proves more useful to the living, you reach down for his coin purse.");
			}
			
			randomStory = randomizer(2);
			
			if(randomStory == 1){
				story("...!");
				
				story("You jump at the sight of the unliving adventurer rising up, ready to defend its peace!");
				
				undead.battle();
				
				if(player.getBlade() == false){
					story("You take the now-truly-dead adventurer's old blade.");
					player.bladeMod(true);
				}
				story("What a fight! You hope you find a way of healing yourself soon.");
			}
			else{
				if(player.getBlade() == false){
					player.bladeMod(true);
					story("Also knowing that coin proves more useful to the living, you reach down for his coin purse.");
				}
				randomMod = randomizer(90) + 10;
				story("You count " + randomMod * player.getGoldFind() + " pieces of gold!");
				player.goldMod(randomMod);
			}
		}
		else{
			story("You are better than this. Respecting the dead is far more important than loot... right?");
			player.willMod(1);
		}
	}
	
	public static void eventMonsterSkeleton(){

		MonsterBattle skeleton = new MonsterBattle(20, 7, 50, "SKELETON WARRIOR");
		
		story("You notice a strange shadow on the floor of the hallway. Something is there!");
		
		story("An armed, spooky, scary skeleton blocks your path!");
		
		story("It charges towards you, making rattling noises with every step!");
		
		skeleton.battle();
		
		story("You emerge triumphant over the pile of bones. Nothing can stop you... right?");
	}
	
	public static void eventMonsterArmor(){
	
		MonsterBattle armor = new MonsterBattle(50, 10, 500, "CURSED ARMOR");
		
		story("After walking for some time, you enter an elegantly built room - one fit for royalty.");
		
		story("The first thing you spot is a massive, golden chest behind an idle suit of armor.");
		
		story("You believe the gold chest cannot simply be for grabs.");
		
		choiceText = "Do you wish to APPROACH the golden chest or avoid it and CARRY on?";
		c1 = "approach";
		c2 = "carry";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 1){
			story("You cautiously approach the treasure, hoping nothing happens.");
			
			story("You open the chest, revealing piles over piles of gold!");
				
			story("To your actual surprise, the golden chest appears to be free of traps!");
			
			story("You pocket as much gold as humanly possible! You're rich!");
			
			player.goldMod(randomizer(1000));
			
			story("...!");
			
			story("Your euphoria is interrupted by a loud, metal, clanking noise.");
			
			story("Behind you - the suit of armor no longer remains idle, bearing a large mace!");
			
			armor.battle();
			
			story("The suit of armor, along with its massive weapon, crumbles into dust.");
			
			story("Incredible. You survived what seemed to be an impossible fight...");
			
			story("Gravely wounded, you rest for awhile in the room...");
			
			player.hpMod(randomizer(5) + 5);
			
			story("You wake up slightly rejuvenated with several of your injuries healed.");
			
			story("This room must be sacred, since you have recovered so quickly.");
			
			story("You get on your legs and leave bearing more teasure than you have imagined.");
		}
		else{
			story("Worried by a trap or curse tied with the treasure, you continue onward.");
			
			story("Survival over treasure seems the best strategy to you.");
		}
	}
	
	//Random Levels
	
	public static void level(){
	
		randomStory = randomizer(5);
		
		if(randomStory == 1){
			levelStranger();			
		}
		else if(randomStory == 2){
			//levelDarby();
		}
		else if(randomStory == 3){
			//levelBeth();
		}
		else if(randomStory == 4){
			//levelBen();
		}
		else{
			//levelMatt();
		}
	}
	
	public static void levelStranger(){
	
		choiceText = "After an hour of exploring in silence, you feel the need to take a BREAK from exploring. Or you could WALK further";
		c1 = "break";
		c2 = "walk";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 1){
			story("You reward yourself with hard-earned rest.");
			
			story("Exhausted from your efforts, you go into a deep sleep.");
		}
		else if(decision == 2){
			story("You resist the urge to nap and continue walking... drowsily...");
		}
		
		story("...");
		
		story("...");
		
		story("...");
		
		if(player.getBlade() == false){
			story("You awaken to the pressing of a sharp blade against your neck!");
		} 
		else{
			story("You awaken to the pressing of your own weapon against your neck!");
			player.bladeMod(false);
		}
		
		story("STRANGER: Don't move a muscle.");
		
		choiceText = "* WHAT do you want from me?\n* WHO are you?";
		c1 = "what";
		c2 = "who";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 1){
			
			story("STRANGER: We came here for the same reason. Gold. Hand it over or die.");
		}
		else if(decision == 2){
		
			story("STRANGER: My name is of no importance. What matters is that you hand over your treasures.");
			
			story("Otherwise, you will have neither your gold nor your life.");
		}
		
		story("You could SURRENDER your gold to the stranger, attempt to break free and FIGHT back.");
		
		choiceText = "Maybe you could attempt to talk it over and NEGOTIATE working together.";
		c1 = "surrender";
		c2 = "fight";
		c3 = "negotiate";
		decision = decisionProcess(c1,c2,c3,choiceText);
		
		if(decision ==  1){ //Surrender gold to stranger
		
			levelStrangerSurrender();	
		}
		else if(decision == 2){ //Fight back the stranger
			
			levelStrangerFight();
		}
		else if(decision == 3){ //Negotiate with the stranger
			
			story("You attempt to talk yourself out of the situation and into an alliance with the stranger.");
			
			story("STRANGER: So, you propose working together. What a fine idea.");
		
			story("STRANGER: However, I don't see how I could profit through such an arrangement.");
			
			choiceText = "There are two things left to do: either you could HAND over the gold or FIGHT back.";
			c1 = "surrender";
			c2 = "fight";
			decision = decisionProcess(c1,c2,choiceText);
			
			if(decision ==  1){ //Surrender gold to stranger
			
				levelStrangerSurrender();
			}
			else if(decision == 2){ //Fight back the stranger
			
				levelStrangerFight();
			}
		}	
	}
	
	public static void levelStrangerSurrender(){

		player.goldMod(player.getGold() * -1);
		
		story("You reluctantly empty your pockets of every last piece of gold.");
		
		story("STRANGER: You made the right decision. I said I would spare your life.");
		
		story("STRANGER: But not your thoughts.");
		
		story("Your head is met with the blow of the hilt of the thief's blade.");
		
		story("You fade into unconsciousness...");
		
		story("...");
		
		story("...");
	
		story("...");
		
		randomMod = randomizer(4) + 2;
		
		player.hpMod(randomMod * -1);
		
		story("You awaken, dazed, unsure of how long you were knocked out.");
		
		story("Your pockets remain empty. The encounter was no dream.");
		
		story("Despite the loss, you vigilantly get on your feet, ready for the next challenge.");	
	}
	
	public static void levelStrangerFight(){
	
		story("Confident in your own strength, you attempt to break free and turn the tables against the attacker.");
						
		randomStory = randomizer(5) + 4;
		
		story("You gather yourself and try your hardest to break free from the hold.");
			
		if(randomStory <= player.getStr()){
			
			story("In a flash, you drive his blade-arm away from you and knock him on the ground.");
			
			player.strMod(1);
			
			story("STRANGER: Ugh... You are a formidable one, adventurer. I do enjoy a challenge, however.");
			
			choiceText = "Your enemy has his back to the ground! You can either go for the BLADE or try to FINISH him off!";
			c1 = "blade";
			c2 = "finish";
			decision = decisionProcess(c1,c2,choiceText);
			
			if(decision == 1){
				
				story("Following your instinct, you sprint towards the shiny metal blade.");
				
				randomStory = randomizer(5) + 4;
				
				if(randomStory <= player.getStr()){
				
					story("The stranger springs up and runs for the weapon as well, but fails to beat you to it.");
				
					story("Seeing that you now wield the blade, he hurriedly takes off down the hallway.");
					
					player.bladeMod(true);
				}
				
				else if(randomStory > player.getStr()){
				
					story("However, the stranger springs up and beats you to the weapon.");
					
					story("You are unable to react quickly enough, and he cuts you down with a single blow!");
					
					story("Your killer greedily pockets all your hard-earned gold with no regrets of your expense.");
					
					player.gameOver();
				}
		 	}
			else if(decision == 2){
				
				story("Ignoring the shiny metal weapon, you forcefully pin the attacker against the ground.");
				
				story("You both exchange blows, leaving yourself with a bloody face and fists.");
				
				randomMod = randomizer(3) + 3;
				player.hpMod(randomMod * -1);
				
				story("However, you manage to finish off your adversary by breaking his neck!");
				
				
				story("Relieved that you survived the encounter, you take the dead stranger's gold and the weapon.");
				
				randomMod = randomizer(200) + 50;
				player.goldMod(randomMod);
				
				player.bladeMod(true);
				
				story("You brush the dust off your clothes with your hands and delve deeper into the dungeon's darkly-lit corridors.");
			}
		}
		else if(randomStory > player.getStr()){
			
			story("Unfortunately, your strength failed you and the stranger slices open your throat.");
			
			story("Your killer greedily pockets all your hard-earned gold with no regrets of your expense.");
			
			player.gameOver();
		}
	}
	
	public static void levelNightmare(){
	
		story("After hours of seemingly endless walking, you notice something unsettling.");
		
		story("The hallway becomes decreasingly lit and a strange, fleshy substance lines the cracks in the stone.");
	
		story("You walk upon a crooked, decaying sign, only barely able to read its crudely scribed letters.");
		
		story("A GrEaT PEril aWAitS YoU, ViSitOr, aND tHerE iS nO TuRniNg BaCk.");
		
		story("yOU HaVE wAlkEd BeyOnD thE POinT OF nO RetURn, OnLy tO bE ChAsEd bY A nIGhtmaRE.");
		
		story("ProCeED SWiFtlY, FOr hE AlReaDy kNowS yOuR PrEseNcE.");
		
		choiceText = "Worried from what you read, you have the urge to TURN back, but the sign says you can only go FORWARD.";
		c1 = "turn";
		c2 = "forward";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 1){
		
			story("Afraid of facing certain doom, you turn back and hope for a less threatening passage.");
			
			story("Strangely, the way back becomes increasingly darker. Something is different.");
			
			choiceText = "You don't know whether to WALK on, or turn back and FACE your fears.";
			c1 = "walk";
			c2 = "face";
			decision = decisionProcess(c1,c2,choiceText);
			
			if(decision == 1){
			
				story("You tell yourself to stop worrying and keep walking. It's all in your head, you tell yourself.");
		
				story("Suddenly, the ground is flooded with a cold, dark, ominous fog!");
				
				story("Fear and instinct take over you, and you take off running!");
				
				story("A massive arm emerges from the fog and quickly grabs you, pulling you into the shadows!");

				player.gameOver();
			}
			else if(decision == 2){
				
				story("You stop for a moment and gather yourself. The sign said not to turn back.");
				
				story("Ultimately, you decide to proceed back towards the creepy sign and past it.");
			}
		}
		
		story("You walk onwards, and the halls are no longer lit by dim, orange flames. Bright, green, seemingly cursed flames light the path.");
		
		story("Soon, you encounter a room containing three large, wooden doors.");
		
		story("...!");
		
		story("You hear a long, sustained moan, and you remember the 'nightmare' mentioned by the sign.");

		story("One of these doors must lead the way. If you are surely being followed, you have no choice but to pick one.");
		
		choiceText = "You must quickly decide - Which door should you enter? LEFT, CENTER, or RIGHT?";
		c1 = "left";
		c2 = "center";
		c3 = "right";
		decision = decisionProcess(c1,c2,c3,choiceText);
		
		if(decision == 1){
			story("You enter the left door, hoping you make it through alive.");
		}
		else if(decision == 2){
			story("You enter the center door, hoping you make it through alive.");
		}
		else{
			story("You enter the right door, hoping you make it through alive.");
		}
		
		randomStory = randomizer(3);
		
		if(randomStory == 1){
			story("...!");
			
			story("Before you have a chance to react, a massive shadowy arm grabs you and pulls you into a void of darkness!");
			
			story("You struggle helplessly against what now appears to be a massive, muscular, humanoid, black skinned demon!");
				
			story("It brings you closer to its head, which is covered in dozens of twisted, black tentacles.");
				
			if(player.getBlade() == true){
				story("Your arms are still free though! Without much hesitation, you draw your blade and stab its grasping hand!");
				
				if(player.getStr() <= randomizer(5) + 7){
					
					story("Pained, it drops you on the ominous, shadowed ground. Prepare for a battle!");
					
					MonsterBattle nightmare = new MonsterBattle(100, 15, 5000, "NIGHTMARE");
					
					nightmare.battle();
					
					story("The NIGHTMARE falls to its knees and fades from existence.");
					
					story("A portal of light appears before you.");
						
					story("Through a minute of pure blindness, you emerge in another dungeon hallway.");
						
					story("You have a feeling that your journey is almost over.");
					
					story("With that thought, you feel that nothing can stop you from succeeding.");
						
					player.willMod(1);
				}
				else{
					story("You lack the strength to inflict even the slightest wound on the enormous beast!");
					
					story("It stares at you with its yellow, glowing eyes, and you feel pure hatred flowing through your body.");
				
					story("A blanket of shadows consume you, making you forget about anything lawful or good.");
					
					story("You become one with the nightmare.");
					
					player.gameOver();
				}
			}
			else{	
				story("After a moment of staring at you with its yellow, glowing eyes, you feel pure hatred flowing through your body.");
				
				story("A blanket of shadows consume you, making you forget about anything lawful or good.");
				
				story("You become one with the nightmare.");
				
				player.gameOver();
			}
		}
		else{
			story("A blinding light pours out of the door... ");
			
			story("Behind you!");
			
			story("An immense, grotesque creature emerges from the hallway behind you!");
			
			story("You hastily run into the light and slam the door behind you shut.");
			
			story("Through a minute of pure blindness, you emerge in another dungeon hallway.");
				
			story("You have a feeling that your journey is almost over.");
			
			story("With that thought, you feel that nothing can stop you from succeeding.");
			
			player.willMod(1);
		}
	}
	
	public static void levelBlackJack(){
		
		story("After stepping into what appears to be a game room, door behind you closes shut.");
		
		story("In front of you is a dimly lit tabletop, and behind it sits a man.");
		
		story("You can't quite make out his features with the poor lighting.");
		
		story("THE DEALER: Welcome, sir. You may call me THE DEALER. May I offer you a wager you surely cannot refuse?");
		
		choiceText = "* Continue to LISTEN to the dealer.\n* QUESTION him about the wager.";
		c1 = "listen";
		c2 = "question";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 2){
			story("THE DEALER: Ah good sir, I am just getting to that.");
		}
		
		story("THE DEALER: As you see, I hold the key to your escape.");
		
		story("The man slowly holds out a rusty key with his gloved hand.");
		
		story("THE DEALER: Similarly, you hold the key to my own escape.");
		
		story("THE DEALER: I am a cursed man, cursed to forever be the dealer of this forsaken place.");
		
		story("THE DEALER: The only way to break my curse is to offer my position to another... willing.");
		
		choiceText = "THE DEALER: So what will it be, will you PLAY?\n* You also have the option to KILL the dealer for the key.";
		c1 = "play";
		c2 = "kill";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 2){
		
			if(player.getBlade() == true){
				story("You brandish your trusty blade and slowly approach the dealer.");
			}
			else{
				story("You crack your knuckles and slowly approach the dealer.");
			}
			
			choiceText = "THE DEALER: You have no power here, naive sir. Do you truly want to do this?\n* Sit down and PLAY the game.\n* FINISH the job.";
			c1 = "play";
			c2 = "finish";
			decision = decisionProcess(c1,c2,choiceText);
				
			if(decision == 1){
				story("Not willing to take the risk, you stand down.");
				
				story("THE DEALER: Smart move, sir. Hopefully it reflects in your card game.");
			}
			else{
				story("You call the dealer's bluff and charge at him!");
				
				if(player.getBlade() == true){
					story("Ready to obtain your prize, you drive your blade into his body...");
					
					story("Instantly, you feel a sharp drive of metal in your own gut!");
					
					story("You quickly bleed to death from your self-inflicted wound.");
					
					story("THE DEALER: Good night... sir.");
					
					player.gameOver();					
				}
				else{
					story("You crack your knuckles and slowly approach the dealer.");
					
					story("He only sits there as you press both you hands on the sides of his head.");
					
					story("With a sudden jerk, you twist his neck...");
					
					story("In a single motion your own neck breaks, instantly killing you!");
					
					story("THE DEALER: Good night... sir.");
					
					player.gameOver();	
				}
			}
		}
		
		story("You take a seat, and the dealer pulls out a deck of cards.");
		
		choiceText = "THE DEALER: The game for tonight is Blackjack! Do you know how to play?\n* YES.\n* NO.";
		c1 = "yes";
		c2 = "no";
		decision = decisionProcess(c1,c2,choiceText);
		
		if(decision == 1){
			story("Good. let us begin then.");
		}
		else{
			story("THE DEALER: The goal of blackjack is to beat the dealer's hand without going over 21.");
			
			story("THE DEALER: Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.");
			
			story("THE DEALER: With that being said, let us begin.");
		}
		
		story("First to three wins the wager!");
		
		int playerScore = 0;
		int dealerScore = 0;

		while(playerScore < 3 && dealerScore < 3){
			if(playerScore == 2 && dealerScore == 2){
				story("THE DEALER: The wager of a millennium! It all goes down to this game!");
			}
			BlackJack blackJackGame = new BlackJack();
			boolean playerWin = BlackJack.playRound();
			if(playerWin == true){
				playerScore = playerScore + 1;
				if(playerScore == 1 && dealerScore == 0){
					story("THE DEALER: Let's hope lady luck stays faithful to you. Again!");
				}
				else if(playerScore == 2){
					story("THE DEALER: Another win for you, good sir! Very good!");
				}
			}
			else{
				dealerScore = dealerScore + 1;
				if(dealerScore == 1){
					story("THE DEALER: Aha! This game belongs to me!");
				}
				else if(dealerScore == 2){
					story("THE DEALER: Another win for THE DEALER! I wish you the best of luck, sir.");
				}
			}
			story("SCORE:\nYou: " + playerScore + "\nTHE DEALER: " + dealerScore);
		}
		
		if(playerScore == 3){
			story("You won the wager!");
			
			player.cunMod(1);
			
			story("THE DEALER: Well, a wager's a wager, and my curse bounds me to my word.");
			
			story("The dealer places the key upon the table.");
			
			story("The exit is behind me. Good luck on your further adventures, sir.");
		}
		else{
			story("You lost the wager!");
			
			story("THE DEALER: Well, a wager's a wager, and my curse belongs to you now!");
			
			story("You suddenly lose consciousness, and your body becomes possessed of the dealer's curse!");
			
			story("No longer caring for gold and adventure, you take the dealer's seat.");
			
			story("EX-DEALER: I'm free! How long has it been...?");
			
			player.gameOver();
		}
	}
	
	public static void levelDoppelganger(){
		
		MonsterBattle doppelganger = new MonsterBattle(player.getHp(), player.getStr()+player.getWill()+player.getCun(), 5000, "ANTI-"+player.getName());
		
		if(player.getBlade() == true){
			doppelganger = new MonsterBattle(player.getHp(), (player.getStr()+player.getWill()+player.getCun())*2, 5000, "ANTI-"+player.getName());
		}
		
		story("Your feet land on an elaborately decorated floor with a vast image depicting a heroic figure.");
		
		story("The walls seem to reach for the open sky, and the room is surrounded by towering, heroic statues.");
		
		story("A bright light shines behind you, creating a vast shadow of yourself across the ornate floor.");
		
		story("Whoa... To your amazement, the shadow disconnects from you, sliding away from you.");
		
		story("...!");
		
		story("Your shadow begins to emerge from the ground!");
		
		story("It lunges at you! Defend yourself!");
	
		doppelganger.battle();
		
		story("You feel death's grip... Barely conscious, your body is lifted upwards.");
		
		story("With your head leaning on one side, you eye an incredible event: a new statue begins to construct itself.");
		
		story("A statue taking the shape of yourself.");
		
		story("What does this mean?");
		
		story("A blinding light covers your face, and you fade from consciousness.");
		
		story("...");
		
		story("...");
		
		story("...");
		
		story("You awaken on a grassy field and you see the wide, blue sky.");
		
		story("You live! Not only in one piece, but with all the valuable treasure you looted!.");
		
		story("The KEEPER approaches you slowly. A slight grin appears on his face.");
		
		story("KEEPER: You passed the class, "+player.getName()+".");
		
		story("He hands you a rolled up parchment.");
		
		story("KEEPER: This is your final grade. I hope you sign up for the second semester.");
		
		player.endGame();
	}		
	
	public static void story(String dialogue){
		JOptionPane.showMessageDialog(null, dialogue);
	}
	
	public static void fastStory(String dialogue){
		JOptionPane.showMessageDialog(null, dialogue);
	}
	
	public static int decisionProcess(String c1, String choiceText){
		int decision = 0;
		while(decision == 0){
			String response = JOptionPane.showInputDialog(choiceText);
			response = response.toLowerCase();
			if(response.equals(c1)){
				decision = 1;
			}
			if(decision == 0){
				JOptionPane.showMessageDialog(null, "Invalid command.");
			}
		}
		return decision;
	}
		
	public static int decisionProcess(String c1, String c2, String choiceText){
		int decision = 0;
		while(decision	 == 0){
			String response = JOptionPane.showInputDialog(choiceText);
			response = response.toLowerCase();
			if(response.equals(c1)){
				decision = 1;
			}
			if(response.equals(c2)){
				decision = 2;
			}
			if(decision == 0){
				JOptionPane.showMessageDialog(null, "Invalid command.");
			}
		}
		return decision;
	}
		
	public static int decisionProcess(String c1, String c2, String c3, String choiceText){
		int decision = 0;
		while(decision == 0){
			String response = JOptionPane.showInputDialog(choiceText);
			response = response.toLowerCase();
			if(response.equals(c1)){
				decision = 1;
			}
			if(response.equals(c2)){
				decision = 2;
			}	
			if(response.equals(c3)){
				decision = 3;
			}
			if(decision == 0){
				JOptionPane.showMessageDialog(null, "Invalid command.");
			}
		}
		return decision;
	}
	
	public static int randomizer(int range){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(range);
		randomInt = randomInt + 1;
		return randomInt;
	}

}