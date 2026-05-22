package thvardhan.ytluckyblocks.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import thvardhan.ytluckyblocks.functions.ExtraFunctions;


public class EntityLuckyMob extends MonsterEntity {

    boolean alwaysRenderNameTag = true;
    private String name = "Lucky Monster";

    public EntityLuckyMob(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.setCustomName(new StringTextComponent(name));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        // Movement / behavior goals
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(9, new LookRandomlyGoal(this));

        // Target goals — these belong in targetSelector, not goalSelector
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 50D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 80.0D);
    }
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld inWorld, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT dataTag) {
        return super.onInitialSpawn(inWorld, difficulty, reason, livingdata, dataTag);
    }

    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return true;
    }

    @Override
    protected void dropSpecialItems(DamageSource damageSource, int looting, boolean recentlyHit) {
        super.dropSpecialItems(damageSource, looting, recentlyHit);

        // Your custom drop
        ItemStack stack = new ItemStack(ExtraFunctions.randomBlock());

        this.entityDropItem(stack, 0.0F);
    }
}