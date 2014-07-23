package me.artish1.OITC.Arena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

public class Arenas {
	
	private static HashMap<String, Arena> arenas = new HashMap<String,Arena>();
	  private static HashMap<String, Arena> playerArena = new HashMap<String,Arena>();
	  private static List<Arena> list = new ArrayList<Arena>();
	  
	  public static Arena getArena(String ArenaName)
	  {
	    if (arenas.containsKey(ArenaName))
	    {
	      Arena arena = (Arena)arenas.get(ArenaName);
	      return arena;
	    }
	    return null;
	  }
	  
	  public static List<Arena> getArenas()
	  {
	    return list;
	  }
	  
	  public static boolean isInArena(Player player)
	  {
	    if (playerArena.containsKey(player.getName())) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static void removeArena(Player player)
	  {
	    if (playerArena.containsKey(player.getName())) {
	      playerArena.remove(player.getName());
	    }
	  }
	  
	  public static void addArena(Arena arena)
	  {
	    if (!arenas.containsKey(arena.getName()))
	    {
	      arenas.put(arena.getName(), arena);
	      if (!list.contains(arena)) {
	        list.add(arena);
	      }
	    }
	  }
	  
	  public static void addArena(Player player, Arena arena)
	  {
	    if (!playerArena.containsKey(player.getName())) {
	      playerArena.put(player.getName(), arena);
	    }
	  }
	  
	  public static Arena getArena(Player player)
	  {
	    String name = player.getName();
	    if (playerArena.containsKey(name))
	    {
	      Arena arena = (Arena)playerArena.get(name);
	      
	      return arena;
	    }
	    return null;
	  }
	  
	  public static boolean arenaExists(String ArenaName)
	  {
	    if (arenas.containsKey(ArenaName)) {
	      return true;
	    }
	    return false;
	  }
}
