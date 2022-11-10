package gregofnothing.common.Items;

import com.google.common.base.CaseFormat;
import gregtech.api.items.materialitem.MetaPrefixItem;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.ore.OrePrefix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class OrePrefixItem extends MetaPrefixItem {

    public static final OrePrefix pebble;
    public static final OrePrefix worm;
    //public static final OrePrefix bacterial;
    //public static final OrePrefix bark;
    //public static final OrePrefix crystal;
    //public static final OrePrefix condensation;


    private static final List<Material> rocks = new ArrayList<Material>() {
        {
            this.add(Materials.Stone);
            this.add(Materials.Endstone);
            this.add(Materials.Andesite);
            this.add(Materials.Diorite);
            this.add(Materials.Granite);
            this.add(Materials.Basalt);
            this.add(Materials.Marble);
            this.add(Materials.GraniteRed);
            this.add(Materials.GraniteBlack);
        }
    };

    static {
        pebble = new OrePrefix(
                "pebble",
                OrePrefix.chunk.getMaterialAmount(null),
                null,
                PrefixIconTypes.pebble,
                1L,
                Conditions.isRock);
        worm = new OrePrefix(
                "worm",
                907200L,
                null,
                PrefixIconTypes.worm,
                1L,
                null
        );

    }

    public OrePrefixItem(OrePrefix orePrefix) {
        super(orePrefix);
    }

    public static void init() {
        reg(pebble);
    }

    private static void reg(OrePrefix prefix) {
        String regName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, prefix.name());
        MetaPrefixItem metaOrePrefix = new OrePrefixItem(prefix);
        metaOrePrefix.setRegistryName(String.format("meta_%s", regName));
    }

    public static class PrefixIconTypes {
        public static final MaterialIconType pebble =
                new MaterialIconType("pebble");
        public static final MaterialIconType worm =
                new MaterialIconType("worm");
    }

    public static class Conditions {
        public static final Predicate<Material> isRock = (mat) -> {
            for (Material m : rocks) {
                if (mat == m) return true;
                else continue; // troll
            }
            return false;
        };
    }
}
