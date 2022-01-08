package com.cartoonishvillain.frozensentinel.entity;

import com.cartoonishvillain.frozensentinel.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class GenericSentinel extends TamableAnimal {

    protected GenericSentinel(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Monster.class, false));
    }

    @Override
    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_) {
        if(!isTame()) {
            tame(p_27584_);
            p_27584_.sendMessage(new TextComponent("I am tamed now."), p_27584_.getUUID());
        }

        return super.mobInteract(p_27584_, p_27585_);
    }

    public LivingEntity getZapTarget(){
        return null;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    public void transferData(GenericSentinel newSentinel, String name, float health, Vec3 position, Player player){
        if(!this.level.isClientSide) {
            if(!name.equals("")) {
                newSentinel.setCustomName(new TextComponent(name));
            }
            newSentinel.setHealth(health);
            newSentinel.setPos(position.x(), position.y(), position.z());
            newSentinel.tame(player);
            this.remove(Entity.RemovalReason.DISCARDED);
            this.level.addFreshEntity(newSentinel);
            BlockPos pos = newSentinel.getOnPos();
            ServerLevel level = (ServerLevel) this.level;
            for (int iterator = 0; iterator < 6; iterator++) {
                if (iterator % 2 == 0) {
                    level.sendParticles(ParticleTypes.ENCHANT, pos.getX() + level.getRandom().nextDouble(), pos.getY() + level.getRandom().nextDouble() + 2, pos.getZ() + level.getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);
                } else {
                    level.sendParticles(ParticleTypes.HAPPY_VILLAGER, pos.getX() + level.getRandom().nextDouble(), pos.getY() + level.getRandom().nextDouble(), pos.getZ() + level.getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);
                }
            }
            level.playSound(null, newSentinel, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1.5f, 0.75f);
        }
    }

    public Vec3 getRealPos(GenericSentinel sentinel) {
        return new Vec3(sentinel.getX(), sentinel.getY(), sentinel.getZ());
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return SoundEvents.SNOW_GOLEM_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNOW_GOLEM_DEATH;
    }
}
