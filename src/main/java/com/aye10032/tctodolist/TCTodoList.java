package com.aye10032.tctodolist;

import net.fabricmc.api.ModInitializer;
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
public class TCTodoList implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("tc-todo-list");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
    }
}
