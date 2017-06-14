/*==============================================================*/
/* Table: LAND_RES                                              */
/*==============================================================*/
create table LAND_RES
(
   id                   bigint(20) unsigned not null auto_increment,
   longitude            varchar(16)  comment '经度',
   latitude             varchar(16)  comment '纬度',
   altitude             varchar(16)  comment '海拔',
   alias                varchar(32)  comment '土地别名',
   address              varchar(128)  comment '土地详细地址',
   size                 varchar(16)  comment '面积大小',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table LAND_RES comment '土地资源表';

/*==============================================================*/
/* Table: CROPS                                              */
/*==============================================================*/
create table CROPS
(
   id                   bigint(20) unsigned not null auto_increment,
   crops_name            varchar(64) not null comment '农作物名称',
   menu_icon            varchar(32) not null comment '农作物图标',
   parent_id            bigint(20) unsigned not null comment '父农作物ID',
   crops_order           int(10) not null comment '农作物排序',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table CROPS comment '农作物表';

/*==============================================================*/
/* Table: TESTING_INSTITUTION                                              */
/*==============================================================*/
create table TESTING_INSTITUTION
(
   id                   bigint(20) unsigned not null auto_increment,
   institution_name            varchar(64) not null comment '检测机构名称',
   institution_address         varchar(32) not null comment '检测机构地址',
   institution_contacts        varchar(32) not null comment '检测机构联系人',
   institution_phone           varchar(16) not null comment '检测机构电话',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table TESTING_INSTITUTION comment '检测机构表';

/*==============================================================*/
/* Table: LAND_QUALITY                                          */
/*==============================================================*/
create table LAND_QUALITY
(
   id                   bigint(20) unsigned not null auto_increment,
   land_id              bigint(20) unsigned not null comment '土地资源主键',
   over_elements        varchar(16)  comment '超标元素',
   missing_elements     varchar(16)  comment '缺失元素',
   ph                varchar(2)  comment '酸碱度',
   testing_id              varchar(128)  comment '检测机构id',
   gmt_testing           datetime not null comment '监测时间',
   testing_file                 varchar(16)  comment '检测附件',
   land_img                 varchar(16)  comment '当前土地照片附件id多张用逗号隔开',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table LAND_QUALITY comment '土地质量监测表';


季度土地作物表
季度年份 季度份 土地id 管理者id 作物id 作物数量

日常作物操作表

作物操作配置表

作物产值表

作物规格表
