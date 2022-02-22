package com.aye10032.tctodolist.screen;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;

import java.awt.image.BufferedImage;

/**
 * @program: TCTodoList
 * @className: TaskPanel
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/21 下午 10:27
 */
public class TaskPanel extends WPlainPanel {

    public TaskPanel(String name, BufferedImage image) {
        this.add(new WLabel(name), 4, 4, 60, 20);
        WImageWidget head = new WImageWidget(image, 2);
        this.add(head, 6, 10);
//            panel.setSize(180, 40);
        this.setBackgroundPainter(BackgroundPainter.VANILLA);
    }


}
