package com.arena.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp Thực thể hệ thống (Singleton) quản lý danh sách các giải đấu và người chơi trong hệ thống ARENA.
 * 
 * @author ARENA Development Team
 * @version 1.0
 */
public class ArenaSystem {

    private static ArenaSystem instance;
    private List<Tournament> tournaments;
    private List<Player> players;

    private ArenaSystem() {
        this.tournaments = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    /**
     * Trả về thể hiện duy nhất của ArenaSystem.
     *
     * @return Thể hiện duy nhất của hệ thống
     */
    public static synchronized ArenaSystem getInstance() {
        if (instance == null) {
            instance = new ArenaSystem();
        }
        return instance;
    }

    /**
     * Thêm giải đấu mới vào hệ thống.
     *
     * @param tournament Giải đấu cần lưu trữ
     */
    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    /**
     * Thêm người chơi mới vào hệ thống.
     *
     * @param player Người chơi
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }
}