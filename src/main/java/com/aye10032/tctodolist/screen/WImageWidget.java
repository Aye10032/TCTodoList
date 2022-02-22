package com.aye10032.tctodolist.screen;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.image.BufferedImage;

/**
 * @program: TCTodoList
 * @className: WImageWidget
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/22 上午 11:07
 */
public class WImageWidget extends WWidget {

    private BufferedImage image;
    private int rate;

    public WImageWidget(BufferedImage image, int rate) {
        this.image = image;
        this.rate = rate;
        setSize(8 * rate, 8 * rate);
    }

    @Override
    public boolean canResize() {
        return true;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int color = image.getRGB(i, j);
                ScreenDrawing.coloredRect(matrices, x + (i * rate), y + (j * rate), rate, rate, color);
            }
        }
    }
}
