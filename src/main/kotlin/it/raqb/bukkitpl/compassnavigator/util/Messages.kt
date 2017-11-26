package it.raqb.bukkitpl.compassnavigator.util

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

object Messages {
    /**
     * Returns the compassnavigator header
     */
    private fun getHeader(): String =
            ChatColor.GREEN.toString() + "" + ChatColor.BOLD + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Navigator" + ChatColor.GREEN + "" + ChatColor.BOLD + "]" + ChatColor.RESET

    /**
     * Sends a message to the console with header
     * @param msg The message to send
     */
    fun sendConsoleMessage(msg: String) {
        Bukkit.getConsoleSender().sendMessage(getHeader() + " " + msg)
    }

    /**
     * Sends a message to a player with header
     * @param p The Player to send the message to
     * @param msg The message to send
     */
    fun sendPlayerMessage(p: Player, msg: String) {
        p.sendMessage(getHeader() + " " + msg)
    }

    /**
     * Sends a list of items to a player
     * @param p The player to send the message to
     * @param list The list to send
     */
    fun sendListMessage(p: Player, list: Array<String>) {
        for (item in list) {
            p.sendMessage("${getHeader()}${ChatColor.RESET} - $item")
        }
    }

    /**
     * Message that gets sent to tell the player the arguments are wrong.
     * @param p The Player to send the message to
     */
    fun wrongArgs(p: Player) {
        p.sendMessage(ChatColor.RED.toString() + "Invalid subcommand. Use Navigator like this:")
        p.sendMessage(ChatColor.DARK_GREEN.toString() + "" + ChatColor.BOLD + "/nav" + ChatColor.GREEN + " - Set your compass' pointer to your current location.")
        p.sendMessage(ChatColor.DARK_GREEN.toString() + "" + ChatColor.BOLD + "/nav x z" + ChatColor.GREEN + " - Set your compass' pointer to specified location.")
        p.sendMessage(ChatColor.DARK_GREEN.toString() + "" + ChatColor.BOLD + "/nav reset" + ChatColor.GREEN + " - Reset your compass' pointer.")
    }

    /**
     * Message that gets sent to a player when it doesn't have the permission for the thing they're trying to do
     * @param p The player to send the message to
     */
    fun noPermission(p: Player) {
        sendPlayerMessage(p, ChatColor.RED.toString() + "Sorry, but you don't have the permission to do this.")
    }
}