package com.aye10032.tctodolist.command;

import com.aye10032.tctodolist.TCTodoList;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.literal;
import static net.minecraft.command.CommandSource.suggestMatching;
import static net.minecraft.command.argument.EntityArgumentType.getPlayer;
import static net.minecraft.command.argument.EntityArgumentType.player;

/**
 * @program: TCTodoList
 * @className: CommandRegister
 * @Description: client command regist
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/8 下午 9:07
 */
public class CommandRegister {

    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static final JsonParser parser = new JsonParser();
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    private static final int DURATION = 5; // seconds

    public static void register() {
        ClientCommandManager.DISPATCHER.register(
                literal("foo")
                        .then(argument("player", string())
                                .suggests((context, builder) -> suggestMatching(((CommandSource) context.getSource()).getPlayerNames(), builder))
                                .executes(ctx -> {
                                    ctx.getSource().sendFeedback(new LiteralText("Hello, world!" + getString(ctx, "player")));
                                    return 0;
                                }))
        );
    }

    private static String getUUID(String player) {
        var ref = new Object() {
            String uuid = "";
        };
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.mojang.com/users/profiles/minecraft/" + player))
                .timeout(Duration.ofSeconds(DURATION))
                .GET()
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(response -> client.send(() -> {
                    JsonElement result = parser.parse(response);
                    if (result instanceof JsonNull) {
                        TCTodoList.LOGGER.error("");
                    } else {
                        ref.uuid = result.getAsJsonObject().get("id").getAsString();
                    }
                }));
        return ref.uuid;
    }
}
