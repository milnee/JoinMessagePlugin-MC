package millen.joinmessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener, CommandExecutor {
    // Set to store players who have disabled join messages
    private Set<UUID> disabledJoinMessages = new HashSet<>();

    @Override
    public void onEnable() {
        saveDefaultConfig(); // Ensure default config is saved
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("joinmessagereload").setExecutor(this); // Register reload command
        getCommand("joinmessage").setExecutor(this); // Register joinmessage command
        
        getLogger().info("Plugin enabled"); // Log plugin enabled
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled"); 
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Reload command
        if (command.getName().equalsIgnoreCase("joinmessagereload")) {
            if (!sender.hasPermission("joinmessage.reload")) {
                sender.sendMessage(ChatColor.RED + "No Permission");
                return true;
            }
        
            reloadConfig(); // Reload the configuration
            sender.sendMessage(ChatColor.GREEN + "JoinMessage reloaded");
            return true;
        }
        
        // Join message toggle command
        if (command.getName().equalsIgnoreCase("joinmessage")) {
            // Ensure the sender is a player
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
                return true;
            }
            
            // Check if sender has permission
            if (!sender.hasPermission("joinmessage.command")) {
                sender.sendMessage(ChatColor.RED + "No Permission");
                return true;
            }
            
            Player player = (Player) sender;
            UUID playerId = player.getUniqueId();
            
            // Toggle join messages
            if (disabledJoinMessages.contains(playerId)) {
                // Re-enable join messages
                disabledJoinMessages.remove(playerId);
                player.sendMessage(ChatColor.GREEN + "Join messages are now enabled.");
            } else {
                // Disable join messages
                disabledJoinMessages.add(playerId);
                player.sendMessage(ChatColor.RED + "Join messages are now disabled.");
            }
            
            return true;
        }
        
        return false;
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        // Check if join messages are enabled in config and for this specific player
        if (getConfig().getBoolean("joinmessage", true) && 
            !disabledJoinMessages.contains(player.getUniqueId())) {
            
            List<String> joinMessages = getConfig().getStringList("messages.join");
            
            // Combine join messages into a single message
            StringBuilder messageBuilder = new StringBuilder();
            for (String line : joinMessages) {
                // If line is empty, add a space character
                if (line.trim().isEmpty()) {
                    messageBuilder.append(" \n");
                } else {
                    messageBuilder.append(ChatColor.translateAlternateColorCodes('&', line)).append("\n");
                }
            }
            
            // Set the join message
            event.setJoinMessage(messageBuilder.toString().trim());
        } else {
            // Clear the join message if disabled
            event.setJoinMessage(null);
        }
    }
}