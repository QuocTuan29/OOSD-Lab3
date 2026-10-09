package com.arena.control;

import com.arena.model.ArenaSystem;
import com.arena.model.Player;
import com.arena.model.Tournament;

import java.time.LocalDate;
import java.util.List;

/**
 * Lớp Điều khiển (Control Object) thực hiện logic nghiệp vụ cho Use Case "AnnounceTournament".
 * Chịu trách nhiệm kiểm tra tính hợp lệ, tạo thực thể Tournament, lưu trữ và phát thông báo.
 * 
 * @author ARENA Development Team
 * @version 1.0
 */
public class AnnounceTournamentControl {

    /**
     * Thực hiện việc công bố giải đấu mới.
     *
     * @param name       Tên giải đấu
     * @param gameStyle  Loại trò chơi (ví dụ: TicTacToe)
     * @param maxPlayers Số lượng người chơi tối đa (ví dụ: 8)
     * @param startDate  Ngày bắt đầu giải đấu
     * @return Đối tượng Tournament vừa khởi tạo
     * @throws IllegalArgumentException Nếu tham số không hợp lệ
     */
    public Tournament announceTournament(String name, String gameStyle, int maxPlayers, LocalDate startDate) {
        // 1. Validation kiểm tra thông tin đầu vào
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên giải đấu không được để trống.");
        }
        if (maxPlayers <= 1) {
            throw new IllegalArgumentException("Số lượng người chơi phải lớn hơn 1.");
        }
        if (startDate == null || startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày bắt đầu giải đấu phải từ ngày hiện tại trở về sau.");
        }

        // 2. Tạo đối tượng Entity Tournament
        Tournament newTournament = new Tournament(name, gameStyle, maxPlayers, startDate);

        // 3. Lưu thông tin giải đấu vào hệ thống
        ArenaSystem arenaSystem = ArenaSystem.getInstance();
        arenaSystem.addTournament(newTournament);

        // 4. Phát thông báo giải đấu đến các người chơi hiện có
        notifyPlayers(newTournament, arenaSystem.getPlayers());

        return newTournament;
    }

    /**
     * Giả lập gửi thông báo tin tức giải đấu đến danh sách người chơi.
     *
     * @param tournament Giải đấu được công bố
     * @param players    Danh sách người chơi trong hệ thống
     */
    private void notifyPlayers(Tournament tournament, List<Player> players) {
        System.out.println("\n[SYSTEM EVENT - ANNOUNCEMENT NOTIFICATION]");
        System.out.println("Đã phát thông báo cho giải đấu: " + tournament.getName());
        System.out.println("Bộ môn: " + tournament.getGameStyle() + " | Giới hạn: " + tournament.getMaxPlayers() + " người chơi.");
        System.out.println("Đang gửi email thông báo tới " + players.size() + " thành viên:");
        for (Player player : players) {
            System.out.println("  -> [Email sent to " + player.getEmail() + "]: Chào " + player.getUsername() 
                    + ", giải đấu TicTacToe 8 người chơi đã mở đăng ký!");
        }
        System.out.println("--------------------------------------------------\n");
    }
}