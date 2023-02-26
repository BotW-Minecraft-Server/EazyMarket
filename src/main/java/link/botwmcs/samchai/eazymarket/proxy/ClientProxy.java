package link.botwmcs.samchai.eazymarket.proxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public ClientProxy() {}

    @Override
    public void start() {
        super.start();
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
    }

}
