package object.construction;

class Book {

  static String DEFAULT_TITLE = "Clean code";
  static String DEFAULT_AUTHOR = "Robert C. Martin";
  static int DEFAULT_PAGE_COUNT = 100;

  private String author;
  private String title;
  private int pageCount;

  {
    // In real-life, should be moved to Book()
    pageCount = DEFAULT_PAGE_COUNT;
  }

  Book() {
    title = DEFAULT_TITLE;
    author = DEFAULT_AUTHOR;
  }

  Book(String title) {
    this.title = title;
  }

  Book(String title, String author) {

    this(title);
    this.author = author;

  }

// Wouldn't work because another (String, String) signature exists
//  Book(String author, String title) {
//
//    this(title);
//    this.author = author;
//
//  }

  String getTitle() {
    return title;
  }

  String getAuthor() {
    return author;
  }

  int getPageCount() {
    return pageCount;
  }

}
