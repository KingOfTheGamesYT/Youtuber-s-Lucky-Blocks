package thvardhan.ytluckyblocks.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import thvardhan.ytluckyblocks.Main;

public enum ModArmorMaterial implements IArmorMaterial {

    YOUTUBE(Main.MODID + ":ytarmor", 100, new int[] { 4, 7, 5, 4}, 1,
             SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    DUCK(Main.MODID + ":duckarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    LEAH(Main.MODID + ":leaharmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    MAX(Main.MODID + ":maxarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    CASSIETHECAT(Main.MODID + ":cassiethecat", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    DONUT(Main.MODID + ":donutarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    EVILLITTLEKELLY(Main.MODID + ":evillittlekellyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    LITTLE_ALLY(Main.MODID + ":littleallyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    LITTLECARLY(Main.MODID + ":littlecarlyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    LITTLE_DONNY(Main.MODID + ":littledonnyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    LITTLEKELLY(Main.MODID + ":littlekellyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    LITTLE_LIZARDGAMING(Main.MODID + ":littlelizardgaming", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    MAX_THEMONKEY(Main.MODID + ":maxthemonkeyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    SHARK_Y(Main.MODID + ":sharkyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    TINY_TURTLE(Main.MODID + ":tinyturtulearmor", 80, new int[] { 4, 8, 6, 4}, 1,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),

    AP_HMAU(Main.MODID + ":aphmauarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    ROPO(Main.MODID + ":ropoarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    SCUBA(Main.MODID + ":scubaarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    CRAINER(Main.MODID + ":crainerarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    ANGEL(Main.MODID + ":angelarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    TNT(Main.MODID + ":tnt", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    LAC(Main.MODID + ":lac", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    MR(Main.MODID + ":mr", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    PETA(Main.MODID + ":peta", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    PINK(Main.MODID + ":pink", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    VIK(Main.MODID + ":vik", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    IHAS(Main.MODID + ":ihasarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    LD(Main.MODID + ":ldarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    PRESTON(Main.MODID + ":prestonarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    S(Main.MODID + ":sarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    STAMPY(Main.MODID + ":stampyarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F),
    THNX(Main.MODID + ":thnxarmor", 80, new int[] { 4, 8, 6, 4}, 1,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[]damageReductionArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;

ModArmorMaterial(String name, int maxDamageFactor, int[]damageReductionArray, int enchantability,
                 SoundEvent soundEvent, Float toughness) {
this.name = name;
this.maxDamageFactor = maxDamageFactor;
this.damageReductionArray = damageReductionArray;
this.enchantability = enchantability;
this.soundEvent = soundEvent;
this.toughness = toughness;
}

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return null;
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}