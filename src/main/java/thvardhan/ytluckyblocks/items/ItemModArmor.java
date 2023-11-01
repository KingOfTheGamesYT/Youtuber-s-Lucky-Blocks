package thvardhan.ytluckyblocks.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemGroup;


public class ItemModArmor extends ArmorItem {

    public ItemModArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {

        super(materialIn, slot, new Properties().group(ItemGroup.COMBAT));
    }


}