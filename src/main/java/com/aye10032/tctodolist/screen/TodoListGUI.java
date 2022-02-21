package com.aye10032.tctodolist.screen;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Axis;
import io.github.cottonmc.cotton.gui.widget.data.Color;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

/**
 * @program: TCTodoList
 * @className: TodoListGUI
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/21 下午 8:51
 */
public class TodoListGUI extends LightweightGuiDescription {
    private int HEIGHT_GRID;
    private int HEIGHT;

    public TodoListGUI(int scaledWidth, int scaledHeight) {
        System.out.println("w:" + scaledWidth + " h:" + scaledHeight);
        HEIGHT_GRID = (scaledHeight - 40) / 9;
        HEIGHT = HEIGHT_GRID * 9;
        WGridPanel root = new WGridPanel(9);
        setRootPanel(root);
        root.setSize(234, HEIGHT);
        root.setInsets(Insets.ROOT_PANEL);

        WLabel title = new WLabel(new TranslatableText("gui.tc-dodo-list.title"));
        title.setHorizontalAlignment(HorizontalAlignment.CENTER);
        title.setColor(Color.WHITE.toRgb());
        root.add(title, 9, 0, 6, 1);

        WButton task_btn = new WButton(new TranslatableText("gui.tc-dodo-list.task_button"));
        task_btn.setAlignment(HorizontalAlignment.CENTER);
        root.add(task_btn, 4, 2, 6, 2);

        WButton message_btn = new WButton(new TranslatableText("gui.tc-dodo-list.message_button"));
        message_btn.setAlignment(HorizontalAlignment.CENTER);
        root.add(message_btn, 14, 2, 6, 2);

        WBox box = new WBox(Axis.VERTICAL);
//        box.setSpacing(2);
//        box.setInsets(new Insets(1,10,1,0));
        box.setHorizontalAlignment(HorizontalAlignment.CENTER);

        for (int i = 0; i < 10; i++) {
            TaskPanel panel = new TaskPanel();
            box.add(panel, 180, 40);
        }
        WScrollPanel sp = new WScrollPanel(box);
//        sp.setBackgroundPainter(BackgroundPainter.createNinePatch(new Identifier("tc-todo-list", "texture/panel_transparent.png")));
        root.add(sp, 3, 5, 21, HEIGHT_GRID - 6);

        root.validate(this);
    }

    @Override
    public void addPainters() {
//        super.addPainters();
        this.getRootPanel().setBackgroundPainter(BackgroundPainter.createNinePatch(new Identifier("tc-todo-list", "texture/panel_transparent.png")));
    }
}
