package object.abstraction;

class C2 extends C1 {

  // Cannot override because getName final in C1
//  @Override
//  final String getName(){
//    return "getNameToo";
//  }

  // Cannot be final, because C3 override it
  String getSurname() {

    return "Surname";

  }


}
