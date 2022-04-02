package io.github.sefiraat.crystamaehistoria.player;

import io.github.sefiraat.crystamaehistoria.CrystamaeHistoria;
import io.github.sefiraat.crystamaehistoria.magic.SpellType;
import io.github.sefiraat.crystamaehistoria.stories.BlockDefinition;
import io.github.sefiraat.crystamaehistoria.utils.theme.ThemeType;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.text.MessageFormat;
import java.util.UUID;

public class PlayerStatistics {

    @ParametersAreNonnullByDefault
    public static void unlockSpell(Player player, SpellType spellType) {
        unlockSpell(player.getUniqueId(), spellType);
    }

    @ParametersAreNonnullByDefault
    public static void unlockSpell(UUID player, SpellType spellType) {
        String path = MessageFormat.format("{0}.{1}.{2}.UNLOCKED", player, StatType.SPELL, spellType.getId());
        CrystamaeHistoria.getConfigManager().getPlayerStats().set(path, true);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedSpell(Player player, SpellType spellType) {
        return hasUnlockedSpell(player.getUniqueId(), spellType);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedSpell(UUID player, SpellType spellType) {
        String path = MessageFormat.format("{0}.{1}.{2}.UNLOCKED", player, StatType.SPELL, spellType.getId());
        return CrystamaeHistoria.getConfigManager().getPlayerStats().getBoolean(path);
    }

    @ParametersAreNonnullByDefault
    public static void addUsage(Player player, SpellType spellType) {
        addUsage(player.getUniqueId(), spellType);
    }

    @ParametersAreNonnullByDefault
    public static void addUsage(UUID player, SpellType spellType) {
        int uses = getUsages(player, spellType);
        uses++;
        String path = MessageFormat.format("{0}.{1}.{2}.TIMES_CAST", player, StatType.SPELL, spellType.getId());
        CrystamaeHistoria.getConfigManager().getPlayerStats().set(path, uses);
    }

    @ParametersAreNonnullByDefault
    public static int getUsages(UUID player, SpellType spellType) {
        String path = MessageFormat.format("{0}.{1}.{2}.TIMES_CAST", player, StatType.SPELL, spellType.getId());
        return CrystamaeHistoria.getConfigManager().getPlayerStats().getInt(path);
    }

    @ParametersAreNonnullByDefault
    public static int getUsages(Player player, SpellType spellType) {
        return getUsages(player.getUniqueId(), spellType);
    }

    @ParametersAreNonnullByDefault
    public static void unlockUniqueStory(Player player, BlockDefinition definition) {
        unlockUniqueStory(player.getUniqueId(), definition);
    }

    @ParametersAreNonnullByDefault
    public static void unlockUniqueStory(UUID player, BlockDefinition definition) {
        String path = MessageFormat.format("{0}.{1}.{2}.UNLOCKED", player, StatType.STORY, definition.getMaterial());
        CrystamaeHistoria.getConfigManager().getPlayerStats().set(path, true);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedUniqueStory(Player player, BlockDefinition definition) {
        return hasUnlockedUniqueStory(player.getUniqueId(), definition);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedUniqueStory(UUID player, BlockDefinition definition) {
        return hasUnlockedUniqueStory(player, definition.getMaterial());
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedUniqueStory(UUID player, Material material) {
        String path = MessageFormat.format("{0}.{1}.{2}.UNLOCKED", player, StatType.STORY, material);
        return CrystamaeHistoria.getConfigManager().getPlayerStats().getBoolean(path);
    }

    @ParametersAreNonnullByDefault
    public static void unlockStoryGilded(UUID player, BlockDefinition definition) {
        String path = MessageFormat.format("{0}.{1}.{2}.GILDED", player, StatType.STORY, definition.getMaterial());
        CrystamaeHistoria.getConfigManager().getPlayerStats().set(path, true);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedStoryGilded(Player player, BlockDefinition definition) {
        return hasUnlockedStoryGilded(player.getUniqueId(), definition);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedStoryGilded(UUID player, BlockDefinition definition) {
        return hasUnlockedStoryGilded(player, definition.getMaterial());
    }

    @ParametersAreNonnullByDefault
    public static boolean hasUnlockedStoryGilded(UUID player, Material material) {
        String path = MessageFormat.format("{0}.{1}.{2}.GILDED", player, StatType.STORY, material);
        return CrystamaeHistoria.getConfigManager().getPlayerStats().getBoolean(path);
    }

    @ParametersAreNonnullByDefault
    public static void addChronicle(Player player, BlockDefinition definition) {
        addChronicle(player.getUniqueId(), definition);
    }

    @ParametersAreNonnullByDefault
    public static void addChronicle(UUID player, BlockDefinition definition) {
        int uses = getChronicle(player, definition);
        uses++;
        String path = MessageFormat.format("{0}.{1}.{2}.TIMES_CHRONICLED", player, StatType.STORY, definition.getMaterial());
        CrystamaeHistoria.getConfigManager().getPlayerStats().set(path, uses);
    }

    @ParametersAreNonnullByDefault
    public static int getChronicle(UUID player, BlockDefinition definition) {
        String path = MessageFormat.format("{0}.{1}.{2}.TIMES_CHRONICLED", player, StatType.STORY, definition.getMaterial());
        return CrystamaeHistoria.getConfigManager().getPlayerStats().getInt(path);
    }

    @ParametersAreNonnullByDefault
    public static int getChronicle(Player player, BlockDefinition definition) {
        return getChronicle(player.getUniqueId(), definition);
    }

    @ParametersAreNonnullByDefault
    public static void addRealisation(Player player, BlockDefinition definition) {
        addChronicle(player.getUniqueId(), definition);
    }

    @ParametersAreNonnullByDefault
    public static void addRealisation(UUID player, BlockDefinition definition) {
        int uses = getRealisation(player, definition);
        uses++;
        String path = MessageFormat.format("{0}.{1}.{2}.TIMES_REALISED", player, StatType.STORY, definition.getMaterial());
        CrystamaeHistoria.getConfigManager().getPlayerStats().set(path, uses);
    }

    @ParametersAreNonnullByDefault
    public static int getRealisation(UUID player, BlockDefinition definition) {
        String path = MessageFormat.format("{0}.{1}.{2}.TIMES_REALISED", player, StatType.STORY, definition.getMaterial());
        return CrystamaeHistoria.getConfigManager().getPlayerStats().getInt(path);
    }

    @ParametersAreNonnullByDefault
    public static int getRealisation(Player player, BlockDefinition definition) {
        return getChronicle(player.getUniqueId(), definition);
    }

    @ParametersAreNonnullByDefault
    public static BlockRank getBlockRank(UUID uuid, BlockDefinition definition) {
        final int chronicleAmount = Math.min(getChronicle(uuid, definition), 100);
        final int realisedAmount = Math.min(getRealisation(uuid, definition), 100);
        final int blockValue = (chronicleAmount + realisedAmount) / 2;
        return BlockRank.getByAmount(blockValue);
    }

    @ParametersAreNonnullByDefault
    public static StoryRank getStoryRank(UUID uuid) {
        int total = CrystamaeHistoria.getStoriesManager().getBlockDefinitionMap().size();
        final int unlocked = getStoriesUnlocked(uuid);
        return StoryRank.getByPercent(((double) unlocked / total) * 100);
    }

    @ParametersAreNonnullByDefault
    public static int getStoriesUnlocked(UUID uuid) {
        String path = MessageFormat.format("{0}.{1}", uuid, StatType.STORY);
        ConfigurationSection section = CrystamaeHistoria.getConfigManager().getPlayerStats().getConfigurationSection(path);
        if (section == null) {
            return 0;
        }
        int unlocked = 0;
        for (String story : section.getKeys(false)) {
            String storyPath = MessageFormat.format("{0}.{1}.{2}.UNLOCKED", uuid, StatType.STORY, story);
            if (CrystamaeHistoria.getConfigManager().getPlayerStats().getBoolean(storyPath)) unlocked++;
        }
        return unlocked;
    }

    @ParametersAreNonnullByDefault
    public static String getStoryRankString(UUID uuid) {
        int total = CrystamaeHistoria.getStoriesManager().getBlockDefinitionMap().size();
        int unlocked = getStoriesUnlocked(uuid);
        StoryRank storyRank = StoryRank.getByPercent(((double) unlocked / total) * 100);
        return MessageFormat.format(
            "{0}Chronicler Rank: {1}{2}{0} ({3}/{4})",
            ThemeType.PASSIVE.getColor(),
            storyRank.getTheme().getColor(),
            storyRank.getTheme().getLoreLine(),
            unlocked,
            total
        );
    }

    @ParametersAreNonnullByDefault
    public static SpellRank getSpellRank(UUID uuid) {
        int total = SpellType.getEnabledSpells().length;
        int unlocked = getSpellsUnlocked(uuid);
        return SpellRank.getByPercent(((double) unlocked / total) * 100);
    }

    @ParametersAreNonnullByDefault
    public static int getSpellsUnlocked(UUID uuid) {
        String path = MessageFormat.format("{0}.{1}", uuid, StatType.SPELL);
        ConfigurationSection section = CrystamaeHistoria.getConfigManager().getPlayerStats().getConfigurationSection(path);
        if (section == null) {
            return 0;
        }
        int unlocked = 0;
        for (String spell : section.getKeys(false)) {
            String storyPath = MessageFormat.format("{0}.{1}.{2}.UNLOCKED", uuid, StatType.SPELL, spell);
            if (CrystamaeHistoria.getConfigManager().getPlayerStats().getBoolean(storyPath)) unlocked++;
        }
        return unlocked;
    }

    @ParametersAreNonnullByDefault
    public static String getSpellRankString(UUID uuid) {
        int total = SpellType.getEnabledSpells().length;
        int unlocked = getSpellsUnlocked(uuid);
        SpellRank spellRank = SpellRank.getByPercent(((double) unlocked / total) * 100);
        return MessageFormat.format(
            "{0}Crystamae Rank: {1}{2}{0} ({3}/{4})",
            ThemeType.PASSIVE.getColor(),
            spellRank.getTheme().getColor(),
            spellRank.getTheme().getLoreLine(),
            unlocked,
            total
        );
    }

    @ParametersAreNonnullByDefault
    public static GildingRank getGildingRank(UUID uuid) {
        int total = CrystamaeHistoria.getStoriesManager().getBlockDefinitionMap().size();
        final int unlocked = getBlocksGilded(uuid);
        return GildingRank.getByPercent(((double) unlocked / total) * 100);
    }

    @ParametersAreNonnullByDefault
    public static int getBlocksGilded(UUID uuid) {
        String path = MessageFormat.format("{0}.{1}", uuid, StatType.STORY);
        ConfigurationSection section = CrystamaeHistoria.getConfigManager().getPlayerStats().getConfigurationSection(path);
        if (section == null) {
            return 0;
        }
        int unlocked = 0;
        for (String story : section.getKeys(false)) {
            String storyPath = MessageFormat.format("{0}.{1}.{2}.GILDED", uuid, StatType.STORY, story);
            if (CrystamaeHistoria.getConfigManager().getPlayerStats().getBoolean(storyPath)) unlocked++;
        }
        return unlocked;
    }

    @ParametersAreNonnullByDefault
    public static String getGildingRankString(UUID uuid) {
        int total = CrystamaeHistoria.getStoriesManager().getBlockDefinitionMap().size();
        int unlocked = getBlocksGilded(uuid);
        GildingRank gildingRank = GildingRank.getByPercent(((double) unlocked / total) * 100);
        return MessageFormat.format(
            "{0}Gilding Rank: {1}{2}{0} ({3}/{4})",
            ThemeType.PASSIVE.getColor(),
            gildingRank.getTheme().getColor(),
            gildingRank.getTheme().getLoreLine(),
            unlocked,
            total
        );
    }

    enum StatType {
        SPELL,
        STORY
    }
}

