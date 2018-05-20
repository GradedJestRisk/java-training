package object.abstraction;

// Cannot be final because C2 inherits from C1

abstract class C1 {

  // Cannot be abstract because implementation is provided
  final String getName() {

    return "Name";

  }

  abstract String getSurname();

}
