package model;

public class User {

    private int id;
    private String name;
    private boolean isBlocked;

    public User(int id, String name, boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.isBlocked = isBlocked;
    }

    public void blockUser() {
        isBlocked = true;
    }

    public void unBlockUser() {
        isBlocked = false;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
