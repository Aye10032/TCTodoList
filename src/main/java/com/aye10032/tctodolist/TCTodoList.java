package com.aye10032.tctodolist;

import com.aye10032.tctodolist.command.CommandRegister;
import com.aye10032.tctodolist.key.KeyBindRegister;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        KeyBindRegister.register();
    }
}
