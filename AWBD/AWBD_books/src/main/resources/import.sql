insert into category(id, name) values(1, 'fantasy');
insert into category(id, name) values(2, 'horror');

insert into book (id, title, author, price) values (1, 'Cruel Prince', 'Holly Black', 50);
insert into info(id, book_id, description) values (1, 1, 'Plot for Cruel Prince');
insert into book_category (book_id, category_id) values(1,1);
insert into reader(id, first_name, last_name) values (1, 'Jon', 'Snow');

insert into book (id, title, author, price) values (2, 'Harry Potter', 'JK Rowling', 30);
insert into info(id, book_id, description) values (2, 2, 'Harry, you are a wizard!');
insert into book_category (book_id, category_id) values (2, 1);

insert into book (id, title, author, price) values (3, 'Night at the museum' , 'John Doe', 20);
insert into info (id, book_id, description) values (3, 3 , 'Horror story');
insert into book_category (book_id, category_id) values (3, 2);
