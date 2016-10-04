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
   file_id              bigint(20) unsigned  not null comment '�ļ�����',
   control_id           bigint(20) unsigned  not null comment 'Ȩ������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table CONTROL_FILE_RELATION comment 'Ȩ���ļ���ϵ��';

/*==============================================================*/
/* Table: CONTROL_MEHTED_RELATION                               */
/*==============================================================*/
create table CONTROL_MEHTED_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   control_id           bigint(20) unsigned  not null comment 'Ȩ������',
   methed_id            bigint(20) unsigned  not null comment '��������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table CONTROL_MEHTED_RELATION comment 'Ȩ�޲�����ϵ��';

/*==============================================================*/
/* Table: CONTROL_MENU_RELATION                                 */
/*==============================================================*/
create table CONTROL_MENU_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   menu_id              bigint(20) unsigned  not null comment '�˵�����',
   control_id           bigint(20) unsigned  not null comment 'Ȩ������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table CONTROL_MENU_RELATION comment 'Ȩ�޲˵���ϵ��';

/*==============================================================*/
/* Table: CONTROL_PAGE_RELATION                                 */
/*==============================================================*/
create table CONTROL_PAGE_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   page_id              bigint(20) unsigned  not null comment 'ҳ��Ԫ������',
   control_id           bigint(20) unsigned  not null comment 'Ȩ������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table CONTROL_PAGE_RELATION comment 'Ȩ��ҳ��Ԫ�ع�ϵ��';

/*==============================================================*/
/* Table: FILE                                                  */
/*==============================================================*/
create table FILE
(
   id                   bigint(20) unsigned  not null auto_increment,
   file_name            varchar(64) not null comment '�ļ�����',
   file_suffix          varchar(16) not null comment '�ļ���׺',
   file_size            varchar(32) not null comment '�ļ���С',
   file_path            varchar(128) not null comment '�ļ�·��',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table FILE comment '�ļ���';

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU
(
   id                   bigint(20) unsigned  not null auto_increment,
   menu_name            varchar(64) not null comment '�˵�����',
   menu_url             varchar(128) not null comment '�˵�URL',
   menu_icon            varchar(32) not null comment '�˵�ͼ��',
   parent_id            bigint(20) unsigned  not null comment '���˵�ID',
   menu_order           int(10) not null comment '�˵�����',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table MENU comment '�˵���';

/*==============================================================*/
/* Table: METHED                                                */
/*==============================================================*/
create table METHED
(
   id                   bigint(20) unsigned  not null auto_increment,
   methed_code          varchar(32) not null comment '��������',
   methed_name          varchar(64) not null comment '��������',
   methed_url           varchar(128) not null comment '����URLǰ׺',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table METHED comment '���ܲ�����';

/*==============================================================*/
/* Table: PAGE                                                  */
/*==============================================================*/
create table PAGE
(
   id                   bigint(20) unsigned  not null auto_increment,
   page_code            varchar(32) not null comment 'Ԫ�ر���',
   page_name            varchar(64) not null comment 'Ԫ������',
   page_order           int(10) not null comment 'Ԫ������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table PAGE comment 'ҳ��Ԫ�ر�';

/*==============================================================*/
/* Table: ROLE_CONTROL_RELATION                                 */
/*==============================================================*/
create table ROLE_CONTROL_RELATION
(
   id                   bigint(20) unsigned  not null,
   role_id              bigint(20) unsigned  not null comment '��ɫ����',
   control_id           bigint(20) unsigned  not null comment 'Ȩ������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table ROLE_CONTROL_RELATION comment '��ɫȨ�޹�ϵ��';

/*==============================================================*/
/* Table: SYS_CONTROL                                           */
/*==============================================================*/
create table SYS_CONTROL
(
   id                   bigint(20) unsigned  not null auto_increment,
   control_name         varchar(64) not null comment 'Ȩ������',
   control_type         varchar(32) not null comment 'Ȩ����Դ���� MENU�˵� PAGEҳ��Ԫ�� FILE�ļ�',
   control_abstract     varchar(128) comment '��Դ��������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table SYS_CONTROL comment 'ϵͳȨ�ޱ�';

/*==============================================================*/
/* Table: SYS_CONTROL_RELATION                                  */
/*==============================================================*/
create table SYS_CONTROL_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   sys_id               bigint(20) unsigned  not null comment 'ϵͳ����',
   control_id           bigint(20) unsigned  not null comment 'Ȩ������',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table SYS_CONTROL_RELATION comment 'ϵͳȨ�޹�ϵ��';

/*==============================================================*/
/* Table: SYS_INFO                                              */
/*==============================================================*/
create table SYS_INFO
(
   id                   bigint(20) unsigned  not null auto_increment comment '����',
   cn_name              varchar(64) not null comment 'ϵͳ��������',
   en_name              varchar(128) comment 'ϵͳӢ������',
   secret_key           varchar(32) not null comment 'ϵͳ��Կ',
   sys_status           tinyint(1) not null comment 'ϵͳ״̬ 1-���� 0-����',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table SYS_INFO comment 'ϵͳ��Ϣ��';

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
   id                   bigint(20) unsigned  not null auto_increment,
   role_name            varchar(64) not null comment '��ɫ����',
   role_abstract        varchar(128) comment '��ɫ����',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table SYS_ROLE comment 'ϵͳ��ɫ��';

/*==============================================================*/
/* Table: SYS_ROLE_RELATION                                     */
/*==============================================================*/
create table SYS_ROLE_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   sys_id               bigint(20) unsigned  not null comment 'ϵͳ����',
   role_id              bigint(20) unsigned  not null comment '��ɫ����',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table SYS_ROLE_RELATION comment 'ϵͳ��ɫ��ϵ��';

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
   id                   bigint(20) unsigned  not null auto_increment,
   username             varchar(32) not null comment '�û���',
   password             varchar(32) not null comment '����',
   phone_number         varchar(16) not null comment '�ֻ�����',
   address              varchar(128) comment '��ַ',
   avatar               varchar(32) comment 'ͷ��',
   nickname             varchar(32) comment '�ǳ�',
   qr_code              varchar(32) not null comment '��ά����Ƭ',
   sex                  tinyint(1) comment '0-Ů 1-��',
   birthday             varchar(9) comment '����',
   user_status          tinyint(1) not null comment '�û�״̬ 1-���� 0-����',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table SYS_USER comment '�û���Ϣ��';

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE
(
   id                   bigint(20) unsigned  not null auto_increment,
   user_id              bigint(20) unsigned  not null comment '�û�����',
   role_id              bigint(20) unsigned  not null comment '��ɫ����',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table SYS_USER_ROLE comment '�û���ɫ��ϵ��';

/*==============================================================*/
/* Table: USER_SYS_RELATION                                     */
/*==============================================================*/
create table USER_SYS_RELATION
(
   id                   bigint(20) unsigned  not null auto_increment,
   user_id              bigint(20) unsigned  not null comment '�û�����',
   sys_id               bigint(20) unsigned  not null comment 'ϵͳ����',
   gmt_create           datetime not null comment '����ʱ��',
   gmt_modified         datetime not null comment '�޸�ʱ��',
   creator              varchar(32) not null comment '������',
   modifier             varchar(32) not null comment '�޸���',
   is_delete            tinyint(1) not null comment '0-��Ч 1-ɾ��',
   primary key (id)
);

alter table USER_SYS_RELATION comment '�û�ϵͳ��ϵ��';

