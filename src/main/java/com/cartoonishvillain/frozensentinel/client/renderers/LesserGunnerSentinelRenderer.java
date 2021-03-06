package com.cartoonishvillain.frozensentinel.client.renderers;

import com.cartoonishvillain.coldsnaphorde.client.RenderManager;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapGunnerModel;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.basemob.ColdSnapGunner;
import com.cartoonishvillain.frozensentinel.client.layers.LesserGunnerSentinelLayer;
import com.cartoonishvillain.frozensentinel.entity.LesserGunnerSentinel;
import com.cartoonishvillain.frozensentinel.entity.LesserStabberSentinel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LesserGunnerSentinelRenderer extends MobRenderer<LesserGunnerSentinel, ColdSnapGunnerModel<LesserGunnerSentinel>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("coldsnaphorde", "textures/entity/coldsnapgunner.png");


    public LesserGunnerSentinelRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapGunnerModel<LesserGunnerSentinel>(p_174304_.bakeLayer(RenderManager.COLDSNAPGUNNER)), 0.5F);
        this.addLayer(new LesserGunnerSentinelLayer(this));
    }



    @Override
    public ResourceLocation getTextureLocation(LesserGunnerSentinel p_114482_) {
        return TEXTURE;
    }
}
