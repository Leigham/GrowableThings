package com.legalamb.GrowableThings.handler;

import com.ibm.icu.util.ULocale;
import com.legalamb.GrowableThings.reference.reference;
import com.legalamb.GrowableThings.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.RecipeSorter;

import java.io.File;
import java.util.Locale;

/**
 * Created by Lega on 24/11/2015.
 */
public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean Minecraft_Ores;

    public static void init(File configFile)
    {
        //Create the configuration object from the given configuration file
        if (configuration == null){
            configuration = new Configuration(configFile);
            LogHelper.info("Configuration file was created.");
            loadConfiguration();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.modID.equalsIgnoreCase(reference.MOD_ID)){

            loadConfiguration();
            LogHelper.info("Configuration settings were loaded.");

        }

    }

    private static void loadConfiguration(){
        Minecraft_Ores = configuration.getBoolean("Enable Default Minecraft Ore to be Grown","Vanilla Minecraft",true,"Enable Default Minecraft Ore to be Grown");

        if (configuration.hasChanged()){

            configuration.save();
            LogHelper.info("Configuration settings were saved.");

        }
    }
}
