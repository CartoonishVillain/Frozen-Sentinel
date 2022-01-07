package com.cartoonishvillain.frozensentinel.client;

import com.cartoonishvillain.frozensentinel.FrozenSentinel;
import com.cartoonishvillain.frozensentinel.Register;
import com.cartoonishvillain.frozensentinel.client.renderers.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrozenSentinel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(Register.LESSERBASESENTINEL.get(), LesserBasicSentinelRenderer::new);
        event.registerEntityRenderer(Register.LESSERSTABBERSENTINEL.get(), LesserStabberSentinelRenderer::new);
        event.registerEntityRenderer(Register.LESSERGUNNERSENTINEL.get(), LesserGunnerSentinelRenderer::new);
        event.registerEntityRenderer(Register.LESSERSNOWBALLERSENTINEL.get(), LesserSnowballerSentinelRenderer::new);
        event.registerEntityRenderer(Register.LESSERGIFTERSENTINEL.get(), LesserGifterSentinelRenderer::new);
        event.registerEntityRenderer(Register.LESSERZAPPERSENTINEL.get(), LesserZapperSentinelRenderer::new);
        event.registerEntityRenderer(Register.LESSERBRAWLERSENTINEL.get(), LesserBrawlerSentinelRenderer::new);
    }
}
