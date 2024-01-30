-- 创建数据库
create database plutus;

-- 使用数据库
use plutus;

-- 用户表
create table user (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(16) not null unique comment '用户名',
    password varchar(32)  comment '密码',
    nickname varchar(16)  default '' comment '昵称',
    email varchar(128) default '' comment '邮箱',
    avatar_url varchar(128) default '' comment '头像',
    user_group int comment '用户组',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '用户表';

-- 一级分类表
create table category_father (
    id int unsigned primary key auto_increment comment 'ID',
    category_name varchar(32) not null comment '分类名称',
    is_out boolean not null comment '收入or支出',
    icon_url varchar(128) not null comment '图标地址',
    create_user int unsigned not null comment '创建人ID',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间',
    constraint fk_category_user foreign key (create_user) references user(id) -- 外键约束
) comment '一级分类表';

-- 二级分类表
create table category_child (
    id int unsigned primary key auto_increment comment 'ID',
    category_name varchar(32) not null comment '分类名称',
    category_id int unsigned not null comment '父分类ID',
    create_user int unsigned not null comment '创建人ID',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间',
    constraint fk_category_user foreign key (create_user) references user(id), -- 外键约束
    constraint fk_category_user foreign key (category_id) references category_father(id) -- 外键约束
) comment '二级分类表';

-- 记录表
create table record (
    id int unsigned primary key auto_increment comment 'ID',
    category_id int unsigned comment '分类ID',
    create_user int unsigned not null comment '创建人ID',
    money float not null comment '金额',
    note varchar(128) not null comment '备注',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间',
    constraint fk_article_category foreign key (category_id) references category(id), -- 外键约束
    constraint fk_article_user foreign key (create_user) references user(id) -- 外键约束
) comment '记录表';