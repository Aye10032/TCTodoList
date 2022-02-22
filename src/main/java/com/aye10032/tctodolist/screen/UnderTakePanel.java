package com.aye10032.tctodolist.screen;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Color;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * @program: TCTodoList
 * @className: UnderTakePanel
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/22 下午 6:13
 */
public class UnderTakePanel extends WPlainPanel {

    public UnderTakePanel(String id, BufferedImage head, String msg, long last_date) {
        WLabel id_label = new WLabel(id);
        id_label.setColor(Color.GRAY_DYE.toRgb());
        WImageWidget avatar = new WImageWidget(head, 2);
        WLabel msg_label = new WLabel(msg);
        msg_label.setColor(Color.BLACK.toRgb());
        msg_label.setHorizontalAlignment(HorizontalAlignment.CENTER);

        Date date = new Date(last_date);

        add(avatar, 5,5);
        add(id_label, 26, 8);
        add(msg_label, 76, 18);

        this.setBackgroundPainter(BackgroundPainter.VANILLA);
    }
}
