/**
 * Listner for Save Inventory
 *
 * @author : Samuel Delepoulle
 */
package fr.manwald.save;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;




public class MyListener implements Listener {

    /**
     * Create a large chest at the location.
     *
     * @param targ the location where the chest will spawn
     */
    public void makeLargeChest(Location targ) {

        Block leftSide = targ.getBlock();
        Block rightSide = targ.clone().add(0, 0, -1).getBlock();

        leftSide.setType(Material.CHEST);
        rightSide.setType(Material.CHEST);

        leftSide.setBlockData(Material.CHEST.createBlockData("[facing=east,type=right]"));
        rightSide.setBlockData(Material.CHEST.createBlockData("[facing=east,type=left]"));

    }

    /**
     *
     * When the player dies, a large (double) chest spawn.
     * The inventory of the player is copied into the chest and
     * the player's inventory is cleared.
     *
     * @param e
     */
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        // to do = only in debug mode
        System.out.println("someone dies");

        Location loc = e.getEntity().getLocation();

        makeLargeChest(loc);

        Block block = loc.getBlock();
        Chest chest = (Chest) block.getState();
        Inventory inv = chest.getInventory();


        Player player = e.getEntity().getPlayer();



        if (player.getInventory() != null) {
            chest.getInventory().setContents(player.getInventory().getContents());
            e.getDrops().clear();
        }


    }
}
