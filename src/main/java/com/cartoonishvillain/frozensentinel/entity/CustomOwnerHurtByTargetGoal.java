package com.cartoonishvillain.frozensentinel.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;

public class CustomOwnerHurtByTargetGoal extends OwnerHurtByTargetGoal {
    public CustomOwnerHurtByTargetGoal(TamableAnimal p_26107_) {
        super(p_26107_);
    }

    @Override
    public boolean canUse() {
        if(this.mob instanceof GenericSentinel && ((GenericSentinel) this.mob).getOwner() != null) {
            LivingEntity livingentity = ((GenericSentinel) this.mob).getOwner();
            this.ownerLastHurtBy = livingentity.getLastHurtByMob();
            boolean shouldAttack = (!((GenericSentinel) this.mob).isAttackingFriend(this.ownerLastHurtBy)) && this.ownerLastHurtBy != null;
            return shouldAttack;
        }
        return super.canUse();
    }
}
