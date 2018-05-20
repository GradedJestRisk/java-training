package object.identity;

class Book {

  private String author;
  private String title;
  private int edition;


  private Book(String title) {
    this.title = title;
  }

  private Book(String title, String author) {

    this(title);
    this.author = author;

  }

  Book(String title, String author, int edition) {

    this(title, author);
    this.edition = edition;

  }

  void setEdition(int edition) {
    this.edition = edition;
  }

  @Override
  public String toString() {
    String toString;

    toString = "Book: " + title + " by " + author + ", edition n°" + Integer
        .toString(edition);

    return toString;
  }

  @Override
  public boolean equals(Object object) {

    Boolean equals;
    Book anotherBook;

    if (object instanceof Book) {
      anotherBook = (Book) object;

      if ((this.title.equals(anotherBook.title)) && (this.author.equals(anotherBook.author))
          && (this.edition == anotherBook.edition)) {
        equals = Boolean.TRUE;
      } else {
        equals = Boolean.FALSE;
      }
    } else {
      equals = Boolean.FALSE;
    }

    return equals;
  }

}
