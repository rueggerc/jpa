create schema authorization chris;

drop sequence HIBERNATE_SEQUENCE_RESTRICT;
create sequence hibernate_sequence
as bigint
start with 1000
increment by 1;
