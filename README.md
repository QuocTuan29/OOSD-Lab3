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
<img width="1431" height="827" alt="image" src="https://github.com/user-attachments/assets/270fbe2f-0130-4fe2-9f71-5a6bd2c58a13" />

