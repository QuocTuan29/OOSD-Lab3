# ARENA – AnnounceTournament (Tic-Tac-Toe Edition)

Simple Java implementation of the **analysis model** for the use case  
**AnnounceTournament** from the textbook  

> Bernd Bruegge & Allen H. Dutoit  
> *Object-Oriented Software Engineering – Using UML, Patterns, and Java* (3rd Edition)

## Scenario
- Game: **Tic-Tac-Toe**
- Number of players: **8**
- Console-based simulation of the complete flow of events (Figure 4-24)
  and the sequence diagrams (Figures 5-26, 5-27, 5-28).

## Project structure (Eclipse / JDK 21)

```
ArenaTicTacToe/
├── src/
│   └── com/
│       └── arena/
│           ├── Main.java
│           ├── boundary/
│           │   └── AnnounceTournamentBoundary.java
│           ├── control/
│           │   └── AnnounceTournamentControl.java
│           └── model/
│               ├── ArenaSystem.java
│               ├── Player.java
│               └── Tournament.java
```

## . Kiến trúc mô hình phân tích (Entity–Boundary–Control)

```
┌─────────────────────────────────────────────────────────┐
│                    Boundary Layer                        │
│         AnnounceTournamentBoundary                       │
│   (Giao diện tương tác với Organizer)                    │
└──────────────────────────┬──────────────────────────────┘
                           │ uses
┌──────────────────────────▼──────────────────────────────┐
│                    Control Layer                         │
│         AnnounceTournamentControl                        │
│   (Logic nghiệp vụ: validate, tạo Tournament,            │
│    lưu trữ, gửi thông báo)                               │
└──────────────────────────┬──────────────────────────────┘
                           │ uses
┌──────────────────────────▼──────────────────────────────┐
│                    Entity Layer                          │
│   ArenaSystem (Singleton)  │  Tournament  │  Player     │
└─────────────────────────────────────────────────────────┘
```


## . Luồng thực thi (tóm tắt)

1. `Main` khởi tạo `ArenaSystem` (Singleton) và thêm 8 người chơi mẫu.
2. Tạo `AnnounceTournamentBoundary` (giao diện Organizer).
3. Organizer gọi `submitTournamentAnnouncement(...)`.
4. Boundary chuyển yêu cầu sang `AnnounceTournamentControl`.
5. Control:
   - Kiểm tra tính hợp lệ của dữ liệu đầu vào.
   - Tạo đối tượng `Tournament`.
   - Lưu Tournament vào `ArenaSystem`.
   - Gửi thông báo (email giả lập) đến tất cả Player.
6. Kết quả được in ra console.

---



## . Kết quả chạy
==================================================
  ARENA SYSTEM - CASE STUDY OBJECT-ORIENTED ANALYSIS
     MÔ PHỎNG USE CASE: ANNOUNCE TOURNAMENT (TICTACTOE)
==================================================

==================================================
[GIAO DIỆN ORGANIZER] Yêu cầu công bố giải đấu mới:
 - Tên giải đấu: TicTacToe Championship 2026
 - Bộ môn game: TicTacToe
 - Quy mô tối đa: 8 người chơi
 - Khởi tranh ngày: 2026-11-15
==================================================

[SYSTEM EVENT - ANNOUNCEMENT NOTIFICATION]
Đã phát thông báo cho giải đấu: TicTacToe Championship 2026
Bộ môn: TicTacToe | Giới hạn: 8 người chơi.
Đang gửi email thông báo tới 8 thành viên:
  -> [Email sent to nguyenminhtri.2002@gmail.com]: Chào Nguyễn Minh Trí, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
  -> [Email sent to hoangnam.tran99@gmail.com]: Chào Trần Hoàng Nam, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
  -> [Email sent to phuonganh.le03@gmail.com]: Chào Lê Phương Anh, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
  -> [Email sent to duchuy.pham.tech@gmail.com]: Chào Phạm Đức Huy, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
  -> [Email sent to voquocbao2001@gmail.com]: Chào Võ Quốc Bảo, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
  -> [Email sent to linh.dangthao98@gmail.com]: Chào Đặng Thảo Linh, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
  -> [Email sent to khoabui.dev@gmail.com]: Chào Bùi Anh Khoa, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
  -> [Email sent to giaphat.ngo.2003@gmail.com]: Chào Ngô Gia Phát, giải đấu TicTacToe 8 người chơi đã mở đăng ký!
--------------------------------------------------

[GIAO DIỆN ORGANIZER] RÀO CHẮN XÁC NHẬN: Công bố giải đấu THÀNH CÔNG!
[Chi tiết giải đấu]: Tournament{name='TicTacToe Championship 2026', gameStyle='TicTacToe', maxPlayers=8, status='ANNOUNCED', startDate=2026-11-15, registeredCount=0}

>>> TRẠNG THÁI HỆ THỐNG ARENA BÊN TRONG CƠ SỞ DỮ LIỆU:
Tổng số giải đấu đã ghi nhận: 1
Thông tin giải đấu: Tournament{name='TicTacToe Championship 2026', gameStyle='TicTacToe', maxPlayers=8, status='ANNOUNCED', startDate=2026-11-15, registeredCount=0}





