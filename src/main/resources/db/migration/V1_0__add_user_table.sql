CREATE TABLE tinder_user
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  user_email varchar(126) unique,
  password   varchar(100) NOT NULL,
  name varchar(126) NULL,
  description text NULL,
  phone_number varchar(9) NULL,
  photo text NULL,
  gender varchar(6)  NULL,
  age smallint  NULL,
  degree text  NULL,
  creation_timestamp timestamp NOT NULL,
  modification_timestamp timestamp NOT NULL
);