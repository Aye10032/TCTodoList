package com.aye10032.tctodolist.key;

import com.aye10032.tctodolist.screen.TodoListGUI;
import com.aye10032.tctodolist.screen.TodoListScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.TranslatableText;
import org.lwjgl.glfw.GLFW;

/**
 * @program: TCTodoList
 * @className: KeyBindRegister
 * @Description: 按键绑定
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/21 下午 2:04
 */
public class KeyBindRegister {
    private static KeyBinding keyBinding;

    public static void register() {
        keyBinding = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.tc-dodo-list.showgui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.tc-dodo-list.title")
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                assert client.player != null;
//                client.player.sendMessage(new TranslatableText("text.tc-dodo-list.test"), true);
                client.setScreen(new TodoListScreen(new TodoListGUI(client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight())));
            }
        });
    }

}
