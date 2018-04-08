package training.utility;

class Output {

  static String putStringInRed (String stringToPutRed) {
    String stringInRed;
    stringInRed = (char)27 + "[31m";
    stringInRed += stringToPutRed;
    stringInRed += (char)27 + "[39m";
    return stringInRed;
  }

  static String putStringInGreen (String stringToPutGreen) {
    String stringInRed;
    stringInRed = (char)27 + "[32m";
    stringInRed += stringToPutGreen;
    stringInRed += (char)27 + "[39m";
    return stringInRed;
  }



}
