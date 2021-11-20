CREATE TABLE IF NOT EXISTS users (
  id SERIAL,
  user_role varchar,
  user_name varchar,
  user_email varchar,
  primary key(id)
);


CREATE TABLE IF NOT EXISTS reviews (
  id SERIAL,
  review_owner integer,
  review_writer integer,
  review_status boolean,
  review_text varchar,
  primary key (id),
  constraint fk_users_owner foreign key(review_owner) references users(id),
  constraint fk_users_writer foreign key(review_writer) references users(id)
);


INSERT INTO users values(DEFAULT,'ADMIN','Admin Account','admin@gmail.com');
INSERT INTO users values(DEFAULT,'USER','User Account 1','user1@gmail.com');
INSERT INTO users values(DEFAULT,'USER','User Account 2','user2@gmail.com');
