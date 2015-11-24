package com.legalamb.GrowableThings;


import com.legalamb.GrowableThings.proxy.IProxy;
import com.legalamb.GrowableThings.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import com.legalamb.GrowableThings.reference.reference;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.legalamb.GrowableThings.handler.ConfigurationHandler;


/**
 * Created by Lega on 23/11/2015.
 */
@Mod(modid = reference.MOD_ID, name = reference.MOD_NAME, version = reference.MOD_VERSION)

public class Growablethings
{
    @Mod.Instance(reference.MOD_ID)
    public static Growablethings instance;

    @SidedProxy(clientSide = reference.CLIENT_PROXY_CLASS,serverSide = reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        LogHelper.info ("Pre-Initialization Complete.");
    }
    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        LogHelper.info ("Initialization Complete.");
    }
    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
        if(ConfigurationHandler.Minecraft_Ores == true)
        {
            LogHelper.info("Configs Loaded");
        }
        LogHelper.info ("Post-Initialization Complete.");

    }

}
