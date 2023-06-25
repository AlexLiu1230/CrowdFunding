use project_crowd;
drop table if exists t_admin;

create table t_admin
(
    id          int          not null auto_increment, #primary key
    login_acc   varchar(255) not null,                #login account
    user_pwd    char(32)     not null,                #login password
    user_name   varchar(255) not null,
    email       varchar(255) not null,
    create_time char(19),
    primary key (id)
)