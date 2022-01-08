package com.cartoonishvillain.frozensentinel;

import com.cartoonishvillain.frozensentinel.entity.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Register {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FrozenSentinel.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrozenSentinel.MOD_ID);

    public static void init() {
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> LESSERANIMATIONCORE = ITEMS.register("lesseranimationcore", () -> new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.lesseranimationcore").withStyle(ChatFormatting.BLUE)));
    public static final RegistryObject<Item> GUNNERTAG = ITEMS.register("gunnertag", () -> new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.gunnertag").withStyle(ChatFormatting.BLUE)));
    public static final RegistryObject<Item> STABBERTAG = ITEMS.register("stabbertag", () -> new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.stabbertag").withStyle(ChatFormatting.BLUE)));
    public static final RegistryObject<Item> SNOWBALLERTAG = ITEMS.register("snowballertag", () -> new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.snowballertag").withStyle(ChatFormatting.BLUE)));
    public static final RegistryObject<Item> GIFTERTAG = ITEMS.register("giftertag", () -> new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.giftertag").withStyle(ChatFormatting.BLUE)));
    public static final RegistryObject<Item> ZAPPERTAG = ITEMS.register("zappertag", () -> new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.zappertag").withStyle(ChatFormatting.BLUE)));
    public static final RegistryObject<Item> BRAWLERTAG = ITEMS.register("brawlertag", () -> new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.brawlertag").withStyle(ChatFormatting.BLUE)));



    public static final RegistryObject<EntityType<LesserBasicSentinel>> LESSERBASESENTINEL = ENTITY_TYPES.register("lesserbasicsentinel", () -> EntityType.Builder.of(LesserBasicSentinel::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(FrozenSentinel.MOD_ID, "lesserbasicsentinel").toString()));
    public static final RegistryObject<EntityType<LesserStabberSentinel>> LESSERSTABBERSENTINEL = ENTITY_TYPES.register("lesserstabbersentinel", () -> EntityType.Builder.of(LesserStabberSentinel::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(FrozenSentinel.MOD_ID, "lesserstabbersentinel").toString()));
    public static final RegistryObject<EntityType<LesserGunnerSentinel>> LESSERGUNNERSENTINEL = ENTITY_TYPES.register("lessergunnersentinel", () -> EntityType.Builder.of(LesserGunnerSentinel::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(FrozenSentinel.MOD_ID, "lessergunnersentinel").toString()));
    public static final RegistryObject<EntityType<LesserSnowballerSentinel>> LESSERSNOWBALLERSENTINEL = ENTITY_TYPES.register("lessersnowballersentinel", () -> EntityType.Builder.of(LesserSnowballerSentinel::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(FrozenSentinel.MOD_ID, "lessersnowballersentinel").toString()));
    public static final RegistryObject<EntityType<LesserGifterSentinel>> LESSERGIFTERSENTINEL = ENTITY_TYPES.register("lessergiftersentinel", () -> EntityType.Builder.of(LesserGifterSentinel::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(FrozenSentinel.MOD_ID, "lessergiftersentinel").toString()));
    public static final RegistryObject<EntityType<LesserZapperSentinel>> LESSERZAPPERSENTINEL = ENTITY_TYPES.register("lesserzappersentinel", () -> EntityType.Builder.of(LesserZapperSentinel::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(FrozenSentinel.MOD_ID, "lesserzappersentinel").toString()));
    public static final RegistryObject<EntityType<LesserBrawlerSentinel>> LESSERBRAWLERSENTINEL = ENTITY_TYPES.register("lesserbrawlersentinel", () -> EntityType.Builder.of(LesserBrawlerSentinel::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(FrozenSentinel.MOD_ID, "lesserbrawlersentinel").toString()));



}
