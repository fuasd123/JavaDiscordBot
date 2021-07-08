package com.discordcommand;

import com.main.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.sql.DataTruncation;
import java.util.HashMap;


public class botcommand extends ListenerAdapter {
    EmbedBuilder embedBuilder = new EmbedBuilder();
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String user = event.getMember().getUser().getAsTag();
        if (args[0].equalsIgnoreCase(bot.prefix + "공지")) {
            if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder embed1 = new EmbedBuilder();
                embed1.setTitle("공지");
                embed1.setColor(Color.RED);
                embed1.setDescription("시스템");
                embed1.setDescription("당신의 권한이 없습니다!");
                embed1.setFooter(user);
                event.getChannel().sendMessage(embed1.build()).queue();
            } else {
                if (args.length == 1) {
                    EmbedBuilder embed2 = new EmbedBuilder();
                    embed2.setTitle("도움말");
                    embed2.setColor(Color.darkGray);
                    embed2.addField("명령어", "/공지 시스템 [메세지] [설명] [사진 링크]", true);
                    embed2.addField("명령어", "/공지 건축 [메세지] [설명] [사진 링크]", true);
                    embed2.addField("명령어", "/공지 사이트 [메세지] [설명] [사진 링크]", true);
                    embed2.setFooter(user);
                    event.getChannel().sendMessage(embed2.build()).queue();
                } else {
                    if (args[1].equals("시스템")) {
                        try {
                            MessageChannel Channel = event.getJDA().getTextChannelById("861600819228442624");
                            EmbedBuilder embed3 = new EmbedBuilder();
                            embed3.setTitle("공지");
                            embed3.setColor(Color.pink);
                            embed3.addField(args[2], args[3], true);
                            embed3.setImage(args[4]);
                            embed3.setFooter(user);
                            MessageAction ch = Channel.sendMessage(embed3.build());
                            ch.queue();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            event.getChannel().sendMessage("메세지 적어주세요.").queue();
                        }
                    }
                }
                if (args[1].equals("건축")) {
                    try {
                        MessageChannel Channel = event.getJDA().getTextChannelById("861599216124035112");
                        EmbedBuilder embed4 = new EmbedBuilder();
                        embed4.setTitle("공지");
                        embed4.setColor(Color.pink);
                        embed4.addField(args[2], args[3], true);
                        embed4.setImage(args[4]);
                        embed4.setFooter(user);
                        MessageAction ch = Channel.sendMessage(embed4.build());
                        ch.queue();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        event.getChannel().sendMessage("메세지 적어주세요.").queue();
                    }
                }
            }
            if (args[1].equals("사이트")) {
                try {
                    MessageChannel Channel = event.getJDA().getTextChannelById("861686651096662046");
                    EmbedBuilder embed5 = new EmbedBuilder();
                    embed5.setTitle("공지");
                    embed5.setColor(Color.pink);
                    embed5.addField(args[1], args[2], true);
                    embed5.setImage(args[3]);
                    embed5.setFooter(user);
                    MessageAction ch = Channel.sendMessage(embed5.build());
                    ch.queue();
                } catch (ArrayIndexOutOfBoundsException e) {
                    event.getChannel().sendMessage("메세지 적어주세요.").queue();
                }
            }
        }
    }
    public void onGuildMemberJoined(GuildMemberJoinEvent event) throws LoginException {
        String user = event.getMember().getUser().getAsTag();
        MessageChannel Channel = event.getJDA().getTextChannelById("793673521480990724");
        embedBuilder.setTitle("입장");
        embedBuilder.setColor(Color.black);
        embedBuilder.setDescription(user + "님 안녕하세요");
        Channel.sendMessage(embedBuilder.build());
    }
}