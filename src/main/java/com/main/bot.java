package com.main;

import com.discordcommand.botcommand;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class bot {
    public static String prefix = "~";
    public static void main(String[] args) throws Exception {
        JDABuilder jdab = JDABuilder.createDefault("").disableCache(CacheFlag.MEMBER_OVERRIDES,CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false)
                .setCompression(Compression.NONE).addEventListeners(new botcommand());
        jdab.build();
    }
}