package thvardhan.ytluckyblocks.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

import net.minecraft.util.text.ITextComponent;

import thvardhan.ytluckyblocks.Main;
import thvardhan.ytluckyblocks.entity.EntityGhost;

public class EntityGhostRender extends BipedRenderer<EntityGhost, BipedModel<EntityGhost>> {
    protected ResourceLocation texture = new ResourceLocation(Main.MODID + ":textures/entity/ghost_skin.png");

    public EntityGhostRender(EntityRendererManager renderManager) {
        super(renderManager, new BipedModel<>(0.0F), 0.5F);
    }

    @Override
    protected void renderName(EntityGhost entity, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        double yHeightCorrection = -0.1D;  // Adjust this value as needed to bring the nameplate down.

        matrixStackIn.push();  // Push the current transformation to the stack
        matrixStackIn.translate(0.0D, yHeightCorrection, 0.0D);  // Apply the translation

        super.renderName(entity, displayNameIn, matrixStackIn, bufferIn, packedLightIn);

        matrixStackIn.pop();  // Pop the last transformation off the stack to revert the change
    }

    @Override
    public void render(EntityGhost entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(1.5F, 1.0F, 1.5F);
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pop();
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getEntityTexture(EntityGhost entity) {
        return texture;
    }
}
