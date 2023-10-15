package fr.tcapi.server.integration;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Skull {

    public static ItemStack getSkull(String Texture) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta skullM = (SkullMeta)skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", Texture));
        Field profileField = null;
        try {
            profileField = skullM.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullM, profile);
        } catch (IllegalArgumentException|IllegalAccessException|NoSuchFieldException|SecurityException e) {
            e.printStackTrace();
        }
        skull.setItemMeta((ItemMeta)skullM);
        return skull;
    }

    public static ItemStack getPlayerSkull(String Nickname) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta ns = (SkullMeta)skull.getItemMeta();
        ns.setOwner(Nickname);
        skull.setItemMeta((ItemMeta)ns);
        return skull;
    }
}
