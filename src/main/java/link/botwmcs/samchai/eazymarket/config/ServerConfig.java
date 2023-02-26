package link.botwmcs.samchai.eazymarket.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber
public class ServerConfig {
    public static void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CONFIG_SPEC);
    }
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final ServerConfig CONFIG;

    public final ForgeConfigSpec.BooleanValue enabled;

    public final ForgeConfigSpec.BooleanValue enable_offline_market;

    public final ForgeConfigSpec.BooleanValue enable_global_market;

    public final ForgeConfigSpec.BooleanValue enable_auction_market;

    public final ForgeConfigSpec.BooleanValue enable_stock_market;


    static {
        Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        CONFIG_SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    ServerConfig(ForgeConfigSpec.Builder builder) {
        builder.push("general");
        enabled = builder
                .comment("Enable EazyMarket")
                .define("enabled", true);
        builder.pop();

        builder.push("offline_market");
        enable_offline_market = builder
                .comment("Enable offline market")
                .define("enable_offline_market", true);
        builder.pop();

        builder.push("global_market");
        enable_global_market = builder
                .comment("Enable global market")
                .define("enable_global_market", true);
        builder.pop();

        builder.push("auction_market");
        enable_auction_market = builder
                .comment("Enable auction market")
                .define("enable_auction_market", true);
        builder.pop();

        builder.push("stock_market");
        enable_stock_market = builder
                .comment("Enable stock market")
                .define("enable_stock_market", true);
        builder.pop();
    }
}
