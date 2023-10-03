package com.ahmedatef.springboot;

import java.util.Objects;

public record Flavor(int id, String flavorName) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flavor flavor = (Flavor) o;
        return Objects.equals(flavorName, flavor.flavorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavorName);
    }
}
