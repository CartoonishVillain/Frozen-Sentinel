package com.cartoonishvillain.frozensentinel.events;

import com.cartoonishvillain.frozensentinel.FrozenSentinel;
import com.cartoonishvillain.frozensentinel.Register;
import com.cartoonishvillain.frozensentinel.entity.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrozenSentinel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event){
        event.put(Register.LESSERBASESENTINEL.get(), LesserBasicSentinel.customAttributes().build());
        event.put(Register.LESSERSTABBERSENTINEL.get(), LesserStabberSentinel.customAttributes().build());
        event.put(Register.LESSERGUNNERSENTINEL.get(), LesserGunnerSentinel.customAttributes().build());
        event.put(Register.LESSERSNOWBALLERSENTINEL.get(), LesserSnowballerSentinel.customAttributes().build());
        event.put(Register.LESSERGIFTERSENTINEL.get(), LesserGifterSentinel.customAttributes().build());
        event.put(Register.LESSERZAPPERSENTINEL.get(), LesserZapperSentinel.customAttributes().build());
        event.put(Register.LESSERBRAWLERSENTINEL.get(), LesserBrawlerSentinel.customAttributes().build());
    }
}
