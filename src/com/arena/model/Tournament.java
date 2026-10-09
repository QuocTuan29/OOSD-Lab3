package com.arena.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp Thực thể (Entity Object) đại diện cho Giải đấu (Tournament).
 * Lưu giữ thông tin chi tiết về giải đấu TicTacToe 8 người chơi.
 * 
 * @author ARENA Development Team
 * @version 1.0
 */
public class Tournament {

    /** Tên của giải đấu. */
    private String name;

    /** Loại trò chơi (ví dụ: TicTacToe). */
    private String gameStyle;

    /** Số lượng người chơi tối đa (ví dụ: 8). */
    private int maxPlayers;

    /** Trạng thái của giải đấu (ANNOUNCED, IN_PROGRESS, COMPLETED). */
    private String status;

    /** Ngày bắt đầu giải đấu. */
    private LocalDate startDate;

    /** Danh sách người chơi đã đăng ký tham gia. */
    private List<Player> registeredPlayers;

    /**
     * Khởi tạo một giải đấu mới.
     *
     * @param name       Tên giải đấu
     * @param gameStyle  Tên trò chơi
     * @param maxPlayers Số người chơi tối đa
     * @param startDate  Ngày bắt đầu
     */
    public Tournament(String name, String gameStyle, int maxPlayers, LocalDate startDate) {
        this.name = name;
        this.gameStyle = gameStyle;
        this.maxPlayers = maxPlayers;
        this.startDate = startDate;
        this.status = "ANNOUNCED";
        this.registeredPlayers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGameStyle() {
        return gameStyle;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    /**
     * Đăng ký một người chơi vào giải đấu.
     *
     * @param player Người chơi muốn đăng ký
     * @return true nếu đăng ký thành công, false nếu giải đấu đã đầy
     */
    public boolean addPlayer(Player player) {
        if (registeredPlayers.size() < maxPlayers) {
            registeredPlayers.add(player);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "name='" + name + '\'' +
                ", gameStyle='" + gameStyle + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", registeredCount=" + registeredPlayers.size() +
                '}';
    }
}