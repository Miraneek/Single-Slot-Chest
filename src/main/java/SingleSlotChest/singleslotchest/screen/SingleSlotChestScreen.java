package SingleSlotChest.singleslotchest.screen;

import SingleSlotChest.singleslotchest.Singleslotchest;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SingleSlotChestScreen extends AbstractContainerScreen<SingleSlotChestMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Singleslotchest.MODID, "textures/gui/single_slot_chest_gui.png");

    public SingleSlotChestScreen(SingleSlotChestMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 176;  // or your custom width
        this.imageHeight = 166; // or your custom height
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // Let GuiGraphics handle the texture binding
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
} 