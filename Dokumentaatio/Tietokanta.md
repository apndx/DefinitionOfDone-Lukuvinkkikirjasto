# Tietokanta

### Luontilauseet

Sprint 1:

Tietokannassa on tässä vaiheessa yksi taulu, jolla määritellään Lukuvinkki. Käytössä on SQLite3 tietokanta.

Tietokannan luontilauseet


```sql

sqlite3 readMeBase.db

CREATE TABLE Book ( book_id integer PRIMARY KEY, 
	book_author varchar(200), 
	book_title varchar(50), 
	book_ISBN integer(100), 
	book_description varchar(3000), 
	book_year integer(50), 
	book_checked boolean, book_date_checked date);

CREATE TABLE Video ( video_id integer PRIMARY KEY, 
	video_author varchar(200), 
	video_title varchar(50), 
	video_link varchar(200), 
	video_description varchar(3000), 
	video_year integer(50), 
	video_checked boolean, 
	video_date_checked date);

CREATE TABLE News ( news_id integer PRIMARY KEY, 
	news_author varchar(200), 
	news_title varchar(50), 
	news_link varchar(200), 
	news_description varchar(3000), 
	news_publisher varchar(200), 
	news_year integer(50), 
	news_checked boolean, 
	news_date_checked date);

CREATE TABLE Article ( article_id integer PRIMARY KEY, 
	article_author varchar(200), 
	article_title varchar(50), 
	article_link varchar(200), 
	article_description varchar(3000), 
	article_publisher varchar(200), 
	article_year integer(50), 
	article_checked boolean, 
	article_date_checked date);

CREATE TABLE Blog ( blog_id integer PRIMARY KEY, 
	blog_author varchar(200), 
	blog_title varchar(50), 
	blog_link varchar(200), 
	blog_description varchar(3000), 
	blog_year integer(50), 
	blog_checked boolean, 
	blog_date_checked date);
	);

```
