package thvardhan.ytluckyblocks.entity.render;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import thvardhan.ytluckyblocks.Main;
import thvardhan.ytluckyblocks.entity.EntityAlexirCraft;
import thvardhan.ytluckyblocks.entity.EntityPrestonPlayz;

public class EntityPrestonRender extends BipedRenderer<EntityPrestonPlayz, BipedModel<EntityPrestonPlayz>> {
    protected ResourceLocation texture = new ResourceLocation(Main.MODID + ":textures/entity/preston_skin.png");

    public EntityPrestonRender(EntityRendererManager renderManager) {
        super(renderManager, new BipedModel<>(0.0F), 0.5F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getEntityTexture(EntityPrestonPlayz entity) {
        return texture;
    }
}
