package model;

public class User {

    private int id;
    private String name;
    private boolean blocked;

    public User(int id, String name, boolean blocked) {
        this.id = id;
        this.name = name;
        this.blocked = blocked;
    }

    public void blockUser(boolean block) {
        blocked = block;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isBlocked=" + blocked +
                '}';
    }
}
