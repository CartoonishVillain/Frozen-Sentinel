package com.cartoonishvillain.frozensentinel.events;


import com.cartoonishvillain.frozensentinel.FrozenSentinel;
import com.cartoonishvillain.frozensentinel.Register;
import com.cartoonishvillain.frozensentinel.entity.LesserBasicSentinel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrozenSentinel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeBusEvents {

    @SubscribeEvent
    public static void attachCore(PlayerInteractEvent.EntityInteract event) {
        //Not client side, and a snow golem is being interacted with, and this is the main hand, and the item is a lesser animation core...
        if(!event.getWorld().isClientSide && event.getTarget().getType().equals(EntityType.SNOW_GOLEM) && event.getHand() == InteractionHand.MAIN_HAND && event.getItemStack().getItem().equals(Register.LESSERANIMATIONCORE.get())){
            LesserBasicSentinel lesserBasicSentinel = new LesserBasicSentinel(Register.LESSERBASESENTINEL.get(), event.getWorld());
            lesserBasicSentinel.setPos(event.getTarget().getX(), event.getTarget().getY(), event.getTarget().getZ());
            lesserBasicSentinel.tame(event.getPlayer());
            event.getTarget().remove(Entity.RemovalReason.DISCARDED);
            event.getWorld().addFreshEntity(lesserBasicSentinel);
            BlockPos pos = lesserBasicSentinel.getOnPos();
            ServerLevel level = (ServerLevel) event.getWorld();
            for (int iterator = 0; iterator < 6; iterator++){
                if(iterator % 2 == 0) {level.sendParticles(ParticleTypes.SNOWFLAKE, pos.getX() + event.getWorld().getRandom().nextDouble(), pos.getY() + event.getWorld().getRandom().nextDouble() + 2, pos.getZ() + event.getWorld().getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);}
                else {level.sendParticles(ParticleTypes.HEART, pos.getX() + event.getWorld().getRandom().nextDouble(), pos.getY() + event.getWorld().getRandom().nextDouble(), pos.getZ() + event.getWorld().getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);}
            }
            event.getWorld().playSound(null, pos, SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.NEUTRAL, 0.5f, 0.5f);
            event.getItemStack().shrink(1);
        }
    }
}
