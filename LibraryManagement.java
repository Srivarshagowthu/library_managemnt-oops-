import java.util.ArrayList;
//persons_class similar struct so abstrac
abstract class Person{
	protected String name;
	protected int id;
	public Person(String name,int id) {
		this.name=name;
		this.id=id;
	}
	//absttarct method is imp
	public abstract void displayinfo();
}
//book class encapsulated to secure the data from outers
class Book{
	private String title;
	private String author;
	private boolean avail;
	public Book(String title,String author) {
		this.title=title;
		this.author=author;
		this.avail=true;
	}
	public boolean isavail() {
		return avail;
	}
	public void displaybook() {
System.out.println("title is"+title+" author is "+author);
	}
	public void borrow() {
		if(avail) {
			avail=false;
			System.out.println(title+"book has borrowed");
		}
		else {
			System.out.println(title+"book unavailable");
		}
		
	}
	public void returnbook() {
		avail=true;
		System.out.println(title+"book has returned");
	}
}
class Member extends Person{
	public Member(String name, int id) {
		super(name,id);
		
	}
	public void displayinfo() {
		System.out.println("member is:"+name+"with id"+id);
	}
	public void borrowbook(Book book) {
		System.out.println(name+"member is borrowing a book");
		book.borrow();
	}
	
}
//librarian
class Librarian extends Person{
	public Librarian(String name,int id) {
		super(name,id);
	}
	public void displayinfo() {
		System.out.println("librarian"+name+"with id"+id);
	}
	public void assisteng_member(Member member,Book book) {
		System.out.println("libarian assistening to borrow for"+member+"with book"+book);
		member.borrowbook(book);
	}
	public void returnbook(Book book) {
		System.out.println("libraran processjng return"+book);
		book.returnbook();
	}
}
class Library{
		private ArrayList<Book> books=new ArrayList<>();
		public void addbooks(Book book) {
			books.add(book);
			System.out.println("book has added");
		}
		public void availbooks() {
			System.out.println("available boosk");
    		for(Book book:books) {
    			if(book.isavail()) {
    				book.displaybook();
    			}
    		}
		}
	}
public class LibraryManagement{
	public static void main(String args[]) {
		//craeting library
		Library library=new Library();
		Book book1=new Book("the raise","varsha");
		Book book2=new Book("the raise2","varsha1");
		library.addbooks(book1);
		library.addbooks(book2);
		Member member=new Member("dhanush",101);
		Librarian librarian=new Librarian("suresh",201);
		library.availbooks();
		librarian.assisteng_member(member,book1);
		library.availbooks();
		librarian.returnbook(book1);
		library.availbooks();
		
	}
}

