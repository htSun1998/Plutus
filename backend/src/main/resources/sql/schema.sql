-- 创建数据库
create database if not exists plutus;

-- 使用数据库
use plutus;

-- 用户表
create table if not exists user (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(16) not null unique comment '用户名',
    password varchar(32) comment '密码',
    nickname varchar(16) comment '昵称',
    email varchar(128) comment '邮箱',
    telephone varchar(11) comment '手机号',
    avatar_url varchar(128) comment '头像',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '用户表';

-- 分组表
create table if not exists user_group (
    id int unsigned primary key auto_increment comment 'ID',
    user_id int unsigned not null comment '用户ID',
    group_name varchar(16) not null comment '分组名称',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间',
    constraint fk_group_user foreign key (user_id) references user(id) -- 外键约束
) comment '用户分组表';

-- 分类表
create table if not exists category (
    id int unsigned primary key auto_increment comment 'ID',
    category_id_1 int unsigned not null comment '一级分类ID',
    category_name_1 varchar(32) not null comment '一级分类名称',
    category_id_2 int unsigned comment '二级分类ID',
    category_name_2 varchar(32) comment '二级分类名称',
    type boolean not null comment '收入/支出，0为收入，1为输出',
    icon_url varchar(128) not null comment '图标地址',
    create_user int unsigned not null comment '创建人ID',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间',
    constraint fk_category_user foreign key (create_user) references user(id) -- 外键约束
) comment '一级分类表';

-- 记录表
create table if not exists record(
    id int unsigned primary key auto_increment comment 'ID',
    category_id int unsigned comment '分类ID',
    create_user int unsigned not null comment '创建人ID',
    money float not null comment '金额',
    note varchar(128) not null comment '备注',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间',
    constraint fk_record_category foreign key (category_id) references category(id), -- 外键约束
    constraint fk_record_user foreign key (create_user) references user(id) -- 外键约束
) comment '记录表';