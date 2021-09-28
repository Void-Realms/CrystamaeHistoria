package io.github.sefiraat.crystamaehistoria.resource;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import org.bukkit.inventory.ItemStack;

public enum Skulls {

    CRYSTAL_COMMON_MECHANICAL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2RkNzIxZDk0NWE3ZjY2OTBkMDI5NjVhOGEyNDhlMmU5YjdhYTMyZjYyYWFmMWZmNWNmYjhlZmY1MGE3YjkzZCJ9fX0=");

    private final String base64Code;

    Skulls(String base64Code) {
        this.base64Code = base64Code;
    }

    public ItemStack getPlayerHead() {
        return PlayerHead.getItemStack(PlayerSkin.fromBase64(base64Code));
    }

}
