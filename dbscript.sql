create table book_details (
				book_id int generated always as identity,
				book_title varchar(200),
				book_author varchar(20),
				book_genre varchar(20),
				book_cost int,
				book_removed boolean,
				primary key(book_id)
			);

insert into book_details(book_title, book_author, book_genre, book_cost, book_removed) values('Harry Potter and the Chamber of Secrets','J.K.Rowling','Fiction',20, false);
insert into book_details(book_title, book_author, book_genre, book_cost, book_removed) values('Harry Potter and the Goblet of Fire','J.K.Rowling','Fiction',25, false);
