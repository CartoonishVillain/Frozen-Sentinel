package com.cartoonishvillain.frozensentinel.entity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;

public class LesserBasicSentinel extends GenericSentinel implements RangedAttackMob {

    public LesserBasicSentinel(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new RangedAttackGoal(this, 1.25D, 20, 10.0F));


    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.125D)
                .add(Attributes.ATTACK_DAMAGE, 2D);
    }


    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        Snowball snowballentity = new Snowball(this.level, this);
        double d0 = target.getEyeY() - (double)1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - snowballentity.getY();
        double d3 = target.getZ() - this.getZ();
        float f = Mth.sqrt((float) (d1 * d1 + d3 * d3)) * 0.2F;
        snowballentity.setOwner(this);
        snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 8.0F);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(snowballentity);
    }
}
