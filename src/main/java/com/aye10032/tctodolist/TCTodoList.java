package com.aye10032.tctodolist;

import ca.weblite.objc.Client;
import com.aye10032.tctodolist.command.CommandRegister;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mojang.brigadier.arguments.StringArgumentType.string;

/**
 * @program: TCTodoList
 * @className: TCTodoList
 * @Description: main class
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/8 下午 1:28
 */
public class TCTodoList implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("tc-todo-list");

    @Override
    public void onInitializeClient() {
        LOGGER.info("TC-Todo-List load finish.");
        //command register
        CommandRegister.register();
    }
}
