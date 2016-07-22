/*
 * Copyright 2016 HideoutMC // Creatiums LLC. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and contributors and should not be interpreted as representing official policies,
 *  either expressed or implied, of anybody else.
 */

package ho.ew;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Factory {
	  public static Plugin plugin;
	  
	  public static File File;
	  public static FileConfiguration configFile;
	  
	  public static File LobbySchematic;
	  
	  public static boolean build(Plugin pl){
      plugin = pl;
	    File = new File(plugin.getDataFolder(), "config.yml");
	    if (!File.exists()) {
	      try
	      {
	        File.getParentFile().mkdirs();
	        copyFile(plugin.getResource("config.yml"), File);
	        configFile = YamlConfiguration.loadConfiguration(File);
	      }
	      catch (Exception e)
	      {
	        plugin.getLogger().info("Algo ha fallado con la configuración principal, Verifique o contacte con el desarrollador.");
	        return false;
	      }
	    } else {
	      configFile = YamlConfiguration.loadConfiguration(File);
	    }
	    
	    LobbySchematic = new File(plugin.getDataFolder(), "schematic/lobby.schematic");
	    if(!LobbySchematic.exists()) {
	    	try{
	    		LobbySchematic.getParentFile().mkdirs();
	    		copyFile(plugin.getResource("schematic/lobby.schematic"), LobbySchematic);
	    	}catch(Exception e){
	    		EggWars.sendError("Algo ha fallado con la configuración principal, Verifique o contacte con el desarrollador.");
		        return false;
	    	}
	    }
	    
	    
		return true;
	  }
	  
	  private static void copyFile(InputStream in, File file){
	    try
	    {
	      OutputStream out = new FileOutputStream(file);
	      byte[] buf = new byte['?'];
	      int len;
	      while ((len = in.read(buf)) > 0)
	      {
	        out.write(buf, 0, len);
	      }
	      out.close();
	      in.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	  }
}