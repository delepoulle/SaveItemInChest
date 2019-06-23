package fr.manwald.save;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Bukkit.getServer;

public class MyListener implements Listener {
    

         @EventHandler
    public void onDeath(PlayerDeathEvent e){

        System.out.println("someone dies");

        /* to do :
          - get location
          - set all items nearby in a chest
          - lock the chest ???
        */
    }
}