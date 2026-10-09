package com.arena.model;

/**
 * Lớp Thực thể (Entity Object) đại diện cho Người chơi (Player) trong hệ thống ARENA.
 * 
 * @author ARENA Development Team
 * @version 1.0
 */
public class Player {

    /** Tên đăng nhập của người chơi. */
    private String username;

    /** Địa chỉ email của người chơi. */
    private String email;

    /**
     * Khởi tạo một đối tượng Player mới.
     *
     * @param username Tên đăng nhập
     * @param email    Địa chỉ email
     */
    public Player(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * Lấy tên đăng nhập của người chơi.
     *
     * @return Tên đăng nhập
     */
    public String getUsername() {
        return username;
    }

    /**
     * Lấy địa chỉ email của người chơi.
     *
     * @return Địa chỉ email
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}