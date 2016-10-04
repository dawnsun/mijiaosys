/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/10/4 13:34:21                           */
/*==============================================================*/


drop table if exists CONTROL_FILE_RELATION;

drop table if exists CONTROL_MEHTED_RELATION;

drop table if exists CONTROL_MENU_RELATION;

drop table if exists CONTROL_PAGE_RELATION;

drop table if exists FILE;

drop table if exists MENU;

drop table if exists METHED;

drop table if exists PAGE;

drop table if exists ROLE_CONTROL_RELATION;

drop table if exists SYS_CONTROL;

drop table if exists SYS_CONTROL_RELATION;

drop table if exists SYS_INFO;

drop table if exists SYS_ROLE;

drop table if exists SYS_ROLE_RELATION;

drop table if exists SYS_USER;

drop table if exists SYS_USER_ROLE;

drop table if exists USER_SYS_RELATION;

/*==============================================================*/
/* Table: CONTROL_FILE_RELATION                                 */
/*==============================================================*/
create table CONTROL_FILE_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   file_id              bigint(20) unsigned  not null comment '文件主键',
   control_id           bigint(20) unsigned  not null comment '权限主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table CONTROL_FILE_RELATION comment '权限文件关系表';

/*==============================================================*/
/* Table: CONTROL_MEHTED_RELATION                               */
/*==============================================================*/
create table CONTROL_MEHTED_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   control_id           bigint(20) unsigned  not null comment '权限主键',
   methed_id            bigint(20) unsigned  not null comment '操作主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table CONTROL_MEHTED_RELATION comment '权限操作关系表';

/*==============================================================*/
/* Table: CONTROL_MENU_RELATION                                 */
/*==============================================================*/
create table CONTROL_MENU_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   menu_id              bigint(20) unsigned  not null comment '菜单主键',
   control_id           bigint(20) unsigned  not null comment '权限主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table CONTROL_MENU_RELATION comment '权限菜单关系表';

/*==============================================================*/
/* Table: CONTROL_PAGE_RELATION                                 */
/*==============================================================*/
create table CONTROL_PAGE_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   page_id              bigint(20) unsigned  not null comment '页面元素主键',
   control_id           bigint(20) unsigned  not null comment '权限主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table CONTROL_PAGE_RELATION comment '权限页面元素关系表';

/*==============================================================*/
/* Table: FILE                                                  */
/*==============================================================*/
create table FILE
(
   id                   bigint(20) unsigned  not null auto_increment,
   file_name            varchar(64) not null comment '文件名称',
   file_suffix          varchar(16) not null comment '文件后缀',
   file_size            varchar(32) not null comment '文件大小',
   file_path            varchar(128) not null comment '文件路径',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table FILE comment '文件表';

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU
(
   id                   bigint(20) unsigned  not null auto_increment,
   menu_name            varchar(64) not null comment '菜单名称',
   menu_url             varchar(128) not null comment '菜单URL',
   menu_icon            varchar(32) not null comment '菜单图标',
   parent_id            bigint(20) unsigned  not null comment '父菜单ID',
   menu_order           int(10) not null comment '菜单排序',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table MENU comment '菜单表';

/*==============================================================*/
/* Table: METHED                                                */
/*==============================================================*/
create table METHED
(
   id                   bigint(20) unsigned  not null auto_increment,
   methed_code          varchar(32) not null comment '操作编码',
   methed_name          varchar(64) not null comment '操作名称',
   methed_url           varchar(128) not null comment '拦截URL前缀',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table METHED comment '功能操作表';

/*==============================================================*/
/* Table: PAGE                                                  */
/*==============================================================*/
create table PAGE
(
   id                   bigint(20) unsigned  not null auto_increment,
   page_code            varchar(32) not null comment '元素编码',
   page_name            varchar(64) not null comment '元素名称',
   page_order           int(10) not null comment '元素排序',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table PAGE comment '页面元素表';

/*==============================================================*/
/* Table: ROLE_CONTROL_RELATION                                 */
/*==============================================================*/
create table ROLE_CONTROL_RELATION
(
   id                   bigint(20) unsigned  not null,
   role_id              bigint(20) unsigned  not null comment '角色主键',
   control_id           bigint(20) unsigned  not null comment '权限主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table ROLE_CONTROL_RELATION comment '角色权限关系表';

/*==============================================================*/
/* Table: SYS_CONTROL                                           */
/*==============================================================*/
create table SYS_CONTROL
(
   id                   bigint(20) unsigned  not null auto_increment,
   control_name         varchar(64) not null comment '权限名称',
   control_type         varchar(32) not null comment '权限资源类型 MENU菜单 PAGE页面元素 FILE文件',
   control_abstract     varchar(128) comment '资源性质描述',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_CONTROL comment '系统权限表';

/*==============================================================*/
/* Table: SYS_CONTROL_RELATION                                  */
/*==============================================================*/
create table SYS_CONTROL_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   sys_id               bigint(20) unsigned  not null comment '系统主键',
   control_id           bigint(20) unsigned  not null comment '权限主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_CONTROL_RELATION comment '系统权限关系表';

/*==============================================================*/
/* Table: SYS_INFO                                              */
/*==============================================================*/
create table SYS_INFO
(
   id                   bigint(20) unsigned  not null auto_increment comment '主键',
   cn_name              varchar(64) not null comment '系统中文名称',
   en_name              varchar(128) comment '系统英文名称',
   secret_key           varchar(32) not null comment '系统秘钥',
   sys_status           tinyint(1) not null comment '系统状态 1-正常 0-锁定',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_INFO comment '系统信息表';

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
   id                   bigint(20) unsigned  not null auto_increment,
   role_name            varchar(64) not null comment '角色名称',
   role_abstract        varchar(128) comment '角色描述',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_ROLE comment '系统角色表';

/*==============================================================*/
/* Table: SYS_ROLE_RELATION                                     */
/*==============================================================*/
create table SYS_ROLE_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   sys_id               bigint(20) unsigned  not null comment '系统主键',
   role_id              bigint(20) unsigned  not null comment '角色主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_ROLE_RELATION comment '系统角色关系表';

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
   id                   bigint(20) unsigned  not null auto_increment,
   username             varchar(32) not null comment '用户名',
   password             varchar(32) not null comment '密码',
   phone_number         varchar(16) not null comment '手机号码',
   address              varchar(128) comment '地址',
   avatar               varchar(32) comment '头像',
   nickname             varchar(32) comment '昵称',
   qr_code              varchar(32) not null comment '二维码名片',
   sex                  tinyint(1) comment '0-女 1-男',
   birthday             varchar(9) comment '生日',
   user_status          tinyint(1) not null comment '用户状态 1-正常 0-锁定',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_USER comment '用户信息表';

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE
(
   id                   bigint(20) unsigned  not null auto_increment,
   user_id              bigint(20) unsigned  not null comment '用户主键',
   role_id              bigint(20) unsigned  not null comment '角色主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_USER_ROLE comment '用户角色关系表';

/*==============================================================*/
/* Table: USER_SYS_RELATION                                     */
/*==============================================================*/
create table USER_SYS_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   user_id              bigint(20) unsigned  not null comment '用户主键',
   sys_id               bigint(20) unsigned  not null comment '系统主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null comment '0-有效 1-删除',
   primary key (id)
);

alter table USER_SYS_RELATION comment '用户系统关系表';

