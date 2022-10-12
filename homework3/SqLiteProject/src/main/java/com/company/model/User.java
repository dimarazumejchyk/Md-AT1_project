package com.company.model;

public class User {
    private  int userId;
    private String name;
    private String address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (!name.equals(user.name)) return false;
        return address.equals(user.address);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}
