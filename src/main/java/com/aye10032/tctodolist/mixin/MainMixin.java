package com.aye10032.tctodolist.mixin;

import com.aye10032.tctodolist.TCTodoList;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @program: TCTodoList
 * @className: MainMixin
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/8 下午 1:29
 */
@Mixin(TitleScreen.class)
public class MainMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        TCTodoList.LOGGER.info("This line is printed by an example mod mixin!");
    }
}
