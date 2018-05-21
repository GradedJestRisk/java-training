package core.string;

public class String {

  static java.lang.String EMPTY_STRING = "";
  static java.lang.String NULL_STRING = null;

  private java.lang.String string;

  String() {
    string = EMPTY_STRING;
  }

  String(java.lang.String string) {
    this.string = string;
  }

  int length() {
    return string.length();
  }

  java.lang.String valueOf(int parameter) {
    return string.valueOf(parameter);
  }

  Boolean isEmpty() {
    return string.isEmpty();
  }

  int compareTo(java.lang.String compared) {
    return string.compareTo(compared);
  }

  Boolean equals(java.lang.String compared) {
    return string.equals(compared);
  }


}
