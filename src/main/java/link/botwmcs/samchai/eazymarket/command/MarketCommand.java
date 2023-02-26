package link.botwmcs.samchai.eazymarket.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class MarketCommand {
    public MarketCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        // Register a boolean argument to check that is a player or not
        Predicate<CommandSourceStack> isPlayer = commandSourceStack -> {
            try {
                commandSourceStack.getPlayerOrException();
                return true;
            } catch (CommandSyntaxException e) {
                return false;
            }
        };

        LiteralCommandNode<CommandSourceStack> register = dispatcher.register(Commands.literal("market")
                .requires(isPlayer)
                .then(Commands.literal("gui")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
//                            player.openMenu(new SimpleMenuProvider((id, inventory, playerEntity) -> new WalletMenu(id, inventory), player.getDisplayName()));
//                            NetworkHooks.openGui(player, new MenuProvider() {
//                                @Override
//                                public Component getDisplayName() {
//                                    return new TextComponent("text");
//                                }
//
//                                @Nullable
//                                @Override
//                                public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
//                                    return new WalletMenu(pContainerId, pPlayerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(player.blockPosition()));
//                                }
//                            });
//                            NetworkHooks.openGui(player, new SimpleMenuProvider((id, inventory, playerEntity) -> new WalletMenu(id, inventory), player.getDisplayName()));
                            return 1;
                        })
                )
        );

    }
}
