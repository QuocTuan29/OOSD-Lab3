package arena;

import com.arena.boundary.AnnounceTournamentBoundary;
import com.arena.model.ArenaSystem;
import com.arena.model.Player;

import java.time.LocalDate;

/**
 * Lớp chạy giả lập hệ thống ARENA và Use Case "AnnounceTournament" cho TicTacToe 8 người chơi.
 * 
 * @author ARENA Development Team
 * @version 1.0
 */
public class Main {

    /**
     * Điểm khởi chạy chương trình.
     *
     * @param args Tham số dòng lệnh
     */
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  ARENA SYSTEM - CASE STUDY OBJECT-ORIENTED ANALYSIS");
        System.out.println("     MÔ PHỎNG USE CASE: ANNOUNCE TOURNAMENT (TICTACTOE)");
        System.out.println("==================================================\n");

     // Khởi tạo 8 người chơi thực tế trong hệ thống ARENA
        ArenaSystem arena = ArenaSystem.getInstance();

        String[][] samplePlayers = {
            {"Nguyễn Minh Trí", "nguyenminhtri.2002@gmail.com"},
            {"Trần Hoàng Nam", "hoangnam.tran99@gmail.com"},
            {"Lê Phương Anh", "phuonganh.le03@gmail.com"},
            {"Phạm Đức Huy", "duchuy.pham.tech@gmail.com"},
            {"Võ Quốc Bảo", "voquocbao2001@gmail.com"},
            {"Đặng Thảo Linh", "linh.dangthao98@gmail.com"},
            {"Bùi Anh Khoa", "khoabui.dev@gmail.com"},
            {"Ngô Gia Phát", "giaphat.ngo.2003@gmail.com"}
        };

        for (String[] p : samplePlayers) {
            arena.addPlayer(new Player(p[0], p[1]));
        }

        // 2. Ban tổ chức thực hiện công bố giải đấu TicTacToe 8 người chơi thông qua Boundary
        AnnounceTournamentBoundary organizerUI = new AnnounceTournamentBoundary();
        
        organizerUI.submitTournamentAnnouncement(
                "TicTacToe Championship 2026",
                "TicTacToe",
                8,
                LocalDate.of(2026, 11, 15)
        );

        // 3. Kiểm tra dữ liệu được tạo lưu trong Thực thể ArenaSystem
        System.out.println("\n>>> TRẠNG THÁI HỆ THỐNG ARENA BÊN TRONG CƠ SỞ DỮ LIỆU:");
        System.out.println("Tổng số giải đấu đã ghi nhận: " + arena.getTournaments().size());
        System.out.println("Thông tin giải đấu: " + arena.getTournaments().getFirst());
    }
}