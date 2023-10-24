package thvardhan.ytluckyblocks.entity.render;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import thvardhan.ytluckyblocks.Main;
import thvardhan.ytluckyblocks.entity.EntityLittleCarlyMC;
import thvardhan.ytluckyblocks.entity.EntityLittleKellyMC;

public class EntityLittleKellyMCRender extends BipedRenderer<EntityLittleKellyMC, BipedModel<EntityLittleKellyMC>> {
    protected ResourceLocation texture = new ResourceLocation(Main.MODID + ":textures/entity/little_kelly.png");

    public EntityLittleKellyMCRender(EntityRendererManager renderManager) {
        super(renderManager, new BipedModel<>(0.0F), 0.5F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getEntityTexture(EntityLittleKellyMC entity) {
        return texture;
    }
}