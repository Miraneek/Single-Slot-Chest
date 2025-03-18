package SingleSlotChest.singleslotchest.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SingleSlotChestEntity extends BlockEntity implements MenuProvider {

    // Define the item handler for the chest
    private final ItemStackHandler itemHandler = new ItemStackHandler(1);

    // Lazy optional for the item handler capability
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    // Constructor for the block entity
    public SingleSlotChestEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // Implement capability handling for item handling
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    // Initialize the lazy optional when the block entity loads
    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    // Invalidate the capability when the block entity is removed
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    // Provide a display name for the chest (optional)
    @Override
    public Component getDisplayName() {
        return Component.literal("Single Slot Chest"); // Example display name
    }

    // Create a menu for the chest (optional)
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        // Example menu creation (you need to implement your own menu class)
        // return new SingleSlotChestMenu(id, playerInventory, this);
        return null;
    }
}
