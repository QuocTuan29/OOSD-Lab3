package com.arena.boundary;

import com.arena.control.AnnounceTournamentControl;
import com.arena.model.Tournament;

import java.time.LocalDate;

/**
 * Lớp Biên (Boundary Object) đại diện cho giao diện tương tác với Ban tổ chức (Organizer).
 * Thu thập dữ liệu công bố giải đấu và gửi tới lớp Control.
 * 
 * @author ARENA Development Team
 * @version 1.0
 */
public class AnnounceTournamentBoundary {

    private AnnounceTournamentControl control;

    /**
     * Khởi tạo giao diện Boundary và liên kết với Control Object tương ứng.
     */
    public AnnounceTournamentBoundary() {
        this.control = new AnnounceTournamentControl();
    }

    /**
     * Giả lập thao tác nhập thông tin trên biểu mẫu và bấm nút "Announce Tournament".
     *
     * @param name       Tên giải đấu
     * @param gameStyle  Loại trò chơi
     * @param maxPlayers Số người chơi tối đa
     * @param startDate  Ngày bắt đầu
     */
    public void submitTournamentAnnouncement(String name, String gameStyle, int maxPlayers, LocalDate startDate) {
        System.out.println("==================================================");
        System.out.println("[GIAO DIỆN ORGANIZER] Yêu cầu công bố giải đấu mới:");
        System.out.println(" - Tên giải đấu: " + name);
        System.out.println(" - Bộ môn game: " + gameStyle);
        System.out.println(" - Quy mô tối đa: " + maxPlayers + " người chơi");
        System.out.println(" - Khởi tranh ngày: " + startDate);
        System.out.println("==================================================");

        try {
            Tournament tournament = control.announceTournament(name, gameStyle, maxPlayers, startDate);
            System.out.println("[GIAO DIỆN ORGANIZER] RÀO CHẮN XÁC NHẬN: Công bố giải đấu THÀNH CÔNG!");
            System.out.println("[Chi tiết giải đấu]: " + tournament);
        } catch (IllegalArgumentException e) {
            System.err.println("[GIAO DIỆN ORGANIZER] RÀO CHẮN XÁC NHẬN: LỖI - " + e.getMessage());
        }
    }
}