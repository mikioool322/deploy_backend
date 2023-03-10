CREATE TABLE user_match_decition
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  selecting_user_email varchar(126) NOT NULL,
  selected_user_email varchar(126) NOT NULL,
  selected_user_approved boolean NOT NULL,
  creation_timestamp timestamp NOT NULL,
  modification_timestamp timestamp NOT NULL
);