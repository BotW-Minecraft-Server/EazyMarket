package link.botwmcs.samchai.eazymarket.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import link.botwmcs.samchai.eazymarket.EazyMarket;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = EazyMarket.MODID, value = Dist.CLIENT)
public class WalletButtonAdder {
    private static final ResourceLocation ICONS = new ResourceLocation(EazyMarket.MODID, "textures/gui/icons.png");

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void initGUI(final ScreenEvent.InitScreenEvent.Post event) {
        Screen screen = event.getScreen();
        if (screen instanceof InventoryScreen) {
            AbstractContainerScreen<?> containerScreen = (AbstractContainerScreen<?>) screen;
            event.addListener(new DynamicButton(containerScreen,
                    containerScreen.getGuiLeft() + 126,
                    containerScreen.height / 2 - 22, 20, 18, 0, 0, 19, ICONS,
                    (pButton -> {
                        // Button pressed code here

                    })
            ));
        }
    }

    public static class DynamicButton extends ImageButton {
        private final AbstractContainerScreen<?> containerScreen;
        public DynamicButton(AbstractContainerScreen<?> screen, int x, int y, int width, int height, int xTextStart, int yTextStart, int yDiffText, ResourceLocation resourceLocation, OnPress onPress) {
            super(x, y, width, height, xTextStart, yTextStart, yDiffText, resourceLocation, onPress);
            containerScreen = screen;
        }

        @Override
        public void renderButton(@Nonnull PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
            x = containerScreen.getGuiLeft() + 126;
            y = containerScreen.getGuiTop() - 22 + 83;
            super.renderButton(poseStack, mouseX, mouseY, partialTicks);
        }

    }

}
