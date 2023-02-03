create TABLE user_preferences
( user_email varchar(126) unique,
 gender varchar(6),
  min_age smallint,
  max_age smallint,
  creation_timestamp timestamp NOT NULL,
  modification_timestamp timestamp NOT NULL
);