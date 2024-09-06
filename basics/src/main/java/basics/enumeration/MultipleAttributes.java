package basics.enumeration;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MultipleAttributes {
  ONE(1, "Jane"),
  TWO(2, "John");

  private int identifier;
  private String name;

  MultipleAttributes(int identifier, String name) {
    this.identifier = identifier;
    this.name = name;
  }

  public static MultipleAttributes findByName(final String name) {
    return Arrays.stream(values())
        .filter(value -> value.getName().equals(name))
        .findFirst()
        .orElse(null);
  }
}
