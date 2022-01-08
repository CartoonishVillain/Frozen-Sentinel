package com.cartoonishvillain.frozensentinel.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;

public class CustomOwnerHurtTargetGoal extends OwnerHurtTargetGoal {
    public CustomOwnerHurtTargetGoal(TamableAnimal p_26114_) {
        super(p_26114_);
    }

    @Override
    public boolean canUse() {
        if(this.mob instanceof GenericSentinel && ((GenericSentinel) this.mob).getOwner() != null) {
            LivingEntity livingentity = ((GenericSentinel) this.mob).getOwner();
            this.ownerLastHurt = livingentity.getLastHurtMob();
            boolean shouldAttack = (!((GenericSentinel) this.mob).isAttackingFriend(this.ownerLastHurt)) && this.ownerLastHurt != null;
            return shouldAttack;
        }

        return super.canUse();
    }
}
