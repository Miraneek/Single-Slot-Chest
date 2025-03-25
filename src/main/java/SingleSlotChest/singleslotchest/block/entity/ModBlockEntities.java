package SingleSlotChest.singleslotchest.block.entity;

import SingleSlotChest.singleslotchest.Singleslotchest;
import SingleSlotChest.singleslotchest.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Singleslotchest.MODID);

    public static final RegistryObject<BlockEntityType<SingleSlotChestEntity>> SINGLE_SLOT_CHEST =
            BLOCK_ENTITIES.register("single_slot_chest",
                    () -> BlockEntityType.Builder.of(SingleSlotChestEntity::new,
                            ModBlocks.SINGLE_SLOT_CHEST.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
