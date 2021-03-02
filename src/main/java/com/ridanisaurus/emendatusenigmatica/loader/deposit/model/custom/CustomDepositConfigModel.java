package com.ridanisaurus.emendatusenigmatica.loader.deposit.model.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ridanisaurus.emendatusenigmatica.loader.deposit.model.common.CommonBlockDefinitionModel;

import java.util.List;

public class CustomDepositConfigModel {
    public static final Codec<CustomDepositConfigModel> CODEC = RecordCodecBuilder.create(x -> x.group(
            Codec.list(CommonBlockDefinitionModel.CODEC).fieldOf("blocks").forGetter(it -> it.blocks),
            Codec.list(Codec.STRING).fieldOf("fillerTypes").forGetter(it -> it.fillerTypes),
            Codec.INT.fieldOf("chance").forGetter(it -> it.chance),
            Codec.INT.fieldOf("density").forGetter(it -> it.density),
            Codec.INT.fieldOf("minYLevel").forGetter(it -> it.minYLevel),
            Codec.INT.fieldOf("maxYLevel").forGetter(it -> it.maxYLevel)
    ).apply(x, CustomDepositConfigModel::new));
    private final List<CommonBlockDefinitionModel> blocks;
    private List<String> fillerTypes;
    private final int chance;
    private final int density;
    private final int minYLevel;
    private final int maxYLevel;

    public CustomDepositConfigModel(List<CommonBlockDefinitionModel> blocks, List<String> fillerTypes, int chance, int density, int minYLevel, int maxYLevel) {

        this.blocks = blocks;
        this.chance = chance;
        this.density = density;
        this.minYLevel = minYLevel;
        this.maxYLevel = maxYLevel;
        this.fillerTypes = fillerTypes;
    }

    public int getChance() {
        return chance;
    }

    public int getDensity() {
        return density;
    }

    public int getMaxYLevel() {
        return maxYLevel;
    }

    public int getMinYLevel() {
        return minYLevel;
    }

    public List<CommonBlockDefinitionModel> getBlocks() {
        return blocks;
    }

    public List<String> getFillerTypes() {
        return fillerTypes;
    }
}