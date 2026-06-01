package thvardhan.ytluckyblocks.functions;

import net.minecraft.util.text.*;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class TooltipRomanFix {

    @SubscribeEvent
    public static void onTooltipRender(ItemTooltipEvent event) {
        List<ITextComponent> tooltip = event.getToolTip();

        for (int i = 0; i < tooltip.size(); i++) {
            String text = tooltip.get(i).getString();

            if (text.contains("enchantment.level.")) {
                Matcher matcher = Pattern.compile("enchantment\\.level\\.(\\d+)").matcher(text);

                if (matcher.find()) {
                    int level = Integer.parseInt(matcher.group(1));

                    String fixedText = text.replace(matcher.group(), toRoman(level));

                    tooltip.set(i, new StringTextComponent(fixedText).mergeStyle(TextFormatting.GRAY));
                }
            }
        }
    }

    private static String toRoman(int number) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            while (number >= entry.getValue()) {
                number -= entry.getValue();
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }
}