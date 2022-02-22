package com.aye10032.tctodolist.screen;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Color;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;

import java.awt.image.BufferedImage;

/**
 * @program: TCTodoList
 * @className: TaskPanel
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/21 下午 10:27
 */
public class TaskPanel extends WPlainPanel{

    public TaskPanel(String name, String pos) {
        WLabel name_label = new WLabel(name);
        name_label.setColor(Color.BLACK.toRgb());
        this.add(name_label, 8, 8);
//            panel.setSize(180, 40);
        this.setBackgroundPainter(BackgroundPainter.VANILLA);
    }
}
