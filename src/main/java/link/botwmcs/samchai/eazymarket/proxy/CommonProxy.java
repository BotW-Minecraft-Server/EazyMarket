package link.botwmcs.samchai.eazymarket.proxy;

import link.botwmcs.samchai.eazymarket.EazyMarket;
import link.botwmcs.samchai.eazymarket.command.MarketCommand;
import link.botwmcs.samchai.eazymarket.config.ServerConfig;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = EazyMarket.MODID)
public class CommonProxy {

    public CommonProxy() {}

    public void start() {
        EazyMarket.LOGGER.info("CommonProxy start");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        registerListeners(bus);
        ServerConfig.init();

    }

    public void registerListeners(IEventBus bus) {
    }

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        new MarketCommand(event.getDispatcher());
    }



}
