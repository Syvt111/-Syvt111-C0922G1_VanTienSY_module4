CREATE DATABASE librariy_auth;
CREATE DATABASE IF NOT EXISTS librariy_auth;
create table APP_USER ( USER_ID BIGINT not null, USER_NAME VARCHAR(36) not null, ENCRYTED_PASSWORD VARCHAR(128) not null, ENABLED BIT not null ) ;
