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
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '用户表';

-- 分类表
create table category(
    id int unsigned primary key auto_increment comment 'ID',
    category_name varchar(32) not null comment '分类名称',
    icon_url varchar(128) not null comment '图标地址',
    create_user int unsigned not null comment '创建人ID',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间',
    constraint fk_category_user foreign key (create_user) references user(id) -- 外键约束
) comment '分类表';

-- 文章表
# create table article(
#                         id int unsigned primary key auto_increment comment 'ID',
#                         title varchar(30) not null comment '文章标题',
#                         content varchar(10000) not null comment '文章内容',
#                         cover_img varchar(128) not null  comment '文章封面',
#                         state varchar(3) default '草稿' comment '文章状态: 只能是[已发布] 或者 [草稿]',
#                         category_id int unsigned comment '文章分类ID',
#                         create_user int unsigned not null comment '创建人ID',
#                         create_time datetime not null comment '创建时间',
#                         update_time datetime not null comment '修改时间',
#                         constraint fk_article_category foreign key (category_id) references category(id),-- 外键约束
#                         constraint fk_article_user foreign key (create_user) references user(id) -- 外键约束
# )