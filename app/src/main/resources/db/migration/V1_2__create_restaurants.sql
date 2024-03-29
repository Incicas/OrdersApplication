CREATE TABLE IF NOT EXISTS restaurants(
   created_on  timestamp   default current_timestamp,
   id          SERIAL      PRIMARY KEY,
   name       varchar(255) not null,
   description    varchar(255) not null,
   location        varchar(255) not null,
   open_hour       TIME         not null,
   close_hour      TIME         not null,
   user_id         int8         references users(id)
  );