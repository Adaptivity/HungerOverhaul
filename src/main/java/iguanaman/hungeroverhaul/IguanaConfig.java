package iguanaman.hungeroverhaul;

import java.io.File;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class IguanaConfig {

	// seeds + hoes
	public static boolean allSeedsEqual;
	public static boolean removeTallGrassSeeds;
	public static boolean modifyHoeUse;
	public static boolean removeHoeRecipes;
	public static int hoeToolDamageMultiplier;
	public static int seedChance;

	// delays
	public static int noSunlightRegrowthMultiplier;
	public static int wrongBiomeRegrowthMultiplier;
	public static int wrongBiomeRegrowthMultiplierSugarcane;
	public static int flowerRegrowthMultiplier;
	public static int cropRegrowthMultiplier;
	public static int cactusRegrowthMultiplier;
	public static int cocoaRegrowthMultiplier;
	public static int sugarcaneRegrowthMultiplier;
	public static int treeCropRegrowthMultiplier;
	public static int saplingRegrowthMultiplier;
	public static int dryingRackTimeMultiplier;
	public static int eggTimeoutMultiplier;
	public static int breedingTimeoutMultiplier;
	public static int childDurationMultiplier;
	public static int milkedTimeout;

	// crop drops
	public static int seedsPerHarvestMin;
	public static int seedsPerHarvestMax;
	public static int producePerHarvestMin;
	public static int producePerHarvestMax;

	// village field
	public static boolean addCustomVillageField;
	public static int fieldNormalWeight;
	public static int fieldReedWeight;
	public static int fieldStemWeight;

	// difficulty scaling
	public static boolean difficultyScaling;
	public static boolean difficultyScalingBoneMeal;
	public static boolean difficultyScalingEffects;
	public static boolean difficultyScalingHealing;
	public static boolean difficultyScalingHunger;
	public static boolean difficultyScalingRespawnHunger;
	public static boolean difficultyScalingSleepHungerLoss;

	// food
	public static boolean modifyFoodValues;
	public static boolean addFoodTooltips;
	public static boolean modifyFoodStackSize;
	public static boolean modifyFoodEatingSpeed;
	public static int foodStackSizeMultiplier;
	public static int modFoodValueDivider;
	public static boolean addWellFedEffect;

	// Rotting
	public static boolean addFoodRotting;
	public static int foodRotSpeed;

	// harvestcraft integration
	public static boolean addTradesButcher;
	public static boolean addTradesFarmer;
	public static boolean addHarvestCraftChestLoot;
	public static int chestLootChance;

	// hunger
	public static boolean addSleepHungerLoss;
	public static boolean addSetHungerCommand;
	public static boolean constantHungerLoss;
	public static int damageOnStarve;
	public static int respawnHungerValue;
	public static int respawnHungerDifficultyModifier;
	public static boolean disableHealingHungerDrain;
	public static int hungerLossRatePercentage;

	// low stat
	public static boolean addGuiText;
	public static boolean addLowStatEffects;
	public static boolean addLowStatNausea;
	public static boolean addLowStatSlowness;
	public static boolean addLowStatWeakness;
	public static boolean addLowStatMiningSlowdown;

	// health
	public static int minHungerToHeal;
	public static boolean foodRegensHealth;
	public static int foodHealDivider;
	public static int healthRegenRatePercentage;
	public static int lowHealthRegenRateModifier;

	// potion ids
	public static int wellFedId;


	public static void init(File file) {

		Configuration config = new Configuration(file);
		config.load();

		// seeds and hoes

		Property allSeedsEqualProperty = config.get("getting seeds", "allSeedsEqual", true);
		allSeedsEqualProperty.comment = "Each seed has an equal chance to drop (grass drops and via hoes)";
		allSeedsEqual = allSeedsEqualProperty.getBoolean(true);

		Property removeHoeRecipesProperty = config.get("getting seeds", "removeHoeRecipes", true);
		removeHoeRecipesProperty.comment = "Whether wood and stone hoe recipes are removed";
		removeHoeRecipes = removeHoeRecipesProperty.getBoolean(true);

		Property modifyHoeUseProperty = config.get("getting seeds", "modifyHoeUse", true);
		modifyHoeUseProperty.comment = "Changes the use of hoes depending on the availability of water";
		modifyHoeUse = modifyHoeUseProperty.getBoolean(true);

		Property removeTallGrassSeedsProperty = config.get("getting seeds", "removeTallGrassSeeds", true);
		removeTallGrassSeedsProperty.comment = "Removes seed drops when breaking tall grass";
		removeTallGrassSeeds = removeTallGrassSeedsProperty.getBoolean(true);

		Property seedChanceProperty = config.get("getting seeds", "seedChance", 20);
		seedChanceProperty.comment = "Chance for seed to drop from hoe use on normal difficulty";
		seedChance = Math.max(seedChanceProperty.getInt(20), 1);
		seedChanceProperty.set(seedChance);

		Property hoeToolDamageMultiplierProperty = config.get("getting seeds", "hoeToolDamageMultiplier", 5);
		hoeToolDamageMultiplierProperty.comment = "Multiplier on tool damage taken when a hoe is used";
		hoeToolDamageMultiplier = Math.max(hoeToolDamageMultiplierProperty.getInt(5), 1);
		hoeToolDamageMultiplierProperty.set(hoeToolDamageMultiplier);

		// delays
		config.getCategory("delays");

		Property noSunlightRegrowthMultiplierProperty = config.get("delays", "noSunlightRegrowthMultiplier", 2);
		noSunlightRegrowthMultiplierProperty.comment = "Multipier on crop growth time without sunlight (1 to disable feature, 0 to make crops only grow in sunlight)";
		noSunlightRegrowthMultiplier = Math.max(noSunlightRegrowthMultiplierProperty.getInt(2), 0);
		noSunlightRegrowthMultiplierProperty.set(noSunlightRegrowthMultiplier);

		Property wrongBiomeRegrowthMultiplierProperty = config.get("delays", "wrongBiomeRegrowthMultiplier", 2);
		wrongBiomeRegrowthMultiplierProperty.comment = "Multipier on crop growth time (except sugarcane) in the wrong biome (1 to disable feature, 0 to make crops only grow in correct biome)";
		wrongBiomeRegrowthMultiplier = Math.max(wrongBiomeRegrowthMultiplierProperty.getInt(2), 0);
		wrongBiomeRegrowthMultiplierProperty.set(wrongBiomeRegrowthMultiplier);

		Property wrongBiomeRegrowthMultiplierSugarcaneProperty = config.get("delays", "wrongBiomeRegrowthMultiplierSugarcane", 2);
		wrongBiomeRegrowthMultiplierSugarcaneProperty.comment = "Multipier on sugarcane growth time in the wrong biome (1 to disable feature, 0 to make sugarcane only grow in correct biome)";
		wrongBiomeRegrowthMultiplierSugarcane = Math.max(wrongBiomeRegrowthMultiplierSugarcaneProperty.getInt(2), 0);
		wrongBiomeRegrowthMultiplierSugarcaneProperty.set(wrongBiomeRegrowthMultiplierSugarcane);

		Property flowerRegrowthMultiplierProperty = config.get("delays", "flowerRegrowthMultiplier", 1);
		flowerRegrowthMultiplierProperty.comment = "Multiplier on the time it takes a WeeeFlower crop to grow";
		flowerRegrowthMultiplier = Math.max(flowerRegrowthMultiplierProperty.getInt(1), 1);
		flowerRegrowthMultiplierProperty.set(flowerRegrowthMultiplier);

		Property cropRegrowthMultiplierProperty = config.get("delays", "cropRegrowthMultiplier", 4);
		cropRegrowthMultiplierProperty.comment = "Multiplier on the time it takes a non-tree crop to grow";
		cropRegrowthMultiplier = Math.max(cropRegrowthMultiplierProperty.getInt(4), 1);
		cropRegrowthMultiplierProperty.set(cropRegrowthMultiplier);

		Property sugarcaneRegrowthMultiplierProperty = config.get("delays", "sugarcaneRegrowthMultiplier", 4);
		sugarcaneRegrowthMultiplierProperty.comment = "Multiplier on the time it takes sugarcane to grow";
		sugarcaneRegrowthMultiplier = Math.max(sugarcaneRegrowthMultiplierProperty.getInt(4), 1);
		sugarcaneRegrowthMultiplierProperty.set(sugarcaneRegrowthMultiplier);

		Property cactusRegrowthMultiplierProperty = config.get("delays", "cactusRegrowthMultiplier", 4);
		cactusRegrowthMultiplierProperty.comment = "Multiplier on the time it takes cactus to grow (Only applies when Natura is present)";
		cactusRegrowthMultiplier = Math.max(cactusRegrowthMultiplierProperty.getInt(4), 1);
		cactusRegrowthMultiplierProperty.set(cactusRegrowthMultiplier);

		Property cocoaRegrowthMultiplierProperty = config.get("delays", "cocoaRegrowthMultiplier", 4);
		cocoaRegrowthMultiplierProperty.comment = "Multiplier on the time it takes cocoa to grow";
		cocoaRegrowthMultiplier = Math.max(cocoaRegrowthMultiplierProperty.getInt(4), 1);
		cocoaRegrowthMultiplierProperty.set(cocoaRegrowthMultiplier);

		Property treeCropRegrowthMultiplierProperty = config.get("delays", "treeCropRegrowthMultiplier", 4);
		treeCropRegrowthMultiplierProperty.comment = "Multiplier on the time it takes a tree crop to grow";
		treeCropRegrowthMultiplier = Math.max(treeCropRegrowthMultiplierProperty.getInt(4), 1);
		treeCropRegrowthMultiplierProperty.set(treeCropRegrowthMultiplier);

		Property saplingRegrowthMultiplierProperty = config.get("delays", "saplingRegrowthMultiplier", 4);
		saplingRegrowthMultiplierProperty.comment = "Multiplier on the time it takes a sapling to grow into a tree";
		saplingRegrowthMultiplier = Math.max(saplingRegrowthMultiplierProperty.getInt(4), 1);
		saplingRegrowthMultiplierProperty.set(saplingRegrowthMultiplier);

		Property dryingRackTimeMultiplierProperty = config.get("delays", "dryingRackTimeMultiplier", 4);
		dryingRackTimeMultiplierProperty.comment = "Multiplier on the time it takes cocoa to grow";
		dryingRackTimeMultiplier = Math.max(dryingRackTimeMultiplierProperty.getInt(4), 1);
		dryingRackTimeMultiplierProperty.set(dryingRackTimeMultiplier);

		Property eggTimeoutMultiplierProperty = config.get("delays", "eggTimeoutMultiplier", 4);
		eggTimeoutMultiplierProperty.comment = "Multiplier applied to the delay between chicken egg laying";
		eggTimeoutMultiplier = Math.max(eggTimeoutMultiplierProperty.getInt(4), 1);
		eggTimeoutMultiplierProperty.set(eggTimeoutMultiplier);

		Property breedingTimeoutMultiplierProperty = config.get("delays", "breedingTimeoutMultiplier", 4);
		breedingTimeoutMultiplierProperty.comment = "Multiplier applied to the delay between breeding entities";
		breedingTimeoutMultiplier = Math.max(breedingTimeoutMultiplierProperty.getInt(4), 1);
		breedingTimeoutMultiplierProperty.set(breedingTimeoutMultiplier);

		Property childDurationMultiplierProperty = config.get("delays", "childDurationMultiplier", 4);
		childDurationMultiplierProperty.comment = "Multiplier applied to the delay before children become adults";
		childDurationMultiplier = Math.max(childDurationMultiplierProperty.getInt(4), 1);
		childDurationMultiplierProperty.set(childDurationMultiplier);

		Property milkedTimeoutProperty = config.get("delays", "milkedTimeout", 20);
		milkedTimeoutProperty.comment = "Delay (in minutes) after milking a cow before it can be milked again";
		milkedTimeout = Math.max(milkedTimeoutProperty.getInt(20), 0);
		milkedTimeoutProperty.set(milkedTimeout);


		// harvesting
		config.getCategory("harvesting");

		Property seedsPerHarvestMinProperty = config.get("harvesting", "seedsPerHarvestMin", 0);
		seedsPerHarvestMinProperty.comment = "Minimum number of seeds you get when harvesting a non-tree crop";
		seedsPerHarvestMin = Math.max(seedsPerHarvestMinProperty.getInt(0), 0);
		seedsPerHarvestMinProperty.set(seedsPerHarvestMin);

		Property seedsPerHarvestMaxProperty = config.get("harvesting", "seedsPerHarvestMax", 0);
		seedsPerHarvestMaxProperty.comment = "Maximum number of seeds you get when harvesting a non-tree crop";
		seedsPerHarvestMax = Math.max(seedsPerHarvestMaxProperty.getInt(0), seedsPerHarvestMin);
		seedsPerHarvestMaxProperty.set(seedsPerHarvestMax);

		Property producePerHarvestMinProperty = config.get("harvesting", "producePerHarvestMin", 2);
		producePerHarvestMinProperty.comment = "Minimum number of produce you get when harvesting a non-tree crop";
		producePerHarvestMin = Math.max(producePerHarvestMinProperty.getInt(2), 0);
		producePerHarvestMinProperty.set(producePerHarvestMin);

		Property producePerHarvestMaxProperty = config.get("harvesting", "producePerHarvestMax", 4);
		producePerHarvestMaxProperty.comment = "Maximum number of produce you get when harvesting a non-tree crop";
		producePerHarvestMax = Math.max(producePerHarvestMaxProperty.getInt(4), producePerHarvestMin);
		producePerHarvestMaxProperty.set(producePerHarvestMax);

		// custom field
		config.getCategory("custom field");

		Property addCustomVillageFieldProperty = config.get("custom field", "addCustomVillageField", true);
		addCustomVillageFieldProperty.comment = "Adds a custom field to villages (possibly causes crashes, use at own risk)";
		addCustomVillageField = addCustomVillageFieldProperty.getBoolean(true);

		Property fieldNormalWeightProperty = config.get("custom field", "fieldNormalWeight", 70);
		fieldNormalWeightProperty.comment = "Weighted chance for custom field to contain 'normal' crops";
		fieldNormalWeight = Math.max(fieldNormalWeightProperty.getInt(70), 0);
		fieldNormalWeightProperty.set(fieldNormalWeight);

		Property fieldReedWeightProperty = config.get("custom field", "fieldReedWeight", 10);
		fieldReedWeightProperty.comment = "Weighted chance for custom field to contain reeds";
		fieldReedWeight = Math.max(fieldReedWeightProperty.getInt(10), 0);
		fieldReedWeightProperty.set(fieldReedWeight);

		Property fieldStemWeightProperty = config.get("custom field", "fieldStemWeight", 10);
		fieldStemWeightProperty.comment = "Weighted chance for custom field to contain pumpkins/melons";
		fieldStemWeight = Math.max(fieldStemWeightProperty.getInt(10), 0);
		fieldStemWeightProperty.set(fieldStemWeight);

		// difficulty scaling
		config.getCategory("difficulty scaling");

		Property difficultyScalingProperty = config.get("difficulty scaling", "difficultyScaling", true);
		difficultyScalingProperty.comment = "Enable/Disable all difficulty scaling effect in one setting";
		difficultyScaling = difficultyScalingProperty.getBoolean(true);

		Property difficultyScalingBoneMealProperty = config.get("difficulty scaling", "difficultyScalingBoneMeal", true);
		difficultyScalingBoneMealProperty.comment = "Effects of bone meal dependant of difficulty ('difficultyScaling' must be true)";
		difficultyScalingBoneMeal = difficultyScalingBoneMealProperty.getBoolean(true);

		Property difficultyScalingSleepHungerLossProperty = config.get("difficulty scaling", "difficultyScalingSleepHungerLoss", true);
		difficultyScalingSleepHungerLossProperty.comment = "Hunger loss while sleeping depends on difficulty ('addSleepHungerLoss' and 'difficultyScaling' must be true)";
		difficultyScalingSleepHungerLoss = difficultyScalingSleepHungerLossProperty.getBoolean(true);

		Property difficultyScalingEffectsProperty = config.get("difficulty scaling", "difficultyScalingEffects", true);
		difficultyScalingEffectsProperty.comment = "Negative effects on low health/hunger scale by difficulty ('difficultyScaling' must be true)";
		difficultyScalingEffects = difficultyScalingEffectsProperty.getBoolean(true);

		Property difficultyScalingHealingProperty = config.get("difficulty scaling", "difficultyScalingHealing", true);
		difficultyScalingHealingProperty.comment = "Healing rate scales by difficulty ('difficultyScaling' must be true)";
		difficultyScalingHealing = difficultyScalingHealingProperty.getBoolean(true);

		Property difficultyScalingHungerProperty = config.get("difficulty scaling", "difficultyScalingHunger", true);
		difficultyScalingHungerProperty.comment = "Hunger loss rate scales by difficulty ('difficultyScaling' must be true)";
		difficultyScalingHunger = difficultyScalingHungerProperty.getBoolean(true);

		Property difficultyScalingRespawnHungerProperty = config.get("difficulty scaling", "difficultyScalingRespawnHunger", true);
		difficultyScalingRespawnHungerProperty.comment = "Hunger value after respawn is affected by difficulty ('difficultyScaling' must be true)";
		difficultyScalingRespawnHunger = difficultyScalingRespawnHungerProperty.getBoolean(true);

		// Food
		config.getCategory("food");

		Property modifyFoodValuesProperty = config.get("food", "modifyFoodValues", true);
		modifyFoodValuesProperty.comment = "Changes the replenishment value of vanilla and HarvestCraft foods";
		modifyFoodValues = modifyFoodValuesProperty.getBoolean(true);

		Property addFoodTooltipsProperty = config.get("food", "addFoodTooltips", true);
		addFoodTooltipsProperty.comment = "Add tooltips to food items showing hints at food value";
		addFoodTooltips = addFoodTooltipsProperty.getBoolean(true);

		Property modifyFoodEatingSpeedProperty = config.get("food", "modifyFoodEatingSpeed", true);
		modifyFoodEatingSpeedProperty.comment = "Changes the eating animation speed to be dependant on the food's replenishment value";
		modifyFoodEatingSpeed = modifyFoodEatingSpeedProperty.getBoolean(true);

		Property modifyFoodStackSizeProperty = config.get("food", "modifyFoodStackSize", true);
		modifyFoodStackSizeProperty.comment = "Changes the stack size of food to be dependant on the food's replenishment value";
		modifyFoodStackSize = modifyFoodStackSizeProperty.getBoolean(true);

		Property foodStackSizeMultiplierProperty = config.get("food", "foodStackSizeMultiplier", 1);
		foodStackSizeMultiplierProperty.comment = "Multiplier on the stack size of food ('modifyFoodStackSize' must be true)";
		foodStackSizeMultiplier = Math.max(foodStackSizeMultiplierProperty.getInt(1), 1);
		foodStackSizeMultiplierProperty.set(foodStackSizeMultiplier);

		Property modFoodValueDividerProperty = config.get("food", "modFoodValueDivider", 4);
		modFoodValueDividerProperty.comment = "Other mod's food replenishment values are divided by this ('modifyFoodValues' must be true)";
		modFoodValueDivider = Math.max(modFoodValueDividerProperty.getInt(4), 1);
		modFoodValueDividerProperty.set(modFoodValueDivider);

		Property addWellFedEffectProperty = config.get("food", "addWellFedEffect", true);
		addWellFedEffectProperty.comment = "Adds a 'well fed' effect that gives slight health regen";
		addWellFedEffect = addWellFedEffectProperty.getBoolean(true);

		config.getCategory("rotting");

		Property addFoodRottingProperty = config.get("rotting", "addFoodRotting", false);
		addFoodRottingProperty.comment = "Turning on causes food to spoil over time (currently buggy)";
		addFoodRotting = addFoodRottingProperty.getBoolean(false);

		Property foodRotSpeedProperty = config.get("rotting", "foodRotSpeed", 100);
		foodRotSpeedProperty.comment = "Rate at which food rots (in ticks)";
		foodRotSpeed = Math.max(foodRotSpeedProperty.getInt(100), 1);
		foodRotSpeedProperty.set(foodRotSpeed);

		// HarvestCraft
		config.getCategory("harvestcraft");

		Property addTradesButcherProperty = config.get("harvestcraft", "addTradesButcher", true);
		addTradesButcherProperty.comment = "Add high tier HarvestCraft foods to the items butcher villagers will sell (HarvestCraft)";
		addTradesButcher = addTradesButcherProperty.getBoolean(true);

		Property addTradesFarmerProperty = config.get("harvestcraft", "addTradesFarmer", true);
		addTradesFarmerProperty.comment = "Add HarvestCraft crop produce to the items farmer villagers will buy (HarvestCraft)";
		addTradesFarmer = addTradesFarmerProperty.getBoolean(true);

		Property addHarvestCraftChestLootProperty = config.get("harvestcraft", "addHarvestCraftChestLoot", true);
		addHarvestCraftChestLootProperty.comment = "HarvestCraft items added to dungeon/temple chests (Harvestcraft)";
		addHarvestCraftChestLoot = addHarvestCraftChestLootProperty.getBoolean(true);

		Property chestLootChanceProperty = config.get("harvestcraft", "chestLootChance", 5);
		chestLootChanceProperty.comment = "Weighted chance for food to be found in chests (addHarvestCraftChestLoot must be true)";
		chestLootChance = Math.max(chestLootChanceProperty.getInt(5), 1);
		chestLootChanceProperty.set(chestLootChance);

		// Hunger
		config.getCategory("hunger");

		Property addSleepHungerLossProperty = config.get("hunger", "addSleepHungerLoss", false);
		addSleepHungerLossProperty.comment = "Enable/disable hunger loss while sleeping";
		addSleepHungerLoss = addSleepHungerLossProperty.getBoolean(false);

		Property addSetHungerCommandProperty = config.get("hunger", "addSetHungerCommand", true);
		addSetHungerCommandProperty.comment = "Adds a console command to allow OPs to set a player's hunger level";
		addSetHungerCommand = addSetHungerCommandProperty.getBoolean(true);

		Property constantHungerLossProperty = config.get("hunger", "constantHungerLoss", true);
		constantHungerLossProperty.comment = "You lose hunger (very slowly) at all times";
		constantHungerLoss = constantHungerLossProperty.getBoolean(true);

		Property damageOnStarveProperty = config.get("hunger", "damageOnStarve", 200);
		damageOnStarveProperty.comment = "Amount of damage you take when hunger hits zero (vanilla default 2)";
		damageOnStarve = Math.max(damageOnStarveProperty.getInt(200), 1);
		damageOnStarveProperty.set(damageOnStarve);

		Property respawnHungerValueProperty = config.get("hunger", "respawnHungerValue", 20);
		respawnHungerValueProperty.comment = "hunger value set after respawning for peaceful/easy difficulty (vanilla default is 20)";
		respawnHungerValue = Math.max(respawnHungerValueProperty.getInt(20), 0);
		respawnHungerValueProperty.set(respawnHungerValue);

		Property respawnHungerDifficultyModifierProperty = config.get("hunger", "respawnHungerDifficultyModifier", 4);
		respawnHungerDifficultyModifierProperty.comment = "The amount difficulty modifies the hunger value set after respawning  ('difficultyScaling' and 'difficultyScalingRespawnHunger' must be true)";
		respawnHungerDifficultyModifier = Math.max(respawnHungerDifficultyModifierProperty.getInt(4), 0);
		respawnHungerDifficultyModifierProperty.set(respawnHungerDifficultyModifier);

		Property disableHealingHungerDrainProperty = config.get("hunger", "disableHealingHungerDrain", true);
		disableHealingHungerDrainProperty.comment = "Disable the hunger drain when healing that was introduced in vanilla 1.6.2";
		disableHealingHungerDrain = disableHealingHungerDrainProperty.getBoolean(true);

		Property hungerLossRatePercentageProperty = config.get("hunger", "hungerLossRatePercentage", 100);
		hungerLossRatePercentageProperty.comment = "Speed up or slow down the rate that hunger drops (set to 0 to disable hunger loss)";
		hungerLossRatePercentage = Math.max(hungerLossRatePercentageProperty.getInt(100), 0);
		hungerLossRatePercentageProperty.set(hungerLossRatePercentage);

		// low stats
		config.getCategory("low stats");

		Property addGuiTextProperty = config.get("low stats", "addGuiText", true);
		addGuiTextProperty.comment = "Shows onscreen text when hunger/health is low";
		addGuiText = addGuiTextProperty.getBoolean(true);

		Property addLowStatEffectsProperty = config.get("low stats", "addLowStatEffects", true);
		addLowStatEffectsProperty.comment = "Enables/disables all low hunger/health effects";
		addLowStatEffects = addLowStatEffectsProperty.getBoolean(true);

		Property addLowStatNauseaProperty = config.get("low stats", "addLowStatNausea", true);
		addLowStatNauseaProperty.comment = "Nausea effect when hunger is really low ('addLowStatEffects' must be true)";
		addLowStatNausea = addLowStatNauseaProperty.getBoolean(true);

		Property addLowStatSlownessProperty = config.get("low stats", "addLowStatSlowness", true);
		addLowStatSlownessProperty.comment = "Slowness effect when health/hunger is low ('addLowStatEffects' must be true)";
		addLowStatSlowness = addLowStatSlownessProperty.getBoolean(true);

		Property addLowStatWeaknessProperty = config.get("low stats", "addLowStatWeakness", true);
		addLowStatWeaknessProperty.comment = "Weakness effect when health/hunger is low ('addLowStatEffects' must be true)";
		addLowStatWeakness = addLowStatWeaknessProperty.getBoolean(true);

		Property addLowStatMiningSlowdownProperty = config.get("low stats", "addLowStatMiningSlowdown", true);
		addLowStatMiningSlowdownProperty.comment = "Mining slowdown effect when health/hunger is low ('addLowStatEffects' must be true)";
		addLowStatMiningSlowdown = addLowStatMiningSlowdownProperty.getBoolean(true);

		// potion ids
		ConfigCategory modifiersCategory = config.getCategory("potion ids");
		modifiersCategory.setComment("Here you can change various multipiers and cutoff values");

		Property wellFedIdProperty = config.get("potion ids", "wellFedID", 30);
		wellFedIdProperty.comment = "Potion ID for the 'Well Fed' effect (maximum 31)";
		wellFedId = wellFedIdProperty.getInt(30);

		config.getCategory("health");

		Property foodRegensHealthProperty = config.get("health", "foodRegensHealth", false);
		foodRegensHealthProperty.comment = "Eating food regenerates health";
		foodRegensHealth = foodRegensHealthProperty.getBoolean(false);

		Property minHungerToHealProperty = config.get("health", "minHungerToHeal", 7);
		minHungerToHealProperty.comment = "Minimum hunger level before healing starts (vanilla default is 18)";
		minHungerToHeal = Math.max(minHungerToHealProperty.getInt(7), 0);
		minHungerToHealProperty.set(minHungerToHeal);

		Property healthRegenRatePercentageProperty = config.get("health", "healthRegenRatePercentage", 100);
		healthRegenRatePercentageProperty.comment = "Speed up or slow down the rate that health regenerates (0 to disable regen)";
		healthRegenRatePercentage = Math.max(healthRegenRatePercentageProperty.getInt(100), 0);
		healthRegenRatePercentageProperty.set(healthRegenRatePercentage);

		Property lowHealthRegenRateModifierProperty = config.get("health", "lowHealthRegenRateModifier", 5);
		lowHealthRegenRateModifierProperty.comment = "The lower your health the longer it takes to regen, modify the effect here (lower = less effect)";
		lowHealthRegenRateModifier = Math.max(lowHealthRegenRateModifierProperty.getInt(5), 0);
		lowHealthRegenRateModifierProperty.set(lowHealthRegenRateModifier);

		Property foodHealDividerProperty = config.get("health", "foodHealDivider", 4);
		foodHealDividerProperty.comment = "Amount of health food restores is the food value divided by this number (foodRegensHealth must be true)";
		foodHealDivider = Math.max(foodHealDividerProperty.getInt(4), 0);
		foodHealDividerProperty.set(foodHealDivider);

		if(config.hasChanged())
			config.save();
	}

}
